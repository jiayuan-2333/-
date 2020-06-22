package 教务管理系统;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class AdminJFrame4 extends JFrame{
	private static final long serialVersionUID = 1L;

	public AdminJFrame4() {
		 setTitle("管理论文表菜单");
		 setLayout(null);
	     setBounds(300, 200, 400, 200);
	     Container cp = getContentPane();
	     
	     JButton jb = new JButton("查看所有论文信息");
	     jb.setBounds(65, 20, 140, 30);
	     cp.add(jb);
	     
	     JButton jb2 = new JButton("查看某个论文信息");
	     jb2.setBounds(65, 60, 140, 30);
	     cp.add(jb2);
	     
	     JButton jb3 = new JButton("增加某个论文信息");
	     jb3.setBounds(220, 20, 140, 30);
	     cp.add(jb3);
	     
	     JButton jb4 = new JButton("删除某个论文信息");
	     jb4.setBounds(220, 60, 140, 30);
	     cp.add(jb4);
	     
	     JButton jb5 = new JButton("更新某个论文信息");
	     jb5.setBounds(65, 100, 140, 30);
	     cp.add(jb5);
	     
	     jb.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	setVisible(false);
	            	new AdminShowBook();
	            }
	        });
     
	     setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	     setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	}

}