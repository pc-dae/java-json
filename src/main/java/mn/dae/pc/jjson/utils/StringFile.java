package mn.dae.pc.jjson.utils;

import java.nio.file.Path;

public class StringFile {

    public static String ReadFile(String fileName) throws Exception {
        Path filePath = Path.of(fileName);
        return java.nio.file.Files.readString(filePath);
    }
    public static void WriteFile(String fileName, String data) throws Exception {
        Path filePath = Path.of(fileName);
        java.nio.file.Files.writeString(filePath, data);
    }
}
