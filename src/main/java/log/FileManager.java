package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileManager {
    private static final Logger logger = LoggerFactory.getLogger(FileManager.class);

    public boolean saveFile(FileData file) {
        logger.info("сохраняем файл " + file.getName());
        boolean resultOK = SaveUtils.save(file);
        if (resultOK) return true;

        logger.warn("проблема с записью файла "+ file.getName());
        String filename = Dialog.selectFile();
        boolean result = SaveUtils.save(file, filename);
        return result;
    }

    private class FileData {
        public String getName() {
            return null;
        }
    }

    private static class SaveUtils {
        public static boolean save(FileData file) {
            return false;
        }
        public static boolean save(FileData file, String filename) {
            return false;
        }
    }

    private static class Dialog {
        public static String selectFile() {
            return null;
        }
    }
}
