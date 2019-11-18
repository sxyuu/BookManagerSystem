package io.github.sxyuu.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import io.github.sxyuu.Util.DbUtil;
import io.github.sxyuu.Util.StringUtil;
import io.github.sxyuu.dao.BookDao;
import io.github.sxyuu.dao.BookTypeDao;
import io.github.sxyuu.model.Book;
import io.github.sxyuu.model.BookType;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class BookManagerInterFrame extends JInternalFrame {
	private JTextField bookname1text;
	private JTextField author1text;
	private JTable table;
	private JTextField bookidtext;
	private JTextField bookname2text;
	private JTextField pricetext;
	private JTextField authortext;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JComboBox booktype1J;
	JComboBox booktype2J;
	JTextArea bookdesctext;
	JRadioButton menradioButton;
	JRadioButton famalradioButton;
	
	DbUtil dbUtil = new DbUtil();
	BookTypeDao booktypedao = new BookTypeDao();
	BookDao bookdao = new BookDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManagerInterFrame frame = new BookManagerInterFrame();
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
	public BookManagerInterFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u67E5\u627E\u4E0E\u7BA1\u7406");
		setBounds(100, 100, 924, 687);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(70)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 719, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 721, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(115, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		
		JLabel label_3 = new JLabel("\u7F16\u53F7\uFF1A");
		
		bookidtext = new JTextField();
		bookidtext.setEditable(false);
		bookidtext.setColumns(10);
		
		JLabel label_4 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		bookname2text = new JTextField();
		bookname2text.setColumns(10);
		
		JLabel label_5 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");
		
		menradioButton = new JRadioButton("\u7537");
		menradioButton.setSelected(true);
		buttonGroup.add(menradioButton);
		
		famalradioButton = new JRadioButton("\u5973");
		buttonGroup.add(famalradioButton);
		
		JLabel label_6 = new JLabel("\u4EF7\u683C\uFF1A");
		
		pricetext = new JTextField();
		pricetext.setColumns(10);
		
		JLabel label_7 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		authortext = new JTextField();
		authortext.setColumns(10);
		
		JLabel label_8 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		booktype2J = new JComboBox();
		fill2();
		
		JLabel label_9 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
		
		bookdesctext = new JTextArea();
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Book book = new Book();
				BookType booktype = (BookType)booktype2J.getSelectedItem();
				if(StringUtil.isEmpty(bookidtext.getText())) {
					JOptionPane.showMessageDialog(null, "请选择需要修改的条目！");
					return;
				}
				if(StringUtil.isEmpty(bookname2text.getText())) {
					JOptionPane.showMessageDialog(null, "图书名不能为空！");
					return;
				}
				if(StringUtil.isEmpty(pricetext.getText())) {
					JOptionPane.showMessageDialog(null, "价格不能为空！");
					return;
				}
				if(StringUtil.isEmpty(authortext.getText())) {
					JOptionPane.showMessageDialog(null, "作者姓名不能为空！");
					return;
				}
				book.setId(Integer.parseInt(bookidtext.getText()));
				book.setBookName(bookname2text.getText());
				book.setAuthor(authortext.getText());
				book.setBookDesc(bookdesctext.getText());
				book.setPrice(Float.parseFloat(pricetext.getText()));
				if(menradioButton.isSelected()) {
					book.setSex("男");
				}else if(famalradioButton.isSelected()) {
					book.setSex("女");
				}
				book.setBooktypeid(booktype.getId());
				
				
				update(book);
			}
		});
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = bookidtext.getText();
				delet(id);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookidtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_6)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(pricetext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(52)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookname2text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_7)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(authortext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(62)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_5)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(menradioButton)
									.addGap(11)
									.addComponent(famalradioButton))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_8)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(booktype2J, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_9)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookdesctext, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button_1)
							.addGap(18)
							.addComponent(button_2)))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(bookidtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(bookname2text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(famalradioButton)
						.addComponent(menradioButton))
					.addGap(32)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(pricetext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7)
						.addComponent(authortext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_8)
						.addComponent(booktype2J, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(32)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_9)
								.addComponent(bookdesctext, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_1)
								.addComponent(button_2))
							.addGap(36))))
		);
		panel_1.setLayout(gl_panel_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 bookTypeMousePressed(e);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u4F5C\u8005\u6027\u522B", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u63CF\u8FF0", "\u56FE\u4E66\u7C7B\u522B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(44);
		table.getColumnModel().getColumn(5).setPreferredWidth(138);
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		bookname1text = new JTextField();
		bookname1text.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		author1text = new JTextField();
		author1text.setColumns(10);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		booktype1J = new JComboBox();
		fill1();
		
		find(new Book());
		JButton button = new JButton("\u641C\u7D22");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Book book = new Book();
				BookType booktype = (BookType) booktype1J.getSelectedItem();
				String name = bookname1text.getText();
				String author = author1text.getText();
				if(!StringUtil.isEmpty(name)) {
					book.setBookName(name);
				}
				if(!StringUtil.isEmpty(author)) {
					book.setAuthor(author);
				}
				book.setBooktypeid(booktype.getId());
				
				find(book);
				
			}
		});
		button.setIcon(new ImageIcon(BookManagerInterFrame.class.getResource("/images/search.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookname1text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(author1text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(booktype1J, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(40))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookname1text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(author1text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(booktype1J, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
		

	}
	
	/**
	 * 修改功能
	 */
	private void update(Book book) {
		Connection con = null;
		int result = JOptionPane.showConfirmDialog(null, "您确定修改该条数据？");
		if(result != 0) {
			return;
		}
		try {
			con = dbUtil.getCon();
			int rs = bookdao.update(con, book);
			if(rs == 1) {
				JOptionPane.showMessageDialog(null, "修改成功！");
			}else {
				JOptionPane.showMessageDialog(null, "修改失败，请重试！");
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "连接失败，请重试！");
			e.printStackTrace();
			return;
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		clean();
	}
	
	
	/**
	 * 查找功能
	 */
	private void find(Book book) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		Connection con =null;
		try {
			con = this.dbUtil.getCon();
			ResultSet result = this.bookdao.findbook(con, book);
			while (result.next()) {
				Vector v = new Vector();
				v.add(result.getString("id"));
				v.add(result.getString("bookname"));
				v.add(result.getString("author"));
				v.add(result.getString("sex"));
				v.add(result.getString("price"));
				v.add(result.getString("bookdesc"));
				v.add(result.getString("bookTypeName"));
				dtm.addRow(v);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "连接失败，请重试！");
			e.printStackTrace();
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
	
	
	/**
	 * 查找类别选项填充
	 */
	private void fill1() {
		Connection con = null;
		BookType booktype = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = booktypedao.find(con, new BookType());
			booktype1J = new JComboBox();
			BookType a = new BookType();
			a.setBookTypeName("请选择类别...");
			a.setId(-1);
			booktype1J.addItem(a);
			while (rs.next()) {
				booktype = new BookType();
				booktype.setId(rs.getInt("id"));
				booktype.setBookTypeName(rs.getString("bookTypeName"));
				this.booktype1J.addItem(booktype);
				
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
	
	/**
	 * 修改类别填充
	 */
	private void fill2() {
		Connection con = null;
		BookType booktype = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = booktypedao.find(con, new BookType());
			this.booktype2J = new JComboBox();
			while (rs.next()) {
				booktype = new BookType();
				booktype.setId(rs.getInt("id"));
				booktype.setBookTypeName(rs.getString("bookTypeName"));
				this.booktype2J.addItem(booktype);
				
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
	
	/**
	 * 点击表格事件
	 * @param e
	 */
	private void bookTypeMousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int row = this.table.getSelectedRow();
		this.bookidtext.setText((String) table.getValueAt(row, 0));
		this.bookname2text.setText((String)table.getValueAt(row, 1));
		this.authortext.setText((String)table.getValueAt(row, 2));
		if(table.getValueAt(row, 3).equals("男")) {
			this.menradioButton.setSelected(true);
		}else if(table.getValueAt(row, 3).equals("女")) {
			this.famalradioButton.setSelected(true);
		}
		this.pricetext.setText((String)table.getValueAt(row, 4));
		this.bookdesctext.setText((String)table.getValueAt(row, 5));
		String typename = (String)table.getValueAt(row, 6);
		int a = this.booktype2J.getItemCount();
		for(int i = 0;i<=a;i++) {
			BookType item = (BookType)this.booktype2J.getItemAt(i);
			if(item.getBookTypeName().equals(typename)) {
				this.booktype2J.setSelectedIndex(i);
				break;
			}
		}
		
	}
	
	/**
	 * 删除操作
	 * @param id
	 */
	private void delet(String id) {
		Connection con = null;
		int result = JOptionPane.showConfirmDialog(null, "您确定修改该条数据？");
		if(result != 0) {
			return;
		}
		try {
			con = dbUtil.getCon();
			int rs = bookdao.delet(con, id);
			if(rs ==1) {
				JOptionPane.showMessageDialog(null, "删除成功！");
			}else {
				JOptionPane.showMessageDialog(null, "删除失败！");
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "连接服务器失败！");
			e.printStackTrace();
			return;
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		clean();
	}
	
	/**
	 * 清空编辑框
	 */
	private void clean(){
		this.bookidtext.setText("");
		this.bookdesctext.setText("");
		this.bookname2text.setText("");
		this.pricetext.setText("");
		this.authortext.setText("");
		find(new Book());
	}
	
}
