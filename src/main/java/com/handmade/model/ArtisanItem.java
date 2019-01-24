package com.handmade.model;

import javax.persistence.*;

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

}
