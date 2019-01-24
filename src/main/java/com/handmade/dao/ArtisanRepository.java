package com.handmade.dao;

import com.handmade.model.Artisan;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by Matt on 12/4/18.
 */

public interface ArtisanRepository extends Repository<Artisan, Integer> {

    void save(Artisan artisan);
    Artisan findByArtisanId(Integer artisanId);
    List<Artisan> findAll();

}
