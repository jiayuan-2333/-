package �������ϵͳ;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.*;

public class AdminUpdateone extends JFrame{
	private static final long serialVersionUID = 1L;

	public AdminUpdateone () {
		 setTitle("����ĳ��ѧ����Ϣ");
		 setLayout(null);
	     setBounds(300, 200, 350, 200);
	     Container cp = getContentPane();
	     
	     JLabel jl = new JLabel("����ѧ����ѧ�ţ�");
	     jl.setBounds(30, 20, 140, 30);
	     cp.add(jl);
	     
	     JTextField jt = new JTextField();
	     jt.setBounds(150,20,140,25);
	     cp.add(jt);
	     
	     
	     JButton jb = new JButton("�������");
	     jb.setBounds(100, 80, 120, 30);
	     cp.add(jb);

	     
	     jb.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	Connection con = jdbc.getConnection("root","520");	
	            	try {
						String id = jt.getText();
						if(jdbc.checkid(id) == false) {
							 JOptionPane.showMessageDialog(null, "���޴���");
						}else {
				            setVisible(false);
				            new AdminUpdate(id);
						}
					}catch (SQLException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
	            	jdbc.releaseConnectin(con);
	            }
	        });
     
	     setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	     setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
	}

}