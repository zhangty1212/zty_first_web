/**  
*    文件名:  IStudentService.java
*    文件描述:  
*  @author zhanggtaoyi 
*  @date 2019年3月20日  
*/
package zty.service;

import java.util.ArrayList;

import zty.entity.Student;
import zty.util.PageBean;

/**
 * 类描述:
 * 
 * @author 张涛一 ,2547260515@qq.com
 * @since 2019年3月20日 上午9:30:19
 */
public interface IStudentService {

	public ArrayList<Student> queryAllStudent();

//	public boolean existJudgeStudent(Student student);

	public void addStudent(Student student);

	public void deleteStudent(Student student);

	public void updateStudent(Student student);

	/**
	 * 分页查询数据
	 */
	public void getAll(PageBean<Student> pb);

	// 通过SID 查询学生信息
	public Student queryStudentByID(String SID);
	
	// 通过SID 删除学生信息
	public void deleteStudentByID(String SID);

}
