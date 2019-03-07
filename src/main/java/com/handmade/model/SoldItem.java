package com.handmade.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Matt on 3/5/19.
 */
@Entity
@Table(name = "tblsolditem")
public class SoldItem {
    private Integer soldItemId;
    private Timestamp dateSold;
    private Integer ArtisanId;
    private Integer itemId;
    private BigDecimal price;
    private String itemDescription;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "sold_product_id")
    public Integer getSoldItemId() {
        return soldItemId;
    }

    public void setSoldItemId(Integer soldItemId) {
        this.soldItemId = soldItemId;
    }

    @Column(name= "date_sold")
    public Timestamp getDateSold() {
        return dateSold;
    }

    public void setDateSold(Timestamp dateSold) {
        this.dateSold = dateSold;
    }

    @Column(name= "artisan_id")
    public Integer getArtisanId() {
        return ArtisanId;
    }

    public void setArtisanId(Integer artisanId) {
        ArtisanId = artisanId;
    }

    @Column(name= "item_id")
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Column(name= "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name= "item_description")
    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
}
