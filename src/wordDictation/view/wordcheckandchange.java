package wordDictation.view;

import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import wordDictation.dao.UserDao;
import wordDictation.dao.selfWordDao;
import wordDictation.model.deliverValue;
import wordDictation.model.selfWord;
import wordDictation.util.Dbutil;
import wordDictation.util.StringUtil;

public class wordcheckandchange extends JInternalFrame {
	private JTable wordtable;
	private JTextField spDateText;
	private Dbutil  dbUtil = new Dbutil();
	private UserDao userDao = new UserDao();
	private JTextField numText;
	private JTextField wordCText;
	private JTextField expText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wordcheckandchange frame = new wordcheckandchange();
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
	public wordcheckandchange() {
		setFrameIcon(new ImageIcon(wordcheckandchange.class.getResource("/images/\u81EA\u5B9A\u4E49.png")));
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("\u5355\u8BCD\u8BB0\u5F55\u67E5\u8BE2\u548C\u4FEE\u6539");
		setBounds(100, 100, 815, 540);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(76, Short.MAX_VALUE))
		);
		
		JLabel label_1 = new JLabel("\u5E8F\u53F7\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		
		numText = new JTextField();
		numText.setFont(new Font("宋体", Font.PLAIN, 20));
		numText.setEditable(false);
		numText.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5355\u8BCD\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		
		wordCText = new JTextField();
		wordCText.setFont(new Font("宋体", Font.PLAIN, 20));
		wordCText.setColumns(10);
		
		JLabel label_3 = new JLabel("\u91CA\u4E49\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 14));
		
		expText = new JTextField();
		expText.setFont(new Font("宋体", Font.PLAIN, 20));
		expText.setColumns(10);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				wordUpdateActionPerformed(evt);
			}

		
		});
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		button.setIcon(new ImageIcon(wordcheckandchange.class.getResource("/images/\u4FEE \u6539.png")));
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			/**
			 * 删除事件
			 */
			public void actionPerformed(ActionEvent evt) {
				wordDeleteActionPerformed(evt);
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 16));
		button_1.setIcon(new ImageIcon(wordcheckandchange.class.getResource("/images/\u5220 \u9664.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(numText, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(wordCText, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(expText, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(numText, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(wordCText, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(expText, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel label = new JLabel("\u67E5\u627E\u65E5\u671F\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		spDateText = new JTextField();
		spDateText.setFont(new Font("宋体", Font.PLAIN, 20));
		spDateText.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wordSearchactionPerformed(e);
			}

		
		});
		btnNewButton.setIcon(new ImageIcon(wordcheckandchange.class.getResource("/images/\u641C\u7D22.png")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spDateText, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(spDateText, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		wordtable = new JTable();
		wordtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				wordtableMouserPressed(met);
			}

		
		});
		wordtable.setFont(new Font("宋体", Font.PLAIN, 18));
		wordtable.setRowHeight(22);
		scrollPane.setViewportView(wordtable);
		wordtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5E8F\u53F7", "\u5355\u8BCD", "\u91CA\u4E49", "\u8BB0\u5F55\u65E5\u671F"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		getContentPane().setLayout(groupLayout);
		selfWord selfword = new selfWord();
		selfword.setOwerUser(deliverValue.logUsername);
		this.filltable(selfword);
	}


	/**
	 * 初始化表格数据
	 * @param selfword
	 */
	private void filltable(selfWord selfword) {
		DefaultTableModel dtm = (DefaultTableModel) wordtable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = selfWordDao.listforchange(con, selfword);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("num"));
				v.add(rs.getString("word"));
				v.add(rs.getString("wordExp"));
				v.add(rs.getString("changeDate"));
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
	 * 单词记录日期查询
	 * @param e
	 */
	private void wordSearchactionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
		String targetDate = this.spDateText.getText();
		selfWord selfword = new selfWord();
		selfword.setChangeDate(targetDate);
		selfword.setOwerUser(deliverValue.logUsername);

		this.filltable(selfword);
		
	}
	
	/**
	 * 表格行点击处理
	 * @param met
	 */
	private void wordtableMouserPressed(MouseEvent met) {
		// TODO Auto-generated method stub
		int row = this.wordtable.getSelectedRow();
		this.numText.setText((String)wordtable.getValueAt(row, 0));
		this.wordCText.setText((String)wordtable.getValueAt(row, 1));
		this.expText.setText((String)wordtable.getValueAt(row, 2));
		
	}
	
	/**
	 * 单词修改事件处理
	 * @param evt
	 */
	private void wordUpdateActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String num = this.numText.getText();
		if(StringUtil.isEmpty(num)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		String word = this.wordCText.getText();
		String wordexp = this.expText.getText();
		selfWord selfword = new selfWord( word,  wordexp,"",  "");
		selfword.setNum(Integer.parseInt(num));
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = selfWordDao.update(con,selfword );
			if(n==1) {
				JOptionPane.showMessageDialog(null, "修改成功 ");
				resetValue();
				selfword.setOwerUser(deliverValue.logUsername);

				filltable(selfword);

			}else {
				JOptionPane.showMessageDialog(null, "修改失败 ");

			}
			
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败 ");

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
	 * 单词记录删除
	 * @param evt
	 */
	private void wordDeleteActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String num = this.numText.getText();
				if(StringUtil.isEmpty(num)) {
					JOptionPane.showMessageDialog(null, "请选择要删除的记录");
					return;
				}
				int n2 = JOptionPane.showConfirmDialog(null, "确定要删除该条记录吗？");
				if(n2==0) {
					String word = this.wordCText.getText();
					String wordexp = this.expText.getText();
					selfWord selfword = new selfWord( word,  wordexp,"",  "");
					selfword.setNum(Integer.parseInt(num));
					Connection con = null;
					try {
						con = dbUtil.getCon();
						int n = selfWordDao.delete(con,Integer.parseInt(num));
						if(n==1) {
							JOptionPane.showMessageDialog(null, "删除成功 ");
							resetValue();
							selfword.setOwerUser(deliverValue.logUsername);

							filltable(selfword);

						}else {
							JOptionPane.showMessageDialog(null, "删除失败 ");

						}
						
					}catch(Exception e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "删除失败 ");

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
	/**
	 * 重置表单
	 */
	
	private void resetValue() {
		this.wordCText.setText("");
		this.expText.setText("");
		this.numText.setText("");
	}
	
}
