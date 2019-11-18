package io.github.sxyuu.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;

import io.github.sxyuu.Util.DbUtil;
import io.github.sxyuu.Util.StringUtil;
import io.github.sxyuu.dao.BookTypeDao;
import io.github.sxyuu.model.BookType;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class AddBookTypeInterFrame extends JInternalFrame {
	private JTextField booktypenametext;
	private JTextArea typedesc = null;
	private DbUtil dbUtil = new DbUtil();
	
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
					AddBookTypeInterFrame frame = new AddBookTypeInterFrame();
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
	public AddBookTypeInterFrame() {
		setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 542, 447);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		booktypenametext = new JTextField();
		booktypenametext.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0\uFF1A");
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			//添加图书类别
			public void actionPerformed(ActionEvent e) {
				addtype();
			}

			
		});
		button.setIcon(new ImageIcon(AddBookTypeInterFrame.class.getResource("/images/add.png")));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		button_1.setIcon(new ImageIcon(AddBookTypeInterFrame.class.getResource("/images/editclear_16px_32658_easyicon.net.png")));
		
		typedesc = new JTextArea();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_1)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(booktypenametext, Alignment.LEADING)
						.addComponent(typedesc, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
					.addContainerGap(98, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(105)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addGap(64))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(74)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(booktypenametext, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(typedesc, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1))
					.addGap(71))
		);
		getContentPane().setLayout(groupLayout);
		
		
	}

	/**
	 * 重置文本框方法
	 */
	protected void reset() {
		booktypenametext.setText("");
		typedesc.setText("");
		
	}

	/**
	 * 添加类别方法
	 */
	private void addtype() {
		// TODO Auto-generated method stub
		if(StringUtil.isEmpty(this.booktypenametext.getText())) {
			JOptionPane.showMessageDialog(null, "图书类别名称不能为空！");
			return;
		}
		BookType bookType = new BookType(this.booktypenametext.getText(),this.typedesc.getText());
		BookTypeDao addBookType = new BookTypeDao();
		Connection con = null;
		try {
			con = dbUtil.getCon();
			if(addBookType.add(con, bookType)==1) {
				JOptionPane.showMessageDialog(null, "添加成功！");
			}else {
				JOptionPane.showMessageDialog(null, "连接失败，请重试！");
			}
			reset();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "连接失败，请重试！");
			reset();
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
