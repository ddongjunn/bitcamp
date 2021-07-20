package dto;

import java.io.Serializable;

public class BbsParam implements Serializable{
	private String category; //title? content? id?
	private String keyword; // °Ë»ö¾î
	
	public BbsParam() {
		
	}

	public BbsParam(String category, String keyword) {
		super();
		this.category = category;
		this.keyword = keyword;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
