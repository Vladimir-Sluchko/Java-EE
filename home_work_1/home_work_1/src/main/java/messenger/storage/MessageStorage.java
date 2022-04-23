package messenger.storage;

import messenger.core.dto.Message;
import messenger.storage.api.IMessageStorage;

import java.util.*;

public class MessageStorage implements IMessageStorage {
    private final Map<String, List<Message>> messageMap;

    private final static IMessageStorage instance = new MessageStorage();

    public static IMessageStorage getInstance() {
        return instance;
    }

    private MessageStorage() {
        this.messageMap = new HashMap<>();
    }

    @Override
    public void addMessage(Message message) {
        String recipientLogin = message.getRecipientLogin();
        List<Message> messages = messageMap.getOrDefault(recipientLogin,new ArrayList<>());
        messages.add(message);
        messageMap.put(recipientLogin,messages);

    }

    @Override
    public List<Message> getMessageAutor(String login) {
        return messageMap.get(login);
                /*getAll().stream().filter(message -> Objects.equals(message.getAutorLogin(),login))
                .collect(Collectors.toList());*/
    }

    @Override
    public List<Message> getMessageRecipient(String login) {
        return messageMap.get(login);
    }

    @Override
    public List<Message> getAll() {
        List<Message> messages = new ArrayList<>();
        messageMap.values().forEach(messages::addAll);
        return Collections.unmodifiableList(messages);
    }

    @Override
    public int getCount() {
        return getAll().size();
    }
}
