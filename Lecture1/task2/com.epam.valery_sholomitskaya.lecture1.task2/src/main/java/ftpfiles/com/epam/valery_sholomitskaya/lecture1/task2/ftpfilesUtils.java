package ftpfiles.com.epam.valery_sholomitskaya.lecture1.task2;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class ftpFilesUtils {
	private FTPClient localFTPClient = new FTPClient();
	private String localDirectory;

	public FTPClient getFTPClient() {
		return localFTPClient;
	}

	public String getDirectory() {
		return localDirectory;
	}

	public void connect(String url, String name, String password)
			throws SocketException, IOException {
		FTPClient ftpClient = new FTPClient();
		ftpClient.connect(url);
		boolean loginResult = ftpClient.login(name, password);
		if (loginResult) {
			System.out.println("Connection established...");
			localFTPClient = ftpClient;
			localDirectory = ftpClient.printWorkingDirectory();
		} else {
			System.out.println("Connection fail...");
		}
	}

	public void logOut() throws Throwable {
		boolean logout = localFTPClient.logout();
		if (logout) {
			System.out.println("Connection close...");
		}

	}

	public void printFTPFile(FTPFile[] localfile) {
		for (FTPFile str : localfile)
			System.out.println(str.getName());
	}

	public void ListOfFilesInFTPServer(FTPClient localClient, String directory) {
		FTPFile[] localFile = null;
		FTPFile[] localDirectory = null;
		try {
			localClient.changeWorkingDirectory(directory);
			localDirectory = localClient.listDirectories();
			for (FTPFile ld : localDirectory) {
				ListOfFilesInFTPServer(localClient, ld.getName());
				localClient.changeToParentDirectory();
			}
			localFile = localClient.listDirectories();
			printFTPFile(localFile);
			localFile = localClient.listFiles();
			printFTPFile(localFile);
		} catch (IOException e) {
			System.out.println("Error with directrys on FTP Server");
			e.printStackTrace();

		}
	}

}
