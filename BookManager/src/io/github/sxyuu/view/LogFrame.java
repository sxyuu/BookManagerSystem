package io.github.sxyuu.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import io.github.sxyuu.Util.DbUtil;
import io.github.sxyuu.Util.StringUtil;
import io.github.sxyuu.dao.UserDao;
import io.github.sxyuu.model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class LogFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	
	DbUtil dbu = new DbUtil();
	UserDao userdao = new UserDao();
	
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
					LogFrame frame = new LogFrame();
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
	public LogFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setIcon(new ImageIcon(LogFrame.class.getResource("/images/Library_512px_1178088_easyicon.net_gaitubao_87x87_gaitubao_64x64.png")));
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 25));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(LogFrame.class.getResource("/images/user_32px_28790_easyicon.net_gaitubao_16x16.png")));
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(LogFrame.class.getResource("/images/password_512px_1169935_easyicon.net_gaitubao_16x16.png")));
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				log(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(LogFrame.class.getResource("/images/login_16px_1229343_easyicon.net.png")));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(LogFrame.class.getResource("/images/editclear_16px_32658_easyicon.net.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(133)
					.addComponent(lblNewLabel)
					.addContainerGap(160, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(62)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(37)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(117)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordTxt, 170, 170, 170))
							.addGap(157))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addComponent(lblNewLabel)
					.addGap(61)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(51)
							.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(36))
		);
		contentPane.setLayout(gl_contentPane);
		
		this.setLocationRelativeTo(null);
	}

	
	/**
	 * 登录功能实现
	 * @param e
	 */
	private void log(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//获取用户输入的用户名和密码
		String username = this.userNameTxt.getText();
		String password = new String(this.passwordTxt.getPassword());
		if(StringUtil.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "请输入用户名");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "请输入密码");
			return;
		}
		User user = new User(username,password);
		
		//建立数据库连接,验证账号密码
		Connection con =null;
		try {
			con = dbu.getCon();
			//JOptionPane.showMessageDialog(null, "成功");
			User resultuser = userdao.login(con, user);
			if (resultuser !=null) {
				JOptionPane.showMessageDialog(null, "登录成功！");
				dispose();
				new MainFrame().setVisible(true);
				
				
			}else {
				
				JOptionPane.showMessageDialog(null, "用户名或密码错误！");
			}
			dbu.closeCon(con);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "连接失败，请重试！");
			e1.printStackTrace();
		}finally {
			try {
				dbu.closeCon(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	
		
	}

	/**
	 * 清空账户名和密码
	 * @param e
	 */
	private void reset(ActionEvent e) {
		// TODO Auto-generated method stub
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
		
	}
}
