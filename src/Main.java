import java.io.IOException;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		int e = n.nextInt();
		if (e == 0) {
			try {
				ServerSocket s = new ServerSocket(8080);
				servidor w = new servidor(s.accept());
				for (;;) {
					w.getRequest();
					w.returnResponse();
				}
			} catch (IOException i) {
				System.err.println("IOException in Server");
			}
		} else {
			try {
				cliente w = new cliente("localhost", 8080);
				for (;;) {
					w.request("/NUSinfo/UG/ug.html");
					w.getResponse();
				}
			} catch (UnknownHostException h) {
				System.err.println("Hostname Unknown");
			} catch (IOException i) {
				System.err.println("IOException in connecting to Host");
			}
		}
		;
	}
}
