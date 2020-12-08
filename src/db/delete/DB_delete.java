package db.delete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.utils.C3P0_Data_Source;

public class DB_delete {
	public static boolean verify_delete(int id)
	{
		Connection connection=C3P0_Data_Source.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet rSet=null;		
		try 
		{
			preparedStatement=connection.prepareStatement("Update admin set usable=0 where id=?");
			preparedStatement.setInt(1,id);
			int count=preparedStatement.executeUpdate();
		    if(count==1)
		    	return true;
		} catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		try {
			C3P0_Data_Source.release(connection, preparedStatement, rSet);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}

