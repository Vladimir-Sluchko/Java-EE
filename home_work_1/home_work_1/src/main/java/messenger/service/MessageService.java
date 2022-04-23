package messenger.service;

import messenger.core.dto.Message;
import messenger.service.api.IMessageService;
import messenger.storage.MessageStorage;
import messenger.storage.api.IMessageStorage;


import java.util.List;


public class MessageService implements IMessageService {
    private final IMessageStorage storage = MessageStorage.getInstance();

    @Override
    public void creatMessage(Message message) {
        storage.addMessage(message);
    }

    @Override
    public List<Message> getAll() {
        return storage.getAll();
    }

    @Override
    public List<Message> getMessageAutor(String login) {
        return storage.getMessageAutor(login);
    }

    @Override
    public List<Message> getMessageRecipient(String login) {
        return storage.getMessageRecipient(login);
    }

    @Override
    public int getCount() {
        return storage.getCount();
    }
}
