package com.cnc.util;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtilsMethod {

        public static JSON doGet(String httpurl, String token, String serviceValue){
            String result="";
            try {
                String url = "http://localhost:6100/products/settingfilter"+"?token="+token+"&serviceValue="+serviceValue;
                URL httpUrl = new URL(url);
                //http链接
                HttpURLConnection huc = (HttpURLConnection) httpUrl.openConnection();
                huc.setRequestProperty("accept", "*/*");
                huc.setRequestProperty("connection", "Keep_alive");
                huc.setRequestProperty("user-agent",
                        "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        huc.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    result += line;
                }
                System.out.println(result);
                huc.disconnect();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String s ="{" +
                    "  \"code\": 0,\n" +
                    "  \"message\": \"string\",\n" +
                    "  \"subCode\": \"string\",\n" +
                    "  \"data\": true\n" +
                    "}";
         return  JSON.parseObject(s);
        }





}
