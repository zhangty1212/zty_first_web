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
		
		// 获取上传文件的目录
		String uploadFilePath = this.getServletContext().getRealPath("/upload");
		
		// 存储要下载的文件名
		Map<String, String> fileNameMap = new HashMap<String, String>();
		
		// 递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中
		
		listfile(new File(uploadFilePath), fileNameMap);// File既可以代表一个文件也可以代表一个目录
		
		// 将Map集合发送到listfile.jsp页面进行显示
		request.setAttribute("fileNameMap", fileNameMap);
		request.getRequestDispatcher("/listfile.jsp").forward(request, response);

	}
	
	/**
	 * @Method: listfile
	 * @Description: 递归遍历指定目录下的所有文件
	 * @Anthor:孤傲苍狼
	 * @param file 即代表一个文件，也代表一个文件目录
	 * @param map  存储文件名的Map集合
	 */
	/*
	这里简单说一下ListFileServlet中listfile方法，listfile方法是用来列出目录下的所有文件的，
	listfile方法内部用到了递归，在实际开发当中，我们肯定会在数据库创建一张表，里面会存储上传的文件名以及文件的具体存放目录，
	我们通过查询表就可以知道文件的具体存放目录，是不需要用到递归操作的，这个例子是因为没有使用数据库存储上传的文件名和文件的具体存放位置，
	而上传文件的存放位置又使用了散列算法打散存放，所以需要用到递归，在递归时，将获取到的文件名存放到从外面传递到listfile方法里面的Map集合当中，
	这样就可以保证所有的文件都存放在同一个Map集合当中。*/
	
	public void listfile(File file, Map<String, String> map) {
		
		// 如果file代表的不是一个文件，而是一个目录
		if (!file.isFile()) {
			// 列出该目录下的所有文件和目录
			File files[] = file.listFiles();
			// 遍历files[]数组
			for (File f : files) {
				// 递归
				listfile(f, map);
			}
		} else {
			/**
			 * 处理文件名，上传后的文件是以uuid_文件名的形式去重新命名的，去除文件名的uuid_部分
			 * file.getName().indexOf("_")检索字符串中第一次出现"_"字符的位置，如果文件名类似于：9349249849-88343-8344_阿_凡_达.avi
			 * 那么file.getName().substring(file.getName().indexOf("_")+1)处理之后就可以得到阿_凡_达.avi部分
			 */
			String realName = file.getName().substring(file.getName().indexOf("_") + 1);
			
			// file.getName()得到的是文件的原始名称，这个名称是唯一的，因此可以作为key，realName是处理过后的名称，有可能会重复
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
