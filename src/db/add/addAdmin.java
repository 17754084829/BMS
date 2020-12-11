package db.add;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.utils.C3P0_Data_Source;
import model.Admin;

public class addAdmin {
	public static boolean verify_add(Admin admin)
	{
		Connection connection=C3P0_Data_Source.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet rSet=null;		
		try {
			
			preparedStatement=connection.prepareStatement("INSERT INTO admin (name,password,telephone,sex,addtime,roles,usable)values(?,?,?,?,?,?,?)");
			
			preparedStatement.setString(1,admin.getName());
			preparedStatement.setString(2,admin.getPassword());
			preparedStatement.setString(3,admin.getTelephone());
			preparedStatement.setInt(4,admin.getSex());
			preparedStatement.setDate(5,admin.getAddtime());
			preparedStatement.setInt(6,admin.getRoles());
			preparedStatement.setInt(7,admin.getUsable());
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