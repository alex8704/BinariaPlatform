package co.com.binariasystems.gestpymesoc.web.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationListener;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.binariasystems.fmw.ioc.IOCHelper;
import co.com.binariasystems.fmw.security.FMWSecurityException;
import co.com.binariasystems.gestpymesoc.business.bean.security.RealmBusinessBean;
import co.com.binariasystems.orion.model.dto.AccessTokenDTO;

public class GestPymeSOCAuthenticationListener implements AuthenticationListener{
	private static final Logger LOGGER = LoggerFactory.getLogger(GestPymeSOCAuthenticationListener.class);
	private RealmBusinessBean businessBean;
	
	public GestPymeSOCAuthenticationListener(){
		businessBean = IOCHelper.getBean(RealmBusinessBean.class);
	}
	
	
	@Override
	public void onSuccess(AuthenticationToken token, AuthenticationInfo info) {
	}

	@Override
	public void onFailure(AuthenticationToken token, AuthenticationException ae) {
	}

	@Override
	public void onLogout(PrincipalCollection principals) {
		AccessTokenDTO accessToken= (AccessTokenDTO)getAvailablePrincipal(principals);
		if(accessToken != null){
			try {
				businessBean.invalidateUserSession(accessToken);
			} catch (FMWSecurityException ex) {
				LOGGER.error("Has ocurred an unexpected error while invalidate user session", ex);
			}
		}
		
	}
	
	protected Object getAvailablePrincipal(PrincipalCollection principals) {
        return principals.getPrimaryPrincipal();
    }

}
