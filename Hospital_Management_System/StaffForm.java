//import java.awt.EmptyBorder;

import java.net.URL;
import java.awt.Color;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import javax.swing.swing.border.Border;
//import javax.swing.swing.border.LineBorder;
import java.lang.*;
public class StaffForm extends JFrame implements ActionListener
{
	JMenuBar mb;
	JMenu m1,m2;
	JMenuItem m1i1,m1i2,m1i3;
	JMenuItem m2i1,m2i2;
	JPanel pnlTop,pnlData,pnlButton,pnlGo,pnlInfo;
	JLabel lblTitle;
	JLabel lblID,lblName,lblContact,lblEmail,lblAge,lblGender,lblExperience;
	JTextField txtID,txtName,txtContact,txtEmail,txtAge,txtExperience;
	ButtonGroup g;
	JRadioButton rbtnMale,rbtnFemale;
	JButton btnNew,btnSave,btnView,btnUpdate,btnDelet;
	JLabel lblSelect,lblClass,lblMyName,lblMNo,lblMobNo;
	JComboBox cmbSelect;
	JButton btnGo;

	StaffForm()
	{

		setSize(800,790);
		setLocation(100,100);
		setTitle("Staff Form");
		setLayout(null);
		getContentPane().setBackground(Color.cyan);

		mb=new JMenuBar();
		m1=new JMenu("SQL");
		m2=new JMenu("UI");

		m1i1=new JMenuItem("Insert Operation.");
		m1i2=new JMenuItem("Update Operation.");
		m1i3=new JMenuItem("Delet Operation.");

		m2i1=new JMenuItem("Show UI");
		m2i2=new JMenuItem("Close UI");
		m1.add(m1i1);
		m1.add(m1i2);
		m1.add(m1i3);
		m2.add(m2i1);
		m2.add(m2i2);
		mb.add(m1);
		mb.add(m2);
		setJMenuBar(mb);

		m1i1.addActionListener(this);
		m1i2.addActionListener(this);
		m1i3.addActionListener(this);
		m2i1.addActionListener(this);
		m2i2.addActionListener(this);

		pnlTop = new JPanel();
		pnlTop.setBounds(10,10,760,100);
		pnlTop.setLayout(null);
		add(pnlTop);
		Color n=new Color(255,170,51);
		pnlTop.setBackground(n);
	//	pnlTop.setBackground(Color.lightblue);
		lblTitle = new JLabel(" HOSPITAL MANAGEMENT (STAFF) ");
		lblTitle.setBounds(70,35,800,30);
		lblTitle.setForeground(Color.blue);
		pnlTop.add(lblTitle);
//pnlTop.setBorder(new EmptyBorder(10,100,10,10));
		pnlData = new JPanel();
		pnlData.setBounds(10,120,760,370);
		add(pnlData);
		pnlData.setLayout(null);
	//	pnlData.setBackground(Color.yellow);
		Color x=new Color(240,255,0);
		pnlData.setBackground(x);


		int y=10,h=40,gap=10,st1=20,st2=160;
		lblID = new JLabel("ID");
		lblID.setBounds(st1,y,100,h);
		pnlData.add(lblID);

		txtID = new JTextField();
		txtID.setBounds(st2,y,150,h);
		pnlData.add(txtID);

		y=y+h+gap;
		lblName = new JLabel("Name");
	//	Border jpBoreder= BorederFactory.createLineBorder(Color.yellow,1);
	//	lblName.setBorder(jpBorder);

/*	Color v=new Color(240,255,0);
		Color c=new Color(100,0,200);
		lblName.setForeground(c);		*/
		lblName.setBounds(st1,y,100,h);
		pnlData.add(lblName);

		txtName = new JTextField();
		txtName.setBounds(st2,y,300,h);
		pnlData.add(txtName);

		y=y+h+gap;
		lblContact = new JLabel("Contact");
		lblContact.setBounds(st1,y,100,h);
		pnlData.add(lblContact);

		txtContact = new JTextField();
		txtContact.setBounds(st2,y,300,h);
		pnlData.add(txtContact);

		y=y+h+gap;
		lblEmail = new JLabel("E-Mail ID");
		lblEmail.setBounds(st1,y,100,h);
		pnlData.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(st2,y,300,h);
		pnlData.add(txtEmail);

		y=y+h+gap;
		lblAge = new JLabel("Age :");
		lblAge.setBounds(st1,y,100,h);
		pnlData.add(lblAge);

		txtAge = new JTextField();
		txtAge.setBounds(st2,y,100,h);
		pnlData.add(txtAge);

		y=y+h+gap;
		lblGender = new JLabel("Gender :");
		lblGender.setBounds(st1,y,100,h);
		pnlData.add(lblGender);

		g= new ButtonGroup();
		rbtnMale=new JRadioButton("Male");
		rbtnMale.setBounds(st2,y,100,h);
		pnlData.add(rbtnMale);

		rbtnFemale=new JRadioButton("Female");
		rbtnFemale.setBounds(st2+110,y,100,h);
		pnlData.add(rbtnFemale);

		g.add(rbtnMale);
		g.add(rbtnFemale);

		y=y+h+gap;
		lblExperience = new JLabel("Experience(Years)");
		lblExperience.setBounds(st1,y,150,h);
		pnlData.add(lblExperience);

		txtExperience = new JTextField();
		txtExperience.setBounds(200,y,70,h);
		pnlData.add(txtExperience);

		pnlButton = new JPanel();
		pnlButton.setBounds(10,500,500,100);        //760
		pnlButton.setLayout(null);
		add(pnlButton);
		pnlButton.setBackground(Color.yellow);
		btnNew = new JButton("New");
		btnNew.setBounds(10,32,85,40);
		pnlButton.add(btnNew);
		btnSave = new JButton("Save");
		btnSave.setBounds(105,32,85,40);
		pnlButton.add(btnSave);
		btnView = new JButton("View");
		btnView.setBounds(200,32,85,40);
		pnlButton.add(btnView);
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(295,32,90,40);
		pnlButton.add(btnUpdate);
		btnDelet = new JButton("Delete");
		btnDelet.setBounds(395,32,90,40);
		pnlButton.add(btnDelet);

		btnNew.addActionListener(this);
		btnSave.addActionListener(this);
		btnView.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelet.addActionListener(this);

		pnlGo = new JPanel();
		pnlGo.setBounds(520,500,250,100);        //760
		pnlGo.setLayout(null);
		add(pnlGo);
		pnlGo.setBackground(Color.yellow);

		lblSelect = new JLabel("Select");
		lblSelect.setBounds(20,15,100,30);
		pnlGo.add(lblSelect);

		cmbSelect = new JComboBox();
		cmbSelect.setBounds(20,50,150,40);
		cmbSelect.addItem("Select Any one ...");
		pnlGo.add(cmbSelect);

		btnGo = new JButton("Go");
		btnGo.setBounds(175,15,70,70);
		pnlGo.add(btnGo);

		btnGo.addActionListener(this);

		pnlInfo = new JPanel();
		pnlInfo.setBounds(10,610,760,100);
		pnlInfo.setLayout(null);
		add(pnlInfo);
		pnlInfo.setBackground(Color.orange);				// cyan , darkgray , gray lightgray , magenta , pink , white , yellow, black , blue, green ,red

//  lblClass,lblMyName,lblMNo;

		lblClass = new JLabel("Galaxy Computer Education, Chopda");
		lblClass.setBounds(10,10,400,30);
		pnlInfo.add(lblClass);
		lblMobNo = new JLabel("Mob No.9890378274");
		lblMobNo.setBounds(10,50,200,30);
		pnlInfo.add(lblMobNo);
		lblMyName = new JLabel("Pankaj A. Mali");
		lblMyName.setBounds(500,10,250,30);
		pnlInfo.add(lblMyName);
		lblMNo = new JLabel("Mob no.9370795133");
		lblMNo.setBounds(500,50,250,30);
		pnlInfo.add(lblMNo);

		lblTitle.setFont(new Font("Century", Font.BOLD , 30));
		lblID.setFont(new Font("Century", Font.BOLD , 15));
		lblName.setFont(new Font("Century", Font.BOLD , 15));
		lblContact.setFont(new Font("Century", Font.BOLD , 15));
		lblEmail.setFont(new Font("Century", Font.BOLD , 15));
		lblAge.setFont(new Font("Century", Font.BOLD , 15));
		lblGender.setFont(new Font("Century", Font.BOLD , 15));
		lblExperience.setFont(new Font("Century", Font.BOLD , 15));
		rbtnMale.setFont(new Font("Arial Black", Font.BOLD , 15));
		rbtnFemale.setFont(new Font("Arial Black", Font.BOLD , 15));

		txtID.setFont(new Font("Bahnschrift SemiBold SemiConden", Font.BOLD , 20));
		txtAge.setFont(new Font("Bahnschrift SemiBold SemiConden", Font.BOLD , 20));
		txtContact.setFont(new Font("Bahnschrift SemiBold SemiConden", Font.BOLD , 20));
		txtName.setFont(new Font("Arial Narrow", Font.BOLD , 20));
		txtEmail.setFont(new Font("Arial Narrow", Font.BOLD , 20));
		txtExperience.setFont(new Font("Arial Narrow", Font.BOLD , 20));

		btnNew.setFont(new Font("Lucida Calligraphy", Font.BOLD , 15));
		btnSave.setFont(new Font("Lucida Calligraphy", Font.BOLD , 15));
		btnView.setFont(new Font("Lucida Calligraphy", Font.BOLD , 15));
		btnUpdate.setFont(new Font("Lucida Calligraphy", Font.BOLD , 12));
		btnDelet.setFont(new Font("Lucida Calligraphy", Font.BOLD , 12));

		lblSelect.setFont(new Font("Lucida Calligraphy", Font.BOLD , 20));
		cmbSelect.setFont(new Font("Arial Narrow", Font.BOLD , 15));
		btnGo.setFont(new Font("Bernard MT Condensed", Font.BOLD , 25));

		lblClass.setFont(new Font("Bahnschrift", Font.BOLD , 22));
		lblClass.setForeground(Color.blue);
		lblMyName.setFont(new Font("Bahnschrift", Font.BOLD , 23));
		lblMyName.setForeground(Color.blue);
		lblMNo.setFont(new Font("Bahnschrift", Font.BOLD , 20));
		lblMNo.setForeground(Color.blue);
		lblMobNo.setFont(new Font("Bahnschrift", Font.BOLD , 20));
		lblMobNo.setForeground(Color.blue);

		setBackground(Color.red);
		show();

	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnNew || ae.getSource()==m2i2)
		{
			txtID.setText(" ");
			txtName.setText(" ");
		//  txtName.requestFocus();
			txtContact.setText(" ");
			txtEmail.setText(" ");
			txtAge.setText(" ");
			txtExperience.setText(" ");


		}
		else if(ae.getSource()==btnSave||ae.getSource()==m1i1)
		{
			JOptionPane.showMessageDialog(this,"Do You want to Save this Staff Information");

			try
			{
				String url = "Jdbc:Odbc:DSNConnect2324";
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con= DriverManager.getConnection(url);

				int mID =Integer.parseInt(txtID.getText());
				String mStaffName=txtName.getText();
				String mContact =txtContact.getText();
				String mMailID=txtEmail.getText();
				int mAge =Integer.parseInt(txtAge.getText());
				int mExperience=Integer.parseInt(txtExperience.getText());
				int mStaffGender;

				if(rbtnMale.isSelected())
				{
					mStaffGender=1;
				}
				else
				{
					mStaffGender=2;
				}

				String q = "insert into tblStaff (ID,StaffName,contact,mailID,Age,Gender,Experience) values("+mID+",'"+mStaffName+"','"+mContact+"','"+mMailID+"',"+mAge+","+mStaffGender+","+mExperience+")";

				JOptionPane.showMessageDialog(this,q);

				Statement st = con.createStatement();
				boolean x = st.execute(q);
				System.out.println(x);
				con.close();
			}
			catch(ClassNotFoundException e) {
				System.out.println("ClassNotFoundException,,,,,,,,,,,,,,,,,,,,,,,"+e);
			}
			catch(SQLException e) {
				System.out.println("SQLException ........................"+e);
			}

		}
		else if(ae.getSource()==btnUpdate || ae.getSource()==m1i2)
		{
			try
			{
				String url = "Jdbc:Odbc:DSNConnect2324";
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con= DriverManager.getConnection(url);
				int mID =Integer.parseInt(txtID.getText());
				String mStaffName=txtName.getText();
				String mContact =txtContact.getText();
				String mMailID=txtEmail.getText();
				int mAge =Integer.parseInt(txtAge.getText());
				int mExperience=Integer.parseInt(txtExperience.getText());
				int mStaffGender;

				if(rbtnMale.isSelected())
				{
					mStaffGender=1;
				}
				else
				{
					mStaffGender=2;
				}
			String q = "UPDATE  tblStaff set StaffName = '"+mStaffName+"',contact ='"+mContact+"',mailID ='"+mMailID+"',Age ='"+mAge+"',Gender ="+mStaffGender+",Experience ="+mExperience+"  WHERE ID="+mID+"";

				JOptionPane.showMessageDialog(this,q);
				Statement st = con.createStatement();
				boolean x = st.execute(q);
				System.out.println(x);
				con.close();
			}
			catch(ClassNotFoundException e) {
				System.out.println("ClassNotFoundException,,,,,,,,,,,,,,,,,,,,,,,"+e);
			}
			catch(SQLException e) {
				System.out.println("SQLException ........................"+e);
			}
		}
		else if(ae.getSource()==btnDelet || ae.getSource()==m1i3)
		{
			JOptionPane.showMessageDialog(this,"Do you want to Delete this Data");

			try
			{
				String url = "Jdbc:Odbc:DSNSTesting";
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con= DriverManager.getConnection(url);

				int mID =Integer.parseInt(txtID.getText());


				String q = "DELETE FROM tblStaff WHERE ID="+mID+" ";

				JOptionPane.showMessageDialog(this,q);

				Statement st = con.createStatement();
				boolean x = st.execute(q);
				System.out.println(x);
				con.close();
			}
			catch(ClassNotFoundException e) {
				System.out.println("ClassNotFoundException,,,,,,,,,,,,,,,,,,,,,,,"+e);
			}
			catch(SQLException e) {
				System.out.println("SQLException ........................"+e);
			}
		}

