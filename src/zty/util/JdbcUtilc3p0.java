package zty.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import zty.entity.Student;

/**
 * jdbc������
 * 
 * @author APPle
 *
 */
public class JdbcUtilc3p0 {

	/**
	 * ��ȡ��ȡ���Ӷ���ķ���
	 */
	public static Connection getConnection() {

		// �� ComboPooledDataSource ���󣬻�ȡ���ݿ����� con

		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

		Connection conn = null;
		try {
			conn = comboPooledDataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;

	}

	/**
	 * ��������: DBUtil ���¡�ɾ�������� ���ݹ�������
	 * 
	 * @since 2019��3��19��
	 */
	public static int updateDatabase(String sql, Object... object) {
		// TODO Auto-generated method stub

		int count=0;
		Connection connection = getConnection();

		QueryRunner queryRunner = new QueryRunner();

		try {
			count= queryRunner.update(connection, sql, object);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;

	}

	/**
	 * ��������: DBUtil ��ѯ���ݹ�������
	 * 
	 * @since 2019��3��19��
	 */
	public static List<Object> queryDatabase(String sql, Object object1, Object... object2) {
		// TODO Auto-generated method stub

		Connection connection = getConnection();

		QueryRunner queryRunner = new QueryRunner();

		List<Object> list = null;

		try {
			list = (List<Object>) queryRunner.query(connection, sql, (ResultSetHandler<Object>) object1, object2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

}
