package gameserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import CODE.Game_Remote_Interface;

public  class Game_Implementation extends UnicastRemoteObject implements Game_Remote_Interface {
	private static Connection conn;
	
	protected Game_Implementation() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/game", "root", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean GameLogin(String username, String password) throws RemoteException {
		// TODO Auto-generated method stub
		boolean result=false;
		try 
		{			
			
			String sql = "SELECT * FROM login WHERE userName = '" + username + "' AND password= '" + password +"'";
			
			PreparedStatement  pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();

					while (rs.next()) {
						if (rs.getString("password").equalsIgnoreCase(password)) {				
							result = true;														 
						} else {
							result = false;
							
						}
					}
						return result; //result		
	
			} 
			catch(Exception e) 
			{
				System.out.println("Implementation error in cath clouse");
				System.out.println(e.getMessage().toString());
				return false;
			}
	}


}
