package co.com.binariasystems.gestpymesoc.web.view.payroll;

import co.com.binariasystems.fmw.vweb.mvp.annotation.Init;
import co.com.binariasystems.fmw.vweb.mvp.annotation.View;
import co.com.binariasystems.fmw.vweb.mvp.annotation.ViewBuild;
import co.com.binariasystems.fmw.vweb.mvp.views.AbstractView;
import co.com.binariasystems.fmw.vweb.uicomponet.Dimension;
import co.com.binariasystems.fmw.vweb.uicomponet.FormPanel;
import co.com.binariasystems.fmw.vweb.uicomponet.SearcherField;
import co.com.binariasystems.fmw.vweb.uicomponet.builders.ComboBoxBuilder;
import co.com.binariasystems.fmw.vweb.uicomponet.builders.DateFieldBuilder;
import co.com.binariasystems.fmw.vweb.uicomponet.builders.TextFieldBuilder;
import co.com.binariasystems.gestpymesoc.business.dto.AppointmentDTO;
import co.com.binariasystems.gestpymesoc.business.dto.EmployeeDTO;
import co.com.binariasystems.gestpymesoc.web.controller.payroll.AdmEmploymentContractViewController;
import co.com.binariasystems.gestpymesoc.web.utils.SN2BooleanConverter;
import co.com.binariasystems.mastercentral.shared.business.dto.CompanyDTO;

import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.AbstractProperty;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

@View(url="/employmentContract", viewStringsByConventions= true,
controller=AdmEmploymentContractViewController.class)
public class AdmEmploymentContractView extends AbstractView {
	private FormPanel form;
	@PropertyId("employee")
	private SearcherField<EmployeeDTO> employeeTxt;
	@PropertyId("appointment")
	private SearcherField<AppointmentDTO> appointmentTxt;
	@PropertyId("termType")
	private ComboBoxBuilder termTypeCmb;
	@PropertyId("startDate")
	private DateFieldBuilder startDateTxt;
	@PropertyId("terminationDate")
	private DateFieldBuilder terminationDateTxt;
	@PropertyId("baseSalaryValue")
	private TextFieldBuilder baseSalaryValueTxt;
	@PropertyId("isFullSalary")
	private CheckBox isFullSalaryChk;
	@PropertyId("haveSurcharge")
	private CheckBox haveSurchargeChk;
	@PropertyId("mustReportWorkTime")
	private CheckBox mustReportWorkTimeChk;
	@PropertyId("company")
	private SearcherField<CompanyDTO> companyTxt;
	private HorizontalLayout checksLyout;
	
	
	@ViewBuild
	public Component build(){
		form = new FormPanel(2);
		employeeTxt = new SearcherField<EmployeeDTO>(EmployeeDTO.class);
		appointmentTxt = new SearcherField<AppointmentDTO>(AppointmentDTO.class);
		termTypeCmb = new ComboBoxBuilder();
		startDateTxt = new DateFieldBuilder();
		terminationDateTxt = new DateFieldBuilder();
		baseSalaryValueTxt = new TextFieldBuilder();
		isFullSalaryChk = new CheckBox();
		haveSurchargeChk = new CheckBox();
		mustReportWorkTimeChk = new CheckBox();
		companyTxt = new SearcherField<CompanyDTO>(CompanyDTO.class);
		checksLyout = new HorizontalLayout();
		
		checksLyout.addComponents(isFullSalaryChk,
				haveSurchargeChk,
				mustReportWorkTimeChk);
		checksLyout.setComponentAlignment(isFullSalaryChk, Alignment.BOTTOM_LEFT);
		checksLyout.setComponentAlignment(haveSurchargeChk, Alignment.BOTTOM_LEFT);
		checksLyout.setComponentAlignment(haveSurchargeChk, Alignment.BOTTOM_LEFT);
		
		form.add(employeeTxt, Dimension.fullPercent())
		.add(appointmentTxt, Dimension.fullPercent())
		.add(termTypeCmb, Dimension.fullPercent())
		.add(startDateTxt, Dimension.fullPercent())
		.add(terminationDateTxt, Dimension.fullPercent())
		.add(baseSalaryValueTxt, Dimension.fullPercent())
		.add(checksLyout, 2, Dimension.fullPercent())
		.add(companyTxt, Dimension.fullPercent());
		
		return form;
	}
	
	@Init
	public void init(){
		checksLyout.setSpacing(true);
		isFullSalaryChk.setConverter(new SN2BooleanConverter());
		haveSurchargeChk.setConverter(new SN2BooleanConverter());
		mustReportWorkTimeChk.setConverter(new SN2BooleanConverter());
	}
}
