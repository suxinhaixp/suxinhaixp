package com.suxinhaixp.sit.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class SpiderController {

    @GetMapping("spider")
    public JSONObject spider(){
        URL url = null;
        URLConnection urlconn = null;
        BufferedReader br = null;
//        PrintWriter pw = null;
//        String regex = "http://[\\w+\\.?/?]+\\.[A-Za-z]+";
        String regex = "<td( .*?)?>.*?</td>";//url匹配规则
        Pattern p = Pattern.compile(regex);
        JSONObject Price = new JSONObject();
        try {
            url = new URL("http://www.bjtzh.gov.cn/bjtz/home/jrcj/index.shtml");//爬取的网址、这里爬取的是一个生物网站
            urlconn = url.openConnection();
//            pw = new PrintWriter(new FileWriter("D:/SiteURL.txt"), true);//将爬取到的链接放到D盘的SiteURL文件中
            br = new BufferedReader(new InputStreamReader(
                    urlconn.getInputStream()));
            String buf = null;
            Integer flag = -1;
            Integer flag_insert;
            Integer id = 0;
            JSONArray all = new JSONArray();
            JSONObject one = null;
            while ((buf = br.readLine()) != null) {
                Matcher buf_m = p.matcher(buf);
                while (buf_m.find()) {
                    flag++;
                     flag_insert = flag % 4;
                    if(flag_insert  == 0 )
                    { one = new JSONObject();}
                    String filter1[] = buf_m.group().split(">");
                    String filter2[] = filter1[1].split("</");
//                    pw.println(buf_m.group());
                    if(flag_insert == 0) one.put("name",filter2[0]);
                    if(flag_insert == 1) one.put("category",filter2[0]);
                    if(flag_insert == 2) one.put("highprice",filter2[0]);
                    if(flag_insert  == 3 ){
                      one.put("avg",filter2[0]);
                      all.add(id,one); id++;}
                }
            }
            Price.put("Veg_price",all);
            System.out.println("爬取成功^_^");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            pw.close();

        }
        return Price;
    }
}
