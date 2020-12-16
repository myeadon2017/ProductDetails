
//This class is used to create my product model
public class Prod {
	
	@Override
	public String toString() {
		return "Prod [id=" + id + ", name=" + name + ", details=" + details
				+ "]";
	}
	private int id;
	private String name,details;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
}
