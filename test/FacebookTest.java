
import com.auction.util.FacebookConfig;
import com.google.gson.JsonObject;
import com.restfb.BinaryAttachment;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;
import com.restfb.types.Page;
import com.restfb.types.User;
import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alamgir
 */
public class FacebookTest {

    private static FacebookClient facebookClient;

    public FacebookTest() {
        
//        facebookClient = new DefaultFacebookClient("EAAJN8HlAVdEBANAPD7u3QN6YKumESMAn6ONP8L2fikMf6w38ooQBtXlj09Xkn1k9tVEdh6ymVfo6VrlxzliysMa7DP9mLZCmr6NJeTcaBS0dg8wLJmMMpyHxQZAoWV0XnemvslLCNrZB9cvkf0rMzZApQ35Fi1oZD","55b6fff3a717b0c16936b4353e9b2f73" ,Version.VERSION_2_3);
        facebookClient = new DefaultFacebookClient("EAAJN8HlAVdEBANAPD7u3QN6YKumESMAn6ONP8L2fikMf6w38ooQBtXlj09Xkn1k9tVEdh6ymVfo6VrlxzliysMa7DP9mLZCmr6NJeTcaBS0dg8wLJmMMpyHxQZAoWV0XnemvslLCNrZB9cvkf0rMzZApQ35Fi1oZD","55b6fff3a717b0c16936b4353e9b2f73" ,Version.VERSION_2_9);
        
        FacebookClient.AccessToken token = facebookClient.obtainExtendedAccessToken("648645175170513", "55b6fff3a717b0c16936b4353e9b2f73");
        
        System.out.println(token.getExpires());
        FacebookClient.DebugTokenInfo debug = facebookClient.debugToken(token.getAccessToken());
        System.out.println(debug.getUserId());
        System.out.println(debug.isValid());
        
        
    }
    
    public static void main(String[] args) {
        FacebookTest ft = new FacebookTest();
        ft.runEverything();

    }

    void runEverything() {
        printProfile();
//        String messageId = publishMessage();
//        delete(messageId);
//        String eventId = publishEvent();
//        delete(eventId);
//        String photoId = publishPhoto();
//        delete(photoId);
    }

    public void printProfile(){
        
        User user = facebookClient.fetchObject("me", User.class);
        
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        System.out.println(user.getBio());
        System.out.println(user.getBirthday());
        System.out.println(user.getBirthdayAsDate());
        System.out.println(user.getGender());
        System.out.println(user.getHometown());
        com.restfb.json.JsonObject js = facebookClient.fetchObject("/me/picture", com.restfb.json.JsonObject.class,
       Parameter.with("type","large"), // the image size
       Parameter.with("redirect","false")); // don't redirect
        System.out.println(js.toString());
        
    }
    
    String publishMessage() {
        System.out.println("* Feed publishing *");

        FacebookType publishMessageResponse
                = facebookClient.publish("me/feed", FacebookType.class, Parameter.with("message", "RestFB test"));

        System.out.println("Published message ID: " + publishMessageResponse.getId());
        return publishMessageResponse.getId();
    }

    String publishEvent() {
        System.out.println("* Event publishing *");

        Date tomorrow = new Date(currentTimeMillis() + 1000L * 60L * 60L * 24L);
        Date twoDaysFromNow = new Date(currentTimeMillis() + 1000L * 60L * 60L * 48L);

        FacebookType publishEventResponse
                = facebookClient.publish("me/events", FacebookType.class, Parameter.with("name", "Party"),
                        Parameter.with("start_time", tomorrow), Parameter.with("end_time", twoDaysFromNow));

        System.out.println("Published event ID: " + publishEventResponse.getId());
        return publishEventResponse.getId();
    }

    String publishPhoto() {
        System.out.println("* Binary file publishing *");

        FacebookType publishPhotoResponse = facebookClient.publish("me/photos", FacebookType.class,
                BinaryAttachment.with("cat.png", getClass().getResourceAsStream("/cat.png")),
                Parameter.with("message", "Test cat"));

        System.out.println("Published photo ID: " + publishPhotoResponse.getId());
        return publishPhotoResponse.getId();
    }

    void delete(String objectId) {
        System.out.println("* Object deletion *");
        System.out.println(format("Deleted %s: %s", objectId, facebookClient.deleteObject(objectId)));
    }
}
