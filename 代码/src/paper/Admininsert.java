package �������ϵͳ;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.*;

public class Admininsert extends JFrame{
	private static final long serialVersionUID = 1L;

	public Admininsert () {
		setTitle("����һ��ѧ������Ϣ");
		setBounds(400, 300, 350, 365);
		setLayout(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Container cp=getContentPane();

		String information []= { "ѧ��","�༶��","����","�Ա�","��������","������Ŀ","��ʦ","��ϵ��ʽ"};	
		
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

		
		JButton jb=new JButton("ȷ�����");
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
				JOptionPane.showMessageDialog(null, "��ӳɹ�");
				jdbc.releaseConnectin(con);
				System.out.println("��ӳɹ�");
			}
		});
		
		JButton jb2=new JButton("���ز˵�");
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
		// TODO �Զ����ɵķ������
	}
}
