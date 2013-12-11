package com.dandelion.memberapp.qiniu;

import java.io.File;

import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.PutPolicy;

public class UploadFile {
	public static void main(String[] args) throws Exception {
		Config.ACCESS_KEY = "7EAZL7bN77bzyRLd8_4aIBIVKC6J45hMQKulx69c";
        Config.SECRET_KEY = "VRgfzWEf7jIILrnSKc_ewLHdKbGK2A2wwnE7PM2h";
        Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
        // 请确保该bucket已经存在
        String bucketName = "dandelion";
        PutPolicy putPolicy = new PutPolicy(bucketName);
        String uptoken = putPolicy.token(mac);
        PutExtra extra = new PutExtra();
        String key = "tu";
        String localFile = "C:\\2013-08-11 21.26.22.png";
        PutRet ret = IoApi.putFile(uptoken, key, new File(localFile), extra);
    }
}
