package calc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
public class CalcCredBB {
	private Integer amount;
	private Integer years;
	private Double interest;
	private Double result;

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	public Double getInterest() {
		return interest;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}

	public Double getResult() {
		return result;
	}

	@Inject
	FacesContext ctx;

	public boolean doTheMath() {
		Double monthly = (double) (amount / (years * 12));
		Double percent = monthly * (interest / 100);
		result = monthly + percent;

		ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
		return true;
	}

	public String calc() {
		if (doTheMath()) {
			return "showresult";
		}
		return null;
	}

	public String calc_AJAX() {
		if (doTheMath()) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Wynik: " + result, null));
		}
		return null;
	}
}
