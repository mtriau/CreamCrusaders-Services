package com.handmade.model;

import javax.persistence.*;

/**
 * Created by Matt on 5/29/19.
 */
@Entity
@Table(name = "tblitemcategory")
public class ItemCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "category_id")
    Integer categoryId;
    @Column(name= "description")
    String description;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
