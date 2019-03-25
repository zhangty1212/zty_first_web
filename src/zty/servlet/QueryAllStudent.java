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

		// ���������������
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		// ����service �㣬��ȡȫ��ѧ���Ĳ�ѯ��Ϣ

		IStudentService iStudentService = new StudentServiceImpl();
		ArrayList<Student> arrayList = iStudentService.queryAllStudent();

		// jsp �� servlet֮�� �����ݴ���
		// 1. �� ��request �򱣴�ѧ����ѯ��̨���ݣ�2�� ����ת���ķ�ʽ�������ݴ��͸� jsp �ļ��� 3. jsp ���û�չʾ��̨��ѯ���ݣ�

		// 1. �� ��request �򱣴�ѧ����ѯ��̨����
		request.setAttribute("studentslist", arrayList);

		// ��� studentslist ��������ݣ�ȷ�� arraylist �Ƿ�ɹ����浽 request �������
		// response.getWriter().println(request.getAttribute("studentslist"));

		// ע�⣺ ���Ѻ�̨���ݱ��浽request �������ʱ��ʹ���ض���ʽʱ��JSP ���޷���ȡ�����ֵ�ģ���ʱ�����á�ת�����ķ�ʽ��
		// response.sendRedirect("/zty_first_web/QueryStudent.jsp");

		// ת�� ����ת�������У����԰Ѻ�̨���ݱ��浽request�������
		// 2. ����ת���ķ�ʽ�������ݴ��͸� jsp �ļ���
		this.getServletContext().getRequestDispatcher("/QueryAllStudent.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