		else if(ae.getSource()==btnGo || ae.getSource()==m2i1)
		{
			String Item=(String)cmbSelect.getSelectedItem();
			String sq="'";
			String comma=",";
			String Query = "Select *from tblStaff where StaffName="+sq+Item+sq+" ";
			String url = "jdbc:odbc:DSNConnect2324";

			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con= DriverManager.getConnection(url);
				Statement st = con.createStatement();
			//	ResultSet rs = st.executeQuery(Query);
			//	cmbSelect.removeAllItems();
	/*			cmbSelect.addItem("Select Staff Name");
				while(rs.next())
				{
					cmbSelect.addItem(rs.getString(1));
				}
*/
				ResultSet rs1=st.executeQuery(Query);
				if(rs1.next())
				{
					txtID.setText(rs1.getString(1));
					txtName.setText(rs1.getString(2));
					txtContact.setText(rs1.getString(3));
					txtEmail.setText(rs1.getString(4));
					txtAge.setText(rs1.getString(5));
					txtExperience.setText(rs1.getString(6));
				}
			}
			catch(Exception e)
			{}
		}
		else if(ae.getSource()==btnView)
		{
			String Query = "Select StaffName from tblStaff";
		//	JOptionPane.showMessageDialog(this,Query);
			String url = "Jdbc:Odbc:DSNConnect2324";
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//	JOptionPane.showMessageDialog(this,"Driver Loaded");
				Connection con= DriverManager.getConnection(url);
			//	JOptionPane.showMessageDialog(this,"Connection Eshtablished");
				Statement st = con.createStatement();
			//	JOptionPane.showMessageDialog(this,"Statement Created");
				ResultSet rs = st.executeQuery(Query);
			//	JOptionPane.showMessageDialog(this,"Data Returned");
				cmbSelect.removeAllItems();
				cmbSelect.addItem("Select Staff Name");
				while(rs.next())
				{
					cmbSelect.addItem(rs.getString(1));
				}
			}
			catch(Exception e)
			{}
		}
	}
	public static void main(String args[])
	{
		StaffForm a=new StaffForm();
	}
}
