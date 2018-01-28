package ch12_151304064_151304094;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;

public class DeleteStudentPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentUI userInterface1,userInterface2;
	private JButton firstButton1,secondButton1,firstButton2,secondButton2;
	String snoUpdate;
	String sqlString;
	public DeleteStudentPanel(){
		String names1[]={"������Ҫɾ����ѧ��ѧ��:"};
		userInterface1=new StudentUI(names1);
		String names2[]={"ѧ ��","����","�Ա�","��������","����ϵ"};
		userInterface2=new StudentUI(names2);
		setLayout(new FlowLayout());
		Box box=Box.createVerticalBox();
		box.add(userInterface1);
		box.add(userInterface2);
		add(box);
		firstButton1=userInterface1.getDoTask1Button();
		firstButton1.setText("ȷ��");
		firstButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DisplayRecord();
			}
		});
		secondButton1=userInterface1.getDoTask2Button();
		secondButton1.setText("����");
		secondButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				userInterface1.clearFields();
			}
		});
		firstButton2=userInterface2.getDoTask1Button();
		firstButton2.setText("ȷ��ɾ��");
		firstButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deleteRecord();
			}
		});
		secondButton2=userInterface2.getDoTask2Button();
		secondButton2.setText("����");
		setSize(400,260);
		setVisible(true);
	}
	public void DisplayRecord(){
		String fieldValues1[]=userInterface1.getFieldValues();
		String fieldValues2[]=new String[5];
		if(!fieldValues1[StudentUI.ѧ��].equals("")){
			snoUpdate=fieldValues1[0];
			try{
				String sqlString="select * from student"+" where ѧ��='"+fieldValues1[0]+"'";
				StudentManager studentmanager=new StudentManager();
				List<Student>list=studentmanager.Query(sqlString);
				if(list.size()!=0){
					fieldValues2[0]=list.get(0).getѧ��();
					fieldValues2[1]=list.get(0).get����();
					fieldValues2[2]=list.get(0).get�Ա�();
					fieldValues2[3]=list.get(0).get��������();
					fieldValues2[4]=list.get(0).getרҵ();
					userInterface2.setFieldValues(fieldValues2);
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	public void deleteRecord(){
		String fieldValues[]=userInterface2.getFieldValues();
		if(!fieldValues[StudentUI.ѧ��].equals("")){
			try{
				String sqlString="delete from student where ѧ��="+snoUpdate+"";
				StudentManager studentmanager=new StudentManager();
				int result=studentmanager.execUpdate(sqlString);
				if(result!=0){
					JOptionPane.showMessageDialog(this, "Deleted sucess!","Delete Result",JOptionPane.PLAIN_MESSAGE);					
				}
				else{
					JOptionPane.showMessageDialog(this, "Bad sno number","Invalid Number Format",JOptionPane.PLAIN_MESSAGE);
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
}
