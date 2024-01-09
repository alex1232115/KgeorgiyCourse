package technologies.inputOutput;

import java.io.*;

public class FileInputOutputStream {
    public static void main(String[] args) {
        try (FileOutputStream outputStream = new FileOutputStream("test.txt");
        FileInputStream inputStream = new FileInputStream("test.txt")){
            byte[] info = "Hello world\n\n".getBytes();
            outputStream.write(info);

            int i;
            while ((i = inputStream.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
