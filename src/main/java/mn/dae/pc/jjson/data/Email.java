package mn.dae.pc.jjson.data;

import java.util.Map;

public class Email {
    private String recipient;
    private Map<String, String> data;

    public Email(String recipient, Map<String, String> data) {
        this.setRecipient(recipient);
        this.setData(data);
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipient() {
        return this.recipient;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public Map<String, String> getData() {
        return this.data;
    }
}