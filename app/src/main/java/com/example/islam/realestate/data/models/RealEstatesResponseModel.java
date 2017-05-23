package com.example.islam.realestate.data.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RealEstatesResponseModel{

	@SerializedName("items")
	private List<ItemsItem> items;

	public void setItems(List<ItemsItem> items){
		this.items = items;
	}

	public List<ItemsItem> getItems(){
		return items;
	}
}