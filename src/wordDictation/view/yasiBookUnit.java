package wordDictation.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import wordDictation.dao.bookDao;
import wordDictation.model.deliverValue;
import wordDictation.util.DbutilforYasiBook;

public class yasiBookUnit extends JInternalFrame {
	private JTextField booknameText;
	private JTable bookunittable;
	private DbutilforYasiBook dbUtil = new DbutilforYasiBook();
	private bookDao bookDao = new bookDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					yasiBookUnit frame = new yasiBookUnit();
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
	public yasiBookUnit() {
		setFrameIcon(new ImageIcon(yasiBookUnit.class.getResource("/images/\u96C5\u601D\u57F9\u8BAD\u7F34\u8D39 (1).png")));
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("\u4E66\u7C4D\u4FE1\u606F");
		setBounds(100, 100, 683, 574);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(yasiBookUnit.class.getResource("/images/\u4E66 (1).png")));
		
		booknameText = new JTextField();
		booknameText.setFont(new Font("宋体", Font.PLAIN, 16));
		booknameText.setEditable(false);
		booknameText.setColumns(10);
		booknameText.setText(deliverValue.BookName);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_1 = new JLabel("\u4E66\u7C4D\u5168\u90E8\u5355\u5143\u5C55\u793A\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JButton btnNewButton = new JButton("\u786E\u5B9A\u5355\u5143");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(btnNewButton))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(booknameText, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(68, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(booknameText, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(58)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)))
					.addGap(36)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		
		bookunittable = new JTable();
		bookunittable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				yasitableMouserPressed(met);
			}
		});
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
		getContentPane().setLayout(groupLayout);
		this.filltable();
	}
	
	/**
	 * 表格行点击处理
	 * @param met
	 */
	private void yasitableMouserPressed(MouseEvent met) {
		// TODO Auto-generated method stub
		int row = this.bookunittable.getSelectedRow();
	    deliverValue.bookUnitName = (String) bookunittable.getValueAt(row, 1);
		JOptionPane.showMessageDialog(null, deliverValue.bookUnitName);

		
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
