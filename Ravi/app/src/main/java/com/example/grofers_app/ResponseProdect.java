package com.example.grofers_app;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseProdect implements Serializable {

	@SerializedName("image")
	private String image;

	@SerializedName("Product MRP")
	private String productMRP;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private int id;

	@SerializedName("Unit")
	private String unit;

	@SerializedName("category")
	private String category;

	@SerializedName("title")
	private String title;

	@SerializedName("Selling Price")
	private String sellingPrice;

	public String getImage(){
		return image;
	}

	public String getProductMRP(){
		return productMRP;
	}

	public String getDescription(){
		return description;
	}

	public int getId(){
		return id;
	}

	public String getUnit(){
		return unit;
	}

	public String getCategory(){
		return category;
	}

	public String getTitle(){
		return title;
	}

	public String getSellingPrice(){
		return sellingPrice;
	}
}