/**  
*    �ļ���:  StudentService.java
*    �ļ�����:  
*  @author zhanggtaoyi 
*  @date 2019��3��20��  
*/
package zty.service.impl;

import java.util.ArrayList;

import zty.dao.IStudentDao;
import zty.dao.impl.StudentDaoImpl_3;
import zty.entity.Student;
import zty.service.IStudentService;
import zty.util.PageBean;

/**
 * ������:
 * 
 * @author ����һ ,2547260515@qq.com
 * @since 2019��3��20�� ����9:33:31
 */
public class StudentServiceImpl implements IStudentService {

	IStudentDao iStudentDao = new StudentDaoImpl_3();

	@Override
	public ArrayList<Student> queryAllStudent() {
		// TODO Auto-generated method stub

		ArrayList<Student> arrayList = iStudentDao.queryAllStudent();
		return arrayList;

	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub

		if (iStudentDao.existJudgeStudent(student)) {

			System.out.println("��Ա�Ѵ��ڣ��޷����");
			return;
		}

		iStudentDao.addStudent(student);
	}

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub

		if (!iStudentDao.existJudgeStudent(student)) {

			System.out.println("��Ա�����ڣ��޷�ɾ��");
			return;
		}

		iStudentDao.deleteStudent(student);
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stubs

		if (!iStudentDao.existJudgeStudent(student)) {

			System.out.println("��Ա�����ڣ��޷�����");
			return;
		}

		iStudentDao.updateStudent(student);
	}

	@Override
	public void getAll(PageBean<Student> pb) {
		// TODO Auto-generated method stub

		iStudentDao.getAll(pb);
	}

	
	@Override
	public Student queryStudentByID(String SID) {
		// TODO Auto-generated method stub
		
		return iStudentDao.queryStudentByID(SID);
	}

	
	@Override
	public void deleteStudentByID(String SID) {
		// TODO Auto-generated method stub
		
		iStudentDao.deleteStudentByID(SID);
	}

}
