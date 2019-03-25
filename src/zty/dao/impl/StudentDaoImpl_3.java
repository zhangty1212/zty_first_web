/**  
*    �ļ���:  StudentDaoImpl_3.java
*    �ļ�����:  
*  @author zhanggtaoyi 
*  @date 2019��3��18��  
*/
package zty.dao.impl;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import zty.dao.IStudentDao;
import zty.entity.Student;
import zty.util.JdbcUtil;
import zty.util.JdbcUtilc3p0;
import zty.util.PageBean;

/**
 * ������:
 * 
 * @author ����һ ,2547260515@qq.com
 * @since 2019��3��18�� ����4:42:41
 */
public class StudentDaoImpl_3 implements IStudentDao {

	// ���ݿ����� conn
	Connection conn;

	@Override
	public ArrayList<Student> queryAllStudent() {
		// TODO Auto-generated method stub
		/*
		 * // ʹ�ù����� JdbcUtilc3p0.java ����ȡ���ݿ����� conn
		 * 
		 * conn = JdbcUtilc3p0.getConnection();
		 * 
		 * // ׼��Ҫִ�е�SQL��� String sql = "select * from student";
		 * 
		 * // ���� DBUtil �齨�ĺ�������� QueryRunner queryRunner
		 * 
		 * QueryRunner queryRunner = new QueryRunner();
		 * 
		 * ArrayList<Student> arrayList = null;
		 * 
		 * // queryRunner �� query ����Ĭ�Ϸ��ص��� list ���ϣ���������Ҫ��һ�����µ�ǿ��ת�ͣ�תΪ ArrayList<Student>
		 * 
		 * try { arrayList = (ArrayList<Student>) queryRunner.query(conn, sql, new
		 * BeanListHandler<Student>(Student.class)); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * // c3p0 ���ӳص����� connn ��û���Ҫ�ֶ��ر�һ�� try { conn.close(); } catch (SQLException e)
		 * { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * return arrayList;
		 */

		String sql = "select * from student";

		Object object1 = new BeanListHandler<Student>(Student.class);

		List<Object> list = JdbcUtilc3p0.queryDatabase(sql, object1);

		Object ob = (Object) list;
		List<Student> students = (List<Student>) ob;

		System.out.println("��ѯȫ�����ݳɹ���");

		return (ArrayList<Student>) students;
	}

	@Override
	public boolean existJudgeStudent(Student student) {
		// TODO Auto-generated method stub

		/*
		 * conn = JdbcUtilc3p0.getConnection();
		 * 
		 * String sql = "select * from student where SID= ?";
		 * 
		 * QueryRunner queryRunner = new QueryRunner();
		 * 
		 * List<Student> list = null; try { list = queryRunner.query(conn, sql, new
		 * BeanListHandler<Student>(Student.class), student.getSID()); } catch
		 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * try { conn.close(); } catch (SQLException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */

		String sql = "select * from student where SID= ?";

		Object object1 = new BeanListHandler<Student>(Student.class);

		List<Object> list = JdbcUtilc3p0.queryDatabase(sql, object1, student.getSID());

		System.out.println("��ѯ���ݳɹ���");

		if (list.size() > 0) {

			for (Object obj : list) {
				System.out.println(obj);
			}
			return true;
		}

		return false;
	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub

		/*
		 * conn = JdbcUtilc3p0.getConnection();
		 * 
		 * String sql =
		 * "insert into student (SID, Sname,Sage,Sex,Sclass) values(?,?,?,?,?) ";
		 * 
		 * QueryRunner queryRunner = new QueryRunner();
		 * 
		 * try { queryRunner.update(conn, sql, student.getSID(), student.getSname(),
		 * student.getSage(), student.getSex(), student.getSclass()); } catch
		 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * try { conn.close(); } catch (SQLException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */

		String sql = "insert into student (SID, Sname,Sage,Sex,Sclass) values(?,?,?,?,?) ";
		JdbcUtilc3p0.updateDatabase(sql, student.getSID(), student.getSname(), student.getSage(), student.getSex(),
				student.getSclass());
		System.out.println("����ɹ���");
	}

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub

		/*
		 * conn = JdbcUtilc3p0.getConnection(); String sql =
		 * "delete from student where SID=? ";
		 * 
		 * QueryRunner queryRunner = new QueryRunner();
		 * 
		 * try { queryRunner.update(conn, sql, student.getSID()); } catch (SQLException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * try { conn.close(); } catch (SQLException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */

