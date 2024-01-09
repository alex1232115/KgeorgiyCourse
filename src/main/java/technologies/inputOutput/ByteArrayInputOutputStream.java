package technologies.inputOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayInputOutputStream {
    public static void main(String[] args) {
        byte[] array1 = new byte[]{1, 3, 5, 7};
        ByteArrayInputStream byteStream1 = new ByteArrayInputStream(array1, 1, 25);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        int b;
        while((b=byteStream1.read())!=-1){
            System.out.println(b);
            output.write(b);
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String text = "Hello World!";
        byte[] buffer = text.getBytes();
        try{
            baos.write(buffer);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        try(FileOutputStream fos = new FileOutputStream("hello.txt")){

            baos.writeTo(fos);
        }
        catch(IOException e){

            System.out.println(e.getMessage());
        }
    }
}
