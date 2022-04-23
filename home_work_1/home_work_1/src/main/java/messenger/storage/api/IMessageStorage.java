package messenger.storage.api;

import messenger.core.dto.Message;

import java.util.List;

public interface IMessageStorage {
    void addMessage(Message message);

    List<Message> getMessageAutor(String login);

    List<Message> getMessageRecipient(String login);

    List<Message> getAll();

    int getCount();


}
