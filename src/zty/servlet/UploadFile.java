package zty.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadFile
 */
@WebServlet("/UploadFile")
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// ��Ϣ��ʾ
		String message = "";

		// ʹ��Apache�ļ��ϴ���� FileUpload �����ļ��ϴ����裺

		// 1������һ��DiskFileItemFactory����
		FileItemFactory fileItemFactory = new DiskFileItemFactory();

		// 2������һ���ļ��ϴ�������
		ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

		// ����ϴ��ļ�������������
		servletFileUpload.setHeaderEncoding("UTF-8");

		// 3���ж��ύ�����ı����Ƿ�����Ҫ�ϴ������ı�

		// �����ϴ���������ͨ��
		if (!servletFileUpload.isMultipartContent(request)) {

			message = "������  enctype ����multipart/form-data�������ϴ��������ϴ�ʧ�ܣ��밴�մ�ͳ��ʽ��ȡ�����ݼ��ɣ�";

		}
		// ��Ҫ�ϴ������ı�
		else {

			try {
				// 4��ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List<FileItem>���ϣ�ÿһ��FileItem��Ӧһ��Form����������

				List<FileItem> list = servletFileUpload.parseRequest(request);

				// ������ �õ�ÿһ���ϴ�������

				for (FileItem item : list) {
					// �жϣ���ͨ�ı�����
					if (item.isFormField()) {
						// ��ͨ�ı����ݴ���
						String fieldName = item.getFieldName(); // ��Ԫ������
						String content = item.getString(); // ��Ԫ�����ƣ� ��Ӧ������
						// item.getString("UTF-8"); ָ������
						System.out.println(fieldName + " " + content);
					}

					else {

						// �������ݴ���
						String fieldName = item.getFieldName(); // ��Ԫ������
						String name = item.getName(); // �ļ���
						String content = item.getString(); // ��Ԫ�����ƣ� ��Ӧ������
						String type = item.getContentType(); // �ļ�����
						InputStream in = item.getInputStream(); // �ϴ��ļ���

						// ע�⣺��ͬ��������ύ���ļ����ǲ�һ���ģ���Щ������ύ�������ļ����Ǵ���·���ģ��磺 c:\a\b\1.txt;
						// ����Щֻ�ǵ������ļ������磺1.txt��
						// ���ϣ�����Ҫ��item.getName() �õ����ļ����ֽ��д���ȷ��ȥ��������·�����֣�ֻ�������������Ա�����򱨴�

						String filename = null;
						filename = name.substring(name.lastIndexOf("\\") + 1);

						// �����ϴ��������֣����ɴ洢Ψһ�ļ���
						name = uniquename(filename);
						
						System.out.println("�ϴ�name: --------"+ name);
						
						// ��ȡ�ϴ��� tomact ��·��
						// ע�⣺ ��ȷ���� webӦ��Ŀ¼�£���һ��upload Ŀ¼��
						String path = getServletContext().getRealPath("/upload");

						// ��Ψһ�ļ��� name ��  ��·��/upload��  path, ���� hash �㷨���õ��������˸�������Ŀ¼ savePath
						String savePath = hashSavePath(name, path);
						
						System.out.println("�ϴ�savePath: --------"+ savePath);
						System.out.println("Ψһ�ļ�����: --------"+name);
						System.out.println("�ļ��洢��Ŀ¼: --------"+path);
						System.out.println("-----------------------------------------------");
						
						// ����Ŀ���ļ�
						File file = new File(savePath, name);

						// �����࣬�ļ��ϴ�
						item.write(file);

						// ɾ��ϵͳ��������ʱ�ļ�
						item.delete();
						message = "�ļ��ϴ��ɹ���";
					}

				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				message = "�ļ��ϴ�ʧ�ܣ�";
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				message = "�ļ��ϴ�ʧ�ܣ�";
				e.printStackTrace();
			}
		}

		request.setAttribute("message", message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);

	}
	
	
	
	// Ϊ�����ļ��������������ϴ��������� ,���磺���ڲ�ͬ�û�readme.txt�ļ�����ϣ�����ǣ� ��̨���� ���ļ������һ��Ψһ���!
	// ����Ψһ�ļ��� uniquename
	public static String uniquename(String filename) {

		String uniquename = null;

		// a. �������һ��Ψһ���
		String id = UUID.randomUUID().toString();

		// b. �����idͨ���»��� "_" ���ļ���ƴ��
		uniquename = id + "_" + filename;

		return uniquename;

	}
	
	
	// hash �㷨�洢·��
	// Ŀ¼��ɢ��HASH�㷨�� https://www.cnblogs.com/lihaoyang/p/7344937.html

	public static String hashSavePath(String name, String path) {

		String hashSavePath = null;

		int hashcode = name.hashCode();// �õ�hashCode

		int dir1 = hashcode & 0xf; // �õ���Ϊ1��16���¼��ļ���

		int dir2 = (hashcode & 0xf0) >> 4; // �õ���Ϊ1��16�����¼��ļ���

		hashSavePath = path + "\\" + dir1 + "\\" + dir2; // �õ��ļ�·��

		// File�ȿ��Դ����ļ�Ҳ���Դ���Ŀ¼
		File file = new File(hashSavePath);
		
		// ���Ŀ¼������
		if (!file.exists()) {
			// ����Ŀ¼
			file.mkdirs();
		}

		return hashSavePath;
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
