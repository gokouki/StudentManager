package ch12_151304064_151304094;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class StudentManager extends DBC{
	private Connection conn=null;
	//构造方法中完成打开数据库连接
	public StudentManager() {
		conn=getConnection();
	}
	//对student表进行插入、修改、删除操作
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
	//对student表行查询，并以List结构返回结果，并及时关闭数据库连接
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
				m.set学号(rs.getString("学号"));
				m.set姓名(rs.getString("姓名"));
				m.set性别(rs.getString("性别"));
				m.set出生日期(rs.getString("出生日期"));
				m.set专业(rs.getString("专业"));
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
