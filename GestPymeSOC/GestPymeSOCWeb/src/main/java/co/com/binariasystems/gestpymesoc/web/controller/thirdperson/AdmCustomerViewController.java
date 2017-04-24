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
import co.com.binariasystems.fmw.vweb.uicomponet.builders.TextFieldBuilder;
import co.com.binariasystems.fmw.vweb.uicomponet.pager.PageChangeEvent;
import co.com.binariasystems.fmw.vweb.uicomponet.pager.PageChangeHandler;
import co.com.binariasystems.fmw.vweb.util.VWebUtils;
import co.com.binariasystems.fmw.vweb.util.ValidationUtils;
import co.com.binariasystems.gestpymesoc.business.bean.CustomerBean;
import co.com.binariasystems.gestpymesoc.business.dto.CustomerDTO;
import co.com.binariasystems.gestpymesoc.business.utils.GestPymeSOCBusinessUtils;
import co.com.binariasystems.mastercentral.shared.business.bean.IdentificationTypeBean;
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
public class AdmCustomerViewController extends AbstractViewController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdmCustomerViewController.class);
	@ViewField private FormPanel form;
	@ViewField private ButtonBuilder saveBtn;
	@ViewField private ButtonBuilder editBtn;
	@ViewField private ButtonBuilder deleteBtn;
	@ViewField private ButtonBuilder searchBtn;
	@ViewField private ButtonBuilder cleanBtn;
	@ViewField private Pager<CustomerDTO, CustomerDTO> pager;
	@ViewField private Map<String, String>	notificationMsgMapping;
	@ViewField private Map<Button, MessageDialog> confirmMsgDialogMapping;
	@ViewField private ComboBoxBuilder personTypeCmb;
	@ViewField private ComboBoxBuilder identificationTypeCmb;
	@ViewField private TextFieldBuilder firstNameTxt;
	@ViewField private TextFieldBuilder lastNameTxt;
	@ViewField private TextFieldBuilder businessNameTxt;
	@ViewField private Grid thirdPersonGrid;
    
	@ViewField private BeanFieldGroup<CustomerDTO> fieldGroup;
	@ViewField private CustomerDTO customer;
	
	@Dependency
	private CustomerBean customerBean;
	@Dependency
	private IdentificationTypeBean idTypeBean;
	
	@Dependency
	private AuditoryDataProvider<AccessTokenDTO> auditoryDataProvider;
	private AdmCustomerViewEventListener eventListener;
	
	
	@Init
	public void init(){
		eventListener = new AdmCustomerViewEventListener();
		searchBtn.addClickListener(eventListener);
		cleanBtn.addClickListener(eventListener);
		pager.setPageChangeHandler(eventListener);
		thirdPersonGrid.addSelectionListener(eventListener);
		for(MessageDialog messageDialog : confirmMsgDialogMapping.values())
			messageDialog.addYesClickListener(eventListener);
	}
	
	@OnLoad
	public void onLoad(){
		personTypeCmb.addItems(PersonType.values());
		identificationTypeCmb.withOptions(idTypeBean.findAll());
		findAll();
		form.initFocus();
	}
	
	@OnUnLoad
	public void onUnLoad(){
		cleanForm();
		personTypeCmb.removeAllItems();
		identificationTypeCmb.removeAllItems();
		toggleActionButtonsState();
	}
	
	private void findAll(){
		pager.setFilterDto(new CustomerDTO());
	}
	
	private void cleanForm(){
		VWebUtils.resetBeanItemDS(fieldGroup.getItemDataSource(), null);
	}
	
	private void saveBtnClick() throws FormValidationException {
		form.validate();
		validateName();
		customer.setThirdPersonId(null);
		generateCompleteName();
		setAuditoryData(true);
		CustomerDTO saved = customerBean.save(customer);
		findAll();
		VWebUtils.resetBeanItemDS(fieldGroup.getItemDataSource(), saved);
		showSuccessOperationNotification((String)saveBtn.getData());
	}
	
	private void editBtnClick() throws FormValidationException {
		form.validate();
		generateCompleteName();
		setAuditoryData(false);
		CustomerDTO saved = customerBean.save(customer);
		findAll();
		VWebUtils.resetBeanItemDS(fieldGroup.getItemDataSource(), saved);
		showSuccessOperationNotification((String)editBtn.getData());
	}
	
	private void deleteBtnClick() {
		customerBean.delete(customer);
		cleanForm();
		findAll();
		showSuccessOperationNotification((String)deleteBtn.getData());
	}
	
	private void searchBtnClick() {
		pager.setFilterDto(customer);
	}

	private void cleanBtnClick() {
		cleanForm();
	}
	
	private void thirdPersonGridSelect(){
		VWebUtils.resetBeanItemDS(fieldGroup.getItemDataSource(), (CustomerDTO)thirdPersonGrid.getSelectedRow());
		toggleActionButtonsState();
	}
	
	private void setAuditoryData(boolean isNew){
		AccessTokenDTO securityPrincipal = auditoryDataProvider.getCurrenAuditoryUser(VWebUtils.getCurrentHttpRequest());
		if(isNew){
			customer.setCreationUser(securityPrincipal.getUser().getLoginAlias());
			customer.setCreationDate(auditoryDataProvider.getCurrentDate());
		}
		customer.setModificationUser(securityPrincipal.getUser().getLoginAlias());
		customer.setModificationDate(auditoryDataProvider.getCurrentDate());
	}
	
	private void validateName() throws FormValidationException{
		if(PersonType.PERSONA_JURIDICA.equals(customer.getPersonType()) && StringUtils.isBlank(customer.getBusinessName()))
			throw new FormValidationException(ValidationUtils.requiredErrorFor(businessNameTxt.getCaption()));
		if(PersonType.PERSONA_NATURAL.equals(customer.getPersonType()) && StringUtils.isBlank(customer.getFirstName()))
			throw new FormValidationException(ValidationUtils.requiredErrorFor(firstNameTxt.getCaption()));
		if(PersonType.PERSONA_NATURAL.equals(customer.getPersonType()) && StringUtils.isBlank(customer.getLastName()))
			throw new FormValidationException(ValidationUtils.requiredErrorFor(lastNameTxt.getCaption()));
	}
	
	private void generateCompleteName(){
		if(PersonType.PERSONA_JURIDICA.equals(customer.getPersonType())) return;
		
		String firstName = StringUtils.defaultString(customer.getFirstName());
		String middleName = StringUtils.defaultString(customer.getMiddleName());
		String lastName = StringUtils.defaultString(customer.getLastName());
		String secondLastName = StringUtils.defaultString(customer.getSecondLasName());
		customer.setBusinessName(new StringBuilder()
		.append(firstName)
		.append(middleName.isEmpty() ? "" : " ").append(middleName)
		.append(lastName.isEmpty() ? "" : " ").append(lastName)
		.append(secondLastName.isEmpty() ? "" : " ").append(secondLastName)
		.toString());
	}
	
	private ListPage<CustomerDTO> pagerLoadPage(PageChangeEvent<CustomerDTO> event) {
		return GestPymeSOCBusinessUtils.pageToListPage(customerBean.findAll(event.getFilterDTO(), event.getPageRequest()));
	}
	
	private void toggleActionButtonsState(){
		editBtn.setEnabled(customer.getThirdPersonId() != null);
		deleteBtn.setEnabled(customer.getThirdPersonId() != null);
	}
	
	private void showSuccessOperationNotification(String action){
		new Notification(FontAwesome.THUMBS_UP.getHtml(), notificationMsgMapping.get(action), Type.TRAY_NOTIFICATION, true).show(Page.getCurrent());
	}
	
	private class AdmCustomerViewEventListener implements ClickListener, SelectionListener, PageChangeHandler<CustomerDTO, CustomerDTO>{

		@Override public ListPage<CustomerDTO> loadPage(PageChangeEvent<CustomerDTO> event) {
			return event.getFilterDTO() != null ? pagerLoadPage(event) : new ListPage<CustomerDTO>();
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
