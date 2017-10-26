package com.auction.manager;

import com.auction.db.HibernateUtil;
import com.bdlions.dto.Message;
import com.bdlions.dto.MessageText;
import com.bdlions.dto.Product;
import com.bdlions.dto.User;
import com.auction.util.TimeUtils;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
    
    /**
     * This method will check whether a message exists or not between two users for a product
     * @param fromUserId from user id
     * @param toUserId to user id
     * @param productId product id
     * @return boolean whether message exists or not
     * @author nazmul hasan on 11th June 2017
     */
    public Message getMessage(int fromUserId, int toUserId, int productId)
    {
        Message messageInfo = null;
        Transaction transaction = null;
        try
        {
            Session session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("select {m.*} from messages m where m.from_user_id = :from_user_id and m.to_user_id = :to_user_id and m.product_id = :product_id ")
                        .addEntity("m",Message.class)
                        .setInteger("from_user_id", fromUserId)
                        .setInteger("to_user_id", toUserId)
                        .setInteger("product_id", productId);
            List<Message> messages =  query.list();
            for (Message message : messages) 
            {
                messageInfo = message;
                break;
            }
            if (!transaction.wasCommitted()){
                transaction.commit();
            }            
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            if(transaction != null)
            {
                transaction.rollback();
            }    
            messageInfo = null;
        }  
        return messageInfo;
    }
    
    /**
     * This method will add message and message text
     * @param message message
     * @return boolean whether message and message text is added or not
     * @author nazmul hasan on 11th June 2017
     */
    public boolean addMessageInfo(Message message)
    {
        boolean response = false;
        Transaction transaction = null;
        try
        {
            if( message != null && message.getFrom() != null && message.getTo() != null && message.getProduct() != null)
            {
                TimeUtils timeUtils = new TimeUtils();
                long currentUnixTime = timeUtils.getCurrentTime();
                message.setCreatedOn(currentUnixTime);
                Session session = HibernateUtil.getSession();
                transaction = session.beginTransaction();
                Query query = session.createSQLQuery("select {m.*} from messages m where m.from_user_id = :from_user_id and m.to_user_id = :to_user_id and m.product_id = :product_id ")
                            .addEntity("m",Message.class)
                            .setInteger("from_user_id", message.getFrom().getId())
                            .setInteger("to_user_id", message.getTo().getId())
                            .setInteger("product_id", message.getProduct().getId());
                List<Message> messages =  query.list();
                if(messages == null || messages.isEmpty())
                {
                    session.save(message);                    
                }
                if (!transaction.wasCommitted()){
                    transaction.commit();
                }
                transaction = session.beginTransaction();
                if(message.getMessageTextList() != null && message.getMessageTextList().size() > 0)
                {
                    MessageText messageText = message.getMessageTextList().get(0);
                    messageText.setCreatedOn(currentUnixTime);
                    messageText.setMessageId(message.getId());
                    session.save(messageText);
                }
                if (!transaction.wasCommitted()){
                    transaction.commit();
                }
                response = true;
            }            
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            if(transaction != null)
            {
                transaction.rollback();
            }     
            response = false;
        }  
        return response;
    }
    
    /**
     * This method will add message text
     * @param message message
     * @return boolean whether message text is added or not
     * @author nazmul hasan on 11th June 2017
     */
    public boolean addMessageText(Message message)
    {
        Transaction transaction = null;
        try
        {
            if(message != null && message.getId() > 0)
            {
                TimeUtils timeUtils = new TimeUtils();
                long currentUnixTime = timeUtils.getCurrentTime();
                Session session = HibernateUtil.getSession();
                transaction = session.beginTransaction();
                if(message.getMessageTextList() != null && message.getMessageTextList().size() > 0)
                {
                    MessageText messageText = message.getMessageTextList().get(0);
                    messageText.setCreatedOn(currentUnixTime);
                    session.save(messageText);
                }
                if (!transaction.wasCommitted()){
                    transaction.commit();
                }
                return true;
            }            
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            if(transaction != null)
            {
                transaction.rollback();
            }            
        }  
        return false;
    }
    
    /**
     * This method will return inbox message list
     * @param userId user id
     * @return List message list
     * @author nazmul hasan on 11th June 2017
     */
    public List<Message> getInboxMessageList(int userId)
    {
        Transaction transaction = null;
        List<Message> messageList = new ArrayList<>();
        try
        {
            Hashtable<Integer, Message> messageIdInfoMap = new Hashtable<>();
            Session session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
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
                    //messageIdInfoMap.get(message.getId()).getMessageTextList().add(messageText);
                }
                else
                {
                    //message.getMessageTextList().add(messageText);
                    messageIdInfoMap.put(message.getId(), message);
                }
            }
            for (Map.Entry<Integer, Message> messageInfo : messageIdInfoMap.entrySet()) 
            {
                Message tempMessage = messageInfo.getValue();
                messageList.add(tempMessage);
            }
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            if(transaction != null)
            {
                transaction.rollback();
            }
            messageList = new ArrayList<>();
        }
        return messageList;
    }
    
    /**
     * This method will return sent message list
     * @param userId user id
     * @return List message list
     * @author nazmul hasan on 11th June 2017
     */
    public List<Message> getSentMessageList(int userId)
    {
        Transaction transaction = null;        
        List<Message> messageList = new ArrayList<>();
        try
        {
            Hashtable<Integer, Message> messageIdInfoMap = new Hashtable<>();
            Session session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
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
                    //messageIdInfoMap.get(message.getId()).getMessageTextList().add(messageText);
                }
                else
                {
                    //message.getMessageTextList().add(messageText);
                    messageIdInfoMap.put(message.getId(), message);
                }
            }
            for (Map.Entry<Integer, Message> messageInfo : messageIdInfoMap.entrySet()) 
            {
                Message tempMessage = messageInfo.getValue();
                messageList.add(tempMessage);
            }
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            if(transaction != null)
            {
                transaction.rollback();
            }
            messageList = new ArrayList<>();
        }        
        return messageList;
    }
    
    /**
     * This method will return message details
     * @param messageId message id
     * @return Message message info
     * @author nazmul hasan on 11th June 2017
     */
    public Message getMessageInfo(int messageId)
    {
        Transaction transaction = null;
        Message message = null;
        TimeUtils timeUtils = new TimeUtils();
        try
        {
            Session session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
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
                messageText.setCreatedTime(timeUtils.convertUnixToHuman(messageText.getCreatedOn(), "dd-MM-yyyy h:mm a"));
                message.getMessageTextList().add(messageText);
            }
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            if(transaction != null)
            {
                transaction.rollback();
            }
            message = null;
        }        
        return message;
    }
}
