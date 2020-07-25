package wordDictation.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import wordDictation.dao.bookDao;
import wordDictation.model.deliverValue;
import wordDictation.util.DbutilforTuofuBook;
import wordDictation.util.DbutilforYasiBook;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tuofuBookUnit extends JInternalFrame {
	private JTextField unitnameText;
	private JTable bookunittable;
	private DbutilforTuofuBook  dbUtil = new DbutilforTuofuBook();
	private bookDao bookDao = new bookDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tuofuBookUnit frame = new tuofuBookUnit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public tuofuBookUnit() {
		setFrameIcon(new ImageIcon(tuofuBookUnit.class.getResource("/images/\u6258\u798F\u57F9\u8BAD\u7F34\u8D39.png")));
		setTitle("\u4E66\u7C4D\u4FE1\u606F");
		setBounds(100, 100, 593, 535);
		
		JLabel lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setIcon(new ImageIcon(tuofuBookUnit.class.getResource("/images/\u4E66 (1).png")));
		
		unitnameText = new JTextField();
		unitnameText.setEditable(false);
		unitnameText.setFont(new Font("宋体", Font.PLAIN, 16));
		unitnameText.setColumns(10);
		unitnameText.setText(deliverValue.BookName);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_1 = new JLabel("\u9009\u62E9\u8981\u542C\u5199\u7684\u5355\u5143\r\n");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("\u786E\u5B9A\u9009\u62E9\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(unitnameText))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
					.addGap(51))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(441, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(78)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(unitnameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(48)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
		);
		
		bookunittable = new JTable();
		scrollPane.setViewportView(bookunittable);
		bookunittable.setRowHeight(24);
		bookunittable.setFont(new Font("宋体", Font.PLAIN, 20));
		bookunittable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5E8F\u53F7\uFF1A", "\u5355\u5143\u540D\u79F0\uFF1A"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookunittable.getColumnModel().getColumn(0).setResizable(false);
		bookunittable.getColumnModel().getColumn(1).setResizable(false);
		getContentPane().setLayout(groupLayout);
		this.filltable();

	}
	/**
	 * 初始化表格数据
	 * @param selfword
	 */
	private void filltable() {
		DefaultTableModel dtm = (DefaultTableModel) bookunittable.getModel();
		dtm.setRowCount(0);
		String bookname = deliverValue.BookName;
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookDao.listUnit(con, bookname);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("unitname"));
		
				dtm.addRow(v);

			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			dbUtil.closeCon(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	}
	
	
}
