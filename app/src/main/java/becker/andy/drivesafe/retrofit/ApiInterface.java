package becker.andy.drivesafe.retrofit;

import becker.andy.drivesafe.models.AdminLogin;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
        @GET("login.php")
        Call<AdminLogin> performLogin(@Query("type") String type,@Query("admin_email") String email, @Query("admin_password") String password);

        @GET ("register.php")
        Call<AdminLogin> performRegister (@Query("driver_name") String driver_name,@Query("driver_cell_no") String driver_cell_no,@Query("email") String email,
                                          @Query("owners_cell_no") String owner_cell_no,@Query("password") String password,@Query("licence_no") String licence_no,@Query("driver_pic_address") String driver_pic_address);


}
