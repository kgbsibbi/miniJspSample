package bean;

public class MenuBean {
	private String id;
	private String name;
	private String ingredients;
	private int price;
	
	public MenuBean() {}
	public MenuBean(String id, String name, String ingredients, int price) {
		this.id = id;
		this.name = name;
		this.ingredients = ingredients;
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
