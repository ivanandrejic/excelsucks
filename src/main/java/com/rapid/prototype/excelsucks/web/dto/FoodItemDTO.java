package com.rapid.prototype.excelsucks.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2017-12-26
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodItemDTO {

	private Long id;
	private String title;
	private String description;
	@JsonProperty("photo_uri")
	private String photoURI;
	private BigDecimal price;

	public FoodItemDTO() {
	}

	public FoodItemDTO(Long id, String title, String description, String photoURI, BigDecimal price) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.photoURI = photoURI;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhotoURI() {
		return photoURI;
	}

	public void setPhotoURI(String photoURI) {
		this.photoURI = photoURI;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
