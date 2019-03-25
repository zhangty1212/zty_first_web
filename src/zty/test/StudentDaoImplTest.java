/**  
*    ÎÄ¼þÃû:  StudentDaoImplTest.java
*    ÎÄ¼þÃèÊö:  
*  @author zhanggtaoyi 
*  @date 2019Äê3ÔÂ18ÈÕ  
*/
package zty.test;

import java.util.ArrayList;

import org.junit.Test;

import zty.dao.impl.StudentDaoImpl_3;
import zty.entity.Student;

/**
 * ÀàÃèÊö:
 * 
 * @author ÕÅÌÎÒ» ,2547260515@qq.com
 * @since 2019Äê3ÔÂ18ÈÕ ÏÂÎç2:39:08
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
	 * println("¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª £¨1£©");
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
	 * println("¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª £¨2£©");
	 * 
	 * }
	 */

	@Test
	public void queryAllStudentTest3() {

		ArrayList<Student> arrayList = new StudentDaoImpl_3().queryAllStudent();

		for (Student student : arrayList) {
			System.out.println(student);

		}
		System.out.println("¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª £¨3£©");
	}

	@Test
	public void existJudgeStudentTest3() {

		Student student = new Student();
		student.setSID("s0012");
		student.setSname("Íõ¾ü");
		boolean b = new StudentDaoImpl_3().existJudgeStudent(student);

		if (b) {
			System.out.println(student.getSID() + " Ö÷¼üÒÑ´æÔÚ£¬¿É¸üÐÂÐÅÏ¢!");

		} else {
			System.out.println(student.getSID() + " Ö÷¼ü²»´æÔÚ£¬¿É²åÈëÐÅÏ¢");
		}

		System.out.println("¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª£¨ÅÐ¶ÏÈËÔ±ÊÇ·ñ´æÔÚ£©");

	}

	@Test
	public void addStudentTest3() {

		Student student = new Student();
		student.setSID("s0012");
		student.setSname("ÕÅÌÎ");
		student.setSage(22);
		student.setSex("1");
		student.setSclass("c102");

		new StudentDaoImpl_3().addStudent(student);

		System.out.println("¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª£¨²åÈëÑ§ÉúÐÅÏ¢£©");

	}

	@Test
	public void updateStudentTest3() {

		Student student = new Student();
		student.setSID("s0012");
		student.setSname("ÕÅÒ»");
		student.setSage(24);
		student.setSex("0");
		student.setSclass("c102");

		new StudentDaoImpl_3().updateStudent(student);

		System.out.println("¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª£¨¸üÐÂÑ§ÉúÐÅÏ¢£©");

	}

	@Test
	public void deleteStudentTest3() {

		Student student = new Student();
		student.setSID("s0012");
		new StudentDaoImpl_3().deleteStudent(student);

		System.out.println("¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª£¨É¾³ýÑ§ÉúÐÅÏ¢£©");

	}

	@Test
	public void getTotalCountTest3() {

		int totalcount = new StudentDaoImpl_3().getTotalCount();
		System.out.println(totalcount);

		System.out.println("¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª£¨Ñ§Éú¸öÊý£©");

	}

}
