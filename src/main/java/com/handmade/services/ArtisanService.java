package com.handmade.services;

import com.handmade.dao.ArtisanRepository;
import com.handmade.model.Artisan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Matt on 12/4/18.
 */
@Service
@Transactional
public class ArtisanService {

    @Autowired
    ArtisanRepository artisanRepository;

    public Artisan saveArtisan(Artisan artisan) {
        artisanRepository.save(artisan);
        return artisan;
    }

    public Artisan getArtisanById(Integer artisanId) {
        return artisanRepository.findByArtisanId(artisanId);
    }

    public List<Artisan> getAllArtisans() {
        return artisanRepository.findAll();
    }

}
