package technologies.inputOutput.ReaderWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterReader {
    public static void main(String[] args) {
        try(FileWriter writer = new FileWriter("notes3.txt", false))
        {
            // ������ ���� ������
            String text = "Hello Gold!";
            writer.write(text);
            // ������ �� ��������
            writer.append('\n');
            writer.append('E');

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        try(FileReader reader = new FileReader("notes3.txt"))
        {
            // ������ �����������
            int c;
            while((c=reader.read())!=-1){

                System.out.print((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
