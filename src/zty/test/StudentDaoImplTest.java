/**  
*    �ļ���:  StudentDaoImplTest.java
*    �ļ�����:  
*  @author zhanggtaoyi 
*  @date 2019��3��18��  
*/
package zty.test;

import java.util.ArrayList;

import org.junit.Test;

import zty.dao.impl.StudentDaoImpl_3;
import zty.entity.Student;

/**
 * ������:
 * 
 * @author ����һ ,2547260515@qq.com
 * @since 2019��3��18�� ����2:39:08
 */
public class StudentDaoImplTest {

	/*
	 * @Test public void queryAllStudentTest1() {
	 * 
	 * ArrayList<Student> arrayList = new StudentDaoImpl_1().queryAllStudent();
	 * 
	 * for (Student student : arrayList) { System.out.println(student);
	 * 
	 * }
	 * 
	 * System.out.
	 * println("���������������������������������������������������������������������������������������������������������������� ��1��");
	 * 
	 * }
	 */

	/*
	 * @Test public void queryAllStudentTest2() {
	 * 
	 * ArrayList<Student> arrayList = new StudentDaoImpl_2().queryAllStudent();
	 * 
	 * for (Student student : arrayList) { System.out.println(student);
	 * 
	 * }
	 * 
	 * System.out.
	 * println("���������������������������������������������������������������������������������������������������������������� ��2��");
	 * 
	 * }
	 */

	@Test
	public void queryAllStudentTest3() {

		ArrayList<Student> arrayList = new StudentDaoImpl_3().queryAllStudent();

		for (Student student : arrayList) {
			System.out.println(student);

		}
		System.out.println("���������������������������������������������������������������������������������������������������������������� ��3��");
	}

	@Test
	public void existJudgeStudentTest3() {

		Student student = new Student();
		student.setSID("s0012");
		student.setSname("����");
		boolean b = new StudentDaoImpl_3().existJudgeStudent(student);

		if (b) {
			System.out.println(student.getSID() + " �����Ѵ��ڣ��ɸ�����Ϣ!");

		} else {
			System.out.println(student.getSID() + " ���������ڣ��ɲ�����Ϣ");
		}

		System.out.println("���������������������������������������������������������������������������������������������ж���Ա�Ƿ���ڣ�");

	}

	@Test
	public void addStudentTest3() {

		Student student = new Student();
		student.setSID("s0012");
		student.setSname("����");
		student.setSage(22);
		student.setSex("1");
		student.setSclass("c102");

		new StudentDaoImpl_3().addStudent(student);

		System.out.println("������������������������������������������������������������������������������������������������ѧ����Ϣ��");

	}

	@Test
	public void updateStudentTest3() {

		Student student = new Student();
		student.setSID("s0012");
		student.setSname("��һ");
		student.setSage(24);
		student.setSex("0");
		student.setSclass("c102");

		new StudentDaoImpl_3().updateStudent(student);

		System.out.println("������������������������������������������������������������������������������������������������ѧ����Ϣ��");

	}

	@Test
	public void deleteStudentTest3() {

		Student student = new Student();
		student.setSID("s0012");
		new StudentDaoImpl_3().deleteStudent(student);

		System.out.println("��������������������������������������������������������������������������������������������ɾ��ѧ����Ϣ��");

	}

	@Test
	public void getTotalCountTest3() {

		int totalcount = new StudentDaoImpl_3().getTotalCount();
		System.out.println(totalcount);

		System.out.println("��������������������������������������������������������������������������������������������ѧ��������");

	}

}
