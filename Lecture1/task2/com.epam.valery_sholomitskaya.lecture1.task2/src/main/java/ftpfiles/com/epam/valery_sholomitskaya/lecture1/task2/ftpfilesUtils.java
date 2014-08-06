package ftpfiles.com.epam.valery_sholomitskaya.lecture1.task2;

import java.io.IOException;
import java.net.SocketException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class ftpfilesUtils {
	public void printFtpFile(FTPFile[] localfile) {
		for (FTPFile str : localfile)
			System.out.println(str.getName());
	}

	public ftpfilesUtils(String url, String name, String password) {
		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient.connect(url);
			boolean login = ftpClient.login(name, password);
			if (login) {
				System.out.println("Connection established...");
				ListOfFtpFiles(ftpClient, "");
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

	public void ListOfFtpFiles(FTPClient localclient, String directory) {
		FTPFile[] localfile = null;
		FTPFile[] localdirectory = null;
		try {
			localclient.changeWorkingDirectory(directory);
			localdirectory = localclient.listDirectories();
			for (FTPFile ld : localdirectory) {
				ListOfFtpFiles(localclient, ld.getName());
				localclient.changeToParentDirectory();
			}
			localfile = localclient.listDirectories();
			printFtpFile(localfile);
			localfile = localclient.listFiles();
			printFtpFile(localfile);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}

}
