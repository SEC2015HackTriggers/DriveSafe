package becker.andy.drivesafe.models;

import com.google.gson.annotations.SerializedName;

public class AdminLogin {
    @SerializedName("response")
    public String Response;
    @SerializedName("name")
    public String Name;

    public String getResponse() {
        return Response;
    }

    public String getName() {
        return Name;
    }
}
