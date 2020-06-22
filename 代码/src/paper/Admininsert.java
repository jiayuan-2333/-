package 教务管理系统;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.*;

public class Admininsert extends JFrame{
	private static final long serialVersionUID = 1L;

	public Admininsert () {
		setTitle("新增一个学生的信息");
		setBounds(400, 300, 350, 365);
		setLayout(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Container cp=getContentPane();

		String information []= { "学号","班级号","姓名","性别","出生日期","论文题目","导师","联系方式"};	
		
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

		
		JButton jb=new JButton("确认添加");
		jb.setBounds(85, 280, 100, 30);
		cp.add(jb);
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> list = new ArrayList<>();
				for(int i = 0;i < JTlist.size();i++) {
					list.add(JTlist.get(i).getText());
				}
				Connection con = jdbc.getConnection("root","520");
				jdbc.insert(con, list);
				JOptionPane.showMessageDialog(null, "添加成功");
				jdbc.releaseConnectin(con);
				System.out.println("添加成功");
			}
		});
		
		JButton jb2=new JButton("返回菜单");
		jb2.setBounds(195, 280, 100, 30);
		cp.add(jb2);
		jb2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new AdminJFrame();
			}
		});
	
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	}
}
