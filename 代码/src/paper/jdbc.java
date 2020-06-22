package �������ϵͳ;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;


public class jdbc {
	static Connection con; // ����Connection����
	static PreparedStatement sql; // ����Statement����
	static ResultSet res; // ����ResultSet����
	
	public static Connection getConnection(String user,String pass) { // �������ݿⷽ��

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paper", user, pass);
			System.out.println("succees");
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
		return con; // ����Connection����
	}
	
	public static void releaseConnectin(Connection con) {//�ͷ����ݿ�����
		try {
			if(con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// ��֤ѧ����¼
	public static boolean checkLogin(String userStr, String passStr)
			throws SQLException {
		sql = con.prepareStatement("select * from ѧ��  where ����='"
				+ userStr + "' and ѧ��='" + passStr + "'"); // ��ѯ���ݿ�
		res = sql.executeQuery(); // ִ��SQL���
		return res.next();
	}
	
	//��֤��ʦ��¼
	public static boolean TeachercheckLogin(String userStr, String passStr)
			throws SQLException {
		sql = con.prepareStatement("select * from ��ʦ��  where ����='"
				+ userStr + "' and ��ʦ��='" + passStr + "'"); // ��ѯ���ݿ�
		res = sql.executeQuery(); // ִ��SQL���
		return res.next();
	}
	
	//��֤ѧ���Ƿ����
	public static boolean checkid(String id)
			throws SQLException {
		sql = con.prepareStatement("select * from ѧ�� where ѧ�� = ? "); // ��ѯ���ݿ�
		sql.setString(1, id);
		res = sql.executeQuery(); // ִ��SQL���
		return res.next();
	}
	
	public static Vector<String> query01(Connection con,String csid) {//��ѯָ��ѧ��ѧ��
		Vector<String> information = new Vector<>();
		try {
			sql = con.prepareStatement("select * from ѧ��  where ѧ�� = ?"); // ��ѯ���ݿ�
			sql.setString(1, csid);
			res = sql.executeQuery(); // ִ��SQL���

			while (res.next()) { // �����ǰ��䲻�����һ�������ѭ��
				information.add(res.getString("ѧ��").trim());
				information.add(res.getString("�༶��").trim());
				information.add(res.getString("����").trim());
				information.add(res.getString("�Ա�").trim());
				information.add(res.getString("��������").trim());
				information.add(res.getString("������Ŀ").trim());
				information.add(res.getString("��ʦ").trim());
				information.add(res.getString("��ϵ��ʽ").trim());
				System.out.println("succees1");
			}	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("erro1");
		}
		return information;
	}
	
	public static Vector<Vector<String>> query(Connection con) {//��ѯ����ѧ��
		Vector<Vector<String>> information = new Vector<>();
		try {
			sql = con.prepareStatement("select * from ѧ��  "); // ��ѯ���ݿ�
			res = sql.executeQuery(); // ִ��SQL���
			while (res.next()) { // �����ǰ��䲻�����һ�������ѭ��
					Vector<String> rowV = new Vector<String>();
					rowV.add(res.getString("ѧ��").trim());
					rowV.add(res.getString("�༶��").trim());
					rowV.add(res.getString("����").trim());
					rowV.add(res.getString("�Ա�").trim());
					rowV.add(res.getString("��������").trim());
					rowV.add(res.getString("������Ŀ").trim());
					rowV.add(res.getString("��ʦ").trim());
					rowV.add(res.getString("��ϵ��ʽ").trim());
					information.add(rowV);
					System.out.println("succees2");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return information;
	}
	
	public static Vector<Vector<String>> queryteacher(Connection con) {//��ѯ���н�ʦ
		Vector<Vector<String>> information = new Vector<>();
		try {
			sql = con.prepareStatement("select * from ��ʦ��"); // ��ѯ���ݿ�
			res = sql.executeQuery(); // ִ��SQL���
			while (res.next()) { // �����ǰ��䲻�����һ�������ѭ��
					Vector<String> rowV = new Vector<String>();
					rowV.add(res.getString("��ʦ��").trim());
					rowV.add(res.getString("����").trim());
					rowV.add(res.getString("�Ա�").trim());
					rowV.add(res.getString("��������").trim());
					rowV.add(res.getString("���").trim());
					rowV.add(res.getString("����").trim());
					rowV.add(res.getString("��ϵ��ʽ").trim());
					information.add(rowV);
					System.out.println("succees3");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error3");
		}
		return information;
	}
	
	
	public static Vector<Vector<String>> querybook(Connection con) {//��ѯ��������
		Vector<Vector<String>> information = new Vector<>();
		try {
			sql = con.prepareStatement("select * from ���ı� "); // ��ѯ���ݿ�
			res = sql.executeQuery(); // ִ��SQL���
			while (res.next()) { // �����ǰ��䲻�����һ�������ѭ��
					Vector<String> rowV = new Vector<String>();
					rowV.add(res.getString("���").trim());
					rowV.add(res.getString("������Ŀ").trim());
					rowV.add(res.getString("����").trim());
					rowV.add(res.getString("ѧ��").trim());
					rowV.add(res.getString("��ʦ").trim());
					information.add(rowV);
					System.out.println("succees6");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error6");
		}
		return information;
	}
	
	public static void update01(Connection con,ArrayList<String>list,String id) {//����ѧ������
		try {
			sql = con.prepareStatement("update ѧ��  set ѧ��  = ? , �༶��  = ?,����  = ?, �Ա� = ?,�������� = ?, "
					+ "������Ŀ = ?,��ʦ = ?,��ϵ��ʽ  = ? where ѧ�� = ? ");
			for(int i = 0;i < 8;i ++) {
				sql.setString(i + 1, list.get(i));
			}
			sql.setString(9, id);
			sql.executeUpdate();
			System.out.println("succees7");
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			System.out.println("error7");
		}
	}
	
	public static void insert(Connection con,ArrayList<String> list) {//����һ��ѧ������
		try {
			sql = con.prepareStatement("insert into ѧ�� (ѧ��,�༶��,����,�Ա�,��������,������Ŀ,��ʦ,��ϵ��ʽ)  "
					+ "values(?,?,?,?,?,?,?,?)");
			for(int i = 0;i < 7;i ++) {
				sql.setString(i + 1, list.get(i));
			}
			sql.setInt(8, Integer.parseInt(list.get(7)));
			sql.executeUpdate();
			System.out.println("succees8");
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			System.out.println("error8");
		}
	}
	
	public static void delete(Connection con,String id) {//ɾ��һ��ѧ������
		try {
			sql = con.prepareStatement("delete from ѧ�� where ѧ�� = ?");
			sql.setString(1, id);
			sql.executeUpdate();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
	}

}
