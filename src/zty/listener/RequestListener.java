package zty.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class FirstListener
 *
 */
@WebListener
public class RequestListener implements ServletRequestListener {

	/**
	 * Default constructor.
	 */
	public RequestListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
	 */
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println(" request ¼àÌýÆ÷Ïú»Ù£¡");
	}

	/**
	 * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
	 */
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println(" request ¼àÌýÆ÷³õÊ¼»¯£¡");
	}

}
