package becker.andy.drivesafe.retrofit;

import becker.andy.drivesafe.models.AdminLogin;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
        @GET("login.php")
        Call<AdminLogin> performLogin(@Query("email") String email, @Query("password") String password);

        @GET ("register.php")
        Call<AdminLogin> performRegister(@Query("shop_name") String Shop_name, @Query("email") String Email,@Query("password") String Password);
}
