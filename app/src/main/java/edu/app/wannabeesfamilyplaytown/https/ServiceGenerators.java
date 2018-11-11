package edu.app.wannabeesfamilyplaytown.https;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import edu.app.wannabeesfamilyplaytown.utils.AppConstants;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerators {


    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static String tokener = "";

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(AppConstants.PLACES_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    public static WannaBeesApi createService() {
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .method(original.method(), original.body());

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });
        OkHttpClient client = httpClient.readTimeout(160, TimeUnit.SECONDS)
                .connectTimeout(160, TimeUnit.SECONDS).build();
        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(WannaBeesApi.class);
    }
}
