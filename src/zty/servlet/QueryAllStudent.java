package zty.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zty.entity.Student;
import zty.service.IStudentService;
import zty.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class QueryAllStudent
 */
@WebServlet("/QueryAllStudent")
public class QueryAllStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryAllStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 解决中文乱码问题
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		// 调用service 层，获取全部学生的查询信息

		IStudentService iStudentService = new StudentServiceImpl();
		ArrayList<Student> arrayList = iStudentService.queryAllStudent();

		// jsp 与 servlet之间 的数据传输
		// 1. 先 用request 域保存学生查询后台数据；2： 利用转发的方式，把数据传送给 jsp 文件； 3. jsp 给用户展示后台查询数据；

		// 1. 先 用request 域保存学生查询后台数据
		request.setAttribute("studentslist", arrayList);

		// 输出 studentslist 域对象内容，确认 arraylist 是否成功保存到 request 域对象中
		// response.getWriter().println(request.getAttribute("studentslist"));

		// 注意： 当把后台数据保存到request 域对象中时，使用重定向方式时，JSP 是无法获取域对象值的，此时必须用“转发”的方式；
		// response.sendRedirect("/zty_first_web/QueryStudent.jsp");

		// 转发 ，在转发过程中，可以把后台数据保存到request域对象中
		// 2. 利用转发的方式，把数据传送给 jsp 文件；
		this.getServletContext().getRequestDispatcher("/QueryAllStudent.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
