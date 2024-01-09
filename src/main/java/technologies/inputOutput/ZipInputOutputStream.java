package technologies.inputOutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipInputOutputStream {
    public static void main(String[] args) {
        String filename = "notes3.txt";
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("output.zip"));
             FileInputStream fis = new FileInputStream(filename)) {

            ZipEntry entry1 = new ZipEntry("notes3.txt");
            zout.putNextEntry(entry1);
            // считываем содержимое файла в массив byte
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            // добавляем содержимое к архиву
            zout.write(buffer);
            // закрываем текущую запись для новой записи
            zout.closeEntry();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try (ZipInputStream zin = new ZipInputStream(new FileInputStream("output.zip"))) {
            ZipEntry entry;
            String name;
            while ((entry = zin.getNextEntry()) != null) {

                name = entry.getName(); // получим название файла
                System.out.printf("File name: %s \n", name);

                // распаковка
                FileOutputStream fout = new FileOutputStream("new" + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }
}
