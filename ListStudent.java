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
		String Listhand[] = {"ѧ��","����","�Ա�","��������","����ϵ"};
		String sqlString = new String("select ѧ��,����,�Ա�,��������,רҵ  from student");
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
				results.append(list.get(i).getѧ��()+"\t");
				results.append(list.get(i).get����()+"\t");
				results.append(list.get(i).get�Ա�()+"\t");
				results.append(list.get(i).get��������()+"\t");
				results.append(list.get(i).getרҵ()+"\t");
				if(i!=list.size()-1)
					results.append("\n");
			}
			JTextArea textArea=new JTextArea(results.toString());
			this.add(new JScrollPane(textArea));
			setSize(300,100);
		}catch(SQLException sqlException){
			JOptionPane.showMessageDialog(null,sqlException.getMessage(),"ɾ������",JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
	

}
