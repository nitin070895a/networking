package nitin.thecrazyprogrammer.networkingexample.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiClient {

    private static Retrofit retrofit = null;

    public static Retrofit getRetrofitClient(String Base_url){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
} 