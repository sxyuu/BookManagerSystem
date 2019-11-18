package io.github.sxyuu.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Enumeration;

public class AboutMeInterFrame extends JInternalFrame {
	
	//改变系统默认字体
		Font font = new Font("Dialog", Font.PLAIN, 12);
		Enumeration<Object> keys = UIManager.getDefaults().keys();{
		
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}

		}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutMeInterFrame frame = new AboutMeInterFrame();
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
	public AboutMeInterFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5173\u4E8E\u4F5C\u8005");
		setBounds(100, 100, 588, 409);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("\u5C71\u4E1C\u5E08\u8303\u5927\u5B66 \u4FE1\u5DE5\u5B66\u9662 2016\u7EA7\u8BA1\u5DE5\u672C3\u73ED\u82CF\u946B\u745C");
		lblNewLabel.setFont(new Font("仿宋", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.GRAY);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(54, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE)
					.addGap(52))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(93)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(103, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

	}
}
