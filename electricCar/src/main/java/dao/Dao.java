package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// dao : DB ���ٰ�ü
public class Dao {
	protected Connection con;	// db���� Ŭ���� 
	protected PreparedStatement ps;  // db���� �������̽�
	protected ResultSet rs; // db��� �������̽�
	
	public Dao() {
			// jdbc 
			// 1. ������Ʈ�� build path �� mysqljdbc.jar �߰�
			// 2. ������Ʈ�� webapp -> web-inf-lib -> mysqljdbc.jar �߰�
		// 1. db ���� ���� 
		try { // ����ó�� => �ڹٿ� �ܺ�����Ҷ� : �Ϲݿ��ܰ� ������ �߻� 
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elecro?serverTimezone=UTC",
					"root","1234");
			System.out.println("jspweb ���� ���� ");
		}catch(Exception e ){ System.out.println("���� ���� ");}
	}
	
	
}