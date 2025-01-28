package mn.dae.pc.jjson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import mn.dae.pc.jjson.utils.StringFile;
import mn.dae.pc.jjson.data.Email;

public class javaJson {

    public static void main(String[] args) {
        try {
            String inputFile = "test.html";
            String outputFile = "test.json";
            int i = 0;
            while (i < args.length) {
                if (args[i].startsWith("--")) {
                    if (args[i].substring(2).equals("input")) {
                        inputFile = args[++i];
                        i++;
                        continue;
                    }
                    if (args[i].substring(2).equals("output")) {
                        outputFile = args[++i];
                        i++;
                        continue;
                    }
                }
                System.out.println(String.format("invalid command line argument: %s", args[i]));
                System.exit(1);
            }

            String htmlContent = StringFile.ReadFile(inputFile);

            // Create the JSON object
            Map<String, String> data = new HashMap<>(2);
            data.put("title", String.format("Test of %s", inputFile));
            data.put("body", htmlContent);
            Email document = new Email("paul.carlton@dae.mn", data);

            // Convert to JSON and save to a file
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(document);

                // Print JSON to the console
                System.out.println("Generated JSON...");
                System.out.println(jsonOutput);

                // Save to file
                File file = new File(outputFile);
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, document);
                System.out.println("JSON document saved to: " + file.getAbsolutePath());
            } catch (Exception e) {
                System.out.println("Error creating JSON document: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error processing HTML: " + e.getMessage());
        }
    }
}