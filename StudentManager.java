package ch12_151304064_151304094;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class StudentManager extends DBC{
	private Connection conn=null;
	//���췽������ɴ����ݿ�����
	public StudentManager() {
		conn=getConnection();
	}
	//��student����в��롢�޸ġ�ɾ������
	public int execUpdate(String sql) throws SQLException{
		int result=0;
		Statement statement=null;
		try{
			statement=conn.createStatement();
			result=statement.executeUpdate(sql);
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			if(statement!=null)
				statement.close();
			closeConnection();
		}
		return result;
	}
	//��student���в�ѯ������List�ṹ���ؽ��������ʱ�ر����ݿ�����
	public List<Student>Query(String sqlString) throws SQLException{
		System.out.println(sqlString);
		List<Student>list=new ArrayList<Student>();
		Statement statement=null;
		ResultSet rs=null;
		try{
			statement=conn.createStatement();
			rs=statement.executeQuery(sqlString);
			while(rs.next()){
				Student m=new Student();
				m.setѧ��(rs.getString("ѧ��"));
				m.set����(rs.getString("����"));
				m.set�Ա�(rs.getString("�Ա�"));
				m.set��������(rs.getString("��������"));
				m.setרҵ(rs.getString("רҵ"));
				list.add(m);
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			if(statement!=null)
				statement.close();
			if(rs!=null)
				rs.close();
			closeConnection();
		}
		return list;
	}
}
