package messenger.core.dto;

import java.time.LocalDateTime;

public class Message {
    private LocalDateTime dateSendingMessage;

    private String autorLogin;

    private String recipientLogin;
    private String textMessage;

    public Message(LocalDateTime dateSendingMessage, String autorLogin, String recipientLogin, String textMessage) {
        this.dateSendingMessage = dateSendingMessage;
        this.autorLogin = autorLogin;
        this.recipientLogin = recipientLogin;
        this.textMessage = textMessage;
    }

    public LocalDateTime getDateSendingMessage() {
        return dateSendingMessage;
    }

    public void setDateSendingMessage(LocalDateTime dateSendingMessage) {
        this.dateSendingMessage = dateSendingMessage;
    }

    public String getAutorLogin() {
        return autorLogin;
    }

    public void setAutorLogin(String autorLogin) {
        this.autorLogin = autorLogin;
    }

    public String getRecipientLogin() {
        return recipientLogin;
    }

    public void setRecipientLogin(String recipientLogin) {
        this.recipientLogin = recipientLogin;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    @Override
    public String toString() {
        return "Сообщение от " + autorLogin + ": " + textMessage + " " +
                "  || ДАТА И ВРЕМЯ СООБЩЕНИЯ:" + dateSendingMessage;
    }
}
