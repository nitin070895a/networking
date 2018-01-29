package nitin.thecrazyprogrammer.networkingexample.Retrofit;

import nitin.thecrazyprogrammer.networkingexample.Models.Device;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("devices")
    Call<Device> getDevices(@Query("brand") String brand);
} 