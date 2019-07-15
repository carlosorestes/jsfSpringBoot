package com.easy.demo;

import java.util.List;

import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class DayOfWeekResolverAction {

	private final DayOfWeekResolverForm dayOfWeekResolverForm;
	private final DayOfWeekResolverService dayOfWeekResolverService;

	public DayOfWeekResolverAction(@Autowired DayOfWeekResolverForm dayOfWeekResolverForm,
			@Autowired DayOfWeekResolverService dayOfWeekResolverService) {
		this.dayOfWeekResolverForm = dayOfWeekResolverForm;
		this.dayOfWeekResolverService = dayOfWeekResolverService;
	}

	public void determineDayOfWeek() {
		int year = dayOfWeekResolverForm.getYear();
		int month = dayOfWeekResolverForm.getMonth();
		int dayOfMonth = dayOfWeekResolverForm.getDayOfMonth();
		String teste = dayOfWeekResolverForm.getInput1();
		
		System.out.println("Teste  ...........  "+ teste);

		String dayOfWeekName = dayOfWeekResolverService.determineDayOfWeek(year, month, dayOfMonth);
		dayOfWeekResolverForm.setDayOfWeek(dayOfWeekName);
	}
	
	public void processEvent(ComponentSystemEvent event) throws AbortProcessingException {
		HtmlPanelGrid panel = new HtmlPanelGrid();
		HtmlForm form = (HtmlForm) event.getComponent();

		panel.getChildren().add(this.criaLabel("Usuário:", "lusuario", true, false));
		panel.getChildren().add(this.criaInput("input1"));

		panel.setColumns(2);
		List<UIComponent> children = form.getChildren();
		children.add(panel);
	}
	
	private UIComponent criaLabel(String value, String nome, Boolean negrito, Boolean cor) {
		FacesContext fctx = FacesContext.getCurrentInstance();
		Application app = fctx.getApplication();
		HtmlOutputLabel label = (HtmlOutputLabel) app.createComponent(HtmlOutputLabel.COMPONENT_TYPE);

		// label.setId(nome);
		label.setValue(value);
		if (negrito) {
			label.setStyle("font-weight: bold;");
		}

		if (cor) {
			label.setStyle(label.getStyle() + "color: #B22222");
		}
		return label;
	}
	
	private UIComponent criaInput(String nome) {
		FacesContext fctx = FacesContext.getCurrentInstance();
		Application app = fctx.getApplication();
		HtmlInputText input = (HtmlInputText) app.createComponent(HtmlInputText.COMPONENT_TYPE);

		// label.setId(nome);
		input.setId(nome);
//		input.setValueExpression(nome, createValueExpression("#{dayOfWeekResolverForm.input1}", String.class));
		
		return input;
	}
	
	public static ValueExpression createValueExpression(String valueExpression, Class<?> valueType) {
	    FacesContext context = FacesContext.getCurrentInstance();
	    return context.getApplication().getExpressionFactory()
	        .createValueExpression(context.getELContext(), valueExpression, valueType);
	}

}
