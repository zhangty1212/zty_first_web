package zty.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * jdbc������
 * 
 * @author APPle
 *
 */
public class JdbcUtil {
	private static String url = null;
	private static String user = null;
	private static String password = null;
	private static String driverClass = null;

	/**
	 * ��̬������У�ֻ����һ�Σ�
	 */
	static {
		try {
			// ��ȡdb.properties�ļ�
			Properties props = new Properties();
			/**
			 * . ����java�������е�Ŀ¼ ��java��Ŀ�£�. java���������Ŀ¼����Ŀ�ĸ�Ŀ¼��ʼ ��web��Ŀ�£� .java
			 * ���������Ŀ¼��tomcat/binĿ¼��ʼ, ���Բ���ʹ�õ�.
			 */
			// FileInputStream in = new FileInputStream("./src/db.properties");

			/**
			 * ʹ����·���Ķ�ȡ��ʽ / : б�ܱ�ʾclasspath�ĸ�Ŀ¼ ��java��Ŀ�£�classpath�ĸ�Ŀ¼��binĿ¼��ʼ
			 * ��web��Ŀ�£�classpath�ĸ�Ŀ¼��WEB-INF/classesĿ¼��ʼ��
			 * 
			 * �ҵ��ܽ᣺
			 * 
			 * ������java��Ŀ������ web��Ŀ,ֱ����src��Ŀ¼�´��� db.properties �ļ���ʹ��/db.properties�� ���ɶ�ȡ���ļ����ݣ�
			 */
			InputStream in = JdbcUtil.class.getResourceAsStream("/db.properties");

			// �����ļ�
			props.load(in);
			// ��ȡ��Ϣ
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
			driverClass = props.getProperty("driverClass");

			// ע����������
			Class.forName(driverClass);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���̳���ע�����");
		}
	}

	/**
	 * ��ȡ��ȡ���Ӷ���ķ���
	 */
	public static Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * �ͷ���Դ�ķ���
	 */
	public static void close(Connection conn, Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new RuntimeException(e1);
			}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
}
