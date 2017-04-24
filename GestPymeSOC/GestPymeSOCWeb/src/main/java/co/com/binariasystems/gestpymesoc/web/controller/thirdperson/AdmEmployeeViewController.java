package co.com.binariasystems.gestpymesoc.web.controller.thirdperson;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.binariasystems.commonsmodel.enumerated.PersonType;
import co.com.binariasystems.fmw.annotation.Dependency;
import co.com.binariasystems.fmw.security.auditory.AuditoryDataProvider;
import co.com.binariasystems.fmw.util.pagination.ListPage;
import co.com.binariasystems.fmw.vweb.mvp.annotation.Init;
import co.com.binariasystems.fmw.vweb.mvp.annotation.ViewController;
import co.com.binariasystems.fmw.vweb.mvp.annotation.ViewController.OnLoad;
import co.com.binariasystems.fmw.vweb.mvp.annotation.ViewController.OnUnLoad;
import co.com.binariasystems.fmw.vweb.mvp.annotation.ViewField;
import co.com.binariasystems.fmw.vweb.mvp.controller.AbstractViewController;
import co.com.binariasystems.fmw.vweb.uicomponet.FormPanel;
import co.com.binariasystems.fmw.vweb.uicomponet.FormValidationException;
import co.com.binariasystems.fmw.vweb.uicomponet.MessageDialog;
import co.com.binariasystems.fmw.vweb.uicomponet.Pager;
import co.com.binariasystems.fmw.vweb.uicomponet.builders.ButtonBuilder;
import co.com.binariasystems.fmw.vweb.uicomponet.builders.ComboBoxBuilder;
import co.com.binariasystems.fmw.vweb.uicomponet.builders.OptionGroupBuilder;
import co.com.binariasystems.fmw.vweb.uicomponet.builders.TextFieldBuilder;
import co.com.binariasystems.fmw.vweb.uicomponet.pager.PageChangeEvent;
import co.com.binariasystems.fmw.vweb.uicomponet.pager.PageChangeHandler;
import co.com.binariasystems.fmw.vweb.util.VWebUtils;
import co.com.binariasystems.fmw.vweb.util.ValidationUtils;
import co.com.binariasystems.gestpymesoc.business.bean.EmployeeBean;
import co.com.binariasystems.gestpymesoc.business.dto.EmployeeDTO;
import co.com.binariasystems.gestpymesoc.business.utils.GestPymeSOCBusinessConstants;
import co.com.binariasystems.gestpymesoc.business.utils.GestPymeSOCBusinessUtils;
import co.com.binariasystems.mastercentral.shared.business.bean.IdentificationTypeBean;
import co.com.binariasystems.mastercentral.shared.business.bean.MasterDataBean;
import co.com.binariasystems.mastercentral.shared.business.bean.StateBean;
import co.com.binariasystems.orion.model.dto.AccessTokenDTO;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.event.SelectionEvent;
import com.vaadin.event.SelectionEvent.SelectionListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

