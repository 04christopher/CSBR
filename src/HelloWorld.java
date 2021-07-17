import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        try {
            saveUrl("testing01.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Rick_Astley_Dallas.jpg/220px-Rick_Astley_Dallas.jpg"); // downloads a very cool image to testing0.txt
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public static void saveUrl(final String filename, final String urlString)
            throws MalformedURLException, IOException {
        BufferedInputStream inputStream = null;
        FileOutputStream fileOut = null;
        try {
            inputStream = new BufferedInputStream(new URL(urlString).openStream());
            fileOut = new FileOutputStream(filename);

            final byte data[] = new byte[1024];
            int count = inputStream.read(data, 0, 1024);
            while (count != -1) {
                fileOut.write(data, 0, count);
                count = inputStream.read(data, 0, 1024);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOut != null) {
                fileOut.close();
            }
        }
    }
}
