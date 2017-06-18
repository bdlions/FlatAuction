package com.auction.manager;

import com.auction.db.HibernateUtil;
import com.auction.dto.Message;
import com.auction.dto.MessageText;
import com.auction.dto.Product;
import com.auction.dto.User;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nazmul hasan
 */
public class MessageManager {
    private final Logger logger = LoggerFactory.getLogger(MessageManager.class);
    public MessageManager()
    {
    
    }
    
    public void addMessageText(Message message)
    {
        
        if(message.getProduct() != null)
        {
            Message messageInfo = new Message();
            Session session = HibernateUtil.getSession();
            session.beginTransaction();
            Query query = session.createSQLQuery("select {m.*} from messages m where product_id = :product_id ")
                        .addEntity("m",Message.class)
                        .setInteger("product_id", message.getProduct().getId());
            List<Message> messages =  query.list();
            if(messages == null || messages.size() == 0)
            {
                session.save(message);                
                messageInfo = message;
            }
            else
            {
                messageInfo = messages.get(0);
            }
            session.getTransaction().commit();
            session.beginTransaction();
            if(message.getMessageTextList() != null && message.getMessageTextList().size() > 0)
            {
                MessageText messageText = message.getMessageTextList().get(0);
                messageText.setMessageId(messageInfo.getId());
                session.save(messageText);
            }
            session.getTransaction().commit();
        }        
    }
    
    public List<Message> getInboxMessageList(int userId)
    {
        List<Message> messageList = new ArrayList<>();
        Hashtable<Integer, Message> messageIdInfoMap = new Hashtable<>();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query query = session.createSQLQuery("select {mt.*}, {m.*} from message_texts mt join messages m on mt.message_id = m.id where m.from_user_id = :from_user_id or m.to_user_id = :to_user_id ")
                    .addEntity("mt",MessageText.class)
                    .addEntity("m",Message.class)
                    .setInteger("from_user_id", userId)
                    .setInteger("to_user_id", userId);
        List<Object[]> rows =  query.list();
        for(Object[] row : rows)
        {
            MessageText messageText = (MessageText)row[0];
            Message message = (Message)row[1];
            if(messageIdInfoMap.contains(message.getId()))
            {
                messageIdInfoMap.get(message.getId()).getMessageTextList().add(messageText);
            }
            else
            {
                message.getMessageTextList().add(messageText);
                messageIdInfoMap.put(message.getId(), message);
            }
        }
        for (Map.Entry<Integer, Message> messageInfo : messageIdInfoMap.entrySet()) 
        {
            Message tempMessage = messageInfo.getValue();
            messageList.add(tempMessage);
        }
        session.getTransaction().commit();
        return messageList;
    }
    
    public List<Message> getSentMessageList(int userId)
    {
        List<Message> messageList = new ArrayList<>();
        Hashtable<Integer, Message> messageIdInfoMap = new Hashtable<>();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query query = session.createSQLQuery("select {mt.*}, {m.*} from message_texts mt join messages m on mt.message_id = m.id where m.from_user_id = :from_user_id")
                    .addEntity("mt",MessageText.class)
                    .addEntity("m",Message.class)
                    .setInteger("from_user_id", userId);
        List<Object[]> rows =  query.list();
        for(Object[] row : rows)
        {
            MessageText messageText = (MessageText)row[0];
            Message message = (Message)row[1];
            if(messageIdInfoMap.contains(message.getId()))
            {
                messageIdInfoMap.get(message.getId()).getMessageTextList().add(messageText);
            }
            else
            {
                message.getMessageTextList().add(messageText);
                messageIdInfoMap.put(message.getId(), message);
            }
        }
        for (Map.Entry<Integer, Message> messageInfo : messageIdInfoMap.entrySet()) 
        {
            Message tempMessage = messageInfo.getValue();
            messageList.add(tempMessage);
        }
        session.getTransaction().commit();
        return messageList;
    }
    
    public Message getMessageInfo(int messageId)
    {
        Message message = null;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query query = session.createSQLQuery("select {mt.*},{u.*}, {m.*} from message_texts mt join users u on mt.user_id = u.id join messages m on mt.message_id = m.id where mt.message_id = :message_id")
                    .addEntity("mt",MessageText.class)
                    .addEntity("u",User.class)
                    .addEntity("m",Message.class)
                    .setInteger("message_id", messageId);
        List<Object[]> rows =  query.list();
        for(Object[] row : rows)
        {
            if(message == null)
            {
                message = (Message)row[2];
                message.setMessageTextList(new ArrayList<>());
            }
            MessageText messageText = (MessageText)row[0];
            User user = (User)row[1];
            messageText.setUser(user);
            message.getMessageTextList().add(messageText);
        }
        session.getTransaction().commit();
        return message;
    }
}
