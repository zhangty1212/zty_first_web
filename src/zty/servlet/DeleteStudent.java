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
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteStudent() {
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

		// 根据 SID 删除学生信息

		IStudentService iStudentService = new StudentServiceImpl();

		iStudentService.deleteStudentByID(SID);

		// 重定向到servlet 类： QueryAllStudent

		response.sendRedirect(request.getContextPath() + "/QueryAllStudent");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

}
