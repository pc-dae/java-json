package mn.dae.pc.jjson;

import com.fasterxml.jackson.databind.ObjectMapper;
import mn.dae.pc.jjson.utils.GetData;
import mn.dae.pc.jjson.utils.Render;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import mn.dae.pc.jjson.utils.StringFile;
import mn.dae.pc.jjson.data.Email;

public class javaJson {
    private static final Render render = new Render();
    private static final GetData getData = new GetData();
    public static void main(String[] args) {
        try {
            String inputFile = "test.html";
            String outputFile = "test.json";
            String dataFile = "data.json";
            int i = 0;
            while (i < args.length) {
                if (args[i].startsWith("--")) {
                    if (args[i].substring(2).equals("input")) {
                        inputFile = args[++i];
                        i++;
                        continue;
                    }
                    if (args[i].substring(2).equals("data")) {
                        dataFile = args[++i];
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

            Map<String, String> data = getData.getDataFromFile(dataFile);
            System.out.println(String.format("data: %s", data));
            String html = render.generateHTML(inputFile, data);
            Map<String, String> emailData = new HashMap<>(2);
            emailData.put("title", String.format("Test of %s", inputFile));
            emailData.put("body", html);
            Email document = new Email("paul.carlton@dae.mn", emailData);

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(document);

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