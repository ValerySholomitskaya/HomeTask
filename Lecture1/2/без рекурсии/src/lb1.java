import java.io.IOException;
import java.net.SocketException;
import org.apache.commons.net.ftp.FTPClient;

public class lb1 {

	public static void main(String args[]) {
		String[] FileList = null;
		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient.connect("ftp.mozilla.org");

			boolean login = ftpClient.login("anonymous", "");
			if (login) {
				System.out.println("Connection established...");
				FileList = ftpClient.listNames();

				boolean logout = ftpClient.logout();
				if (logout) {
					System.out.println("Connection close...");
				}
			} else {
				System.out.println("Connection fail...");
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < FileList.length; i++) {
			System.out.println(FileList[i]);
		}
	}
}
