package 教务管理系统;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class StudentJFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	public StudentJFrame(String id) {
		 setTitle("学生用户菜单");
		 setLayout(null);
	     setBounds(300, 200, 260, 150);
	     Container cp = getContentPane();
	     JButton jb = new JButton("查看个人信息");
	     jb.setBounds(65, 20, 120, 30);
	     cp.add(jb);
	     
	     JButton jb2 = new JButton("修改个人信息");
	     jb2.setBounds(65, 60, 120, 30);
	     cp.add(jb2);
	     
	     jb.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	setVisible(false);
	            	new StudentTable(id);
	            }
	        });
	     
	     jb2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	setVisible(false);
	            	new StudentUpdate(id);
	            }
	        });
	     
	     setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	     setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	}

}
