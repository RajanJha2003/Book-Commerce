package model;

public class CategoryPojo {
  private int id;
  private String categoryName;
@Override
public String toString() {
	return "CategoryPojo [id=" + id + ", categoryName=" + categoryName + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
}
