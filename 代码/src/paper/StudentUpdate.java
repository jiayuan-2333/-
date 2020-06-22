package 教务管理系统;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.*;
import javax.swing.*;

public class StudentUpdate extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public StudentUpdate(String id){
		setTitle("修改你的信息");
		setBounds(400, 300, 350, 365);
		setLayout(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Container cp=getContentPane();

		String information []= { "学号", "班级号", "姓名", "性别", "出生日期", "论文题目","导师","联系方式"};	
		
		ArrayList<JLabel> JLlist= new ArrayList<>();
		for(int i = 0;i < information.length;i ++) {
			JLabel jl = new JLabel(information[i]);
			jl.setBounds(45, 10 + 30 * i, 80, 25);
			cp.add(jl);
			JLlist.add(jl);
		}
		
		ArrayList<JTextField> JTlist = new ArrayList<>();
		for(int i = 0;i < information.length;i ++) {
			JTextField jt = new JTextField();
			jt.setBounds(100, 10 + 30 * i, 200, 25);
			cp.add(jt);
			JTlist.add(jt);
		}
		JTlist.get(0).setText(id);
		JTlist.get(0).setEditable(false);
		
		JButton jb=new JButton("确认修改");
		jb.setBounds(85, 280, 100, 30);
		cp.add(jb);
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> list = new ArrayList<>();
				for(int i = 0;i < JTlist.size();i++) {
					list.add(JTlist.get(i).getText());
				}
				Connection con = jdbc.getConnection("root","520");
				jdbc.update01(con, list,id);
				JOptionPane.showMessageDialog(null, "修改成功");
				jdbc.releaseConnectin(con);
			}
		});
		
		JButton jb2=new JButton("返回菜单");
		jb2.setBounds(195, 280, 100, 30);
		cp.add(jb2);
		jb2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new StudentJFrame(id);
			}
		});
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		
	}
}
