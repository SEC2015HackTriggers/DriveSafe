package becker.andy.drivesafe.models;

import com.google.gson.annotations.SerializedName;

public class GetPendingDrivers {
    @SerializedName("driver_name")
    public String driver_name;
    @SerializedName("driver_cell_no")
    public String driver_cell_no;
    @SerializedName("email")
    public String email;
    @SerializedName("owners_cell_no")
    public String owners_cell_no;
    @SerializedName("licence_no")
    public String licence_no;
    @SerializedName("driver_pic_address")
    public String driver_pic_address;

    public String getDriver_name() {
        return driver_name;
    }

    public String getDriver_cell_no() {
        return driver_cell_no;
    }

    public String getEmail() {
        return email;
    }

    public String getOwners_cell_no() {
        return owners_cell_no;
    }

    public String getLicence_no() {
        return licence_no;
    }

    public String getDriver_pic_address() {
        return driver_pic_address;
    }
}
