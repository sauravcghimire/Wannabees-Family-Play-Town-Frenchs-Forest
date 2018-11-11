package edu.app.wannabeesfamilyplaytown.https;

import edu.app.wannabeesfamilyplaytown.model.PlaceResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WannaBeesApi {

    @GET("place/details/json?")
    Call<PlaceResult> getPlaceDetail(@Query("placeid") String placeId, @Query("key") String apiKey);
}
