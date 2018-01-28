package ch12_151304064_151304094;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class AddStudentPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton clearButton,writeButton;
	private StudentUI userInterface;
	String name1[]={"学  号","姓 名","性 别","出生年月","所 在 系"};
	public AddStudentPanel() {
		setLayout(new BorderLayout());
		userInterface=new StudentUI(name1);
		this.add(userInterface,BorderLayout.NORTH);
		writeButton=userInterface.getDoTask1Button();
		writeButton.setText("录入");
		writeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String fieldValues[]=userInterface.getFieldValues();
				if(!fieldValues[StudentUI.学号].equals("")){
					try{
						String sqlString="insert into student values('"+fieldValues[0]+"','"+fieldValues[1]+"','"+fieldValues[2]+"','"+fieldValues[3]+"','"+fieldValues[4]+"')";
						
						//执行查询
						StudentManager studentmanager=new StudentManager();
						int result;
						result = studentmanager.execUpdate(sqlString);
						if(result!=0){
							userInterface.clearFields();
							JOptionPane.showMessageDialog(AddStudentPanel.this, "插入成功!!","插入结果",JOptionPane.INFORMATION_MESSAGE);
							
						}
					}catch(NumberFormatException formatException){
						JOptionPane.showMessageDialog(AddStudentPanel.this, "插入失败","插入异常抛出",JOptionPane.ERROR_MESSAGE);
						
					}catch(SQLException e){
						System.out.println(e);
					}
				}
			}
		});
		clearButton=userInterface.getDoTask2Button();
		clearButton.setText("重置");
	}
}
	

