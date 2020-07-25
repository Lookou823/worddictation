package wordDictation.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import wordDictation.dao.playSettingDao;
import wordDictation.dao.selfWordDao;
import wordDictation.model.deliverValue;
import wordDictation.model.playSetting;
import wordDictation.model.selfWord;
import wordDictation.util.Dbutil;
import wordDictation.util.StringUtil;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;

public class settingDic extends JInternalFrame {
	private JTextField timeText;
	private JTextField frequencyText;
	private Dbutil dbUtil = new Dbutil();
	private selfWordDao selfWordDao = new selfWordDao();
	private JTable table;
	private JTable settingtable;
	private JTextField changetimesText;
	private JTextField changeintervalText;
	private JTextField numText;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					settingDic frame = new settingDic();
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
	public settingDic() {
		setFrameIcon(new ImageIcon(settingDic.class.getResource("/images/\u6717\u8BFB2.png")));
		setIconifiable(true);
		setClosable(true);
		setTitle("\u6717\u8BFB\u8BBE\u7F6E");
		setBounds(100, 100, 630, 679);
		
		table = new JTable();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u5F53\u524D\u6717\u8BFB\u8BBE\u7F6E\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u6DFB\u52A0\u65B0\u7684\u8BBE\u7F6E", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u4FEE\u6539\u8BBE\u7F6E", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 476, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE))
							.addGap(9)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(74, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(59, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE)
					.addGap(80))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(153)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 120, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
							.addGap(36)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel label_1 = new JLabel("\u8BBE\u7F6E\u6717\u8BFB\u6B21\u6570\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label_2 = new JLabel("\u8BBE\u7F6E\u95F4\u9694\u65F6\u95F4\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		changetimesText = new JTextField();
		changetimesText.setFont(new Font("宋体", Font.PLAIN, 16));
		changetimesText.setColumns(10);
		
		changeintervalText = new JTextField();
		changeintervalText.setFont(new Font("宋体", Font.PLAIN, 16));
		changeintervalText.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("\u4FEE\u6539");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				settingUpdateActionPerformed(evt);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_2.setIcon(new ImageIcon(settingDic.class.getResource("/images/\u4FEE \u6539.png")));
		
		JButton btnNewButton_3 = new JButton("\u5220\u9664");
		btnNewButton_3.addActionListener(new ActionListener() {
			/**
			 * 删除设置
			 */
			public void actionPerformed(ActionEvent evt) {
				settingDeleteActionPerformed(evt);
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_3.setIcon(new ImageIcon(settingDic.class.getResource("/images/\u5220 \u9664.png")));
		
		JLabel lblNewLabel_2 = new JLabel("\u5E8F\u53F7\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		numText = new JTextField();
		numText.setFont(new Font("宋体", Font.PLAIN, 16));
		numText.setEditable(false);
		numText.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnNewButton_2)
							.addPreferredGap(ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
							.addComponent(btnNewButton_3)
							.addGap(38))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE))
								.addComponent(label_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
								.addComponent(label_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(numText)
								.addComponent(changeintervalText)
								.addComponent(changetimesText, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
							.addContainerGap(73, Short.MAX_VALUE))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(numText, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(changetimesText, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(changeintervalText, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BBE\u7F6E\u6717\u8BFB\u6B21\u6570\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel = new JLabel("\u8BBE\u7F6E\u95F4\u9694\u65F6\u95F4\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		frequencyText = new JTextField();
		frequencyText.setFont(new Font("宋体", Font.PLAIN, 16));
		frequencyText.setColumns(10);
		
		timeText = new JTextField();
		timeText.setFont(new Font("宋体", Font.PLAIN, 16));
		timeText.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				resetValueActionPerformed(e);
			}
		});
		
		JButton btnNewButton = new JButton("\u8BBE\u7F6E\u5B8C\u6BD5");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				settingAddActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(timeText, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
								.addComponent(frequencyText, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(frequencyText, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(timeText, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		settingtable = new JTable();
		settingtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				settingtableMouserPressed( met);
				
			}
		});
		settingtable.setFont(new Font("宋体", Font.PLAIN, 20));
		settingtable.setRowHeight(24);
		scrollPane.setViewportView(settingtable);
		settingtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5E8F\u53F7", "\u6717\u8BFB\u6B21\u6570", "\u95F4\u9694\u65F6\u95F4\uFF08ms\uFF09"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		settingtable.getColumnModel().getColumn(1).setPreferredWidth(82);
		settingtable.getColumnModel().getColumn(2).setPreferredWidth(104);
		getContentPane().setLayout(groupLayout);
		this.filltable();
	
	}
	
	
	/**
	 * 设置记录删除
	 * @param evt
	 */

	private void settingDeleteActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String num = this.numText.getText();
		if(StringUtil.isEmpty(num)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n2 = JOptionPane.showConfirmDialog(null, "确定要删除该条记录吗？");
		if(n2==0) {
			String settimes = this.changetimesText.getText();
			String setinterval = this.changeintervalText.getText();
			playSetting playsetting = new playSetting();
			playsetting.setIntervaltime(Integer.parseInt(setinterval));
			playsetting.setReadingtimes(Integer.parseInt(settimes));
			playsetting.setS_username(deliverValue.logUsername);
			playsetting.setNum(Integer.parseInt(num));
			Connection con = null;
			try {
				con = dbUtil.getCon();
				int n = playSettingDao.delete(con,Integer.parseInt(num));
				if(n==1) {
					JOptionPane.showMessageDialog(null, "删除成功 ");
					cresetValue();
					filltable();

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
	 * 初始化表格数据
	 * @param selfword
	 */
	private void filltable() {
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
	private void settingtableMouserPressed(MouseEvent met) {
		// TODO Auto-generated method stub
		int row = this.settingtable.getSelectedRow();
		this.changetimesText.setText((String)settingtable.getValueAt(row, 1));
		this.changeintervalText.setText((String)settingtable.getValueAt(row, 2));
		this.numText.setText((String)settingtable.getValueAt(row, 0));

		
	}
	
	
	
	/**
	 * 朗读设置添加处理事件
	 * @param evt
	 */
	private void settingAddActionPerformed(ActionEvent evt) {
		//获得文本框中的内容
		String readingtimesContent =  this.frequencyText.getText();
		String intervaltimeContent = this.timeText.getText();
		String s_usernameContent = deliverValue.logUsername;
		
		if(StringUtil.isEmpty(readingtimesContent)||StringUtil.isEmpty(intervaltimeContent)||StringUtil.isEmpty(s_usernameContent)) {
			JOptionPane.showMessageDialog(null, "朗读次数或间隔时间或用户名不能为空！");
			return;
			
		}
		//实例化
		int int_readingtimesContent = Integer.parseInt(readingtimesContent);
		int int_intervaltimeContent = Integer.parseInt(intervaltimeContent);
		playSetting playSetting = new playSetting();
		playSetting.setIntervaltime(int_intervaltimeContent);
		playSetting.setReadingtimes(int_readingtimesContent);
		playSetting.setS_username(deliverValue.logUsername);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = playSettingDao.add(con, playSetting);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "添加成功 ");
				resetValue();
				this.filltable();

			}else {
				JOptionPane.showMessageDialog(null, "添加失败 ");

			}
			
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "添加失败 ");

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
	 * 单词修改事件处理
	 * @param evt
	 */
	private void settingUpdateActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String num = this.numText.getText();
		if(StringUtil.isEmpty(num)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		//建立对象获得参数
		String settimes = this.changetimesText.getText();
		String setinterval = this.changeintervalText.getText();
		playSetting playsetting = new playSetting();
		playsetting.setIntervaltime(Integer.parseInt(setinterval));
		playsetting.setReadingtimes(Integer.parseInt(settimes));
		playsetting.setS_username(deliverValue.logUsername);
		playsetting.setNum(Integer.parseInt(num));
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = playSettingDao.update(con,playsetting );
			if(n==1) {
				JOptionPane.showMessageDialog(null, "修改成功 ");
				cresetValue();

				filltable();

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
	 * 重置事件处理
	 * @param evt
	 */

	private void resetValueActionPerformed(ActionEvent evt) {
		this.resetValue();
	}
	
	
	/**
	 * 重置设置的输入
	 */
	
	
	private void resetValue() {
		this.timeText.setText("");
		this.frequencyText.setText("");
	}
	
	private void cresetValue() {
		this.changeintervalText.setText("");
		this.changetimesText.setText("");
		this.numText.setText("");
	}
}
