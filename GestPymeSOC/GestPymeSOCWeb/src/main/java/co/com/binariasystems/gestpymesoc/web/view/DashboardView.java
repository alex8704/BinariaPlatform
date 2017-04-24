package co.com.binariasystems.gestpymesoc.web.view;

import static co.com.binariasystems.fmw.vweb.uicomponet.builders.Builders.button;
import static co.com.binariasystems.fmw.vweb.uicomponet.builders.Builders.comboBox;
import static co.com.binariasystems.fmw.vweb.uicomponet.builders.Builders.label;
import static co.com.binariasystems.fmw.vweb.uicomponet.builders.Builders.treeMenu;
import co.com.binariasystems.fmw.vweb.mvp.annotation.DashBoard;
import co.com.binariasystems.fmw.vweb.mvp.annotation.Init;
import co.com.binariasystems.fmw.vweb.mvp.annotation.NoConventionString;
import co.com.binariasystems.fmw.vweb.mvp.annotation.View;
import co.com.binariasystems.fmw.vweb.mvp.annotation.View.Root;
import co.com.binariasystems.fmw.vweb.mvp.annotation.ViewBuild;
import co.com.binariasystems.fmw.vweb.mvp.views.AbstractView;
import co.com.binariasystems.fmw.vweb.uicomponet.TreeMenu;
import co.com.binariasystems.fmw.vweb.uicomponet.builders.ButtonBuilder;
import co.com.binariasystems.fmw.vweb.uicomponet.builders.ComboBoxBuilder;
import co.com.binariasystems.fmw.vweb.uicomponet.builders.LabelBuilder;
import co.com.binariasystems.fmw.vweb.util.VWebUtils;
import co.com.binariasystems.gestpymesoc.business.utils.GestPymeSOCBusinessUtils;
import co.com.binariasystems.gestpymesoc.web.controller.DashboardViewController;
import co.com.binariasystems.gestpymesoc.web.utils.GPSWebConstants;
import co.com.binariasystems.mastercentral.shared.business.dto.CompanyDTO;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.themes.ValoTheme;

@DashBoard
@Root(contentSetterMethod="setCurrentView")
@View(url="/", controller=DashboardViewController.class, messages=AuthenticationView.MESSAGES_BUNDLE, viewStringsByConventions= true)
public class DashboardView extends AbstractView implements GPSWebConstants {
	public static final String		MESSAGES_BUNDLE = GPSWebConstants.MESSAGES_PACKAGE + "." + MAIN_MESSAGES_FILE;
	private VerticalLayout mainContainer;
	private HorizontalLayout logoAndTrademarkPanel;
	private HorizontalSplitPanel menuDivisorSplitPanel;
	private VerticalSplitPanel centralSplitPanel;
	private HorizontalLayout topPanel;
	private HorizontalLayout accountInfoPanel;
	
	private LabelBuilder welcomeLbl;
	private LabelBuilder currentUserNameLbl;
	private LabelBuilder loginAliasLbl;
	private LabelBuilder netAddressLbl;
	private LabelBuilder authenticationDateLbl;
	private LabelBuilder companyLbl;
	@NoConventionString
	private ComboBoxBuilder companyCmb;
	private TreeMenu treeMenu;
	private ButtonBuilder logoutBtn;
	
	
	@ViewBuild
	public Component build(){
		mainContainer = new VerticalLayout();
		logoAndTrademarkPanel = new HorizontalLayout();
		menuDivisorSplitPanel = new HorizontalSplitPanel();
		centralSplitPanel = new VerticalSplitPanel();
		accountInfoPanel = new HorizontalLayout();
		topPanel = new HorizontalLayout();
		treeMenu = treeMenu();
		welcomeLbl = label();
		currentUserNameLbl = label();
		loginAliasLbl = label();
		netAddressLbl = label();
		authenticationDateLbl = label();
		companyLbl = label();
		companyCmb = comboBox();
		logoutBtn = button(FontAwesome.SIGN_OUT);
		
		mainContainer.addComponent(logoAndTrademarkPanel);
		mainContainer.addComponent(menuDivisorSplitPanel);
		
		menuDivisorSplitPanel.setFirstComponent(treeMenu);
		menuDivisorSplitPanel.setSecondComponent(centralSplitPanel);
		
		centralSplitPanel.setFirstComponent(topPanel);
		
		topPanel.addComponent(accountInfoPanel);
		topPanel.addComponent(logoutBtn);
		
		accountInfoPanel.addComponent(welcomeLbl);
		accountInfoPanel.addComponent(currentUserNameLbl);
		accountInfoPanel.addComponent(loginAliasLbl);
		accountInfoPanel.addComponent(label("|"));
		accountInfoPanel.addComponent(netAddressLbl);
		accountInfoPanel.addComponent(label("|"));
		accountInfoPanel.addComponent(authenticationDateLbl);
		accountInfoPanel.addComponent(label("|"));
		accountInfoPanel.addComponent(companyLbl);
		accountInfoPanel.addComponent(companyCmb);
		
		return mainContainer;
	}
	
	@Init
	public void init(){
		mainContainer.setSizeFull();
		mainContainer.setExpandRatio(menuDivisorSplitPanel, 1.0f);
		
		logoAndTrademarkPanel.setHeight(40, Unit.PIXELS);
		
		menuDivisorSplitPanel.setSplitPosition(250, Unit.PIXELS);
		
		centralSplitPanel.setMaxSplitPosition(25, Unit.PIXELS);
		centralSplitPanel.setLocked(true);
		
		accountInfoPanel.setSpacing(true);
		accountInfoPanel.setMargin(new MarginInfo(false, true, false, true));
		//accountInfoPanel.setWidth(100, Unit.PERCENTAGE);
		
		topPanel.setWidth(100, Unit.PERCENTAGE);
		topPanel.setExpandRatio(accountInfoPanel, 1.0f);
		topPanel.setComponentAlignment(logoutBtn, Alignment.TOP_RIGHT);
		
		currentUserNameLbl.boldStyle();
		loginAliasLbl.boldStyle();
		logoutBtn.withStyleNames(ValoTheme.BUTTON_LINK);
		
		companyCmb.setContainerDataSource(new BeanItemContainer<CompanyDTO>(CompanyDTO.class));
		companyCmb.setItemCaptionPropertyId("businessName");
		companyCmb.setItemCaption(null, VWebUtils.getComboBoxNoSelectionShortDescription());
		companyCmb.addStyleName(ValoTheme.COMBOBOX_SMALL);
		companyCmb.setWidth(200, Unit.PIXELS);
		companyCmb.readOnly();
		
		treeMenu.setTitle(GestPymeSOCBusinessUtils.getApplicationName());
		
		companyCmb.addValueChangeListener(new DashboardViewEventListener());
	}
	
	public void setCurrentView(Component component){
		centralSplitPanel.setSecondComponent(component);
	}
	
	private class DashboardViewEventListener implements ValueChangeListener{
		@Override public void valueChange(ValueChangeEvent event) {
			if(companyCmb.equals(event.getProperty()))
			UI.getCurrent().getSession().setAttribute(CompanyDTO.class, (CompanyDTO)event.getProperty().getValue());
		}
		
	}
}
