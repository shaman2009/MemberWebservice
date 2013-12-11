package com.dandelion.memberapp.qiniu;

import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.rs.PutPolicy;

public class Uptoken {
	public static void main(String[] args) throws Exception {
		Config.ACCESS_KEY = "7EAZL7bN77bzyRLd8_4aIBIVKC6J45hMQKulx69c";
        Config.SECRET_KEY = "VRgfzWEf7jIILrnSKc_ewLHdKbGK2A2wwnE7PM2h";
        Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
        // 请确保该bucket已经存在
        String bucketName = "membershipapp";
        PutPolicy putPolicy = new PutPolicy(bucketName);
        String uptoken = putPolicy.token(mac);
        System.out.println(uptoken);
    }
}
