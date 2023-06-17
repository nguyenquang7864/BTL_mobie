package com.example.mymusic.Service;

public class APIService {
    private  static String base_url = "https://nxq7864.000webhostapp.com/Sever/";

    public static Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}