package �������ϵͳ;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class AdminJFrame3 extends JFrame{
	private static final long serialVersionUID = 1L;

	public AdminJFrame3() {
		 setTitle("�����ʦ��˵�");
		 setLayout(null);
	     setBounds(300, 200, 400, 200);
	     Container cp = getContentPane();
	     
	     JButton jb = new JButton("�鿴������ʦ��Ϣ");
	     jb.setBounds(65, 20, 140, 30);
	     cp.add(jb);
	     
	     JButton jb2 = new JButton("�鿴ĳ����ʦ��Ϣ");
	     jb2.setBounds(65, 60, 140, 30);
	     cp.add(jb2);
	     
	     JButton jb3 = new JButton("����ĳ����ʦ��Ϣ");
	     jb3.setBounds(220, 20, 140, 30);
	     cp.add(jb3);
	     
	     JButton jb4 = new JButton("ɾ��ĳ����ʦ��Ϣ");
	     jb4.setBounds(220, 60, 140, 30);
	     cp.add(jb4);
	     
	     JButton jb5 = new JButton("����ĳ����ʦ��Ϣ");
	     jb5.setBounds(65, 100, 140, 30);
	     cp.add(jb5);
	     
	     jb.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	setVisible(false);
	            	new AdminShowTeacher();
	            }
	        });
     
	     setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	     setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
	}

}