package model.bean;

public class Image {
	@Override
	public String toString() {
		return "Image [product_id=" + product_id + ", id=" + id + "]";
	}
	private int product_id;
	private int id;
	

	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}