package 教务管理系统;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class TeacherJFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	public TeacherJFrame(String id) {
		 setTitle("教师用户菜单");
		 setLayout(null);
	     setBounds(300, 200, 400, 200);
	     Container cp = getContentPane();
	     
	     JButton jb = new JButton("查看个人信息");
	     jb.setBounds(120, 20, 120, 30);
	     cp.add(jb);
	     
	     JButton jb2 = new JButton("修改个人信息");
	     jb2.setBounds(120, 60, 120, 30);
	     cp.add(jb2);
	     
	     JButton jb3 = new JButton("查看学生信息");
	     jb3.setBounds(120, 100, 120, 30);
	     cp.add(jb3);
	   
	     jb.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	setVisible(false);
	            	new TeacherTable(id);
	            }
	        });
	     
	     jb2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	setVisible(false);
	            	new TeacherUpdate(id);
	            }
	        });
	     
	     jb3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	setVisible(false);
	            	new AdminSelectone();
	            }
	        });
	     
	     setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	     setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	}

}