		String sql = "delete from student where SID=? ";

		JdbcUtilc3p0.updateDatabase(sql, student.getSID());

		System.out.println("ɾ���ɹ���");
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub

		/*
		 * conn = JdbcUtilc3p0.getConnection();
		 * 
		 * String sql = "update student set Sname=?,Sage=?,Sex=?,Sclass=? where SID=? ";
		 * 
		 * QueryRunner queryRunner = new QueryRunner();
		 * 
		 * try { queryRunner.update(conn, sql, student.getSname(), student.getSage(),
		 * student.getSex(), student.getSclass(), student.getSID()); } catch
		 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * try { conn.close(); } catch (SQLException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */

		String sql = "update student set Sname=?,Sage=?,Sex=?,Sclass=? where SID=? ";

		System.out.println(student.getSname() + "-------" + student.getSage());

		JdbcUtilc3p0.updateDatabase(sql, student.getSname(), student.getSage(), student.getSex(), student.getSclass(),
				student.getSID());

		System.out.println("���³ɹ���");

	}

	@Override
	public void getAll(PageBean<Student> pb) {

		// 1. ��ѯ�ܼ�¼��; ���õ�pb������
		int totalCount = this.getTotalCount();
		pb.setTotalCount(totalCount);

		// 2. ���� ��ҳ��ĩҳ������
		/*
		 * ���⣺ jspҳ�棬�����ǰҳΪ��ҳ���ٵ����һҳ���� �����ǰҳΪĩҳ���ٵ���һҳ��ʾ�����⣡ ����� 1. �����ǰҳ <= 0;
		 * ��ǰҳ���õ�ǰҳΪ1; 2. �����ǰҳ > ���ҳ���� ��ǰҳ����Ϊ���ҳ��
		 */
		if (pb.getCurrentPage() <= 0) {
			pb.setCurrentPage(1); // �ѵ�ǰҳ����Ϊ1
		} else if (pb.getCurrentPage() > pb.getTotalPage()) {
			pb.setCurrentPage(pb.getTotalPage()); // �ѵ�ǰҳ����Ϊ���ҳ��
		}

		// 3. ��ȡ��ǰҳ�� �����ѯ����ʼ�С����ص�����
		int currentPage = pb.getCurrentPage();
		int index = (currentPage - 1) * pb.getPageCount(); // ��ѯ����ʼ��
		int count = pb.getPageCount();

		// 4. ��ҳ��ѯ����; �Ѳ�ѯ�����������õ�pb������
		String sql = "select * from student limit ?,?";

		conn = JdbcUtilc3p0.getConnection();
		QueryRunner queryRunner = new QueryRunner();

		List<Student> pageData = null;

		try {
			pageData = queryRunner.query(conn, sql, new BeanListHandler<Student>(Student.class), index, count);
			pb.setPageData(pageData);
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

	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub

		String sql = "select count(*) from student";

		conn = JdbcUtilc3p0.getConnection();

		QueryRunner queryRunner = new QueryRunner();

		Long totalcount = null;

		try {
			totalcount = queryRunner.query(conn, sql, new ScalarHandler<Long>());
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalcount.intValue();

	}

	@Override
	public Student queryStudentByID(String SID) {
		// TODO Auto-generated method stub

		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		conn = JdbcUtilc3p0.getConnection();

		String sql = "select * from student where SID= ?";
		try {
			preparedStatement = conn.prepareStatement(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			preparedStatement.setString(1, SID);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			rs = preparedStatement.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Student student = null;

		try {
			if (rs.next()) {
				student = new Student();
				// System.out.println(rs.next() + "----------------------------");
				// System.out.println(rs.getString("SID"));
				student.setSID(rs.getString("SID"));
				student.setSname(rs.getString("Sname"));
				student.setSage(rs.getInt("Sage"));
				student.setSclass(rs.getString("Sclass"));
				student.setSex(rs.getString("Sex"));
				// System.out.println(student + "--------------------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, preparedStatement, rs);
		}

		// System.out.println(student + "--------------------------------");
		return student;
	}

	@Override
	public void deleteStudentByID(String SID) {
		// TODO Auto-generated method stub

		String sql = "delete from student where SID=? ";
		JdbcUtilc3p0.updateDatabase(sql, SID);
		System.out.println("���� SID ɾ��ѧ����Ϣ�ɹ���");
	}

}
