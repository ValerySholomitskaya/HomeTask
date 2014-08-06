package lab1;

import java.io.IOException;
import java.net.SocketException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class ftpfiles {
	public static void look(FTPClient localclient, String directory) {
		FTPFile[] localfile = null;
		FTPFile[] localdirectory = null;
		try {
			localclient.changeWorkingDirectory(directory);
			localdirectory = localclient.listDirectories();
			for (FTPFile ld : localdirectory) {
				look(localclient, ld.getName());
				localclient.changeToParentDirectory();
			}
			localfile = localclient.listDirectories();

			for (FTPFile str : localfile)
				System.out.println(str.getName());
			localfile = localclient.listFiles();

			for (FTPFile str : localfile)
				System.out.println(str.getName());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}

	public static void main(String args[]) {
		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient.connect("ftp.mozilla.org");
			boolean login = ftpClient.login("anonymous", "");
			if (login) {
				System.out.println("Connection established...");
				look(ftpClient, "");
				System.out.println("finish");
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
	}
}