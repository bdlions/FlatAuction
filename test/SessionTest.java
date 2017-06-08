
import com.auction.dto.Credential;
import com.auction.util.DBUserProvider;
import org.bdlions.session.ISession;
import org.bdlions.session.UserSessionManagerImpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alamgir
 */
public class SessionTest {
    public static void main(String[] args) {
        UserSessionManagerImpl s = new UserSessionManagerImpl(new DBUserProvider());
        Credential cr = new Credential();
        cr.setUserName("alamgir");
        cr.setPassword("pass");
        
        ISession session = s.createSession(cr);
        session = s.getSessionBySessionId(session.getSessionId());
        System.out.println("User id : " + session.getUserId());
    }
}
