package ftpfiles.com.epam.valery_sholomitskaya.lecture1.task2;

public class Main {
	private final static String link = "ftp.mozilla.org";
	private final static String name = "anonymous";;
	private final static String password = "";

	public static void main(String[] args) throws Throwable {

		ftpFilesUtils utils = new ftpFilesUtils();
		utils.connect(link, name, password);
		utils.ListOfFilesInFTPServer(utils.getFTPClient(), utils.getDirectory());
		utils.logOut();

	}

}
