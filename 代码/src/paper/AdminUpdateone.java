package 教务管理系统;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.*;

public class AdminUpdateone extends JFrame{
	private static final long serialVersionUID = 1L;

	public AdminUpdateone () {
		 setTitle("更新某个学生信息");
		 setLayout(null);
	     setBounds(300, 200, 350, 200);
	     Container cp = getContentPane();
	     
	     JLabel jl = new JLabel("更新学生的学号：");
	     jl.setBounds(30, 20, 140, 30);
	     cp.add(jl);
	     
	     JTextField jt = new JTextField();
	     jt.setBounds(150,20,140,25);
	     cp.add(jt);
	     
	     
	     JButton jb = new JButton("进入更新");
	     jb.setBounds(100, 80, 120, 30);
	     cp.add(jb);

	     
	     jb.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	Connection con = jdbc.getConnection("root","520");	
	            	try {
						String id = jt.getText();
						if(jdbc.checkid(id) == false) {
							 JOptionPane.showMessageDialog(null, "查无此人");
						}else {
				            setVisible(false);
				            new AdminUpdate(id);
						}
					}catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
	            	jdbc.releaseConnectin(con);
	            }
	        });
     
	     setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	     setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
	}

}