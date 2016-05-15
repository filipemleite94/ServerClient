import java.io.*;
import java.net.*;
import java.util.Scanner;

class servidor {
	Socket soc;
	OutputStream os;
	BufferedReader is;
	String resource;
	Scanner t;

	void getRequest() {
		try {
			String mensagem;
			mensagem = is.readLine();
			System.err.println(mensagem);
		} catch (IOException e) {
			System.err.println("Error receiving Web request");
		}
	}

	void returnResponse() {
		try {
			String mensagem = t.nextLine() + "\n";
			os.write(mensagem.getBytes());
			os.flush();
		} catch (IOException e) {
			System.err.println("IOException in reading in Web " + "server");
		}
	}

	public void close() {
		try {
			is.close();
			os.close();
			soc.close();
			t.close();
		} catch (IOException e) {
			System.err.println("IOException in closing connection");
		}
	}

	servidor(Socket s) throws IOException {
		soc = s;
		os = soc.getOutputStream();
		is = new BufferedReader(new InputStreamReader(soc.getInputStream()));
		t = new Scanner(System.in);
	}
}