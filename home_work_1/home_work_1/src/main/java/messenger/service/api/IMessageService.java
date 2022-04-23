package messenger.service.api;

import messenger.core.dto.Message;

import java.util.List;

public interface IMessageService {
    void creatMessage(Message message);

    List<Message> getAll();

    List<Message> getMessageAutor(String login);

    List<Message> getMessageRecipient(String login);

    int getCount();
}
