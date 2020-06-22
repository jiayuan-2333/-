package �������ϵͳ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

public class AdminShowone extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
	
	}
	
	public AdminShowone(String id) {
		super();
		setTitle("����ѧ������Ϣ");
		setBounds(300, 200, 680, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		String[] columnNames = {"ѧ��", "�༶��","����", "�Ա�", "��������", "������Ŀ","��ʦ","��ϵ��ʽ"};
		Vector<String> columnNameV = new Vector<>();
		for (int column = 0; column < columnNames.length; column++) {
			columnNameV.add(columnNames[column]);
		}
		
		Connection con = jdbc.getConnection("root","520");	
		Vector<String> information=jdbc.query01(con, id);
		Vector<Vector<String>> tableValueV = new Vector<>();
		tableValueV.add(information);
		
		JTable table = new MTable(tableValueV, columnNameV);
		 //����е��Զ���������
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		// ѡ��ģʽΪ��ѡ
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// ��ѡ���еı���ɫΪ��ɫ
		table.setSelectionBackground(Color.YELLOW);
		// ��ѡ���е�ǰ��ɫ��������ɫ��Ϊ��ɫ
		table.setSelectionForeground(Color.RED);
		table.setRowHeight(30); // �����и�Ϊ30����
		scrollPane.setViewportView(table);
		
		JButton jb2=new JButton("���ز˵�");
		getContentPane().add(jb2, BorderLayout.SOUTH);

		jb2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new AdminJFrame();
			}
		});
		setVisible(true);
		jdbc.releaseConnectin(con);
	}
	
	private class MTable extends JTable { // ʵ���Լ��ı����
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MTable(Vector<Vector<String>> rowData, Vector<String> columnNames) {
			super(rowData, columnNames);
		}
		
		@Override
		public JTableHeader getTableHeader() { // ������ͷ
			// ��ñ��ͷ����
			JTableHeader tableHeader = super.getTableHeader();
			tableHeader.setReorderingAllowed(false); // ���ñ���в�������
			DefaultTableCellRenderer hr = (DefaultTableCellRenderer) tableHeader
					.getDefaultRenderer(); // ��ñ��ͷ�ĵ�Ԫ�����
			// ��������������ʾ
			hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			return tableHeader;
		}
		
		// ���嵥Ԫ��
		@Override
		public TableCellRenderer getDefaultRenderer(Class<?> columnClass) {
			DefaultTableCellRenderer cr = (DefaultTableCellRenderer) super
					.getDefaultRenderer(columnClass); // ��ñ��ĵ�Ԫ�����
			// ���õ�Ԫ�����ݾ�����ʾ
			cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			return cr;
		}
		
		@Override
		public boolean isCellEditable(int row, int column) { // ��񲻿ɱ༭
			return false;
		}
	}
}


