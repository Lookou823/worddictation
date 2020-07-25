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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import wordDictation.dao.bookDao;
import wordDictation.model.deliverValue;
import wordDictation.util.DbutilforKaoyanBook;
import wordDictation.util.DbutilforYasiBook;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class kaoyanBookUnit extends JInternalFrame {
	private JTextField booknameText;
	private JTable bookunittable;
	private DbutilforKaoyanBook dbUtil = new DbutilforKaoyanBook();
	private bookDao bookDao = new bookDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kaoyanBookUnit frame = new kaoyanBookUnit();
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
	public kaoyanBookUnit() {
		setFrameIcon(new ImageIcon(kaoyanBookUnit.class.getResource("/images/\u8003\u7814.png")));
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("\u4E66\u7C4D\u4FE1\u606F");
		setBounds(100, 100, 585, 508);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(kaoyanBookUnit.class.getResource("/images/\u4E66 (1).png")));
		
		booknameText = new JTextField();
		booknameText.setEditable(false);
		booknameText.setFont(new Font("宋体", Font.PLAIN, 16));
		booknameText.setColumns(10);
		booknameText.setText(deliverValue.BookName);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_1 = new JLabel("\u9009\u62E9\u8981\u542C\u5199\u7684\u5355\u5143\uFF1A\r\n");
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
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(booknameText, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
							.addGap(36)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(booknameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(33))
		);
		
		bookunittable = new JTable();
		bookunittable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				kaoyantableMouserPressed( met);
			}
		});
		bookunittable.setRowHeight(24);
		bookunittable.setFont(new Font("宋体", Font.PLAIN, 20));

		scrollPane.setViewportView(bookunittable);
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
	private void kaoyantableMouserPressed(MouseEvent met) {
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
