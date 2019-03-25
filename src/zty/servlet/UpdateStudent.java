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
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// 获取 QueryAllStudent.jsp 页面传递的参数 SID

		String SID = request.getParameter("SID");

		System.out.println(SID + "--------------------------------------------");

		// 根据 SID 查询要更新的学生信息

		IStudentService iStudentService = new StudentServiceImpl();

		Student student = iStudentService.queryStudentByID(SID);

		// System.out.println(student+"--------------------------------------------");

		// 保存学生信息到request 域对象

		request.setAttribute("student", student);

		// 转发

		this.getServletContext().getRequestDispatcher("/UpdateStudent.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
