package 教务管理系统;
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
		setTitle("查找学生的信息");
		setBounds(300, 200, 680, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		String[] columnNames = {"学号", "班级号","姓名", "性别", "出生日期", "论文题目","导师","联系方式"};
		Vector<String> columnNameV = new Vector<>();
		for (int column = 0; column < columnNames.length; column++) {
			columnNameV.add(columnNames[column]);
		}
		
		Connection con = jdbc.getConnection("root","520");	
		Vector<String> information=jdbc.query01(con, id);
		Vector<Vector<String>> tableValueV = new Vector<>();
		tableValueV.add(information);
		
		JTable table = new MTable(tableValueV, columnNameV);
		 //表格列的自动调整功能
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		// 选择模式为单选
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// 被选择行的背景色为黄色
		table.setSelectionBackground(Color.YELLOW);
		// 被选择行的前景色（文字颜色）为红色
		table.setSelectionForeground(Color.RED);
		table.setRowHeight(30); // 表格的行高为30像素
		scrollPane.setViewportView(table);
		
		JButton jb2=new JButton("返回菜单");
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
	
	private class MTable extends JTable { // 实现自己的表格类
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MTable(Vector<Vector<String>> rowData, Vector<String> columnNames) {
			super(rowData, columnNames);
		}
		
		@Override
		public JTableHeader getTableHeader() { // 定义表格头
			// 获得表格头对象
			JTableHeader tableHeader = super.getTableHeader();
			tableHeader.setReorderingAllowed(false); // 设置表格列不可重排
			DefaultTableCellRenderer hr = (DefaultTableCellRenderer) tableHeader
					.getDefaultRenderer(); // 获得表格头的单元格对象
			// 设置列名居中显示
			hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			return tableHeader;
		}
		
		// 定义单元格
		@Override
		public TableCellRenderer getDefaultRenderer(Class<?> columnClass) {
			DefaultTableCellRenderer cr = (DefaultTableCellRenderer) super
					.getDefaultRenderer(columnClass); // 获得表格的单元格对象
			// 设置单元格内容居中显示
			cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			return cr;
		}
		
		@Override
		public boolean isCellEditable(int row, int column) { // 表格不可编辑
			return false;
		}
	}
}


