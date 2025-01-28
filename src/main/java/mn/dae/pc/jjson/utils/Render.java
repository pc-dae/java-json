package mn.dae.pc.jjson.utils;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.StringWriter;
import java.util.Map;

public class Render {

    public String generateHTML(String templateName, Map<String, String> data) {
        try {
            MustacheFactory mf = new DefaultMustacheFactory();
            Mustache mustache = mf.compile(templateName);
            StringWriter writer = new StringWriter();
            mustache.execute(writer, data).flush();
            return writer.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
