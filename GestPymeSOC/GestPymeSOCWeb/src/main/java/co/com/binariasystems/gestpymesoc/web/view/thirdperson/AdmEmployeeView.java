package co.com.binariasystems.gestpymesoc.web.view.thirdperson;

import java.util.HashMap;
import java.util.Map;

import co.com.binariasystems.fmw.vweb.mvp.annotation.Init;
import co.com.binariasystems.fmw.vweb.mvp.annotation.NoConventionString;
import co.com.binariasystems.fmw.vweb.mvp.annotation.View;
import co.com.binariasystems.fmw.vweb.mvp.annotation.ViewBuild;
import co.com.binariasystems.fmw.vweb.mvp.annotation.validation.AddressValidator;
import co.com.binariasystems.fmw.vweb.mvp.annotation.validation.NullValidator;
import co.com.binariasystems.fmw.vweb.mvp.annotation.validation.StringLengthValidator;
import co.com.binariasystems.fmw.vweb.mvp.views.AbstractView;
import co.com.binariasystems.fmw.vweb.uicomponet.AddressEditorField;
import co.com.binariasystems.fmw.vweb.uicomponet.Dimension;
import co.com.binariasystems.fmw.vweb.uicomponet.FormPanel;
import co.com.binariasystems.fmw.vweb.uicomponet.MessageDialog;
import co.com.binariasystems.fmw.vweb.uicomponet.MessageDialog.Type;
import co.com.binariasystems.fmw.vweb.uicomponet.Pager;
import co.com.binariasystems.fmw.vweb.uicomponet.SearcherField;
import co.com.binariasystems.fmw.vweb.uicomponet.SortableBeanContainer;
import co.com.binariasystems.fmw.vweb.uicomponet.builders.ButtonBuilder;
import co.com.binariasystems.fmw.vweb.uicomponet.builders.ComboBoxBuilder;
import co.com.binariasystems.fmw.vweb.uicomponet.builders.OptionGroupBuilder;
import co.com.binariasystems.fmw.vweb.uicomponet.builders.TextFieldBuilder;
import co.com.binariasystems.fmw.vweb.util.GridUtils.GenericStringPropertyGenerator;
import co.com.binariasystems.gestpymesoc.business.dto.EmployeeDTO;
import co.com.binariasystems.gestpymesoc.web.controller.thirdperson.AdmEmployeeViewController;
import co.com.binariasystems.gestpymesoc.web.utils.ThirdPersonBusinessNameColumnGenerator;
import co.com.binariasystems.gestpymesoc.web.utils.ThirdPersonIdentificationColumnGenerator;
import co.com.binariasystems.mastercentral.shared.business.dto.AddressDTO;
import co.com.binariasystems.mastercentral.shared.business.dto.CityDTO;
import co.com.binariasystems.mastercentral.shared.business.dto.EconomicActivityDTO;
import co.com.binariasystems.mastercentral.shared.business.dto.HealthAdminCompanyDTO;
import co.com.binariasystems.mastercentral.shared.business.dto.IdentificationTypeDTO;
import co.com.binariasystems.mastercentral.shared.business.dto.MasterDataDTO;
import co.com.binariasystems.mastercentral.shared.business.dto.PensionFundAdminCompanyDTO;
import co.com.binariasystems.mastercentral.shared.business.dto.StateDTO;
import co.com.binariasystems.mastercentral.shared.business.dto.TaxpayerTypeDTO;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.GeneratedPropertyContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.grid.HeightMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;

@View(url="/employee", viewStringsByConventions= true,
controller=AdmEmployeeViewController.class)
public class AdmEmployeeView extends AbstractView {
	private FormPanel form;
	@NullValidator
	@StringLengthValidator(max=10)
	@PropertyId("phoneNumber1")
    private TextFieldBuilder phoneNumber1Txt;
	@StringLengthValidator(max=10)
	@PropertyId("phoneNumber2")
    private TextFieldBuilder phoneNumber2Txt;
	@NullValidator
	@StringLengthValidator(max=10)
	@PropertyId("identificationNumber")
    private TextFieldBuilder identificationNumberTxt;
	@StringLengthValidator(max=64)
	@PropertyId("firstName")
    private TextFieldBuilder firstNameTxt;
	@StringLengthValidator(max=64)
	@PropertyId("middleName")
    private TextFieldBuilder middleNameTxt;
	@StringLengthValidator(max=64)
	@PropertyId("lastName")
    private TextFieldBuilder lastNameTxt;
	@StringLengthValidator(max=64)
	@PropertyId("secondLasName")
    private TextFieldBuilder secondLasNameTxt;
	@StringLengthValidator(max=256)
	@PropertyId("emailAddress")
    private TextFieldBuilder emailAddressTxt;
	@NullValidator
	@PropertyId("identificationType")
    private ComboBoxBuilder identificationTypeCmb;
	@PropertyId("taxpayerType")
    private SearcherField<TaxpayerTypeDTO> taxpayerTypeTxt;
	@AddressValidator
	@PropertyId("address")
    private AddressEditorField<AddressDTO> addressTxt;
	@NullValidator
	@PropertyId("city")
    private SearcherField<CityDTO> cityTxt;
	@PropertyId("economicActivity")
    private SearcherField<EconomicActivityDTO> economicActivityTxt;
	@NullValidator
	@PropertyId("gender")
	private OptionGroupBuilder genderCmb;
	@PropertyId("profession")
	private ComboBoxBuilder professionCmb;
	@NullValidator
	@PropertyId("healthAdminCompany")
	private SearcherField<HealthAdminCompanyDTO> healthAdminCompanyTxt;
	@NullValidator
	@PropertyId("pensionFundAdminCompany")
	private SearcherField<PensionFundAdminCompanyDTO> pensionFundAdminCompanyTxt;
	@NullValidator
	@PropertyId("state")
	private ComboBoxBuilder stateCmb;
    
