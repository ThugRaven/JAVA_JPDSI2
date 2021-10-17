package calc;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class TimeBB {
	private Date date = new Date();

	public Date getDate() {
		return date;
	}

	public String getYear() {
		return new SimpleDateFormat("yyyy").format(date);
	}

}
