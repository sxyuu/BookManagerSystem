package io.github.sxyuu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table = null;

	
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
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 531);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u6570\u636E\u7EF4\u62A4");
		menu.setIcon(new ImageIcon(MainFrame.class.getResource("/images/base.png")));
		menuBar.add(menu);
		
		JMenu mnNewMenu = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		menu.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		menuItem.addActionListener(new ActionListener() {
			//图书类别添加按钮
			public void actionPerformed(ActionEvent e) {
				AddBookTypeInterFrame addBooktypeInterFrame = new AddBookTypeInterFrame();
				addBooktypeInterFrame.setVisible(true);
				table.add(addBooktypeInterFrame);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/images/add.png")));
		mnNewMenu.add(menuItem);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookTypeManagerInterFrame bmif = new BookTypeManagerInterFrame();
				bmif.setVisible(true);
				table.add(bmif);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/images/edit.png")));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menu.add(mnNewMenu_1);
		
		JMenuItem menuItem_1 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddBookInterFrame addBook = new AddBookInterFrame();
				addBook.setVisible(true);
				table.add(addBook);
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrame.class.getResource("/images/add.png")));
		mnNewMenu_1.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookManagerInterFrame bookmanager = new BookManagerInterFrame();
				bookmanager.setVisible(true);
				table.add(bookmanager);
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainFrame.class.getResource("/images/edit.png")));
		mnNewMenu_1.add(menuItem_2);
		
		JMenuItem menuItem_4 = new JMenuItem("\u9000\u51FA");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "确定退出？");
				if(result == 0) {
					dispose();
				}else{
					return;
				}

			}
		});
		menuItem_4.setIcon(new ImageIcon(MainFrame.class.getResource("/images/login.png")));
		menu.add(menuItem_4);
		
		JMenu menu_1 = new JMenu("\u5173\u4E8E\u4F5C\u8005");
		menu_1.setIcon(new ImageIcon(MainFrame.class.getResource("/images/about.png")));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("\u4F5C\u8005\u4FE1\u606F");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutMeInterFrame aboutMe = new AboutMeInterFrame();
				aboutMe.setVisible(true);
				table.add(aboutMe);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainFrame.class.getResource("/images/user_32px_28790_easyicon.net_gaitubao_16x16.png")));
		menu_1.add(menuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JDesktopPane();
		table.setBackground(Color.ORANGE);
		contentPane.add(table, BorderLayout.CENTER);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	}
}
