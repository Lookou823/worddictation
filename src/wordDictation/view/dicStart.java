package wordDictation.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import wordDictation.dao.UserDao;
import wordDictation.dao.playSettingDao;
import wordDictation.dao.selfWordDao;
import wordDictation.model.deliverValue;
import wordDictation.model.playSetting;
import wordDictation.util.Dbutil;
import java.awt.event.MouseAdapter;

public class dicStart extends JInternalFrame {
	private JTable wordlistTable;
	private Dbutil  dbUtil = new Dbutil();
	private UserDao userDao = new UserDao();
	private JTextField dateChoose;
	private JTable choosesettingtable;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dicStart frame = new dicStart();
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
	public dicStart() {
		setFrameIcon(new ImageIcon(dicStart.class.getResource("/images/\u542C\u5199 (1).png")));
		setIconifiable(true);
		setClosable(true);
		setTitle("\u542C\u5199\u754C\u9762");
		setBounds(100, 100, 843, 697);
		
		JButton btnNewButton = new JButton("\u5F00\u59CB\u6717\u8BFB");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				wavStartPlay(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JButton button = new JButton("\u6682\u505C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label = new JLabel("\u9009\u62E9\u6717\u8BFB\u8BBE\u7F6E\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JButton btnNewButton_1 = new JButton("\u63D0\u4EA4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JButton btnNewButton_2 = new JButton("\u663E\u793A\u6B63\u786E\u5355\u8BCD");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					correctWordListShow(e);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		
		dateChoose = new JTextField();
		dateChoose.setFont(new Font("宋体", Font.PLAIN, 18));
		dateChoose.setText("\u8F93\u5165\u683C\u5F0F\u4E3A: yyyy-mm-dd");
		dateChoose.setColumns(10);
		
		JLabel label_1 = new JLabel("\u9009\u62E9\u65E5\u671F\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addComponent(btnNewButton_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(dateChoose, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(226, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(162)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 501, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(163, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(18, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(dateChoose, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
					.addGap(19)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(22))))
		);
		
		choosesettingtable = new JTable();
		choosesettingtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent mvt) {
				settingtableMouserPressed(mvt);
			}
		});
		scrollPane_1.setViewportView(choosesettingtable);
		choosesettingtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5E8F\u53F7", "\u6717\u8BFB\u6B21\u6570", "\u95F4\u9694\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		choosesettingtable.getColumnModel().getColumn(0).setPreferredWidth(62);
		choosesettingtable.getColumnModel().getColumn(1).setPreferredWidth(79);
		choosesettingtable.getColumnModel().getColumn(2).setPreferredWidth(83);
		
		wordlistTable = new JTable();
		wordlistTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5E8F\u53F7", "\u5355\u8BCD", "\u4E2D\u6587\u89E3\u91CA"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(wordlistTable);
		getContentPane().setLayout(groupLayout);
		this.filltable2();
	}
	
	
	
	/**
	 * 播放单词
	 * @param evt
	 */
	private void wavStartPlay(ActionEvent evt) {
		Connection con = null;
		try {
			con = dbUtil.getCon();
			//获得登陆用户名
			String username = deliverValue.logUsername;
  		   JOptionPane.showMessageDialog(null, username);

			//获得今天的时间
//			Date dateo = new Date();
//			
//			//简化时间格式
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			//将日期格式类型 转换为 string 类型格式
//			String dateString = format.format(dateo);
//			System.out.println(dateString);
//			//再将转换后的简化格式类型转换为日期格式
//			Date date = format.parse(dateString);
//			//改成sql 用的日期形式
//			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//			SimpleDateFormat changedFormat = new SimpleDateFormat("yyyy-MM-dd");
			//链接数据库，获得用户今日进行的单词录入列表
			String date = dateChoose.getText();

			ResultSet rs = selfWordDao.list(con,username,date);
			Vector<String> v = new  Vector<String>();
			
			while(rs.next()) {

				v.add(rs.getString("word"));
				//v.add(rs.getString("wordExp"));
					
			}
//			Connection con2 = null;
//			con2 = dbUtil.getCon();
//			ResultSet rs2 = playSettingDao.list(con2, username);
//			JOptionPane.showMessageDialog(null, rs2.getString("readingtimes"));
//    		JOptionPane.showMessageDialog(null, rs2.getString("intervaltime"));

    		//将数据库中的间隔时间设置和朗读次数设置读取
		
		
			for(String item: v ) {
				//设置每个单词的重复播放次数
				
				int playTimes = Integer.parseInt(deliverValue.readingtimes); 
				int sleepTime = Integer.parseInt(deliverValue.intervaltime);
				String filePath = "C:\\Users\\留雍迪\\wavforJava\\"+item+".wav";
				while(playTimes>0) {
					
				
				if (!filePath.equals("")) {
					//Get audio input stream
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
					//Get audio coding object
					AudioFormat audioFormat = audioInputStream.getFormat();
					//Set data entry
					DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat,
							AudioSystem.NOT_SPECIFIED);
					SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
					sourceDataLine.open(audioFormat);
					sourceDataLine.start();
					//Read from the data sent to the mixer input stream
					int count;
					byte tempBuffer[] = new byte[1024];
					
					while ((count = audioInputStream.read(tempBuffer, 0, tempBuffer.length)) != -1) {
						if (count > 0) {
							sourceDataLine.write(tempBuffer, 0, count);
						}
					}
					
					Thread.sleep(sleepTime);

					//Empty the data buffer, and close the input
					sourceDataLine.drain();
					sourceDataLine.close();
				}
				else
				{
		    		JOptionPane.showMessageDialog(null, "fuck");

				}
				
				playTimes = playTimes-1;
				}

				
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
	 * 显示正确单词
	 * @param evt
	 * @throws ParseException 
	 */
	private void correctWordListShow(ActionEvent evt) throws ParseException {
		this.fillTable();
	}
	
	/**
	 * 初始化表格1
	 * @param selfWord
	 * @throws ParseException 
	 */
	private void fillTable() throws ParseException {
		DefaultTableModel dtm = (DefaultTableModel) wordlistTable.getModel();
		dtm.setRowCount(0);
//		清空表格
		
//		//获得登陆用户名
		String username = deliverValue.logUsername;
//		//获得今天的时间
//		Date dateo = new Date();
//		
//		//简化时间格式
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		//将日期格式类型 转换为 string 类型格式
//		String dateString = format.format(dateo);
//		System.out.println(dateString);
//		//再将转换后的简化格式类型转换为日期格式
//		Date date = format.parse(dateString);
//		//改成sql 用的日期形式
//		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//		SimpleDateFormat changedFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateChoose.getText();
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = selfWordDao.list(con,username,date);
			while(rs.next()) {
				Vector v = new  Vector();
				v.add(rs.getString("num"));
				v.add(rs.getString("word"));
				v.add(rs.getString("wordExp"));
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
	 * 初始化表格2（选择朗读设置）
	 */
	private void filltable2() {
		DefaultTableModel dtm = (DefaultTableModel) choosesettingtable.getModel();
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
		int row = this.choosesettingtable.getSelectedRow();
		deliverValue.readingtimes = (String)choosesettingtable.getValueAt(row, 1);
		deliverValue.intervaltime = (String)choosesettingtable.getValueAt(row, 2);

		
	}
	
}
