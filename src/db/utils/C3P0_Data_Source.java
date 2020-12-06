package db.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0_Data_Source {
	 //�õ�һ������Դ
    private static DataSource dataSource = new ComboPooledDataSource();

    //������Դ�еõ��и����Ӷ���
    public static Connection getConnection(){
        try{
            return dataSource.getConnection();
        }catch (SQLException e){
            throw new RuntimeException("����������");
        }
    }

    public static void release(Connection conn, Statement stmt, ResultSet rs){
        if(rs!=null){
            try{
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(stmt!=null){
            try{
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
