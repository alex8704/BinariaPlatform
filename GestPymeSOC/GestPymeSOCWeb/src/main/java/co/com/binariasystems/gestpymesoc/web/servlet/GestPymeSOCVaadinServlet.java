package co.com.binariasystems.gestpymesoc.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import co.com.binariasystems.gestpymesoc.web.GestPymeSOC;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

@WebServlet(
		urlPatterns = {"/main/*","/VAADIN/*"}, 
		name = "GestPymeSOC-VServlet", asyncSupported = true, loadOnStartup = 1,
		initParams={@WebInitParam(
						name="org.atmosphere.cpr.AtmosphereInterceptor", 
						value="co.com.binariasystems.fmw.vweb.util.atmosphere.SpringContextPushInterceptor,org.atmosphere.interceptor.ShiroInterceptor")}
)
@VaadinServletConfiguration(ui = GestPymeSOC.class, productionMode = false)
public class GestPymeSOCVaadinServlet extends VaadinServlet {
	private GestPymeSOCSessionListener sessionListener = new GestPymeSOCSessionListener();
	private GestPymeSOCSystemMessagesProvider systemMessagesProvider;
	@Override
	protected void servletInitialized() throws ServletException {
		super.servletInitialized();
		
		systemMessagesProvider = new GestPymeSOCSystemMessagesProvider(getServletContext().getContextPath());
		getService().addSessionInitListener(sessionListener);
		getService().addSessionDestroyListener(sessionListener);
		getService().setSystemMessagesProvider(systemMessagesProvider);
	}
}
