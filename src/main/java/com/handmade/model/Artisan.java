package com.handmade.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Matt on 12/4/18.
 */
@Entity
@Table(name = "tblartisans")
public class Artisan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "artisan_id")
    Integer artisanId;
    @Column(name= "first_name")
    String firstName;
    @Column(name= "last_name")
    String lastName;
    @Column(name= "bio")
    String bio;
    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "artisan_id", referencedColumnName = "artisan_id")
    Collection<ArtisanItem> artisanItems;

    public Integer getArtisanId() {
        return artisanId;
    }

    public void setArtisanId(Integer artisanId) {
        this.artisanId = artisanId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Collection<ArtisanItem> getArtisanItems() {
        return artisanItems;
    }

    public void setArtisanItems(Collection<ArtisanItem> artisanItems) {
        this.artisanItems = artisanItems;
    }
}
