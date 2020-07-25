package wordDictation.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

public class infoIntro extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					infoIntro frame = new infoIntro();
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
	public infoIntro() {
		setFrameIcon(new ImageIcon(infoIntro.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC.png")));
		setIconifiable(true);
		setClosable(true);
//		setMaximum(false);
		setTitle("\u5173\u4E8E\u6211\u4EEC");
		setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(infoIntro.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC (3).png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(label)
					.addContainerGap(333, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(label)
					.addContainerGap(165, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