    @NoConventionString(permitDescription=true)
    private ButtonBuilder saveBtn;
    @NoConventionString(permitDescription=true)
    private ButtonBuilder editBtn;
    @NoConventionString(permitDescription=true)
    private ButtonBuilder deleteBtn;
    @NoConventionString(permitDescription=true)
    private ButtonBuilder searchBtn;
    @NoConventionString(permitDescription=true)
    private ButtonBuilder cleanBtn;
	
    private GeneratedPropertyContainer gridContainer;
    private Grid thirdPersonGrid;
    private Pager<EmployeeDTO, EmployeeDTO> pager;
	
	private BeanFieldGroup<EmployeeDTO> fieldGroup;
    private EmployeeDTO employee = new EmployeeDTO();
    
    private AdmEmployeeViewEventListener eventListener;
	private Map<String, String>	notificationMsgMapping;
	private Map<Button, MessageDialog> confirmMsgDialogMapping;
	
	
	@ViewBuild
	public Component build(){
		form = new FormPanel(2);
		identificationTypeCmb = new ComboBoxBuilder();
		identificationNumberTxt = new TextFieldBuilder();
	    firstNameTxt = new TextFieldBuilder();
	    middleNameTxt = new TextFieldBuilder();
	    lastNameTxt = new TextFieldBuilder();
	    secondLasNameTxt = new TextFieldBuilder();
		phoneNumber1Txt = new TextFieldBuilder();
	    phoneNumber2Txt = new TextFieldBuilder();
	    emailAddressTxt = new TextFieldBuilder();
	    cityTxt = new SearcherField<CityDTO>(CityDTO.class);
	    taxpayerTypeTxt = new SearcherField<TaxpayerTypeDTO>(TaxpayerTypeDTO.class);
	    addressTxt = new AddressEditorField<AddressDTO>(AddressDTO.class);
	    economicActivityTxt = new SearcherField<EconomicActivityDTO>(EconomicActivityDTO.class);
	    genderCmb = new OptionGroupBuilder();
	    professionCmb = new ComboBoxBuilder();
	    healthAdminCompanyTxt = new SearcherField<HealthAdminCompanyDTO>(HealthAdminCompanyDTO.class);
	    pensionFundAdminCompanyTxt = new SearcherField<PensionFundAdminCompanyDTO>(PensionFundAdminCompanyDTO.class);
	    stateCmb = new ComboBoxBuilder();
	    
	    gridContainer = new GeneratedPropertyContainer(new SortableBeanContainer<EmployeeDTO>(EmployeeDTO.class));
		thirdPersonGrid = new Grid();
		pager = new Pager<EmployeeDTO, EmployeeDTO>();
		saveBtn = new ButtonBuilder(FontAwesome.SAVE);
		editBtn = new ButtonBuilder(FontAwesome.EDIT);
		deleteBtn = new ButtonBuilder(FontAwesome.TRASH);
		searchBtn = new ButtonBuilder(FontAwesome.SEARCH);
		cleanBtn = new ButtonBuilder(FontAwesome.ERASER);
		
		form.add(identificationTypeCmb, Dimension.fullPercent())
		.add(identificationNumberTxt, Dimension.fullPercent())
		.add(firstNameTxt, Dimension.fullPercent())
		.add(middleNameTxt, Dimension.fullPercent())
		.add(lastNameTxt, Dimension.fullPercent())
		.add(secondLasNameTxt, Dimension.fullPercent())
		.add(phoneNumber1Txt, Dimension.fullPercent())
		.add(phoneNumber2Txt, Dimension.fullPercent())
		.add(emailAddressTxt, Dimension.fullPercent())
		.add(cityTxt, Dimension.fullPercent())
		.add(taxpayerTypeTxt, Dimension.fullPercent())
		.add(economicActivityTxt, Dimension.fullPercent())
		.add(genderCmb, Dimension.fullPercent())
		.add(professionCmb, Dimension.fullPercent())
		.add(healthAdminCompanyTxt, Dimension.fullPercent())
		.add(pensionFundAdminCompanyTxt, Dimension.fullPercent())
		.add(stateCmb, Dimension.fullPercent())
		.addCenteredOnNewRow(Dimension.fullPercent(), addressTxt)
		.addCenteredOnNewRow(saveBtn, editBtn, deleteBtn, searchBtn, cleanBtn)
		.addCenteredOnNewRow(Dimension.fullPercent(), thirdPersonGrid)
		.addCenteredOnNewRow(Dimension.fullPercent(), pager);
		
		addDataBinding();
		return form;
	}
	
