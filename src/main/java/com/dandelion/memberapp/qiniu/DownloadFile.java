package com.dandelion.memberapp.qiniu;

import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.rs.GetPolicy;
import com.qiniu.api.rs.URLUtils;

public class DownloadFile {

    public static void main(String[] args) throws Exception {
		Config.ACCESS_KEY = "7EAZL7bN77bzyRLd8_4aIBIVKC6J45hMQKulx69c";
        Config.SECRET_KEY = "VRgfzWEf7jIILrnSKc_ewLHdKbGK2A2wwnE7PM2h";
        Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
        // 请确保该bucket已经存在
        String domain = "dandelion.u.qiniudn.com";
        String baseUrl = URLUtils.makeBaseUrl(domain, "android");
        GetPolicy getPolicy = new GetPolicy();
        String downloadUrl = getPolicy.makeRequest(baseUrl, mac);
        System.out.println(downloadUrl);
    }
}