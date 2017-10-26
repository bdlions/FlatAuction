
import com.bdlions.dto.Credential;
import java.net.InetAddress;
import java.util.ArrayList;
import org.apache.shiro.authc.UnknownAccountException;
import org.bdlions.session.ISession;
import org.bdlions.session.ISessionManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alamgir
 */
public class MockSessionManager implements ISessionManager{

    @Override
    public ISession getSessionBySessionId(String sessionId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ISession getOnlineSessionByUserId(long userId) throws UnknownAccountException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ISession createSession(Credential iSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroySession(String sessionId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateSession(String sessionId, InetAddress address, int port) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ISession getSession(String userName, int device) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ISession getLatestSession(String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ISession> getSessions(String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
