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
		//修改条件
		String names1[]={"请输入要查询或修改学生的学号："};
		userInterface1=new StudentUI(names1);
		//设置显示要修改的记录画面
		String names2[]={"(新) 学  号","(新) 姓  名","(新) 性  别","(新)年  龄","(新) 所 在 系"};
		userInterface2=new StudentUI(names2);
		this.setLayout(new FlowLayout());
		//Container c=getContentPane();
		Box box=Box.createVerticalBox();
		box.add(userInterface1);
		box.add(userInterface2);
		add(box);
		firstButton1=userInterface1.getDoTask1Button();
		firstButton1.setText("确认");
		firstButton1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent event) {
				DisplayRecord();
			}
			
		});
		secondButton1=userInterface1.getDoTask2Button();
		secondButton1.setText("重置");
		secondButton1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent event) {
				userInterface1.clearFields();
			}
			
		});
		
		firstButton2=userInterface2.getDoTask1Button();
		firstButton2.setText("录入修改");
		firstButton2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				UpdateRecord();
			}
			
		});
		secondButton2=userInterface2.getDoTask2Button();
		secondButton2.setText("放弃");
		
		setSize(400,260);
		setVisible(true);
	}
	public void DisplayRecord(){
		String fieldValues1[]=userInterface1.getFieldValues();
		String fieldValues2[]=new String[5];
		if(!fieldValues1[StudentUI.学号].equals("")){
			snoUpdate=fieldValues1[0];
			try {
				String sqlString="select*from student where 学号='"+fieldValues1[0]+"'";
				StudentManager studentmanager=new StudentManager();
				List<Student>list=studentmanager.Query(sqlString);
				if(list.size()!=0){
					fieldValues2[0]=list.get(0).get学号();
					fieldValues2[1]=list.get(0).get姓名();
					fieldValues2[2]=list.get(0).get性别();
					fieldValues2[3]=list.get(0).get出生日期();
					fieldValues2[4]=list.get(0).get专业();
					userInterface2.setFieldValues(fieldValues2);
				}else{
					userInterface2.clearFields();
					
					JOptionPane.showMessageDialog(UpdateStudentPanel.this, "找不到该学号的学生",
							"查询结果",JOptionPane.INFORMATION_MESSAGE);
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
		if(!fieldValues[StudentUI.学号].equals("")){
			try {
				String sqlString="Update student set "+
						"学号='"+fieldValues[0]+"',"+
						"姓名='"+fieldValues[1]+"',"+
						"性别='"+fieldValues[2]+"',"+
						"出生日期='"+fieldValues[3]+"',"+
						"专业='"+fieldValues[4]+"' where 学号='"+snoUpdate+"'";
				System.out.println(sqlString);
				StudentManager studentmanager=new StudentManager();
				int result=studentmanager.execUpdate(sqlString);
				if(result!=0){
					JOptionPane.showMessageDialog(this,"更新信息成功!","更新结果",
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
