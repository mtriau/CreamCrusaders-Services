package com.handmade.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Matt on 12/4/18.
 */
@Entity
@Table(name = "tblartisanitem")
public class ArtisanItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "item_id")
    Integer itemId;
    @Column(name= "artisan_id")
    Integer artisanId;
    @Column(name= "item_name")
    String itemName;
    @Column(name= "item_description")
    String itemDescription;
    @Transient
    String encodedImage;
    @Column(name="image_id")
    String imageId;
    @Column(name="price")
    BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    ItemCategory itemCategory;


    public Integer getArtisanId() {
        return artisanId;
    }

    public void setArtisanId(Integer artisanId) {
        this.artisanId = artisanId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getEncodedImage() {
        return encodedImage;
    }

    public void setEncodedImage(String encodedImage) {
        this.encodedImage = encodedImage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }
}
