package com.thecodeschol.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

@RestController
@RequestMapping(path = "/bucket")
public class S3ObjectController {
	
	final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
	
	public String welcome() {
		return "Welcome to AWS S3";
	}
	
	@GetMapping("/list")
	public List<Bucket> listBucket() {
		System.out.println("listBucket...");
		List<Bucket> buckets = s3.listBuckets();
        System.out.println("Your Amazon S3 buckets are:");
        for (Bucket b : buckets) {
            System.out.println("* " + b.toString());
        }
		return buckets;
	}
	
	@DeleteMapping("/delete/{bucketName}")
	public boolean deleteBucket(@PathVariable String bucketName) {
		System.out.println("deleteBucket..."+bucketName);
		
		try {
			s3.deleteBucket(bucketName);
		} catch (AmazonServiceException e) {
		    System.err.println(e.getErrorMessage());
		    return false;
		}
		return true;
	}
	
	@PostMapping("/create")
	public String createBucket(@RequestBody String bucketName) {
		System.out.println("createBucket..."+bucketName);
		try {
			s3.createBucket(bucketName);
		} catch (AmazonServiceException e) {
		    System.err.println(e.getErrorMessage());
		    return e.getErrorMessage();
		}
		return "done";
	}
	
	

}
