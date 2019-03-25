/**  
*    文件名:  StudentService.java
*    文件描述:  
*  @author zhanggtaoyi 
*  @date 2019年3月20日  
*/
package zty.service.impl;

import java.util.ArrayList;

import zty.dao.IStudentDao;
import zty.dao.impl.StudentDaoImpl_3;
import zty.entity.Student;
import zty.service.IStudentService;
import zty.util.PageBean;

/**
 * 类描述:
 * 
 * @author 张涛一 ,2547260515@qq.com
 * @since 2019年3月20日 上午9:33:31
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

			System.out.println("人员已存在，无法添加");
			return;
		}

		iStudentDao.addStudent(student);
	}

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub

		if (!iStudentDao.existJudgeStudent(student)) {

			System.out.println("人员不存在，无法删除");
			return;
		}

		iStudentDao.deleteStudent(student);
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stubs

		if (!iStudentDao.existJudgeStudent(student)) {

			System.out.println("人员不存在，无法更新");
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
