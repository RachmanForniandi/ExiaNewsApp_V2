package com.example.exianewsappv2.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseArticles{

	@SerializedName("sortBy")
	private String sortBy;

	@SerializedName("source")
	private String source;

	@SerializedName("articles")
	private List<ArticlesItem> articles;

	@SerializedName("status")
	private String status;

	public void setSortBy(String sortBy){
		this.sortBy = sortBy;
	}

	public String getSortBy(){
		return sortBy;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	public void setArticles(List<ArticlesItem> articles){
		this.articles = articles;
	}

	public List<ArticlesItem> getArticles(){
		return articles;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}