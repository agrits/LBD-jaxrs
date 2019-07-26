package pl.fis.artur.kasza.jaxrs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

	private static String PATTERN = "yyyy-MM-dd";
	
	@Override
	public String marshal(LocalDate arg0) throws Exception {
		return DateTimeFormatter.ofPattern(PATTERN).format(arg0);
	}

	@Override
	public LocalDate unmarshal(String arg0) throws Exception {
		return LocalDate.parse(arg0, DateTimeFormatter.ofPattern(PATTERN));
	}

		
}
