package com.dandelion.memberapp.qiniu;

import java.io.File;

import com.qiniu.api.config.Config;

public class Init {
	public static void main(String[] args) {
//		Config.ACCESS_KEY = "7EAZL7bN77bzyRLd8_4aIBIVKC6J45hMQKulx69c";
//        Config.SECRET_KEY = "VRgfzWEf7jIILrnSKc_ewLHdKbGK2A2wwnE7PM2h";
		 String localFile = "C:\\test.txt";
		 System.out.println(new File(localFile));
	}
}
