import java.io.*;
import java.net.*;

public class HelloWorld {
    static BufferedReader systemInputReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");

        System.out.println("enter url of file to download.");
        String testingFileToDownload = readLine();

        
        System.out.println("enter filename to download to.");
        String testingFileDestination = readLine();

        saveFile(testingFileDestination, testingFileToDownload);
    }

    public static void saveFile(String fileDestination, String fileUrlLocation) throws IOException {
        BufferedInputStream input = null;
        FileOutputStream output = null;

        input = new BufferedInputStream(new URL(fileUrlLocation).openConnection(Proxy.NO_PROXY).getInputStream());
        output = new FileOutputStream(fileDestination);
        byte[] bytesRead = new byte[1024];
        while (input.read(bytesRead, 0, 1024) != -1) {
            output.write(bytesRead, 0, 1024);
        }
        if (input != null) {
            input.close();
        }
        if (output != null) {
            output.close();
        }

    }

    public static String readLine() throws IOException {
        return systemInputReader.readLine();
    }
}
