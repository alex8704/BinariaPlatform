package co.com.binariasystems.gestpymesoc.business.utils;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import co.com.binariasystems.commonsmodel.constants.SystemConstants;
import co.com.binariasystems.fmw.constants.FMWConstants;
import co.com.binariasystems.fmw.ioc.IOCHelper;
import co.com.binariasystems.fmw.util.ObjectUtils;
import co.com.binariasystems.fmw.util.messagebundle.PropertiesManager;
import co.com.binariasystems.fmw.util.pagination.ListPage;

public class GestPymeSOCBusinessUtils implements GestPymeSOCBusinessConstants, SystemConstants {
	private static PropertiesManager configProperties;
	public static String getApplicationName(){
		return getConfigProperties().getString(APP_NAME_PROP);
	}
	
	public static String getApplicationVersion(){
		return getConfigProperties().getString(APP_VERSION_PROP);
	}
	
	public static String getMainDataSourceName(){
		return getConfigProperties().getString(MAIN_DSOURCE_PROP);
	}
	
	public static PropertiesManager getConfigProperties(){
		if(configProperties == null){
			configProperties = PropertiesManager.forPath("/configuration.properties", false, IOCHelper.getBean(FMWConstants.DEFAULT_LOADER_CLASS, Class.class));
		}
		return configProperties;
	}
	
	public static Sort builSpringSort(co.com.binariasystems.fmw.business.domain.Sort sort){
		return builSpringSort(sort, null);
	}
	
	public static Sort builSpringSort(co.com.binariasystems.fmw.business.domain.Sort sort, co.com.binariasystems.fmw.business.domain.Order defaultOrder){
		if(sort == null || sort.getOrders().isEmpty()){
			return defaultOrder != null ? new Sort(new Sort.Order(Direction.fromStringOrNull(defaultOrder.getDirection().name()), defaultOrder.getProperty())):
				null;
		}
		Sort.Order[] orders = new Sort.Order[sort.getOrders().size()];
		for(int i = 0; i < sort.getOrders().size(); i++){
			orders[i] = new Sort.Order(Direction.fromStringOrNull(sort.getOrders().get(i).getDirection().name()), sort.getOrders().get(i).getProperty());
		}
		return new Sort(orders);
	}
	
	public static PageRequest buildPageRequest(co.com.binariasystems.fmw.business.domain.PageRequest pageRequest){
		return buildPageRequest(pageRequest, null);
	}
	
	public static PageRequest buildPageRequest(co.com.binariasystems.fmw.business.domain.PageRequest pageRequest,  co.com.binariasystems.fmw.business.domain.Order defaultOrder){
		return new PageRequest(pageRequest.getPage() - 1, pageRequest.getSize(), builSpringSort(pageRequest.getSort(), defaultOrder));
	}
	
	public static <F, T> co.com.binariasystems.fmw.business.domain.Page<T> toPage(Page<F> page){
		return toPage(page, null);
	}
	
	public static <F, T> co.com.binariasystems.fmw.business.domain.Page<T> toPage(Page<F> page, Class<T> targetContentClazz){
		if(targetContentClazz != null)
			return new co.com.binariasystems.fmw.business.domain.Page<T>(page.getTotalPages(), page.getTotalElements(), ObjectUtils.transferProperties(page.getContent(), targetContentClazz));
		return new co.com.binariasystems.fmw.business.domain.Page<T>(page.getTotalPages(), page.getTotalElements(), (List<T>) page.getContent());
	}
	
	public static <T> ListPage<T> pageToListPage(co.com.binariasystems.fmw.business.domain.Page<T> page){
		return new ListPage<T>(page.getContent(), page.getTotalElements());
	}
}
