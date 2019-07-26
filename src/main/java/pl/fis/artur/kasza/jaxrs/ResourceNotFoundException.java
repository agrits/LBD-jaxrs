package pl.fis.artur.kasza.jaxrs;

public class ResourceNotFoundException extends Exception {
	private String resourceName;
	public ResourceNotFoundException(String name) {
		super();
		this.resourceName = name;
	}
	public String getResourceName() {
		
		return resourceName;
	}
}
