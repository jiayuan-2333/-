package �������ϵͳ;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class AdminJFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	public AdminJFrame() {
		 setTitle("����Ա�û��˵�");
		 setLayout(null);
	     setBounds(300, 200, 400, 200);
	     Container cp = getContentPane();
	     
	     JButton jb = new JButton("ѧ����");
	     jb.setBounds(120, 20, 120, 30);
	     cp.add(jb);
	     
	     JButton jb2 = new JButton("��ʦ��");
	     jb2.setBounds(120, 60, 120, 30);
	     cp.add(jb2);
	     
	     JButton jb3 = new JButton("���ı�");
	     jb3.setBounds(120, 100, 120, 30);
	     cp.add(jb3);
	     
	     jb.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	setVisible(false);
	            	new AdminJFrame2();
	            }
	        });
	     
	     jb2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	setVisible(false);
	            	new AdminJFrame3();
	            }
	        });
	     
	     jb3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	setVisible(false);
	            	new AdminJFrame4();
	            }
	        });
    
	     setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	     setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
	}

}
