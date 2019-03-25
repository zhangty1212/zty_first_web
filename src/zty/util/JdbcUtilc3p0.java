package zty.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import zty.entity.Student;

/**
 * jdbc工具类
 * 
 * @author APPle
 *
 */
public class JdbcUtilc3p0 {

	/**
	 * 抽取获取连接对象的方法
	 */
	public static Connection getConnection() {

		// 由 ComboPooledDataSource 对象，获取数据库链接 con

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
	 * 方法描述: DBUtil 更新、删除、插入 数据公共方法
	 * 
	 * @since 2019年3月19日
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
	 * 方法描述: DBUtil 查询数据公共方法
	 * 
	 * @since 2019年3月19日
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
