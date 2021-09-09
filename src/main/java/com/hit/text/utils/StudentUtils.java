package com.hit.text.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author yang
 * @create 2021-09-08 22:21
 */
public class StudentUtils {
    public static String getJSONString(int code, String msg, Map<String,Object> map){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("msg",msg);
        if(map != null){
            for(String key : map.keySet()){
                jsonObject.put(key,map.get(key));
            }
        }
        return jsonObject.toJSONString();
    }
    public static String getJSONString(int code, String msg){
        return getJSONString(code, msg, null);
    }
}
