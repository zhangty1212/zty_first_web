package zty.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zty.entity.Student;
import zty.service.IStudentService;
import zty.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 解决中文乱码问题
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		// 获取参数，封装成Student对象

		Student student = new Student();
		student.setSID(request.getParameter("number"));
		student.setSname(request.getParameter("name"));
		student.setSage(Integer.parseInt(request.getParameter("age")));
		student.setSex(request.getParameter("sex"));
		student.setSclass(request.getParameter("class"));
		

		// 调用 service 层
		IStudentService iStudentService = new StudentServiceImpl();
		iStudentService.addStudent(student);

		// 重定向到学生信息查看jsp页面
		response.sendRedirect(request.getContextPath() + "/QueryAllStudent");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
