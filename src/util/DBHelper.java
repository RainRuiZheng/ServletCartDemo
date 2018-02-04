package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
   
	private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //���ݿ�����
	//�������ݿ��URL��ַ//jdbc:sqlserver://localhost:1433; DatabaseName=ServletSQL
	private static final String url="jdbc:sqlserver://localhost:1433; DatabaseName=ServletSQL"; 
	private static final String username="sa";//���ݿ���û���
	private static final String password="123456";//���ݿ������
    
	private static Connection conn=null;
	
	//��̬����鸺���������
	static 
	{
		try
		{
			Class.forName(driver);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	//����ģʽ�������ݿ����Ӷ���
	public static Connection getConnection() throws Exception
	{
		if(conn==null)
		{
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;
	}
	
	public static void main(String[] args) {
		
		try
		{
		   Connection conn = DBHelper.getConnection();
		   if(conn!=null)
		   {
			   System.out.println("���ݿ�����������");
		   }
		   else
		   {
			   System.out.println("���ݿ������쳣��");
		   }
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
}
