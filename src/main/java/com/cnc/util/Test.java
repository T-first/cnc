package com.cnc.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Test {
    public  void  func(){
        try{
            String url="http://localhost:8080/products/settingfilter";
            URL httpUrl =  new URL(url);
            //http链接
            HttpURLConnection huc = (HttpURLConnection)httpUrl.openConnection();
            huc.setRequestMethod("GET");
            huc.setConnectTimeout(15000);
            huc.setDoOutput(true);
            huc.setDoInput(true);
            huc.setReadTimeout(60000);
            huc.setUseCaches(false);
            huc.setInstanceFollowRedirects(true);
            huc.setRequestProperty("Content-Type", "application/json");
            huc.connect();
            DataOutputStream dataout = new DataOutputStream(huc.getOutputStream());
            String  t_oken = "id=1";
            // String  h_ierarchyCode = "&hierarchyCode="+hierarchyCode;
            String param =t_oken;
            //+h_ierarchyCode;
            dataout.writeBytes(param);
            dataout.flush();
            dataout.close();
            BufferedReader bf =  new BufferedReader(new InputStreamReader(huc.getInputStream(),"UTF-8"));
            StringBuffer sbf = new StringBuffer();
            String temp =null;
            while((temp=bf.readLine())!=null){
                sbf.append(temp);
                sbf.append("\r\n");
            }
            String result =sbf.toString();
            JSONObject jsonObject = JSON.parseObject(result);
            jsonObject.get("data");
            System.out.println(result);
            dataout.close();
            huc.disconnect();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void  test() {

        try {
            String url = "http://localhost:8080/products/settingfilter";
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
            String result="";
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
    }
        public static void main(String[] args) {

          new Test().func();
          new Test().test();
    }
}