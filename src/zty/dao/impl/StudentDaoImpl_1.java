/**  
*    文件名:  StudentDaoImpl.java
*    文件描述:  
*  @author zhanggtaoyi 
*  @date 2019年3月18日  
*//*
package zty.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import zty.dao.IStudentDao;
import zty.entity.Student;

*//**
 * 类描述:
 * 
 * @author 张涛一 ,2547260515@qq.com
 * @since 2019年3月18日 上午11:12:06
 *//*
public class StudentDaoImpl_1 implements IStudentDao {

	
	  (non-Javadoc)
	  
	  @see zty.dao.IStudentDao#queryAllStudent()
	 
	@Override
	public ArrayList<Student> queryAllStudent() {

		// 注册 mysql 驱动
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e7) {
			// TODO Auto-generated catch block
			e7.printStackTrace();
		}

		// 获取一个数据库连接
		String url = "jdbc:mysql://localhost:3306/zty?&useSSL=false&serverTimezone=UTC";
		String user = "root";
		String password = "zty1212";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e7) {
			// TODO Auto-generated catch block
			e7.printStackTrace();
		}
		try {
			if (!conn.isClosed())
				System.out.println("数据库连接成功！");
		} catch (SQLException e7) {
			// TODO Auto-generated catch block
			e7.printStackTrace();
		}

		// 准备要执行的SQL语句
		String sql = "select * from student";

		// 创建 PreparedStatement 类对象，用来执行SQL语句！
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(sql);
		} catch (SQLException e6) {
			// TODO Auto-generated catch block
			e6.printStackTrace();
		}

		ResultSet resultSet = null;
		try {
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e5) {
			// TODO Auto-generated catch block
			e5.printStackTrace();
		}

		ArrayList<Student> arrayList = new ArrayList<>();

		try {
			while (resultSet.next()) {

				Student student = new Student();
				try {
					student.setSID(resultSet.getString("SID"));
				} catch (SQLException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
				try {
					student.setSname(resultSet.getString("Sname"));
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				try {
					student.setSage(resultSet.getInt("Sage"));
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					student.setSex(resultSet.getString("Sex"));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					student.setSclass(resultSet.getString("Sclass"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				arrayList.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrayList;
	}

	
	  (non-Javadoc)
	  
	  @see zty.dao.IStudentDao#existJudgeStudent(zty.entity.Student)
	 
	@Override
	public boolean existJudgeStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	
	  (non-Javadoc)
	  
	  @see zty.dao.IStudentDao#addStudent(zty.entity.Student)
	 
	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub

	}

	
	  (non-Javadoc)
	  
	  @see zty.dao.IStudentDao#deleteStudent(zty.entity.Student)
	 
	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub

	}

	
	  (non-Javadoc)
	  
	  @see zty.dao.IStudentDao#updateStudent(zty.entity.Student)
	 
	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub

	}

}
*/