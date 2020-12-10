package db.look;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import db.utils.C3P0_Data_Source;
import model.Admin;

public class DB_lookuser {
	public static ArrayList<Admin> user_look(String name, int id,Date addtime) {
		//创建资源链接对象
		Connection connection = C3P0_Data_Source.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
        //用于存储查询的结果的
		ArrayList <Admin> ads = new ArrayList<Admin>();
        //用于存储查询的条件参数的
        ArrayList list = new ArrayList();
		try {
            //定义sql语句
            String sql = "select * from admin where usable=1 and 1 = 1";
            //admin id 不为空
            
            if (id != 0) {
                sql = sql + " and id = ?";
                list.add(id);
            }
          //admin name 不为空
            if (!"".equals(name.trim())){
                sql = sql + " and name = ?";
                list.add(name);
            }
            if(addtime!=null) {
            	 sql = sql + " and addtime = ?";
                 list.add(addtime);
            }
            preparedStatement = connection.prepareStatement(sql);
            if (list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    preparedStatement.setObject(i+1,list.get(i));
                }
            }
            //执行sql
            rs = preparedStatement.executeQuery();
            //遍历查询
            while (rs.next()) {
				Admin ad = new Admin();
				ad.setId(rs.getInt("id"));
				ad.setName(rs.getString("name"));
				ad.setSex(rs.getInt("sex"));
				ad.setTelephone(rs.getString("telephone"));
				ad.setAddtime(rs.getDate("addtime"));
				ad.setUsable(rs.getInt("0"));
				ads.add(ad);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			C3P0_Data_Source.release(connection, preparedStatement, rs);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ads;
	}
	

	
	
	
	public static ArrayList<Admin> alluser_look() {
		//创建资源链接对象
		Connection connection = C3P0_Data_Source.getConnection();
		PreparedStatement preparedStatement = null;
		ArrayList<Admin> arr = new ArrayList();
		ResultSet rSet = null;
		try {
			preparedStatement = connection.prepareStatement("select * from admin where usable=1");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Admin ad = new Admin();
				ad.setId(rs.getInt("id"));
				ad.setName(rs.getString("name"));
				ad.setSex(rs.getInt("sex"));
				ad.setTelephone(rs.getString("telephone"));
				ad.setAddtime(rs.getDate("addtime"));
				arr.add(ad);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			C3P0_Data_Source.release(connection, preparedStatement, rSet);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return arr;
	}
}
