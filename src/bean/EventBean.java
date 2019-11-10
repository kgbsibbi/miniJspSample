package bean;

public class EventBean {
	private String name;
	private String description;
	private String imagePath;
	
	public EventBean(String name, String desc, String path) {
		this.name=name;
		this.description = desc;
		this.imagePath=path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imgPath) {
		this.imagePath = imgPath;
	}
	
	
}
