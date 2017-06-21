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
    //@Test
    public void addMessageTextTest() 
    {
        User user1 = new User();
        user1.setId(1);
        User user2 = new User();
        user2.setId(2);
        Product product = new Product();
        product.setId(1);
        
        Message message = new Message();
        message.setFrom(user2);
        message.setTo(user1);
        message.setProduct(product);
        message.setSubject("Hi There");
        
        MessageText messageText = new MessageText();
        messageText.setUser(user1);
        messageText.setBody("Hello World2");
        
        message.getMessageTextList().add(messageText);
        
        MessageManager messageManager = new MessageManager();
        messageManager.addMessageText(message);
        
    }
    
    //@Test
    public void getInboxMessageListTest() 
    {
        MessageManager messageManager = new MessageManager();
        messageManager.getInboxMessageList(2);
    }
    
    @Test
    public void getMessageInfoTest() 
    {
        MessageManager messageManager = new MessageManager();
        Message message = messageManager.getMessageInfo(1);
        System.out.println(message.getSubject());
    }
}
