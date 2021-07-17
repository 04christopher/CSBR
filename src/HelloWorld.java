import java.io.*;
import java.net.*;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        try {
            saveFile("testing01.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Rick_Astley_Dallas.jpg/220px-Rick_Astley_Dallas.jpg"); // downloads
                                                                                                                                      // a
                                                                                                                                      // very
                                                                                                                                      // cool
                                                                                                                                      // image
                                                                                                                                      // to
                                                                                                                                      // testing0.txt
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public static void saveFile(String fileDestination, String fileUrlLocation) throws IOException {
        BufferedInputStream input = null;
        FileOutputStream output = null;

        input = new BufferedInputStream(new URL(fileUrlLocation).openStream());
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
}
