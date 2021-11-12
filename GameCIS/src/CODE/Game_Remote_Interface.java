/**
 * 
 */
package CODE;

import java.rmi.RemoteException;

/**
 * @author Uditha Nayanajith
 *
 */
public interface Game_Remote_Interface {
	public boolean GameLogin(String username,String password) throws RemoteException;

}
