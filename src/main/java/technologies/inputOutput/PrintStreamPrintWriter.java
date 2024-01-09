package technologies.inputOutput;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintStreamPrintWriter {
    // https://metanit.com/java/tutorial/6.6.php
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream out = new PrintStream(System.out);
        out.print("52");
        out = new PrintStream("printStream.txt");
        out.println("testing Print Stream");
        out.write(52);
        out.close();
        PrintWriter printWriter = new PrintWriter(System.out);
        String output = "\nHello everyone!";
        printWriter.write(output);
        printWriter.close();
    }
}