	private void addDataBinding(){
		eventListener = new AdmEmployeeViewEventListener();
		fieldGroup = new BeanFieldGroup<EmployeeDTO>(EmployeeDTO.class);
		notificationMsgMapping = new HashMap<String, String>();
		confirmMsgDialogMapping = new HashMap<Button, MessageDialog>();
		
		fieldGroup.setItemDataSource(employee);
		fieldGroup.setBuffered(false);
		fieldGroup.bindMemberFields(this);
		
		gridContainer.addGeneratedProperty("identificationNumber", new ThirdPersonIdentificationColumnGenerator());
		gridContainer.addGeneratedProperty("city", new GenericStringPropertyGenerator());
		gridContainer.addGeneratedProperty("personType", new GenericStringPropertyGenerator());
		gridContainer.addGeneratedProperty("businessName", new ThirdPersonBusinessNameColumnGenerator());
		gridContainer.addGeneratedProperty("taxpayerType", new GenericStringPropertyGenerator());
		thirdPersonGrid.setContainerDataSource(gridContainer);
		thirdPersonGrid.setColumns("identificationNumber", 
				"businessName", 
				"personType",
				"city", 
				"taxpayerType",
				"emailAddress");
		
		identificationTypeCmb.setContainerDataSource(new BeanItemContainer<IdentificationTypeDTO>(IdentificationTypeDTO.class));
		genderCmb.setContainerDataSource(new BeanItemContainer<MasterDataDTO>(MasterDataDTO.class));
		professionCmb.setContainerDataSource(new BeanItemContainer<MasterDataDTO>(MasterDataDTO.class));
		stateCmb.setContainerDataSource(new BeanItemContainer<StateDTO>(StateDTO.class));
		pager.setPageDataTargetForGrid(thirdPersonGrid);
	}
	
	@Init
	public void init(){
		form.setWidth(Dimension.percent(90.0f));
		saveBtn.withData("create");
		
		editBtn.withData("edit")
		.disable();
		
		deleteBtn.withData("delete")
		.disable();
		
		genderCmb.horizontal();
		
		identificationTypeCmb.setItemCaptionPropertyId("description");
		genderCmb.setItemCaptionPropertyId("description");
		professionCmb.setItemCaptionPropertyId("description");
		stateCmb.setItemCaptionPropertyId("name");
		
		emailAddressTxt.withoutUpperTransform();
		
		thirdPersonGrid.setHeightMode(HeightMode.ROW);
		
		notificationMsgMapping.put((String)saveBtn.getData(), getText("common.message.success_complete_creation.notification"));
		notificationMsgMapping.put((String)editBtn.getData(), getText("common.message.success_complete_edition.notification"));
		notificationMsgMapping.put((String)deleteBtn.getData(), getText("common.message.success_complete_deletion.notification"));
		
		confirmMsgDialogMapping.put(saveBtn, new MessageDialog(getText("common.message.creation_confirmation.title"), 
				getText("common.message.creation_confirmation.question"), Type.QUESTION));
		
		confirmMsgDialogMapping.put(editBtn, new MessageDialog(getText("common.message.edition_confirmation.title"), 
				getText("common.message.edition_confirmation.question"), Type.QUESTION));
		
		confirmMsgDialogMapping.put(deleteBtn, new MessageDialog(getText("common.message.deletion_confirmation.title"), 
				getText("common.message.deletion_confirmation.question"), Type.QUESTION));
		
		for(Button button : confirmMsgDialogMapping.keySet())
			button.addClickListener(eventListener);
	}
	
	
	private class AdmEmployeeViewEventListener implements ClickListener{
		@Override public void buttonClick(ClickEvent event) {
			if(confirmMsgDialogMapping.containsKey(event.getButton()))
				confirmMsgDialogMapping.get(event.getButton()).show();
		}
		
	}
}
