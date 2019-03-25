/**  
*    �ļ���:  IStudentDao.java
*    �ļ�����:  
*  @author zhanggtaoyi 
*  @date 2019��3��18��  
*/
package zty.dao;

import java.util.ArrayList;

import zty.entity.Student;
import zty.util.PageBean;

/**
 * ������:
 * 
 * @author ����һ ,2547260515@qq.com
 * @since 2019��3��18�� ����10:52:17
 */
public interface IStudentDao {

	public ArrayList<Student> queryAllStudent();

	public boolean existJudgeStudent(Student student);

	public void addStudent(Student student);

	public void deleteStudent(Student student);

	public void updateStudent(Student student);

	// ͨ��SID ��ѯѧ����Ϣ
	public Student queryStudentByID(String SID);

	// ��ҳ��ѯ����
	public void getAll(PageBean<Student> pb);

	// ��ѯ�ܼ�¼��
	public int getTotalCount();

	// ͨ��SID ɾ��ѧ����Ϣ
	public void deleteStudentByID(String SID);

}