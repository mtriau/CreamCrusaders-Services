package com.handmade.services;

import com.handmade.dao.ArtisanRepository;
import com.handmade.model.Artisan;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.List;

/**
 * Created by Matt on 12/4/18.
 */
@Service
@Transactional
public class ArtisanService {

    @Autowired
    ArtisanRepository artisanRepository;
    @Autowired
    S3Service s3Service;

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

    public void imageTest() {
        File file = new File("/Users/Matt/Desktop/test_image.png");
        try {
            ByteArrayInputStream in = new ByteArrayInputStream(FileUtils.readFileToByteArray(file));
            s3Service.uploadFile("test/test_image.png", in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
