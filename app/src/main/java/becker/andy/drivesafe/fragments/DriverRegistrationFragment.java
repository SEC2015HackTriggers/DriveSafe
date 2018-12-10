package becker.andy.drivesafe.fragments;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import becker.andy.drivesafe.MainActivity;
import becker.andy.drivesafe.R;
import becker.andy.drivesafe.activities.AdminActivity;
import becker.andy.drivesafe.activities.DriverActivity;
import becker.andy.drivesafe.classes.Mytoast;
import becker.andy.drivesafe.models.AdminLogin;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;
import static android.graphics.Bitmap.CompressFormat.JPEG;

/**
 * A simple {@link Fragment} subclass.
 */
public class DriverRegistrationFragment extends android.support.v4.app.Fragment {

    private static final int IMG_REQUEST = 200;
    EditText dName, dEmail, dpassword, dphone, dOwnerPhone, dLicense;
    Button dRegister;
    ImageView dImage;
    Bitmap bitmap;
    public static interface OnPerformanceListerner{
        public void performWelcomeDriver();
        public void performWelcome();
    }
    OnPerformanceListerner onPerformanceListerner;

    public DriverRegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_driver_registration, container, false);

        dName = view.findViewById(R.id.driver_name);
        dEmail = view.findViewById(R.id.driver_email);
        dpassword = view.findViewById(R.id.driver_pass);
        dphone = view.findViewById(R.id.driver_phone);
        dOwnerPhone = view.findViewById(R.id.driver_owner_phone);
        dLicense = view.findViewById(R.id.driver_license);
        dRegister = view.findViewById(R.id.driver_register);
        dImage = view.findViewById(R.id.driver_image);
        dRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performRegistration();
            }
        });
        dImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosepic();
            }
        });

        return view;
    }

    private void performRegistration() {
        if(bitmap==null){
            Mytoast.showToast(getActivity(),"Select Image");
            return;
        }
        String driver_name=dName.getText().toString().trim();
        String email=dEmail.getText().toString().trim();
        String password=dpassword.getText().toString().trim();
        String driver_cell_no=dphone.getText().toString().trim();
        String owner_cel_no=dOwnerPhone.getText().toString().trim();
        String licence_no=dLicense.getText().toString().trim();
        String image=imageToString();
        if(driver_name.equals("")|| email.equals("")|| password.equals("")|| driver_cell_no.equals("")
                || owner_cel_no.equals("")|| licence_no.equals("")||image.equals("")){
            return;
        }
        Call<AdminLogin> call= DriverActivity.apiInterface.performRegister(driver_name,driver_cell_no,email,owner_cel_no,password,licence_no,image);
        call.enqueue(new Callback<AdminLogin>() {
            @Override
            public void onResponse(Call<AdminLogin> call, Response<AdminLogin> response) {
                Mytoast.showToast(getActivity(),response.body().getResponse().toString());
                if(response.body().getResponse().equals("ok")){
                    Mytoast.showToast(getActivity(),"Registration Successful");
                    onPerformanceListerner.performWelcomeDriver();
                }
            }

            @Override
            public void onFailure(Call<AdminLogin> call, Throwable t) {

            }
        });
    }

    private void choosepic() {
        Intent intent= new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,IMG_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==IMG_REQUEST && resultCode==RESULT_OK && data!=null){
            Uri path=data.getData();

            try{ bitmap= MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),path);
                 dImage.setImageBitmap(bitmap);


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public String imageToString(){
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] imgByte=byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgByte,Base64.DEFAULT);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity= (Activity) context;
        onPerformanceListerner= (OnPerformanceListerner) activity;
    }
}
