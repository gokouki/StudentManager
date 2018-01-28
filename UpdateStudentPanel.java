package ch12_151304064_151304094;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
public class UpdateStudentPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentUI userInterface1,userInterface2;
	private JButton firstButton1,secondButton1,firstButton2,secondButton2;
	String snoUpdate;
	String sqlString;
	public UpdateStudentPanel(){
		//�޸�����
		String names1[]={"������Ҫ��ѯ���޸�ѧ����ѧ�ţ�"};
		userInterface1=new StudentUI(names1);
		//������ʾҪ�޸ĵļ�¼����
		String names2[]={"(��) ѧ  ��","(��) ��  ��","(��) ��  ��","(��)��  ��","(��) �� �� ϵ"};
		userInterface2=new StudentUI(names2);
		this.setLayout(new FlowLayout());
		//Container c=getContentPane();
		Box box=Box.createVerticalBox();
		box.add(userInterface1);
		box.add(userInterface2);
		add(box);
		firstButton1=userInterface1.getDoTask1Button();
		firstButton1.setText("ȷ��");
		firstButton1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent event) {
				DisplayRecord();
			}
			
		});
		secondButton1=userInterface1.getDoTask2Button();
		secondButton1.setText("����");
		secondButton1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent event) {
				userInterface1.clearFields();
			}
			
		});
		
		firstButton2=userInterface2.getDoTask1Button();
		firstButton2.setText("¼���޸�");
		firstButton2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				UpdateRecord();
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
			try {
				String sqlString="select*from student where ѧ��='"+fieldValues1[0]+"'";
				StudentManager studentmanager=new StudentManager();
				List<Student>list=studentmanager.Query(sqlString);
				if(list.size()!=0){
					fieldValues2[0]=list.get(0).getѧ��();
					fieldValues2[1]=list.get(0).get����();
					fieldValues2[2]=list.get(0).get�Ա�();
					fieldValues2[3]=list.get(0).get��������();
					fieldValues2[4]=list.get(0).getרҵ();
					userInterface2.setFieldValues(fieldValues2);
				}else{
					userInterface2.clearFields();
					
					JOptionPane.showMessageDialog(UpdateStudentPanel.this, "�Ҳ�����ѧ�ŵ�ѧ��",
							"��ѯ���",JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else//if sno field value is empty
			JOptionPane.showMessageDialog(this,"Bad sno number","Invalid Number Format",
					JOptionPane.ERROR_MESSAGE);
	}
	
	//update record of student
	public void UpdateRecord(){
		String fieldValues[]=userInterface2.getFieldValues();
		if(!fieldValues[StudentUI.ѧ��].equals("")){
			try {
				String sqlString="Update student set "+
						"ѧ��='"+fieldValues[0]+"',"+
						"����='"+fieldValues[1]+"',"+
						"�Ա�='"+fieldValues[2]+"',"+
						"��������='"+fieldValues[3]+"',"+
						"רҵ='"+fieldValues[4]+"' where ѧ��='"+snoUpdate+"'";
				System.out.println(sqlString);
				StudentManager studentmanager=new StudentManager();
				int result=studentmanager.execUpdate(sqlString);
				if(result!=0){
					JOptionPane.showMessageDialog(this,"������Ϣ�ɹ�!","���½��",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} 
			//process  invalid age number format
			catch(NumberFormatException formatException){
				JOptionPane.showMessageDialog(this, "Bad age number","Invalid Number Format",
						JOptionPane.ERROR_MESSAGE);
			}
			//process exceptions from sql
			catch (SQLException e) {
				System.out.println(e);
			}	
		}else JOptionPane.showMessageDialog(this, 
				"Bad sno number","Invalid Number Format",JOptionPane.ERROR_MESSAGE);
	}
}
