import java.io.*;
import java.net.*;
import java.util.Scanner;

public class cliente {
	Socket soc;
	OutputStream os;
	BufferedReader is;
	Scanner t;

	cliente(String server, int port) throws IOException, UnknownHostException {
		soc = new Socket(server, port);
		os = soc.getOutputStream();
		is = new BufferedReader(new InputStreamReader(soc.getInputStream()));
		t = new Scanner(System.in);
	}

	void request(String path) {
		try {
			String mensagem = t.nextLine() + "\n";
			os.write(mensagem.getBytes());
			os.flush();
		} catch (IOException e) {
			System.err.println("Error in HTTP request");
		}
	}

	void getResponse() {
		try {
			String mensagem;
			mensagem = is.readLine();
			System.err.println(mensagem);
		} catch (IOException e) {
			System.err.println("IOException in reading from " + "Web server");
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
}
