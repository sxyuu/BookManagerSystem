package io.github.sxyuu.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;


import io.github.sxyuu.Util.DbUtil;
import io.github.sxyuu.Util.StringUtil;
import io.github.sxyuu.dao.BookDao;
import io.github.sxyuu.dao.BookTypeDao;
import io.github.sxyuu.model.Book;
import io.github.sxyuu.model.BookType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBookInterFrame extends JInternalFrame {
	private JTextField bookNameText;
	private JTextField authorText;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceText;
	private JComboBox bookTypeJ = new JComboBox();
	private JTextArea bookDescText = new JTextArea();
	private JRadioButton menRadioButton;
	private JRadioButton famaleRadioButton;
	
	private BookDao bookDao = new BookDao();
	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookInterFrame frame = new AddBookInterFrame();
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
	public AddBookInterFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u6DFB\u52A0\u56FE\u4E66");
		setBounds(100, 100, 604, 519);
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		bookNameText = new JTextField();
		bookNameText.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		authorText = new JTextField();
		authorText.setColumns(10);
		
		JLabel label_2 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");
		
		menRadioButton = new JRadioButton("\u7537");
		buttonGroup.add(menRadioButton);
		
		famaleRadioButton = new JRadioButton("\u5973");
		buttonGroup.add(famaleRadioButton);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u4EF7\u683C\uFF1A");
		
		priceText = new JTextField();
		priceText.setColumns(10);
		
		JLabel label_3 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
		
		
		JLabel label_4 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		fillBookType();
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add(e);
			}
		});
		button.setIcon(new ImageIcon(AddBookInterFrame.class.getResource("/images/add.png")));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clean();
			}
		});
		button_1.setIcon(new ImageIcon(AddBookInterFrame.class.getResource("/images/editclear_16px_32658_easyicon.net.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(90)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_4)
									.addGap(18)
									.addComponent(bookTypeJ, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(bookDescText, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label)
											.addGap(18)
											.addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_2)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(menRadioButton)
											.addGap(18)
											.addComponent(famaleRadioButton)))
									.addGap(56)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_1)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(authorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(priceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(153)
							.addComponent(button)
							.addGap(128)
							.addComponent(button_1)))
					.addContainerGap(140, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(authorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(menRadioButton)
						.addComponent(famaleRadioButton)
						.addComponent(lblNewLabel)
						.addComponent(priceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_4)
						.addComponent(bookTypeJ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3)
						.addComponent(bookDescText, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(46))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	//添加
	protected void add(ActionEvent e) {
		// TODO Auto-generated method stub
		Book book = new Book();
		String price = this.priceText.getText();
		String sex = "";
		if(this.menRadioButton.isSelected()) {
			sex = "男";
		}else if(this.famaleRadioButton.isSelected()) {
			sex = "女";
		}else {
			JOptionPane.showMessageDialog(null, "请选择作者性别！");
		}
		
		BookType bookType = (BookType) this.bookTypeJ.getSelectedItem();
	
		if(StringUtil.isEmpty(this.authorText.getText())) {
			JOptionPane.showMessageDialog(null, "图书作者不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "图书价格不能为空！");
			return;
		}
		if(StringUtil.isEmpty(this.bookNameText.getText())) {
			JOptionPane.showMessageDialog(null, "图书名称不能为空！");
			return;
		}
		book.setAuthor(this.authorText.getText()); 
		book.setBookDesc(this.bookDescText.getText());
		book.setBookName(this.bookNameText.getText());
		book.setBooktypeid(bookType.getId());
		book.setPrice(Float.parseFloat(price));
		book.setSex(sex);
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			bookDao.addBook(con, book);
			JOptionPane.showMessageDialog(null, "添加成功！");
			clean();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "图书添加失败！");
			e1.printStackTrace();
			return;
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		//book.setBooktypeid(this.bookTypeJ);
		
		
	}

	//清空数据
	protected void clean() {
		this.bookNameText.setText("");
		this.authorText.setText("");
		this.buttonGroup.clearSelection();
		this.priceText.setText("");
		this.fillBookType();
		this.bookDescText.setText("");
		
	}

	//图书类别下拉框
	private void fillBookType() {
		
		Connection con = null;
		BookType booktype = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookTypeDao.find(con, new BookType());
			bookTypeJ = new JComboBox();
			while (rs.next()) {
				booktype = new BookType();
				booktype.setId(rs.getInt("id"));
				booktype.setBookTypeName(rs.getString("bookTypeName"));
				this.bookTypeJ.addItem(booktype);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "连接服务器失败！");
			return;
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
