package com.dandelion.memberapp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.baidu.inf.iis.bcs.BaiduBCS;
import com.baidu.inf.iis.bcs.auth.BCSCredentials;
import com.baidu.inf.iis.bcs.model.ObjectMetadata;
import com.baidu.inf.iis.bcs.request.PutObjectRequest;
import com.baidu.inf.iis.bcs.response.BaiduBCSResponse;


/**
 * BCS(Baidu Cloud Storage)
 * @author Fengxiang
 *
 */
public class BCSController {
	public static final String ACCESSKEY = "Zz8A04mhbHpDWdavM8W5Gl3l";
	public static final String SECRETKEY = "t8xuVeTlQsTridUf8orTwOXsOj4x2YCD";
	public static final String HOST = "bs.baidu.com";
	public static final String BUCKET = "hkmemberapp";
	
	 
	public static final String OBJECT = "/Dandelion";
	
	
	public static void main(String[] args) {
		BCSCredentials credentials = new BCSCredentials(ACCESSKEY, SECRETKEY);
		BaiduBCS baiduBCS = new BaiduBCS(credentials, HOST);
		baiduBCS.setDefaultEncoding("UTF-8"); // Default UTF-8
		
		putObjectByFile(baiduBCS);	
	}

	public static void putObjectByFile(BaiduBCS baiduBCS) {
		PutObjectRequest request = new PutObjectRequest(BUCKET, OBJECT, createSampleFile());
		ObjectMetadata metadata = new ObjectMetadata();
		// metadata.setContentType("text/html");
		request.setMetadata(metadata);        
		BaiduBCSResponse<ObjectMetadata> response = baiduBCS.putObject(request);
		ObjectMetadata objectMetadata = response.getResult();
	}

	private static File createSampleFile() {
		try {
			File file = File.createTempFile("java-sdk-", ".txt");
			file.deleteOnExit();

			Writer writer = new OutputStreamWriter(new FileOutputStream(file));
			writer.write("01234567890123456789\n");
			writer.write("01234567890123456789\n");
			writer.write("01234567890123456789\n");
			writer.write("01234567890123456789\n");
			writer.write("01234567890123456789\n");
			writer.close();

			return file;
		} catch (IOException e) {
			return null;
		}
	}
}