@ViewController
public class AdmEmployeeViewController extends AbstractViewController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdmEmployeeViewController.class);
	@ViewField private FormPanel form;
	@ViewField private ButtonBuilder saveBtn;
	@ViewField private ButtonBuilder editBtn;
	@ViewField private ButtonBuilder deleteBtn;
	@ViewField private ButtonBuilder searchBtn;
	@ViewField private ButtonBuilder cleanBtn;
	@ViewField private Pager<EmployeeDTO, EmployeeDTO> pager;
	@ViewField private Map<String, String>	notificationMsgMapping;
	@ViewField private Map<Button, MessageDialog> confirmMsgDialogMapping;
	@ViewField private ComboBoxBuilder identificationTypeCmb;
	@ViewField private TextFieldBuilder firstNameTxt;
	@ViewField private TextFieldBuilder lastNameTxt;
	@ViewField private Grid thirdPersonGrid;
	@ViewField private OptionGroupBuilder genderCmb;
	@ViewField private ComboBoxBuilder professionCmb;
	@ViewField private ComboBoxBuilder stateCmb;
    
	@ViewField private BeanFieldGroup<EmployeeDTO> fieldGroup;
	@ViewField private EmployeeDTO employee;
	
	@Dependency
	private EmployeeBean employeeBean;
	@Dependency
	private StateBean stateBean;
	@Dependency
	private MasterDataBean masterDataBean;
	@Dependency
	private IdentificationTypeBean idTypeBean;
	
	@Dependency
	private AuditoryDataProvider<AccessTokenDTO> auditoryDataProvider;
	private AdmEmployeeViewEventListener eventListener;
	
	
	@Init
	public void init(){
		eventListener = new AdmEmployeeViewEventListener();
		searchBtn.addClickListener(eventListener);
		cleanBtn.addClickListener(eventListener);
		pager.setPageChangeHandler(eventListener);
		thirdPersonGrid.addSelectionListener(eventListener);
		for(MessageDialog messageDialog : confirmMsgDialogMapping.values())
			messageDialog.addYesClickListener(eventListener);
	}
	
	@OnLoad
	public void onLoad(){
		identificationTypeCmb.withOptions(idTypeBean.findAll());
		genderCmb.withOptions(masterDataBean.findByMasterCode(GestPymeSOCBusinessConstants.GENDER_MASTER));
		professionCmb.withOptions(masterDataBean.findByMasterCode(GestPymeSOCBusinessConstants.PROFESSION_MASTER));
		stateCmb.withOptions(stateBean.findByGroupingCode(GestPymeSOCBusinessConstants.EMPL_STATE_GROUP));
		findAll();
		form.initFocus();
	}
	
	@OnUnLoad
	public void onUnLoad(){
		cleanForm();
		toggleActionButtonsState();
	}
	
	private void findAll(){
		pager.setFilterDto(new EmployeeDTO());
	}
	
	private void cleanForm(){
		VWebUtils.resetBeanItemDS(fieldGroup.getItemDataSource(), null);
	}
	
	private void saveBtnClick() throws FormValidationException {
		form.validate();
		validateName();
		employee.setThirdPersonId(null);
		employee.setPersonType(PersonType.PERSONA_NATURAL);
		generateCompleteName();
		setAuditoryData(true);
		EmployeeDTO saved = employeeBean.save(employee);
		findAll();
		VWebUtils.resetBeanItemDS(fieldGroup.getItemDataSource(), saved);
		showSuccessOperationNotification((String)saveBtn.getData());
	}
	
	private void editBtnClick() throws FormValidationException {
		form.validate();
		generateCompleteName();
		setAuditoryData(false);
		EmployeeDTO saved = employeeBean.save(employee);
		findAll();
		VWebUtils.resetBeanItemDS(fieldGroup.getItemDataSource(), saved);
		showSuccessOperationNotification((String)editBtn.getData());
	}
	
	private void deleteBtnClick() {
		employeeBean.delete(employee);
		cleanForm();
		findAll();
		showSuccessOperationNotification((String)deleteBtn.getData());
	}
	
	private void searchBtnClick() {
		pager.setFilterDto(employee);
	}

	private void cleanBtnClick() {
		cleanForm();
	}
	
	private void thirdPersonGridSelect(){
		VWebUtils.resetBeanItemDS(fieldGroup.getItemDataSource(), (EmployeeDTO)thirdPersonGrid.getSelectedRow());
		toggleActionButtonsState();
	}
	
	private void setAuditoryData(boolean isNew){
		AccessTokenDTO securityPrincipal = auditoryDataProvider.getCurrenAuditoryUser(VWebUtils.getCurrentHttpRequest());
		if(isNew){
			employee.setCreationUser(securityPrincipal.getUser().getLoginAlias());
			employee.setCreationDate(auditoryDataProvider.getCurrentDate());
		}
		employee.setModificationUser(securityPrincipal.getUser().getLoginAlias());
		employee.setModificationDate(auditoryDataProvider.getCurrentDate());
	}
	
	private void validateName() throws FormValidationException{
		if(StringUtils.isBlank(employee.getFirstName()))
			throw new FormValidationException(ValidationUtils.requiredErrorFor(firstNameTxt.getCaption()));
		if(StringUtils.isBlank(employee.getLastName()))
			throw new FormValidationException(ValidationUtils.requiredErrorFor(lastNameTxt.getCaption()));
	}
	
	private void generateCompleteName(){
		String firstName = StringUtils.defaultString(employee.getFirstName());
		String middleName = StringUtils.defaultString(employee.getMiddleName());
		String lastName = StringUtils.defaultString(employee.getLastName());
		String secondLastName = StringUtils.defaultString(employee.getSecondLasName());
		employee.setBusinessName(new StringBuilder()
		.append(firstName)
		.append(middleName.isEmpty() ? "" : " ").append(middleName)
		.append(lastName.isEmpty() ? "" : " ").append(lastName)
		.append(secondLastName.isEmpty() ? "" : " ").append(secondLastName)
		.toString());
	}
	
	private ListPage<EmployeeDTO> pagerLoadPage(PageChangeEvent<EmployeeDTO> event) {
		return GestPymeSOCBusinessUtils.pageToListPage(employeeBean.findAll(event.getFilterDTO(), event.getPageRequest()));
	}
	
	private void toggleActionButtonsState(){
		editBtn.setEnabled(employee.getThirdPersonId() != null);
		deleteBtn.setEnabled(employee.getThirdPersonId() != null);
	}
	
	private void showSuccessOperationNotification(String action){
		new Notification(FontAwesome.THUMBS_UP.getHtml(), notificationMsgMapping.get(action), Type.TRAY_NOTIFICATION, true).show(Page.getCurrent());
	}
	
	private class AdmEmployeeViewEventListener implements ClickListener, SelectionListener, PageChangeHandler<EmployeeDTO, EmployeeDTO>{
		@Override public ListPage<EmployeeDTO> loadPage(PageChangeEvent<EmployeeDTO> event) {
			return event.getFilterDTO() != null ? pagerLoadPage(event) : new ListPage<EmployeeDTO>();
		}
		@Override public void select(SelectionEvent event) {
			if(thirdPersonGrid.equals(event.getSource()))
				thirdPersonGridSelect();
		}
		@Override public void buttonClick(ClickEvent event) {
			try{
				if(confirmMsgDialogMapping.get(saveBtn).yesButton().equals(event.getButton()))
					saveBtnClick();
				if(confirmMsgDialogMapping.get(editBtn).yesButton().equals(event.getButton()))
					editBtnClick();
				if(confirmMsgDialogMapping.get(deleteBtn).yesButton().equals(event.getButton()))
					deleteBtnClick();
				if(searchBtn.equals(event.getButton()))
					searchBtnClick();
				if(cleanBtn.equals(event.getButton()))
					cleanBtnClick();
			}catch(Exception ex){
				handleError(ex, LOGGER);
			}
			finally{
				toggleActionButtonsState();
			}
		}
		
	}
}
