package pl.fis.artur.kasza.jaxrs;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		return Response.status(Response.Status.BAD_REQUEST)
				.entity(prepareMessage(exception))
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

	private String prepareMessage(ConstraintViolationException exception) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"status\":\"BAD_REQUEST\",");
		sb.append("\"field-errors\":[\n");
		String prefix = "";
		for(ConstraintViolation<?> cv : exception.getConstraintViolations()) {
			String fieldName = cv.getPropertyPath().toString();
			String message = cv.getMessage();
			sb.append(prefix);
			sb.append(String.format("{\"%s\" : : \"%s\"}", fieldName, message));
			prefix = ",\n";
		}
		
		sb.append("]}");
		
		return sb.toString();
	}

}
