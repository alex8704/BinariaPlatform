package co.com.binariasystems.gestpymesoc.web.servlet;

import org.apache.commons.lang3.StringUtils;

import co.com.binariasystems.fmw.util.messagebundle.MessageBundleManager;
import co.com.binariasystems.fmw.vweb.util.VWebUtils;
import co.com.binariasystems.gestpymesoc.web.resources.resources;
import co.com.binariasystems.gestpymesoc.web.utils.GPSWebConstants;

import com.vaadin.server.CustomizedSystemMessages;
import com.vaadin.server.SystemMessages;
import com.vaadin.server.SystemMessagesInfo;
import com.vaadin.server.SystemMessagesProvider;

public class GestPymeSOCSystemMessagesProvider implements SystemMessagesProvider, GPSWebConstants {
	private MessageBundleManager messages;
	private String contextPath;
	
	
	private GestPymeSOCSystemMessagesProvider(){
		messages = MessageBundleManager.forPath(resources.getMessageFilePath(MAIN_MESSAGES_FILE), false);
	}
	
	public GestPymeSOCSystemMessagesProvider(String contextPath){
		this();
		this.contextPath = contextPath;
	}
	
	@Override
	public SystemMessages getSystemMessages(SystemMessagesInfo systemMessagesInfo) {
		CustomizedSystemMessages customizedMessages = new CustomizedSystemMessages();
		customizedMessages.setSessionExpiredURL(contextPath);
		customizedMessages.setSessionExpiredNotificationEnabled(Boolean.valueOf(StringUtils.defaultIfBlank(messages.getString("GestPymeSOC.sessionExpiredNotificationEnabled", systemMessagesInfo.getLocale()), "true")));
		customizedMessages.setSessionExpiredCaption(messages.getString("GestPymeSOC.sessionExpiredCaption", systemMessagesInfo.getLocale()));
		customizedMessages.setSessionExpiredMessage(messages.getString("GestPymeSOC.sessionExpiredMessage", systemMessagesInfo.getLocale()));
		
		customizedMessages.setCommunicationErrorURL(contextPath);
		customizedMessages.setCommunicationErrorNotificationEnabled(Boolean.valueOf(StringUtils.defaultIfBlank(messages.getString("GestPymeSOC.communicationErrorNotificationEnabled", systemMessagesInfo.getLocale()), "true")));
		customizedMessages.setCommunicationErrorCaption(messages.getString("GestPymeSOC.communicationErrorCaption", systemMessagesInfo.getLocale()));
		customizedMessages.setCommunicationErrorMessage(messages.getString("GestPymeSOC.communicationErrorMessage", systemMessagesInfo.getLocale()));
		
		customizedMessages.setAuthenticationErrorURL(contextPath);
		customizedMessages.setAuthenticationErrorNotificationEnabled(Boolean.valueOf(StringUtils.defaultIfBlank(messages.getString("GestPymeSOC.authenticationErrorNotificationEnabled", systemMessagesInfo.getLocale()), "true")));
		customizedMessages.setAuthenticationErrorCaption(messages.getString("GestPymeSOC.authenticationErrorCaption", systemMessagesInfo.getLocale()));
		customizedMessages.setAuthenticationErrorMessage(messages.getString("GestPymeSOC.authenticationErrorMessage", systemMessagesInfo.getLocale()));
		
		customizedMessages.setInternalErrorURL(contextPath);
		customizedMessages.setInternalErrorNotificationEnabled(Boolean.valueOf(StringUtils.defaultIfBlank(messages.getString("GestPymeSOC.internalErrorNotificationEnabled", systemMessagesInfo.getLocale()), "true")));
		customizedMessages.setInternalErrorCaption(messages.getString("GestPymeSOC.internalErrorCaption", systemMessagesInfo.getLocale()));
		customizedMessages.setInternalErrorMessage(messages.getString("GestPymeSOC.internalErrorMessage", systemMessagesInfo.getLocale()));
		
		customizedMessages.setCookiesDisabledURL(contextPath);
		customizedMessages.setCookiesDisabledNotificationEnabled(Boolean.valueOf(StringUtils.defaultIfBlank(messages.getString("GestPymeSOC.cookiesDisabledNotificationEnabled", systemMessagesInfo.getLocale()), "true")));
		customizedMessages.setCookiesDisabledCaption(messages.getString("GestPymeSOC.cookiesDisabledCaption", systemMessagesInfo.getLocale()));
		customizedMessages.setCookiesDisabledMessage(messages.getString("GestPymeSOC.cookiesDisabledMessage", systemMessagesInfo.getLocale()));
		
		return customizedMessages;
	}
}
