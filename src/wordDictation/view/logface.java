package wordDictation.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import wordDictation.dao.UserDao;
import wordDictation.model.User;
import wordDictation.model.deliverValue;
import wordDictation.util.Dbutil;
import wordDictation.util.StringUtil;

public class logface extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	private Dbutil  dbUtil = new Dbutil();
	private UserDao userDao = new UserDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logface frame = new logface();
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
	public logface() {
		setTitle("\u8F7B\u677E\u542C\u5355\u8BCD");
		setIconImage(Toolkit.getDefaultToolkit().getImage(logface.class.getResource("/images/\u82F1\u8BED (1).png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton_login = new JButton("\u767B\u5F55");
		btnNewButton_login.setFont(new Font("幼圆", Font.PLAIN, 15));
		btnNewButton_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		
		JButton btnNewButton_reset = new JButton("\u91CD\u7F6E");
		btnNewButton_reset.setFont(new Font("幼圆", Font.PLAIN, 15));
		btnNewButton_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);

				
			}
		});
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u767B\u5F55\u754C\u9762");
		lblNewLabel.setIcon(new ImageIcon(logface.class.getResource("/images/\u4E66 (2).png")));
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(logface.class.getResource("/images/\u7528\u6237.png")));
		lblNewLabel_1.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		JLabel label = new JLabel("\u5BC6\u7801\uFF1A\r\n");
		label.setIcon(new ImageIcon(logface.class.getResource("/images/\u5BC6\u7801.png")));
		label.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
										.addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton_login, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_reset, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(19))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_login, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_reset, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
//		设置居中
		this.setLocationRelativeTo(null);  
	}
	/**
	 * 登录事件处理
	 * @param e
	 */
    private void loginActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
    	String userName = this.userNameTxt.getText();
    	deliverValue.logUsername = userName;
    	String passWord = new String(this.passwordTxt.getPassword());
    	if(StringUtil.isEmpty(userName)) {
    		JOptionPane.showMessageDialog(null, "用户名不能为空");
    		return;
    	}
    	if(StringUtil.isEmpty(passWord)) {
    		JOptionPane.showMessageDialog(null, "密码不能为空");
    		return;
    	}
		User user = new User(userName,passWord);
		Connection con = null;
		
		try {
			con = dbUtil.getCon();
			User currentUser = userDao.login(con, user);
			if(currentUser != null) {
//				JOptionPane.showMessageDialog(null, "登录成功！");
//				销毁当前窗体

//核对信息成功后，及时关闭连接，避免库锁导致sqlite busy
//				dbUtil.closeCon(con);
				dispose();
				new Mainframe().setVisible(true);
				
			}else {
				JOptionPane.showMessageDialog(null, "用户名或者密码错误！");
			}
		}catch(Exception e1) {
			e1.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	/**
	 * 重置事件处理
	 * @param e
	 */
	protected void resetValueActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
		
	}
}
