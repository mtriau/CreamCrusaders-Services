package com.handmade.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;

/**
 * Created by Matt on 5/16/19.
 */
public class ImageUtil {

//    @Value("${img.root_path}")
    private static String imageRootPath = System.getProperty("user.dir") + "\\conf\\images\\";

    public static String getImageStringByImgId(String imageId) {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        return imageToEncodedString(imageRootPath + imageId + ".png");
    }

    public static String imageToEncodedString(String file) {
        String imageStr = "";
        try {
            File f = new File(file);		//change path of image according to you
            FileInputStream fis = new FileInputStream(f);
            byte byteArray[] = new byte[(int)f.length()];
            fis.read(byteArray);
            imageStr = Base64.encodeBase64String(byteArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageStr;
    }
    public static void saveEncodedString(String encodedImage, String imageId) {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        byte[] data = Base64.decodeBase64(encodedImage);
        try (OutputStream stream = new FileOutputStream(imageRootPath + imageId + ".png")) {
            stream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
