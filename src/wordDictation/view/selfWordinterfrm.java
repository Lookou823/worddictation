package wordDictation.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import wordDictation.dao.selfWordDao;
import wordDictation.model.deliverValue;
import wordDictation.model.selfWord;
import wordDictation.util.Dbutil;
import wordDictation.util.StringUtil;
public class selfWordinterfrm extends JInternalFrame {
	private JTextField wordText;
	private JTextField wordExpText;
	private Dbutil dbUtil = new Dbutil();
	private selfWordDao selfWordDao = new selfWordDao();
	//ctrl shift o ���������
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selfWordinterfrm frame = new selfWordinterfrm();
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
	public selfWordinterfrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u81EA\u5B9A\u4E49\u5355\u8BCD\u542C\u5199");
		setBounds(100, 100, 450, 429);
		
		JLabel lblNewLabel = new JLabel("\u5355\u8BCD\u8F93\u5165\uFF1A");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));
		
		wordText = new JTextField();
		wordText.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					wordAddActionPerformed(e);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 16));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		/**
		 * reset
		 */
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("\u5355\u8BCD\u91CA\u4E49\uFF1A");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 20));
		
		wordExpText = new JTextField();
		wordExpText.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("\u8F93\u5165\u5B8C\u6BD5");
		btnNewButton_2.addActionListener(new ActionListener() {
			/**
			 * ���ٴ��ڣ�������һ���������ʶ������ͼ��ʱ��
			 */
			public void actionPerformed(ActionEvent e) {
				dispose();
		}
		});
		btnNewButton_2.setFont(new Font("����", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(wordText, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
										.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(62)
											.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(wordExpText, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)))))))
					.addGap(46))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(wordText, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(68)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(wordExpText, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
					.addGap(42)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(23))
		);
		getContentPane().setLayout(groupLayout);

		//�����ı���߿�
		
		wordExpText.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
	}
	
	
	/**
	 * ������Ӵ����¼�
	 * @param evt
	 * @throws ParseException 
	 */
	private void wordAddActionPerformed(ActionEvent evt) throws ParseException {
		
		
		//��ȡ��¼ʱ���û���
		String userName = deliverValue.logUsername;		
		//����ı����е�����
		String wordContent =  this.wordText.getText();
		String wordExpContent = this.wordExpText.getText();
		//��ý����ʱ��
		Date dateo = new Date();
		
		//��ʱ���ʽ
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//�����ڸ�ʽ���� ת��Ϊ string ���͸�ʽ
		String dateString = format.format(dateo);
		System.out.println(dateString);
		//�ٽ�ת����ļ򻯸�ʽ����ת��Ϊ���ڸ�ʽ
		Date date = format.parse(dateString);
		//�ĳ�sql �õ�������ʽ
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		SimpleDateFormat changedFormat = new SimpleDateFormat("yyyy-MM-dd");

		
		if(StringUtil.isEmpty(wordContent)||StringUtil.isEmpty(wordExpContent)) {
			JOptionPane.showMessageDialog(null, "���ʻ����岻��Ϊ�գ�");
			return;
			
		}
		//ʵ����
		selfWord selfWord = new selfWord(wordContent,wordExpContent," "," ");
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = selfWordDao.add(con, selfWord,userName,changedFormat.format(sqlDate));
			if(n==1) {
				JOptionPane.showMessageDialog(null, "��ӳɹ� ");
				resetValue();

			}else {
				JOptionPane.showMessageDialog(null, "���ʧ�� ");

			}
			
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "���ʧ�� ");

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
	 * �����¼�����
	 * @param evt
	 */

	private void resetValueActionPerformed(ActionEvent evt) {
		this.resetValue();
	}
	
	
	/**
	 * �������뵥��
	 */
	
	
	private void resetValue() {
		this.wordText.setText("");
		this.wordExpText.setText("");
	}
}
