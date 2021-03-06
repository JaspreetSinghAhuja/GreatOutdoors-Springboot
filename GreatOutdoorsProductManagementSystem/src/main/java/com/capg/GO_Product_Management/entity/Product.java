package com.capg.GO_Product_Management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


	/*
	private long productID;
	private Integer productPrice;
	private String productColour;
	private String productDimension;
	private String productSpecification;
	private String productManufacturer;
	private Integer productQuantity;
	private String productCategory;
	private String productName;
	private String productBrand;
	*/

@Entity
@Table(name = "ProductDTO_GreatOutdoors")
@DynamicUpdate
@JsonIgnoreProperties(value = "productMaster")
public class Product {
  
	@Id
	@Column(name = "Product_Id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	
	@NotNull(message = "Product Price cannot be empty")
	@Column(name="Product_Price",nullable = false)
	@Range(min=1,max=Integer.MAX_VALUE,message="Product Price is InValid")
	private Integer productPrice;
	
	@NotBlank(message = "Product Colour cannot be empty")
	@Column(name="Product_Colour",nullable = false)
	@Pattern(regexp = "^[a-zA-z]+([\\s][a-zA-Z]+)*$",message = "Product Colour pattern invalid")
	private String productColour;
	
	@NotBlank(message = "Product Dimension cannot be empty")
	@Column(name="Product_Dimension",nullable = false)
	@Size(min = 2,max=20,message = "Product Dimension size not valid")
	@Pattern(regexp = "^[a-zA-z]+([\\s][a-zA-Z]+)*$",message = "Product Dimension pattern invalid")
	private String productDimension;
	
	@NotBlank(message = "Product Specification cannot be empty")
	@Column(name="Product_Specification",nullable = false)
	@Pattern(regexp = "^[a-zA-z]+([\\s][a-zA-Z]+)*$",message = "Product Specification pattern invalid")
	private String productSpecification;
	
	@NotBlank(message = "Product Manufacturer cannot be empty")
	@Column(name="Product_Manufacturer",nullable = false)
	@Pattern(regexp = "^[a-zA-z]+([\\s][a-zA-Z]+)*$",message = "Product Manufacturer pattern invalid")
	private String productManufacturer;
    
	
	@Column(name="Product_Quantity",nullable = false)
	@Range(min=1,max=Integer.MAX_VALUE,message="Product Quantity InValid")
	@NotNull(message="Product Quantity cannot be empty")
	private Integer productQuantity;
	
	@Column(name="Product_Category",nullable = false)
	@NotNull(message="Product Category cannot be empty")
	private String productCategory;
	
	@NotBlank(message = "Product Name cannot be empty")
	@Column(name="Product_Name",nullable = false)
	@Pattern(regexp = "^[a-zA-z]+([\\s][a-zA-Z]+)*$",message = "Product Name pattern invalid")
	private String productName;
	
	@NotBlank(message = "Product Brand cannot be empty")
	@Column(name="Product_Brand",nullable = false)
	@Size(min=3,max=25,message="Product Brand Size is not valid")
	@Pattern(regexp = "^[a-zA-z]+([\\s][a-zA-Z]+)*$",message = "Product Brand pattern invalid")
	private String productBrand;
    
	//TODO make @not null
	@ManyToOne(targetEntity = User.class )
	@JoinColumn(name = "ProductMaster_Id",nullable = false)
	private User productMaster;
	
	public User getProductMaster() {
		return productMaster;
	}

	public void setProductMaster(User productMaster) {
		this.productMaster = productMaster;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer price) {
		this.productPrice = price;
	}

	public String getProductColour() {
		return productColour;
	}

	public void setProductColour(String colour) {
		this.productColour = colour;
	}

	public String getProductDimension() {
		return productDimension;
	}

	public void setProductDimension(String dimension) {
		this.productDimension = dimension;
	}

	public String getProductSpecification() {
		return productSpecification;
	}

	public void setProductSpecification(String specification) {
		this.productSpecification = specification;
	}

	public String getProductManufacturer() {
		return productManufacturer;
	}

	public void setProductManufacturer(String manufacturer) {
		this.productManufacturer = manufacturer;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int quantity) {
		this.productQuantity = quantity;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productPrice=" + productPrice + ", productColour="
				+ productColour + ", productDimension=" + productDimension + ", productSpecification="
				+ productSpecification + ", productManufacturer=" + productManufacturer + ", productQuantity="
				+ productQuantity + ", productCategory=" + productCategory + ", productName=" + productName
				+ ", productBrand=" + productBrand + ", productMaster=" + productMaster + "]";
	}
	
}
