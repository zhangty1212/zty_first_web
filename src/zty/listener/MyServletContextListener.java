package zty.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletContextListener
 *
 */
@WebListener
public class MyServletContextListener implements javax.servlet.ServletContextListener {

	/**
	 * Default constructor.
	 */
	public MyServletContextListener() {
		// TODO Auto-generated constructor stub

	}

	/**
	 * @see MyServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

		System.out.println("MyServletContextListener Ïú»Ù£¡");
	}

	/**
	 * @see MyServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub

		System.out.println("MyServletContextListener ´´½¨£¡");
	}

}
