/**  
*    �ļ���:  StudentDaoImpl_2.java
*    �ļ�����:  
*  @author zhanggtaoyi 
*  @date 2019��3��18��  
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
 * ������:
 * 
 * @author ����һ ,2547260515@qq.com
 * @since 2019��3��18�� ����3:35:46
 *//*
public class StudentDaoImpl_2 implements IStudentDao {

	@Override
	public ArrayList<Student> queryAllStudent() {
		// TODO Auto-generated method stub

		// ʹ�ù����� JdbcUtil �õ����ݿ�����
		Connection con = JdbcUtil.getConnection();

		// ׼��Ҫִ�е�SQL���
		String sql = "select * from student";

		// ���� PreparedStatement ����
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = con.prepareStatement(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// ִ�в�ѯ���õ� ResultSet ����

		ResultSet resultSet = null;
		try {
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// ����һ�� arrayList ����� Student ����

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

			// ʹ�ù����� JdbcUtil���ͷ����ݿ�����
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