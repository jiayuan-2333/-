package �������ϵͳ;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.*;

public class AdminDelete extends JFrame{
	private static final long serialVersionUID = 1L;

	public AdminDelete () {
		 setTitle("ɾ��ĳ��ѧ����Ϣ");
		 setLayout(null);
	     setBounds(300, 200, 350, 200);
	     Container cp = getContentPane();
	     
	     JLabel jl = new JLabel("Ҫɾ��ѧ����ѧ�ţ�");
	     jl.setBounds(30, 20, 140, 30);
	     cp.add(jl);
	     
	     JTextField jt = new JTextField();
	     jt.setBounds(150,20,140,25);
	     cp.add(jt);
	     
	     JButton jb = new JButton("ȷ��ɾ��");
	     jb.setBounds(50, 80, 120, 30);
	     cp.add(jb);

	     JButton jb2 = new JButton("���ز˵�");
	     jb2.setBounds(180, 80, 120, 30);
	     cp.add(jb2);
	     
	     jb.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	Connection con = jdbc.getConnection("root","520");		
					try {
						String id = jt.getText();
						if(jdbc.checkid(id) == false) {
							 JOptionPane.showMessageDialog(null, "���޴���");
						}else {
			            	jdbc.delete(con, id);
			            	JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
						}
					}catch (SQLException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
					jdbc.releaseConnectin(con);
	            }
	        });
	     
	     jb2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	setVisible(false);
	            	new AdminJFrame();
	            }
	        });
     
	     setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	     setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
	}

}