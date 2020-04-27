package com.ems.blog.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * @author mani
 * The actual post of the user will be mapped to this pojo class. id and permalink will be unique values per post.
 * Author will be mapped to the use and User first last name combination will be displayed. 
 * category will be constant from category enum. Body of the post will contain actual content of the post.
 *
 */
@Document(collection = "posts")
public class Post implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String permalink;
    private String authorId;
    private String authorName;
    private String authorEmail;
    @NotEmpty
    @Size(min=15,max=200,message="Title should be minmum 15 and maximum 200 character long.")
    private String title;
    private List<String> tags;
    private Category category;
    private Set<Rate> rate = new HashSet<Rate>();
	@NotEmpty
    @Size(min=500,message="Post should be minmum 500 character long")
    private String content;
    private Date lastUpdationDate;
    private Date creationDate;
    private String shortContent;
    private int hitCount;
    private int rating;
    private float averageRating;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the permalink
	 */
	public String getPermalink() {
		return permalink;
	}
	/**
	 * @param permalink the permalink to set
	 */
	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}
	
	/**
	 * @return the authorId
	 */
	public String getAuthorId() {
		return authorId;
	}
	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}
	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	/**
	 * @return the authorEmail
	 */
	public String getAuthorEmail() {
		return authorEmail;
	}
	/**
	 * @param authorEmail the authorEmail to set
	 */
	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the tags
	 */
	public List<String> getTags() {
		return tags;
	}
	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	/**
	 * @return the lastUpdationDate
	 */
	public Date getLastUpdationDate() {
		return lastUpdationDate;
	}
	/**
	 * @param lastUpdationDate the lastUpdationDate to set
	 */
	public void setLastUpdationDate(Date lastUpdationDate) {
		this.lastUpdationDate = lastUpdationDate;
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	/**
	 * @return the rate
	 */
	public Set<Rate> getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(Set<Rate> rate) {
		this.rate = rate;
	}
	public String getShortContent() {
		return shortContent;
	}
	public void setShortContent(String shortContent) {
		this.shortContent = shortContent;
	}
	
	/**
	 * @return the hitCount
	 */
	public int getHitCount() {
		return hitCount;
	}
	/**
	 * @param hitCount the hitCount to set
	 */
	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
	
	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	/**
	 * @return the averageRating
	 */
	public float getAverageRating() {
		return averageRating;
	}
	/**
	 * @param averageRating the averageRating to set
	 */
	public void setAverageRating(float averageRating) {
		this.averageRating = averageRating;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Post [id=" + id + ", permalink=" + permalink + ", authorName="
				+ authorName + ", authorEmail=" + authorEmail + ", title="
				+ title + ", tags=" + tags + ", category=" + category
				+ ", rate=" + rate + ", lastUpdationDate=" + lastUpdationDate
				+ ", creationDate=" + creationDate + ", shortContent="
				+ shortContent + "]";
	}
}
