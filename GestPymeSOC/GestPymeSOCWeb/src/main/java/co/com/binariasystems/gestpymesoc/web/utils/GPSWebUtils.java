package co.com.binariasystems.gestpymesoc.web.utils;

import co.com.binariasystems.fmw.constants.FMWConstants;
import co.com.binariasystems.fmw.util.StringUtils;
import co.com.binariasystems.fmw.vweb.mvp.dispatcher.MVPUtils;

import com.vaadin.server.Page;

public final class GPSWebUtils {
	public static void modalPopup(String targetUR){
		StringBuilder invocationBuilder = new StringBuilder();
		invocationBuilder.append("javascript:")
		.append(GPSWebConstants.OPEN_POPUP_VIEW_FUNCTION)
		.append(FMWConstants.LPARENTHESIS)
		.append(StringUtils.singleQuote(MVPUtils.encodeURI(targetUR)))
		.append(FMWConstants.RPARENTHESIS);
		Page.getCurrent().getJavaScript().execute(invocationBuilder.toString());
	}
}
