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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import wordDictation.dao.bookDao;
import wordDictation.model.book;
import wordDictation.model.deliverValue;
import wordDictation.util.DbutilforKaoyanBook;
import wordDictation.util.DbutilforYasiBook;

public class kaoyanBookView extends JInternalFrame {
	private JTable bookTable;
	private DbutilforKaoyanBook dbUtil = new DbutilforKaoyanBook();
	private bookDao bookDao = new bookDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kaoyanBookView frame = new kaoyanBookView();
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
	public kaoyanBookView() {
		setFrameIcon(new ImageIcon(kaoyanBookView.class.getResource("/images/\u96C5\u601D\u57F9\u8BAD\u7F34\u8D39 (1).png")));
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("\u96C5\u601D\u4E66\u7C4D\u4E00\u89C8");
		setBounds(100, 100, 738, 606);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u9009\u62E9\u8981\u8FDB\u884C\u542C\u5199\u7684\u96C5\u601D\u8BCD\u6C47\u4E66\u7C4D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("\u786E\u5B9A\u9009\u62E9");
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
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 606, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(68, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(42))
		);
		
		bookTable = new JTable();
bookTable.addMouseListener(new MouseAdapter() {
			
			/**
			 * 获得选择的书名
			 */
			@Override
			public void mousePressed(MouseEvent met) {
			
		
					booktableMouserPressed(met);
				
			}
		});
		scrollPane.setViewportView(bookTable);
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5E8F\u53F7", "\u4E66\u540D"
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
	 * 初始化表格数据
	 * @param selfword
	 */
	private void filltable() {
		DefaultTableModel dtm = (DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0);
		//String username = deliverValue.logUsername;
		Connection con = null;
		try {
			con = dbUtil.getCon();
			book book = new book();
			ResultSet rs = bookDao.list(con, book);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("name"));
		
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
	/**
	 * 表格行点击处理
	 * @param met
	 */
	private void booktableMouserPressed(MouseEvent met) {
		// TODO Auto-generated method stub
		int row = this.bookTable.getSelectedRow();
		deliverValue.BookName = (String)bookTable.getValueAt(row, 1);
		JOptionPane.showMessageDialog(null, deliverValue.BookName);

		
	}
}
