package technologies.inputOutput.ReaderWriter;

import java.io.*;

public class BufferedReaderWriter {
    public static void main(String[] args) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("notes4.txt")))
        {
            String text = "Hello  World!\nHey! Teachers! Leave the kids alone.";
            bw.write(text);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        try(BufferedReader br = new BufferedReader(new FileReader("notes4.txt")))
        {
            //чтение построчно
            String s;
            while((s=br.readLine())!=null){

                System.out.println(s);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        try(BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new FileWriter("notes5.txt")))
        {
            // чтение построчно
            String text;
            while(!(text=br.readLine()).equals("ESC")){

                bw.write(text + "\n");
                bw.flush();
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
