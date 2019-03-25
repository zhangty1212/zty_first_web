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
import zty.util.PageBean;

/**
 * 4. ���Ʋ㿪��
 * 
 * @author Jie.Yuan
 *
 */
@WebServlet("/PageQuery")

public class PageQuery extends HttpServlet {
	// ����Serviceʵ��
	private IStudentService iStudentService = new StudentServiceImpl();
	// ��ת��Դ
	// private String uri;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// 1. ��ȡ����ǰҳ�������� (��һ�η��ʵ�ǰҳΪnull)
			String currPage = request.getParameter("currentPage");
			// �ж�
			if (currPage == null || "".equals(currPage.trim())) {
				currPage = "1"; // ��һ�η��ʣ����õ�ǰҳΪ1;
			}
			// ת��
			int currentPage = Integer.parseInt(currPage);

			// 2. ����PageBean�������õ�ǰҳ������ ����service��������
			PageBean<Student> pageBean = new PageBean<Student>();
			pageBean.setCurrentPage(currentPage);

			// 3. ����service
			iStudentService.getAll(pageBean); // ��pageBean�Ѿ���dao��������ݡ�

			// 4. ����pageBean���󣬵�request����
			request.setAttribute("pageBean", pageBean);

			// 5. ��ת
			// uri = "/WEB-INF/list.jsp";
		} catch (Exception e) {
			e.printStackTrace(); // ����ʹ��
			// ���ִ�����ת������ҳ�棻���û��Ѻ���ʾ
			// uri = "/error/error.jsp";
		}
		// request.getRequestDispatcher(uri).forward(request, response);

		this.getServletContext().getRequestDispatcher("/PageQuery.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
