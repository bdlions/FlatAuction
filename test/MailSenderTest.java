
import com.auction.email.MailSender;
import com.auction.email.MailUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alamgir
 */
public class MailSenderTest {

    /**
     * Test the send html e-mail method
     *
     */
    public static void main(String[] args) {

        // outgoing message information
        String mailTo = "alamgirkabir7@gmail.com";
        String subject = "Hello my friend";

        Map<String, String> input = new HashMap<>();
        input.put("v_link", "http://property-auction.com/verify?vCode=" + UUID.randomUUID().toString());
        input.put("email", mailTo);

        //HTML mail content
        String htmlText = MailUtil.readEmailFromHtml("mail-templates/mail-verification.html", input);

        MailSender mailer = new MailSender();

        try {
            mailer.sendHtmlEmail(mailTo, subject, htmlText);
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email.");
            ex.printStackTrace();
        }
    }
}
