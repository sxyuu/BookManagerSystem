package io.github.sxyuu.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import io.github.sxyuu.Util.DbUtil;
import io.github.sxyuu.Util.StringUtil;
import io.github.sxyuu.dao.BookTypeDao;
import io.github.sxyuu.model.BookType;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookTypeManagerInterFrame extends JInternalFrame {
	private JTable booktypetable;
	private JTextField typenametext;
	
	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao booktypedao = new BookTypeDao();
	private JTextField idtext;
	private JTextField typenametext1;
	private JTextArea typedesctext = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManagerInterFrame frame = new BookTypeManagerInterFrame();
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
	public BookTypeManagerInterFrame() {
		setTitle("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 688, 701);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u8F93\u5165\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		typenametext = new JTextField();
		typenametext.setColumns(10);
		
		JButton button = new JButton("\u67E5\u627E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String booktypename = typenametext.getText();
				BookType  booktype = new BookType();
				booktype.setBookTypeName(booktypename);
				filltable(booktype);
			}
		});
		button.setIcon(new ImageIcon(BookTypeManagerInterFrame.class.getResource("/images/search.png")));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(69)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addGap(18)
							.addComponent(typenametext, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(button)))
					.addContainerGap(83, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(typenametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
					.addGap(31))
		);
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delet();
			}
		});
		button_2.setIcon(new ImageIcon(BookTypeManagerInterFrame.class.getResource("/images/editclear_16px_32658_easyicon.net.png")));
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		button_1.setIcon(new ImageIcon(BookTypeManagerInterFrame.class.getResource("/images/edit.png")));
		
		JLabel label_1 = new JLabel("\u7C7B\u522B\u7F16\u53F7\uFF1A");
		
		idtext = new JTextField();
		idtext.setEditable(false);
		idtext.setColumns(10);
		
		JLabel label_2 = new JLabel("\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		typenametext1 = new JTextField();
		typenametext1.setColumns(10);
		
		JLabel label_3 = new JLabel("\u7C7B\u522B\u63CF\u8FF0\uFF1A");
		
		typedesctext = new JTextArea();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(90)
					.addComponent(button_2)
					.addPreferredGap(ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
					.addComponent(button_1)
					.addGap(101))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(typedesctext))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(idtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(48)
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(typenametext1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(idtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(typenametext1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(30)
							.addComponent(label_3))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(typedesctext, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_2)
						.addComponent(button_1))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		booktypetable = new JTable();
		booktypetable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				bookTypeMousePressed(e);
				
			}
		});
		booktypetable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B", "\u7C7B\u522B\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		booktypetable.getColumnModel().getColumn(0).setPreferredWidth(40);
		booktypetable.getColumnModel().getColumn(2).setPreferredWidth(90);
		scrollPane.setViewportView(booktypetable);
		getContentPane().setLayout(groupLayout);

		filltable(new BookType());
		
		
	}
	
	/**
	 * 更新数据按钮
	 */
	protected void update() {
		// TODO Auto-generated method stub
		int result = JOptionPane.showConfirmDialog(null, "您确定修改该条数据？");
		if(result != 0) {
			return;
		}
		if(StringUtil.isEmpty(idtext.getText())) {
			JOptionPane.showMessageDialog(null, "请选择需要修改的数据！");
			return;
		}
		BookType booktype = new BookType(Integer.parseInt(idtext.getText()), typenametext1.getText(), typedesctext.getText());
		Connection con =null;
		try {
			con = dbUtil.getCon();
			if(this.booktypedao.update(con, booktype)==1) {
				JOptionPane.showMessageDialog(null, "修改成功！");
				filltable(new BookType());
				clear();
			}else {
				JOptionPane.showMessageDialog(null, "连接失败，请重试！");
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
		
	}

	/**
	 * 删除按钮事件
	 */
	protected void delet() {
		// TODO Auto-generated method stub
		int result = JOptionPane.showConfirmDialog(null, "您确定删除该条数据？");
		if(result != 0) {
			return;
		}
		 String id = idtext.getText();
		 if (StringUtil.isEmpty(id)) {
			 JOptionPane.showMessageDialog(null, "请选择要删除的数据！");
			 return;
		 }
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			if(booktypedao.DeleteType(con, id)==1) {
				JOptionPane.showMessageDialog(null, "删除成功！");
				filltable(new BookType());
				clear();
			}else {
				JOptionPane.showMessageDialog(null, "连接失败，请重试！");
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
		
	}

	/**
	 * 表格行点击事件
	 * @param e
	 */
	protected void bookTypeMousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int row = this.booktypetable.getSelectedRow();
		this.idtext.setText((String) this.booktypetable.getValueAt(row, 0));
		this.typenametext1.setText((String) this.booktypetable.getValueAt(row, 1));
		this.typedesctext.setText((String) this.booktypetable.getValueAt(row, 2));
		
	}

	/**
	 * 填充表格
	 * @param booktype
	 */
	public void filltable(BookType booktype) {
		DefaultTableModel dtm = (DefaultTableModel) booktypetable.getModel();
		dtm.setRowCount(0);
		Connection con =null;
		try {
			con = this.dbUtil.getCon();
			ResultSet result = this.booktypedao.find(con, booktype);
			while (result.next()) {
				Vector v = new Vector();
				v.add(result.getString("id"));
				v.add(result.getString("bookTypeName"));
				v.add(result.getString("bookTypeDesc"));
				dtm.addRow(v);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "连接失败，请重试！");
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
	
	public void clear() {
		idtext.setText("");
		typenametext1.setText("");
		typedesctext.setText("");
		
	}
}
