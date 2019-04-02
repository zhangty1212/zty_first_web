package zty.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownLoadFile
 */
@WebServlet("/DownLoadFile")
public class DownLoadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownLoadFile() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    
		// �õ�Ҫ���ص��ļ���
		String fileName = request.getParameter("filename"); // 23239283-92489-������.avi
    	//	fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");
		
		System.out.println("����fileName:------" + fileName);
		
		// �ϴ����ļ����Ǳ����� /uploadĿ¼�µ���Ŀ¼����
		String fileSaveRootPath = this.getServletContext().getRealPath("/upload");
		
		// ͨ���ļ����ҳ��ļ�������Ŀ¼
		String path = findFileSavePathByFileName(fileName, fileSaveRootPath);
		
		System.out.println("����path:------" + path);
		System.out.println("Ψһ�ļ�����: --------" + fileName);
		System.out.println("�ļ��洢��Ŀ¼: --------" + fileSaveRootPath);
		System.out.println("-----------------------------------------------");
		
		// �õ�Ҫ���ص��ļ�
		File file = new File(path + "\\" + fileName);
		
		// ����ļ�������
		if (!file.exists()) {
			request.setAttribute("message", "��Ҫ���ص���Դ�ѱ�ɾ������");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		// �����ļ���
		String realname = fileName.substring(fileName.indexOf("_") + 1);
		
		// ������Ӧͷ��������������ظ��ļ�
		
		// URLEncoder.encodeת���, �ļ����ִ����ո� �Ļ��Ӻ� ��+���� ������Ҫ�� URLEncoder.encode �Ľ������ replace ����

		String string = null;
		String string2=null;
		
		string = URLEncoder.encode(realname, "UTF-8");
		string2= string.replace("+", "%20");
		
		System.out.println("---------------------------------------"+string);
		System.out.println("---------------------------------------"+string2);
		

		response.setHeader("content-disposition", "attachment;filename=" + string2);
		
		// ��ȡҪ���ص��ļ������浽�ļ�������
		FileInputStream in = new FileInputStream(path + "\\" + fileName);
		
		// ���������
		OutputStream out = response.getOutputStream();
		
		// ����������
		byte buffer[] = new byte[1024];
		int len = 0;
		
		// ѭ�����������е����ݶ�ȡ������������
		while ((len = in.read(buffer)) > 0) {
			// ��������������ݵ��������ʵ���ļ�����
			out.write(buffer, 0, len);
		}
		
		// �ر��ļ�������
		in.close();
		
		// �ر������
		out.close();

	}
	
	
	/**
	 * @Method: findFileSavePathByFileName
	 * @Description: ͨ���ļ����ʹ洢�ϴ��ļ���Ŀ¼�ҳ�Ҫ���ص��ļ�������·��
	 * @Anthor:�°�����
	 * @param filename     Ҫ���ص��ļ���
	 * @param saveRootPath �ϴ��ļ�����ĸ�Ŀ¼��Ҳ����/uploadĿ¼
	 * @return Ҫ���ص��ļ��Ĵ洢Ŀ¼
	 */
	
	public String findFileSavePathByFileName(String filename, String saveRootPath) {
		int hashcode = filename.hashCode();
		int dir1 = hashcode & 0xf; // 0--15
		int dir2 = (hashcode & 0xf0) >> 4; // 0-15
		String dir = saveRootPath + "\\" + dir1 + "\\" + dir2; // upload\2\3 upload\3\5
		
		File file = new File(dir);
		if (!file.exists()) {
			// ����Ŀ¼
			file.mkdirs();
		}
		return dir;
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
