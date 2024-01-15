package technologies.collections;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] arr = new String[]{"Alex", "Danya", "Roma", "Gleb", "Nastya"};
        Iterable<String> collection = Arrays.asList(arr);
        Iterator<String> iterator = collection.iterator();
        try (FileWriter fileWriter = new FileWriter("collectionOutput")) {
            while (iterator.hasNext()) {
                String cur = iterator.next();
                System.out.print(cur + " ");
                fileWriter.append(cur).append(" ");
            }
        }
    }
}
