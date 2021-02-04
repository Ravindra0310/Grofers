package com.example.grofers_app;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class ResponseModel implements Serializable {

	@SerializedName("image")
	private String image;

	@SerializedName("Product MRP")
	private Object productMRP;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String title;

	@SerializedName("Unit")
	private String unit;

	@SerializedName("category")
	private String category;

	@SerializedName("Selling Price")
	private Object sellingPrice;

	public String getImage(){
		return image;
	}

	public String getProductMRP(){
		return (String) productMRP;
	}

	public String getDescription(){
		return description;
	}

	public int getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public String getUnit(){
		return unit;
	}

	public String getCategory(){
		return category;
	}

	public String getSellingPrice(){
		return (String) sellingPrice;
	}
}