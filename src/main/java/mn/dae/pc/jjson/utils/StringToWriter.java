package mn.dae.pc.jjson.utils;

import java.io.StringWriter;
import java.io.Writer;

public class StringToWriter {
    public static Writer GetWriter(String data) throws Exception {
        // Create a StringWriter
        Writer writer = new StringWriter();

        try {
            // Write the string to the Writer
            writer.write(data);
            return writer;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                writer.close(); // Close the writer
            } catch (Exception ex) {
                throw ex;
            }
        }
    }
}