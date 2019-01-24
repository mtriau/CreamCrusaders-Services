package com.handmade.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Created by Matt on 5/18/18.
 */
public class UtilityService {

    private static final String configPath = "/Users/Matt/Documents/CreamCrusaders/config";
    private static final String emailTemplatesPath = "/email_templates";

    public static String getConfigPath() {
        return configPath;
    }
    public static String getEmailPath() {
        return configPath + emailTemplatesPath;
    }
    public static String getDonationFilePath(Integer donationId) {
        return configPath + File.separator + "donation_images" + File.separator +  donationId.toString();
    }
    public static String getFileContents(String filePath) {
        File file = new File(filePath);
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()) {
                sb.append(scan.nextLine());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    public static void saveFileContents(String filePath, String contents) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(contents);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
