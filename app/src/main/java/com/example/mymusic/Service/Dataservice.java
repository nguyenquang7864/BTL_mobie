package com.example.mymusic.Service;

import java.util.List;

import Model.Album;
import Model.Chude;
import Model.Playlist;
import Model.Quangcao;
import Model.Yeuthich;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {

    @GET("songbanner.php")
    Call<List<Quangcao>> GetDataBanner();

    @GET("playlistforcurrent.php")
    Call<List<Playlist>> GetPlaylistCurrentDay() ;

    @GET("album.php")
    Call<List<Album>> GetAlbum();

    @GET("yeuthich.php")
    Call<List<Yeuthich>> GetYeuthich();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Yeuthich>> GetDanhsachbaihattheoquangcao(@Field("idquangcao") String idquangcao);


    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Yeuthich>> GetDanhsachbaihattheoplaylist(@Field("idplaylist") String idplaylist);

    @GET("danhsachplaylist.php")
    Call<List<Playlist>> GetDatacacplaylist();

    @GET("tatcaalbum.php")
    Call<List<Album>> GetAllAlbum();
    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Yeuthich>> GetDanhsachbaihattheoalbum(@Field("idalbum") String idalbum);

    @FormUrlEncoded
    @POST("luotthich.php")
    Call<String> Updateluotthich(@Field("luotthich") String luotthich,@Field("idbaihat") String idbaihat);

    @FormUrlEncoded
    @POST("search.php")
    Call<List<Yeuthich>> GetSearchBaihat(@Field("tukhoa") String tukhoa);
}

