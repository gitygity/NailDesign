package webservice;


import java.util.List;

import model.Pic;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIinterface {

@GET("picnail/fetchpicnail.php")
    Call<List<Pic>> getpic();


}
