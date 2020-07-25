package wordDictation.view;

import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import wordDictation.dao.UserDao;
import wordDictation.dao.playSettingDao;
import wordDictation.model.deliverValue;
import wordDictation.util.Dbutil;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class confirmreadingSetting extends JInternalFrame {
	private JTable settingtable;
	private Dbutil  dbUtil = new Dbutil();
	private UserDao userDao = new UserDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					confirmreadingSetting frame = new confirmreadingSetting();
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
	public confirmreadingSetting() {
		setFrameIcon(new ImageIcon(confirmreadingSetting.class.getResource("/images/\u8BBE \u7F6E.png")));
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("\u8BBE\u7F6E\u5168\u5C40\u6717\u8BFB");
		setBounds(100, 100, 674, 503);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("\u8BBE\u7F6E\u5B8C\u6BD5\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 540, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(59)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(77, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(45))
		);
		
		settingtable = new JTable();
		settingtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				mousechoose(met);
			}
		});
		scrollPane.setViewportView(settingtable);
		settingtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5E8F\u53F7\uFF1A", "\u6717\u8BFB\u6B21\u6570", "\u95F4\u9694\u65F6\u95F4\uFF08ms\uFF09"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		settingtable.getColumnModel().getColumn(1).setPreferredWidth(105);
		settingtable.getColumnModel().getColumn(2).setPreferredWidth(142);
		getContentPane().setLayout(groupLayout);
		this.filltable2();
	}
	
	
	/**
	 * 初始化表格2（选择朗读设置）
	 */
	private void filltable2() {
		DefaultTableModel dtm = (DefaultTableModel) settingtable.getModel();
		dtm.setRowCount(0);
		String username = deliverValue.logUsername;
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = playSettingDao.list(con, username);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("num"));
				v.add(rs.getString("readingtimes"));
				v.add(rs.getString("intervaltime"));
		
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
	
	/**
	 * 表格行点击处理
	 * @param met
	 */
	private void mousechoose(MouseEvent met) {
		// TODO Auto-generated method stub
		int row = this.settingtable.getSelectedRow();
		deliverValue.readingtimes = (String)settingtable.getValueAt(row, 1);
		deliverValue.intervaltime = (String)settingtable.getValueAt(row, 2);

		
	}
	
}
