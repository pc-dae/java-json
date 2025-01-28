package mn.dae.pc.jjson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import mn.dae.pc.jjson.utils.StringFile;

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
            Document document = new Document();
            document.setTitle(String.format("Test of %s", inputFile));
            document.setHtmlContent(htmlContent.toString());

            // Convert to JSON and save to a file
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(document);

                // Print JSON to the console
                System.out.println("Generated JSON:");
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

    // Static inner class to represent the document structure
    static class Document {
        private String title;
        private String htmlContent;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getHtmlContent() {
            return htmlContent;
        }

        public void setHtmlContent(String htmlContent) {
            this.htmlContent = htmlContent;
        }
    }
}