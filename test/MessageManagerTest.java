/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.auction.dto.Message;
import com.auction.dto.MessageText;
import com.auction.dto.Product;
import com.auction.dto.User;
import com.auction.manager.MessageManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nazmul
 */
public class MessageManagerTest {
    
    public MessageManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void addMessageTextTest() 
    {
        
        int userId = 2;
        User user = new User();
        user.setId(1);
        Product product = new Product();
        product.setId(1);
        product.setUser(user);
        
        User user2 = new User();
        
        Message message = new Message();
        message.setSubject("sub1");
        message.setProduct(product);
        MessageText messageText = new MessageText();
        messageText.setBody("body2");
        message.getMessageTextList().add(messageText);
        
        MessageManager messageManager = new MessageManager();
        Message messageInfo = messageManager.getMessage(userId, message.getProduct().getUser().getId(), message.getProduct().getId()); 
        if(messageInfo == null || messageInfo.getId() == 0)
        {
            //add new message
            User fromUser = new User();
            fromUser.setId(userId);
            message.setFrom(fromUser);
            User toUser = new User();
            toUser.setId(message.getProduct().getUser().getId());
            message.setTo(toUser);
            user2.setId(userId);
            message.getMessageTextList().get(0).setUser(user2);
            messageManager.addMessageInfo(message);
        }
        else
        {
            //add message text
            message.setId(messageInfo.getId());
            user2.setId(userId);
            message.getMessageTextList().get(0).setUser(user2);            
            message.getMessageTextList().get(0).setMessageId(messageInfo.getId());
            messageManager.addMessageText(message);
        }
        
    }
    
    //@Test
    public void getInboxMessageListTest() 
    {
        MessageManager messageManager = new MessageManager();
        messageManager.getInboxMessageList(2);
    }
    
    //@Test
    public void getMessageInfoTest() 
    {
        MessageManager messageManager = new MessageManager();
        Message message = messageManager.getMessageInfo(1);
        System.out.println(message.getSubject());
    }
}
