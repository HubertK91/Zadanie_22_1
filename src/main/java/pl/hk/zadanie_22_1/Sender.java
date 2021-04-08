package pl.hk.zadanie_22_1;

public class Sender {
    String name;
    String senderMail;
    String content;

    public Sender() {
    }
    public Sender(String name, String senderMail, String content) {
        this.name = name;
        this.senderMail = senderMail;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSenderMail() {
        return senderMail;
    }

    public void setSenderMail(String senderMail) {
        this.senderMail = senderMail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
