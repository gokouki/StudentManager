package ch12_151304064_151304094;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class StudentUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JLabel labels[];
	protected JTextField fields[];
	protected JButton doTask1,doTask2;
	protected JPanel innerPanelCenter,innerPanelSouth;
	protected int size;
	public static final int ѧ��=0,����=1,�Ա�=2,��������=3,רҵ=4;
	//���췽���Ĳ������ַ��������������ֵΪGUI���ֶ��б���
	public StudentUI(String arrayString[]){
		size=arrayString.length;
		labels=new JLabel[size];
		fields=new JTextField[size];
		//������ǩ
		for(int count=0;count<labels.length;count++){
			labels[count]=new JLabel(arrayString[count]);
		}
		for(int count=0;count<fields.length;count++){
			fields[count]=new JTextField();
		}
		innerPanelCenter=new JPanel();
		innerPanelCenter.setLayout(new GridLayout(size,2));
		for(int count=0;count<size;count++){
			innerPanelCenter.add(labels[count]);
			innerPanelCenter.add(fields[count]);
		}
		doTask1=new JButton();
		doTask2=new JButton();
		innerPanelSouth=new JPanel();
		innerPanelSouth.add(doTask1);
		innerPanelSouth.add(doTask2);
		setLayout(new BorderLayout());
		add(innerPanelCenter,BorderLayout.CENTER);
		add(innerPanelSouth,BorderLayout.SOUTH);
		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		validate();
		
	}
	public JButton getDoTask1Button(){
		return doTask1;
	}
	public JButton getDoTask2Button(){
		return doTask2;
	}
	public JTextField[] getFields(){
		return fields;
	}
	public void clearFields(){
		for(int count=0;count<size;count++){
			fields[count].setText("");
		}
	}
	public void setFieldValues(String strings[]){
		if(strings.length!=size){
			throw new IllegalArgumentException("There must be "+size+" Strings in the array");
		}
		for(int count=0;count<size;count++){
				fields[count].setText(strings[count]);	
		}
	}
	public String[] getFieldValues(){
		String values[]=new String[size];
		for(int count=0;count<size;count++){
			values[count]=fields[count].getText();
		}
		return values;
	}
}
