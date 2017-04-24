package co.com.binariasystems.gestpymesoc.business.dao;

import static co.com.binariasystems.gestpymesoc.business.resources.resources.getPropertyFilePath;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.com.binariasystems.fmw.dataaccess.db.FMWAbstractDAO;
import co.com.binariasystems.fmw.util.db.DBUtil;
import co.com.binariasystems.fmw.util.messagebundle.PropertiesManager;

@Repository
public class GestPymeSOCSystemDAO extends FMWAbstractDAO{
	private static final Logger LOGGER = LoggerFactory.getLogger(GestPymeSOCSystemDAO.class);
	private PropertiesManager configProperties;
	
	@Qualifier("jdbcTemplate")
	@Autowired
	public void setTemplate(JdbcTemplate jdbcTemplate){
		setJdbcTemplate(jdbcTemplate);
	}
	
	@PostConstruct
	protected void init(){
		DBUtil.init(getDataSource());
		setMessagesFilePath(getPropertyFilePath(new StringBuilder(getClass().getSimpleName()).append("_SQL.xml").toString()));
		ensureMessageBundle();
		configProperties = PropertiesManager.forPath("/configuration.properties", false);
	}
	
	public boolean isSuperAdminConfigured(){
		return true;
	}
}
