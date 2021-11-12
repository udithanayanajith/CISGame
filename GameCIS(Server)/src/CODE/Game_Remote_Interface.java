/**
 * 
 */
package CODE;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Uditha Nayanajith
 *
 */
public interface Game_Remote_Interface extends Remote {
	public boolean GameLogin(String username,String password) throws RemoteException;

}
