import java.io.*;
import java.net.*;
import java.util.*;

public class HelloWorld {
    static BufferedReader systemInputReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");

        System.out.println("enter url of file to download.");
        String testingFileToDownload = systemInputReader.readLine();

        System.out.println("enter filename to download to.");
        String testingFileDestination = systemInputReader.readLine();

        saveNonTextUrl(testingFileDestination, testingFileToDownload);
        String[] myStrings = readUrl(testingFileToDownload);
        for (String m : myStrings) {
            System.out.println(m);
        }
    }

    public static void saveTextUrl(String fileDestination, String fileUrlLocation) throws IOException {
        BufferedReader input = null;
        FileWriter output = null;

        input = new BufferedReader(
                new InputStreamReader(new URL(fileUrlLocation).openConnection(Proxy.NO_PROXY).getInputStream()));
        output = new FileWriter(fileDestination);

        String currentString = input.readLine();
        while (currentString != null) {
            output.write(currentString + "\n");
            currentString = input.readLine();
        }

        if (input != null) {
            input.close();
        }
        if (output != null) {
            output.close();
        }
    }

    public static void saveNonTextUrl(String fileDestination, String fileUrlLocation) throws IOException {
        BufferedInputStream input = null;
        FileOutputStream output = null;

        input = new BufferedInputStream(new URL(fileUrlLocation).openConnection(Proxy.NO_PROXY).getInputStream());
        output = new FileOutputStream(fileDestination);

        byte[] myData = new byte[1024];
        int amount = input.read(myData, 0, 1024);
        while (amount != -1) {
            output.write(myData, 0, 1024);
            amount = input.read(myData, 0, 1024);
        }

        if (input != null) {
            input.close();
        }
        if (output != null) {
            output.close();
        }
    }

    public static String[] readUrl(String fileUrlLocation) throws IOException {
        BufferedReader input = null;

        input = new BufferedReader(
                new InputStreamReader(new URL(fileUrlLocation).openConnection(Proxy.NO_PROXY).getInputStream()));
        List<String> tmp = new ArrayList<String>();
        String currentString = input.readLine();
        while (currentString != null) {
            tmp.add(currentString);
            currentString = input.readLine();
        }
        String[] finalStringArray = new String[tmp.size()];

        for (int i = 0; i < tmp.size(); i++) {
            finalStringArray[i] = tmp.get(i);
        }
        return finalStringArray;
    }
}
