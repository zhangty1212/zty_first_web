/**  
*    文件名:  StudentDaoImpl_2.java
*    文件描述:  
*  @author zhanggtaoyi 
*  @date 2019年3月18日  
*//*
package zty.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import zty.dao.IStudentDao;
import zty.entity.Student;
import zty.util.JdbcUtil;

*//**
 * 类描述:
 * 
 * @author 张涛一 ,2547260515@qq.com
 * @since 2019年3月18日 下午3:35:46
 *//*
public class StudentDaoImpl_2 implements IStudentDao {

	@Override
	public ArrayList<Student> queryAllStudent() {
		// TODO Auto-generated method stub

		// 使用工具类 JdbcUtil 得到数据库链接
		Connection con = JdbcUtil.getConnection();

		// 准备要执行的SQL语句
		String sql = "select * from student";

		// 创建 PreparedStatement 对象
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = con.prepareStatement(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// 执行查询，得到 ResultSet 对象

		ResultSet resultSet = null;
		try {
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// 定义一个 arrayList ，存放 Student 对象

		ArrayList<Student> arrayList = new ArrayList<>();

		try {
			while (resultSet.next()) {

				Student student = new Student();
				student.setSID(resultSet.getString("SID"));
				student.setSname(resultSet.getString("Sname"));
				student.setSage(resultSet.getInt("Sage"));
				student.setSex(resultSet.getString("Sex"));
				student.setSclass(resultSet.getString("Sclass"));
				arrayList.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// 使用工具类 JdbcUtil，释放数据库链接
			JdbcUtil.close(con, preparedStatement, resultSet);
		}

		return arrayList;

	}

	@Override
	public boolean existJudgeStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub

	}

}
*/