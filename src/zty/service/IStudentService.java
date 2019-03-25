/**  
*    �ļ���:  IStudentService.java
*    �ļ�����:  
*  @author zhanggtaoyi 
*  @date 2019��3��20��  
*/
package zty.service;

import java.util.ArrayList;

import zty.entity.Student;
import zty.util.PageBean;

/**
 * ������:
 * 
 * @author ����һ ,2547260515@qq.com
 * @since 2019��3��20�� ����9:30:19
 */
public interface IStudentService {

	public ArrayList<Student> queryAllStudent();

//	public boolean existJudgeStudent(Student student);

	public void addStudent(Student student);

	public void deleteStudent(Student student);

	public void updateStudent(Student student);

	/**
	 * ��ҳ��ѯ����
	 */
	public void getAll(PageBean<Student> pb);

	// ͨ��SID ��ѯѧ����Ϣ
	public Student queryStudentByID(String SID);
	
	// ͨ��SID ɾ��ѧ����Ϣ
	public void deleteStudentByID(String SID);

}
