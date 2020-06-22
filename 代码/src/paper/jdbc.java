package 教务管理系统;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;


public class jdbc {
	static Connection con; // 声明Connection对象
	static PreparedStatement sql; // 声明Statement对象
	static ResultSet res; // 声明ResultSet对象
	
	public static Connection getConnection(String user,String pass) { // 连接数据库方法

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paper", user, pass);
			System.out.println("succees");
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
		return con; // 返回Connection对象
	}
	
	public static void releaseConnectin(Connection con) {//释放数据库连接
		try {
			if(con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 验证学生登录
	public static boolean checkLogin(String userStr, String passStr)
			throws SQLException {
		sql = con.prepareStatement("select * from 学生  where 姓名='"
				+ userStr + "' and 学号='" + passStr + "'"); // 查询数据库
		res = sql.executeQuery(); // 执行SQL语句
		return res.next();
	}
	
	//验证老师登录
	public static boolean TeachercheckLogin(String userStr, String passStr)
			throws SQLException {
		sql = con.prepareStatement("select * from 老师表  where 姓名='"
				+ userStr + "' and 教师号='" + passStr + "'"); // 查询数据库
		res = sql.executeQuery(); // 执行SQL语句
		return res.next();
	}
	
	//验证学号是否存在
	public static boolean checkid(String id)
			throws SQLException {
		sql = con.prepareStatement("select * from 学生 where 学号 = ? "); // 查询数据库
		sql.setString(1, id);
		res = sql.executeQuery(); // 执行SQL语句
		return res.next();
	}
	
	public static Vector<String> query01(Connection con,String csid) {//查询指定学号学生
		Vector<String> information = new Vector<>();
		try {
			sql = con.prepareStatement("select * from 学生  where 学号 = ?"); // 查询数据库
			sql.setString(1, csid);
			res = sql.executeQuery(); // 执行SQL语句

			while (res.next()) { // 如果当前语句不是最后一条则进入循环
				information.add(res.getString("学号").trim());
				information.add(res.getString("班级号").trim());
				information.add(res.getString("姓名").trim());
				information.add(res.getString("性别").trim());
				information.add(res.getString("出生日期").trim());
				information.add(res.getString("论文题目").trim());
				information.add(res.getString("导师").trim());
				information.add(res.getString("联系方式").trim());
				System.out.println("succees1");
			}	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("erro1");
		}
		return information;
	}
	
	public static Vector<Vector<String>> query(Connection con) {//查询所有学生
		Vector<Vector<String>> information = new Vector<>();
		try {
			sql = con.prepareStatement("select * from 学生  "); // 查询数据库
			res = sql.executeQuery(); // 执行SQL语句
			while (res.next()) { // 如果当前语句不是最后一条则进入循环
					Vector<String> rowV = new Vector<String>();
					rowV.add(res.getString("学号").trim());
					rowV.add(res.getString("班级号").trim());
					rowV.add(res.getString("姓名").trim());
					rowV.add(res.getString("性别").trim());
					rowV.add(res.getString("出生日期").trim());
					rowV.add(res.getString("论文题目").trim());
					rowV.add(res.getString("导师").trim());
					rowV.add(res.getString("联系方式").trim());
					information.add(rowV);
					System.out.println("succees2");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return information;
	}
	
	public static Vector<Vector<String>> queryteacher(Connection con) {//查询所有教师
		Vector<Vector<String>> information = new Vector<>();
		try {
			sql = con.prepareStatement("select * from 老师表"); // 查询数据库
			res = sql.executeQuery(); // 执行SQL语句
			while (res.next()) { // 如果当前语句不是最后一条则进入循环
					Vector<String> rowV = new Vector<String>();
					rowV.add(res.getString("教师号").trim());
					rowV.add(res.getString("姓名").trim());
					rowV.add(res.getString("性别").trim());
					rowV.add(res.getString("出生日期").trim());
					rowV.add(res.getString("婚否").trim());
					rowV.add(res.getString("籍贯").trim());
					rowV.add(res.getString("联系方式").trim());
					information.add(rowV);
					System.out.println("succees3");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error3");
		}
		return information;
	}
	
	
	public static Vector<Vector<String>> querybook(Connection con) {//查询所有论文
		Vector<Vector<String>> information = new Vector<>();
		try {
			sql = con.prepareStatement("select * from 论文表 "); // 查询数据库
			res = sql.executeQuery(); // 执行SQL语句
			while (res.next()) { // 如果当前语句不是最后一条则进入循环
					Vector<String> rowV = new Vector<String>();
					rowV.add(res.getString("编号").trim());
					rowV.add(res.getString("论文题目").trim());
					rowV.add(res.getString("作者").trim());
					rowV.add(res.getString("学号").trim());
					rowV.add(res.getString("导师").trim());
					information.add(rowV);
					System.out.println("succees6");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error6");
		}
		return information;
	}
	
	public static void update01(Connection con,ArrayList<String>list,String id) {//更新学生数据
		try {
			sql = con.prepareStatement("update 学生  set 学号  = ? , 班级号  = ?,姓名  = ?, 性别 = ?,出生日期 = ?, "
					+ "论文题目 = ?,导师 = ?,联系方式  = ? where 学号 = ? ");
			for(int i = 0;i < 8;i ++) {
				sql.setString(i + 1, list.get(i));
			}
			sql.setString(9, id);
			sql.executeUpdate();
			System.out.println("succees7");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("error7");
		}
	}
	
	public static void insert(Connection con,ArrayList<String> list) {//插入一个学生数据
		try {
			sql = con.prepareStatement("insert into 学生 (学号,班级号,姓名,性别,出生日期,论文题目,导师,联系方式)  "
					+ "values(?,?,?,?,?,?,?,?)");
			for(int i = 0;i < 7;i ++) {
				sql.setString(i + 1, list.get(i));
			}
			sql.setInt(8, Integer.parseInt(list.get(7)));
			sql.executeUpdate();
			System.out.println("succees8");
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("error8");
		}
	}
	
	public static void delete(Connection con,String id) {//删除一个学生数据
		try {
			sql = con.prepareStatement("delete from 学生 where 学号 = ?");
			sql.setString(1, id);
			sql.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	}

}
