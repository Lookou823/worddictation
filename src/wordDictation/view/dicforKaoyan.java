package wordDictation.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import wordDictation.dao.bookDao;
import wordDictation.dao.selfWordDao;
import wordDictation.model.deliverValue;
import wordDictation.util.DbutilforKaoyanBook;
import wordDictation.util.DbutilforYasiBook;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class dicforKaoyan extends JInternalFrame {
	private JTable wordtable;
	private JTextField wordNumText;
	private DbutilforKaoyanBook dbUtil = new DbutilforKaoyanBook();
	private bookDao bookDao = new bookDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dicforKaoyan frame = new dicforKaoyan();
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
	public dicforKaoyan() {
		setFrameIcon(new ImageIcon(dicforKaoyan.class.getResource("/images/\u8003\u7814.png")));
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("\u542C\u5199\u754C\u9762");
		setBounds(100, 100, 603, 564);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u4F60\u60F3\u542C\u5199\u7684\u5355\u8BCD\u4E2A\u6570\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		wordNumText = new JTextField();
		wordNumText.setColumns(10);
		
		JButton btnNewButton = new JButton("\u9690\u85CF\u8868\u683C\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wordtable.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton btnNewButton_1 = new JButton("\u663E\u793A\u8868\u683C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wordtable.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton btnNewButton_2 = new JButton("\u5F00\u59CB\u542C\u5199\r\n");
		btnNewButton_2.addActionListener(new ActionListener() {
			/**
			 * 听写。。。。。
			 */
			public void actionPerformed(ActionEvent e) {
				
				wavStartPlay(e);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(32, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(wordNumText, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)
								.addGap(39)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton)
							.addGap(27)
							.addComponent(btnNewButton_1)
							.addGap(21))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(wordNumText)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
					.addGap(87)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		
		wordtable = new JTable();
		wordtable.setRowHeight(24);
		wordtable.setFont(new Font("宋体", Font.PLAIN, 20));
		wordtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				kaoyantableMouserPressed(met);
			}
		});
		scrollPane.setViewportView(wordtable);
		wordtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5E8F\u53F7\uFF1A", "\u5355\u8BCD\u5185\u5BB9\uFF1A", "\u91CA\u4E49\uFF1A"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		wordtable.getColumnModel().getColumn(1).setPreferredWidth(114);
		wordtable.getColumnModel().getColumn(2).setPreferredWidth(179);
		getContentPane().setLayout(groupLayout);
		this.filltable();
	}
	
	private void wavStartPlay(ActionEvent evt) {
		Connection con = null;
		try {
			con = dbUtil.getCon();
			//获得登陆用户名
//			String username = deliverValue.logUsername;
//  		   JOptionPane.showMessageDialog(null, username);

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
//			String date = dateChoose.getText();
			String bookname = deliverValue.BookName;
			String unitname = deliverValue.bookUnitName;
			deliverValue.numtag2 = Integer.parseInt(wordNumText.getText());
			int begin = deliverValue.numtag1;
			int end = begin+deliverValue.numtag2;
			ResultSet rs = bookDao.listWordLimit(con, bookname, unitname, begin, end);
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
	 * 表格行点击处理
	 * @param met
	 */
	private void kaoyantableMouserPressed(MouseEvent met) {
		// TODO Auto-generated method stub
		int row = this.wordtable.getSelectedRow();
	    deliverValue.numtag1 = Integer.parseInt((String)wordtable.getValueAt(row, 0));
		JOptionPane.showMessageDialog(null, deliverValue.numtag1);

		
	}
	
	/**
	 * 初始化表格数据
	 * @param selfword
	 */
	private void filltable() {
		DefaultTableModel dtm = (DefaultTableModel) wordtable.getModel();
		dtm.setRowCount(0);
		String bookname = deliverValue.BookName;
		String unitname = deliverValue.bookUnitName;
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookDao.listWord(con, bookname,unitname);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("word"));
				v.add(rs.getString("exp"));

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
