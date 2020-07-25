package wordDictation.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mainframe extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainframe frame = new Mainframe();
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
	public Mainframe() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Mainframe.class.getResource("/images/\u81EA\u62CD-\u4E3B\u754C\u9762-\u7F8E\u989C.png")));
		setTitle("\u542C\u5199\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 743);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u4E3B\u4F53\u529F\u80FD");
		menu.setIcon(new ImageIcon(Mainframe.class.getResource("/images/\u529F\u80FD.png")));
		menuBar.add(menu);
		
		JMenu menu_2 = new JMenu("\u81EA\u5B9A\u4E49\u5355\u8BCD\u542C\u5199");
		menu.add(menu_2);
		
		JMenuItem menuItem = new JMenuItem("\u81EA\u5B9A\u4E49\u5355\u8BCD\u5F55\u5165");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selfWordinterfrm selfWordinterfrm =new selfWordinterfrm();
				selfWordinterfrm.setVisible(true);
				table.add(selfWordinterfrm);
				
			}
		});
		menuItem.setIcon(new ImageIcon(Mainframe.class.getResource("/images/\u81EA\u5B9A\u4E49.png")));
		menu_2.add(menuItem);
		
		JMenuItem menuItem_6 = new JMenuItem("\u5F00\u59CB\u542C\u5199");
		menuItem_6.addActionListener(new ActionListener() {
			/**
			 * 自定义听写开始
			 */
			public void actionPerformed(ActionEvent e) {
				
				dicStart dicStart =new dicStart();
				dicStart.setVisible(true);
				table.add(dicStart);
			}
		});
		
		JMenuItem menuItem_7 = new JMenuItem("\u6717\u8BFB\u8BBE\u7F6E");
		menuItem_7.addActionListener(new ActionListener() {
			/**
			 * 朗读设置
			 */
			public void actionPerformed(ActionEvent e) {
				
				settingDic settingDic =new settingDic();
				settingDic.setVisible(true);
				table.add(settingDic);
				
				
			}
		});
		
		JMenuItem menuItem_8 = new JMenuItem("\u5355\u8BCD\u67E5\u8BE2\u548C\u5220\u9664");
		/**
		 * 实现录入单词的查询和删除
		 */
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wordcheckandchange wordcheckandchange =new wordcheckandchange();
				wordcheckandchange.setVisible(true);
				table.add(wordcheckandchange);
				
			}
		});
		menuItem_8.setIcon(new ImageIcon(Mainframe.class.getResource("/images/\u81EA\u5B9A\u4E49.png")));
		menu_2.add(menuItem_8);
		menuItem_7.setIcon(new ImageIcon(Mainframe.class.getResource("/images/\u8BBE \u7F6E.png")));
		menu_2.add(menuItem_7);
		
		JMenuItem menuItem_11 = new JMenuItem("\u786E\u5B9A\u5168\u5C40\u6717\u8BFB\u8BBE\u7F6E");
		menuItem_11.addActionListener(new ActionListener() {
			/**
			 * 确定全局朗读设置
			 */
			public void actionPerformed(ActionEvent e) {
				confirmreadingSetting confirmreadingSetting =new confirmreadingSetting();
				confirmreadingSetting.setVisible(true);
				table.add(confirmreadingSetting);
			}
		});
		menuItem_11.setIcon(new ImageIcon(Mainframe.class.getResource("/images/\u8BBE \u7F6E.png")));
		menu_2.add(menuItem_11);
		menuItem_6.setIcon(new ImageIcon(Mainframe.class.getResource("/images/\u542C\u5199.png")));
		menu_2.add(menuItem_6);
		
		JMenu menu_3 = new JMenu("\u4E13\u9879\u5355\u8BCD\u542C\u5199");
		menu.add(menu_3);
		
		JMenuItem menuItem_1 = new JMenuItem("\u96C5\u601D");
		menuItem_1.addActionListener(new ActionListener() {
			/**
			 * 进入雅思书籍一览
			 */
			public void actionPerformed(ActionEvent e) {
				yasiBookView yasiBookView =new yasiBookView();
				yasiBookView.setVisible(true);
				table.add(yasiBookView);
				
			}
			
		});
		menuItem_1.setIcon(new ImageIcon(Mainframe.class.getResource("/images/\u96C5\u601D\u57F9\u8BAD\u7F34\u8D39 (1).png")));
		menu_3.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u6258\u798F");
		menuItem_2.addActionListener(new ActionListener() {
			/**
			 * 托福书籍一览
			 */
			public void actionPerformed(ActionEvent e) {
				
				tuofuBookView tuofuBookView =new tuofuBookView();
				tuofuBookView.setVisible(true);
				table.add(tuofuBookView);
			}
		});
		
		JMenu menu_4 = new JMenu("\u4E66\u7C4D\u64CD\u4F5C");
		menu_3.add(menu_4);
		
		JMenuItem menuItem_9 = new JMenuItem("\u4E66\u7C4D\u67E5\u770B");
		menuItem_9.addActionListener(new ActionListener() {
			/**
			 * 弹出书籍信息
			 */
			public void actionPerformed(ActionEvent e) {
				
				yasiBookUnit bookUnit =new yasiBookUnit();
				bookUnit.setVisible(true);
				table.add(bookUnit);
				
			}
		});
		menu_4.add(menuItem_9);
		
		JMenuItem menuItem_10 = new JMenuItem("\u5355\u8BCD\u542C\u5199");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dicforYasi bookUnit =new dicforYasi();
				bookUnit.setVisible(true);
				table.add(bookUnit);
				
			}
		});
		menu_4.add(menuItem_10);
		menuItem_2.setIcon(new ImageIcon(Mainframe.class.getResource("/images/\u6258\u798F\u57F9\u8BAD\u7F34\u8D39.png")));
		menu_3.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u8003\u7814");
		menuItem_3.addActionListener(new ActionListener() {
			/**
			 * 考研书籍一览
			 */
			public void actionPerformed(ActionEvent e) {
				
				
				kaoyanBookView kaoyanBookView =new kaoyanBookView();
				kaoyanBookView.setVisible(true);
				table.add(kaoyanBookView);
				
			}
		});
		
		JMenu menu_5 = new JMenu("\u4E66\u7C4D\u64CD\u4F5C");
		menu_3.add(menu_5);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4E66\u7C4D\u67E5\u770B");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				tuofuBookUnit bookUnit =new tuofuBookUnit();
				bookUnit.setVisible(true);
				table.add(bookUnit);
				
			}
		});
		menu_5.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u5355\u8BCD\u542C\u5199");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dicforTuofu bookUnit =new dicforTuofu();
				bookUnit.setVisible(true);
				table.add(bookUnit);
				
			}
		});
		menu_5.add(mntmNewMenuItem_1);
		menuItem_3.setIcon(new ImageIcon(Mainframe.class.getResource("/images/\u8003\u7814.png")));
		menu_3.add(menuItem_3);
		
		JMenu menu_6 = new JMenu("\u4E66\u7C4D\u64CD\u4F5C");
		menu_3.add(menu_6);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u4E66\u7C4D\u67E5\u770B");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			/**
			 * 显示考研的书
			 */
			public void actionPerformed(ActionEvent e) {
				
				
				kaoyanBookUnit bookUnit =new kaoyanBookUnit();
				bookUnit.setVisible(true);
				table.add(bookUnit);
			}
		});
		menu_6.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u5355\u8BCD\u542C\u5199");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dicforKaoyan bookUnit =new dicforKaoyan();
				bookUnit.setVisible(true);
				table.add(bookUnit);
			}
		});
		menu_6.add(mntmNewMenuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
				
//				System.out.println(result);
				
				if(result == 0) {
					
					dispose();
				}
				
				
				
			}
			
			
		});
		menu.add(menuItem_4);
		
		JMenu menu_1 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		menu_1.setIcon(new ImageIcon(Mainframe.class.getResource("/images/\u95EE\u53F7.png")));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_5 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				infoIntro infoIntro =new infoIntro();
				infoIntro.setVisible(true);
				table.add(infoIntro);
			}
		});
		menu_1.add(menuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		 table = new JDesktopPane();
		 contentPane.add(table, BorderLayout.CENTER);
		
//		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
//		设置居中
		this.setLocationRelativeTo(null);  

	}
}
