package com.handmade.services;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import com.amazonaws.services.s3.model.ObjectMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
/**
 * Created by Matt on 8/27/18.
 */
@Service
public class S3Service {

//    private Logger logger = LoggerFactory.getLogger(S3Service.class);
//
//    @Autowired
//    private AmazonS3 s3client;
//
//    @Value("${jsa.s3.bucket}")
//    private String bucketName;
//
//    public InputStream downloadFile(String keyName) {
//
//        try {
//
//            System.out.println("Downloading an object");
//            S3Object s3object = s3client.getObject(new GetObjectRequest(bucketName, keyName));
//            System.out.println("Content-Type: "  + s3object.getObjectMetadata().getContentType());
//            logger.info("===================== Import File - Done! =====================");
//            return s3object.getObjectContent();
//
//        } catch (AmazonServiceException ase) {
//            logger.info("Caught an AmazonServiceException from GET requests, rejected reasons:");
//            logger.info("Error Message:    " + ase.getMessage());
//            logger.info("HTTP Status Code: " + ase.getStatusCode());
//            logger.info("AWS Error Code:   " + ase.getErrorCode());
//            logger.info("Error Type:       " + ase.getErrorType());
//            logger.info("Request ID:       " + ase.getRequestId());
//        } catch (AmazonClientException ace) {
//            logger.info("Caught an AmazonClientException: ");
//            logger.info("Error Message: " + ace.getMessage());
//        } catch (Exception ioe) {
//            logger.info("IOE Error Message: " + ioe.getMessage());
//        }
//        return null;
//    }
//
//    public void uploadFile(String keyName, InputStream inputStream) {
//
//        try {
//            ObjectMetadata metadata = new ObjectMetadata();
//            metadata.setContentType("image/png");
//            metadata.setContentLength(inputStream.available());
//            s3client.putObject(new PutObjectRequest(bucketName, keyName, inputStream, metadata));
//            logger.info("===================== Upload File - Done! =====================");
//
//        } catch (AmazonServiceException ase) {
//            logger.info("Caught an AmazonServiceException from PUT requests, rejected reasons:");
//            logger.info("Error Message:    " + ase.getMessage());
//            logger.info("HTTP Status Code: " + ase.getStatusCode());
//            logger.info("AWS Error Code:   " + ase.getErrorCode());
//            logger.info("Error Type:       " + ase.getErrorType());
//            logger.info("Request ID:       " + ase.getRequestId());
//        } catch (AmazonClientException ace) {
//            logger.info("Caught an AmazonClientException: ");
//            logger.info("Error Message: " + ace.getMessage());
//        } catch(IOException ioExceiption) {
//            logger.info("Error Message: ioException");
//        }
//    }
}
