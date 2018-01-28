package ch12_151304064_151304094;

import java.util.List;
import java.sql.SQLException;
import javax.swing.*;

public class ListStudent extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ListStudent(){
		String Listhand[] = {"学号","姓名","性别","出生年月","所在系"};
		String sqlString = new String("select 学号,姓名,性别,出生日期,专业  from student");
		StudentManager studentManager = new StudentManager();
		try{
			List<Student>list=studentManager.Query(sqlString);
			StringBuffer results = new StringBuffer();
			results.append(" ");
			for(int i=0;i<Listhand.length;i++){
				results.append(Listhand[i]+"\t");
			}
			results.append("\n");
			for(int i=0;i<list.size();i++){
				results.append(" ");
				results.append(list.get(i).get学号()+"\t");
				results.append(list.get(i).get姓名()+"\t");
				results.append(list.get(i).get性别()+"\t");
				results.append(list.get(i).get出生日期()+"\t");
				results.append(list.get(i).get专业()+"\t");
				if(i!=list.size()-1)
					results.append("\n");
			}
			JTextArea textArea=new JTextArea(results.toString());
			this.add(new JScrollPane(textArea));
			setSize(300,100);
		}catch(SQLException sqlException){
			JOptionPane.showMessageDialog(null,sqlException.getMessage(),"删除错误",JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
	

}
