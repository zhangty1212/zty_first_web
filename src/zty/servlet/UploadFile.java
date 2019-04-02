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

		// 消息提示
		String message = "";

		// 使用Apache文件上传组件 FileUpload 处理文件上传步骤：

		// 1、创建一个DiskFileItemFactory工厂
		FileItemFactory fileItemFactory = new DiskFileItemFactory();

		// 2、创建一个文件上传解析器
		ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

		// 解决上传文件名的中文乱码
		servletFileUpload.setHeaderEncoding("UTF-8");

		// 3、判断提交上来的表单，是否是需要上传附件的表单

		// 无需上传附件的普通表单
		if (!servletFileUpload.isMultipartContent(request)) {

			message = "表单类型  enctype 不是multipart/form-data，无需上传附件，上传失败；请按照传统方式获取表单数据即可！";

		}
		// 需要上传附件的表单
		else {

			try {
				// 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项

				List<FileItem> list = servletFileUpload.parseRequest(request);

				// 遍历： 得到每一个上传的数据

				for (FileItem item : list) {
					// 判断：普通文本数据
					if (item.isFormField()) {
						// 普通文本数据处理
						String fieldName = item.getFieldName(); // 表单元素名称
						String content = item.getString(); // 表单元素名称， 对应的数据
						// item.getString("UTF-8"); 指定编码
						System.out.println(fieldName + " " + content);
					}

					else {

						// 附件数据处理
						String fieldName = item.getFieldName(); // 表单元素名称
						String name = item.getName(); // 文件名
						String content = item.getString(); // 表单元素名称， 对应的数据
						String type = item.getContentType(); // 文件类型
						InputStream in = item.getInputStream(); // 上传文件流

						// 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如： c:\a\b\1.txt;
						// 而有些只是单纯的文件名，如：1.txt；
						// 由上，我们要对item.getName() 得到的文件名字进行处理，确保去除附件的路径部分，只保留附件名，以避免程序报错

						String filename = null;
						filename = name.substring(name.lastIndexOf("\\") + 1);

						// 根据上传附件名字，生成存储唯一文件名
						name = uniquename(filename);
						
						System.out.println("上传name: --------"+ name);
						
						// 获取上传的 tomact 基路径
						// 注意： 请确保在 web应用目录下，有一个upload 目录；
						String path = getServletContext().getRealPath("/upload");

						// 由唯一文件名 name 和  根路径/upload的  path, 根据 hash 算法，得到服务器端附件保存目录 savePath
						String savePath = hashSavePath(name, path);
						
						System.out.println("上传savePath: --------"+ savePath);
						System.out.println("唯一文件名字: --------"+name);
						System.out.println("文件存储根目录: --------"+path);
						System.out.println("-----------------------------------------------");
						
						// 创建目标文件
						File file = new File(savePath, name);

						// 工具类，文件上传
						item.write(file);

						// 删除系统产生的临时文件
						item.delete();
						message = "文件上传成功！";
					}

				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				message = "文件上传失败！";
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				message = "文件上传失败！";
				e.printStackTrace();
			}
		}

		request.setAttribute("message", message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);

	}
	
	
	
	// 为避免文件名重名，导致上传附件覆盖 ,例如：对于不同用户readme.txt文件，不希望覆盖！ 后台处理： 给文件名添加一个唯一标记!
	// 生成唯一文件名 uniquename
	public static String uniquename(String filename) {

		String uniquename = null;

		// a. 随机生成一个唯一标记
		String id = UUID.randomUUID().toString();

		// b. 将随机id通过下划线 "_" 与文件名拼接
		uniquename = id + "_" + filename;

		return uniquename;

	}
	
	
	// hash 算法存储路径
	// 目录打散－HASH算法： https://www.cnblogs.com/lihaoyang/p/7344937.html

	public static String hashSavePath(String name, String path) {

		String hashSavePath = null;

		int hashcode = name.hashCode();// 得到hashCode

		int dir1 = hashcode & 0xf; // 得到名为1到16的下级文件夹

		int dir2 = (hashcode & 0xf0) >> 4; // 得到名为1到16的下下级文件夹

		hashSavePath = path + "\\" + dir1 + "\\" + dir2; // 得到文件路径

		// File既可以代表文件也可以代表目录
		File file = new File(hashSavePath);
		
		// 如果目录不存在
		if (!file.exists()) {
			// 创建目录
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
