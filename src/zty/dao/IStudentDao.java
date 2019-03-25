/**  
*    文件名:  IStudentDao.java
*    文件描述:  
*  @author zhanggtaoyi 
*  @date 2019年3月18日  
*/
package zty.dao;

import java.util.ArrayList;

import zty.entity.Student;
import zty.util.PageBean;

/**
 * 类描述:
 * 
 * @author 张涛一 ,2547260515@qq.com
 * @since 2019年3月18日 上午10:52:17
 */
public interface IStudentDao {

	public ArrayList<Student> queryAllStudent();

	public boolean existJudgeStudent(Student student);

	public void addStudent(Student student);

	public void deleteStudent(Student student);

	public void updateStudent(Student student);

	// 通过SID 查询学生信息
	public Student queryStudentByID(String SID);

	// 分页查询数据
	public void getAll(PageBean<Student> pb);

	// 查询总记录数
	public int getTotalCount();

	// 通过SID 删除学生信息
	public void deleteStudentByID(String SID);

}
