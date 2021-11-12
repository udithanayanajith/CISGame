/**
 * 
 */
package gameserver;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import CODE.Game_Remote_Interface;

/**
 * @author Uditha Nayanajith
 *
 */
public class Game_server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting The Server............!!!");
		try {
			Game_Remote_Interface rmt_intface=new Game_Implementation();
			Registry game_reg=LocateRegistry.createRegistry(2021);
			game_reg.rebind("GameService2021", rmt_intface);
						
			System.out.println("Game Server started,Game Service is running now....!");
			
		} catch (RemoteException e) {
			// TODO: handle exception
			System.out.println("Error....!!!"+e.toString());
			e.printStackTrace();
		}
	}

}
