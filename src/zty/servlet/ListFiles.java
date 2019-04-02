package zty.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListFiles
 */
@WebServlet("/ListFiles")
public class ListFiles extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListFiles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// ��ȡ�ϴ��ļ���Ŀ¼
		String uploadFilePath = this.getServletContext().getRealPath("/upload");
		
		// �洢Ҫ���ص��ļ���
		Map<String, String> fileNameMap = new HashMap<String, String>();
		
		// �ݹ����filepathĿ¼�µ������ļ���Ŀ¼�����ļ����ļ����洢��map������
		
		listfile(new File(uploadFilePath), fileNameMap);// File�ȿ��Դ���һ���ļ�Ҳ���Դ���һ��Ŀ¼
		
		// ��Map���Ϸ��͵�listfile.jspҳ�������ʾ
		request.setAttribute("fileNameMap", fileNameMap);
		request.getRequestDispatcher("/listfile.jsp").forward(request, response);

	}
	
	/**
	 * @Method: listfile
	 * @Description: �ݹ����ָ��Ŀ¼�µ������ļ�
	 * @Anthor:�°�����
	 * @param file ������һ���ļ���Ҳ����һ���ļ�Ŀ¼
	 * @param map  �洢�ļ�����Map����
	 */
	/*
	�����˵һ��ListFileServlet��listfile������listfile�����������г�Ŀ¼�µ������ļ��ģ�
	listfile�����ڲ��õ��˵ݹ飬��ʵ�ʿ������У����ǿ϶��������ݿⴴ��һ�ű������洢�ϴ����ļ����Լ��ļ��ľ�����Ŀ¼��
	����ͨ����ѯ��Ϳ���֪���ļ��ľ�����Ŀ¼���ǲ���Ҫ�õ��ݹ�����ģ������������Ϊû��ʹ�����ݿ�洢�ϴ����ļ������ļ��ľ�����λ�ã�
	���ϴ��ļ��Ĵ��λ����ʹ����ɢ���㷨��ɢ��ţ�������Ҫ�õ��ݹ飬�ڵݹ�ʱ������ȡ�����ļ�����ŵ������洫�ݵ�listfile���������Map���ϵ��У�
	�����Ϳ��Ա�֤���е��ļ��������ͬһ��Map���ϵ��С�*/
	
	public void listfile(File file, Map<String, String> map) {
		
		// ���file����Ĳ���һ���ļ�������һ��Ŀ¼
		if (!file.isFile()) {
			// �г���Ŀ¼�µ������ļ���Ŀ¼
			File files[] = file.listFiles();
			// ����files[]����
			for (File f : files) {
				// �ݹ�
				listfile(f, map);
			}
		} else {
			/**
			 * �����ļ������ϴ�����ļ�����uuid_�ļ�������ʽȥ���������ģ�ȥ���ļ�����uuid_����
			 * file.getName().indexOf("_")�����ַ����е�һ�γ���"_"�ַ���λ�ã�����ļ��������ڣ�9349249849-88343-8344_��_��_��.avi
			 * ��ôfile.getName().substring(file.getName().indexOf("_")+1)����֮��Ϳ��Եõ���_��_��.avi����
			 */
			String realName = file.getName().substring(file.getName().indexOf("_") + 1);
			
			// file.getName()�õ������ļ���ԭʼ���ƣ����������Ψһ�ģ���˿�����Ϊkey��realName�Ǵ����������ƣ��п��ܻ��ظ�
			map.put(file.getName(), realName);
		}
	}
     
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
