package e.welcome.acmadminapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class Glimpses extends AppCompatActivity {
    private String Gname,Savecurrentdate,Savecurrenttime;
    private android.widget.ImageView inputGlimpsesImage;
    private Button AddNewGlimpsesButton;
    private EditText inputGlimpsesName;
    private static final int GalleryPick=1;
    private Uri ImageUri;
    private String ProductRandomKey,downloadimageurl;
    private StorageReference GlimpsesImagesRef;
    private DatabaseReference GlimpsesRef;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glimpses);
        inputGlimpsesImage=findViewById(R.id.select_glimpses);
        GlimpsesImagesRef= FirebaseStorage.getInstance().getReference().child("Glimpses Images");
        GlimpsesRef= FirebaseDatabase.getInstance().getReference("Glimpses");
        AddNewGlimpsesButton=findViewById(R.id.Glimpses_Add);
        inputGlimpsesName=findViewById(R.id.Glimpses_name);
        loadingBar=new ProgressDialog(this);
        inputGlimpsesImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenGallery();
            }
        });
        AddNewGlimpsesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidateProductData();
            }
        });
    }
    private void OpenGallery() {
        Intent galleryIntent=new Intent();
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, GalleryPick);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode==GalleryPick && resultCode == RESULT_OK && data != null)
        {

            ImageUri= data.getData();
            inputGlimpsesImage.setImageURI(ImageUri);
        }
    }
    private void ValidateProductData()
    {
        Gname=inputGlimpsesName.getText().toString();
        if(ImageUri==null)
        {
            Toast.makeText(this, "Glimpses Image is mandotary........", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(Gname))
        {
            Toast.makeText(this, "Please Write Glimpses name", Toast.LENGTH_SHORT).show();

        }
        else
        {
            StoreProductInfomation();
        }
    }

    private void StoreProductInfomation() {
        loadingBar.setTitle("Adding new Product");
        loadingBar.setMessage("Please Wait  while we are checking the credentials");
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.show();
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat currentDate=new SimpleDateFormat("MMM dd,yyyy");
        Savecurrentdate=currentDate.format(calendar.getTime());
        SimpleDateFormat currentTime=new SimpleDateFormat("HH:mm:ss a");
        Savecurrenttime=currentTime.format(calendar.getTime());
        ProductRandomKey = Savecurrentdate + Savecurrenttime;
        final StorageReference filepath= GlimpsesImagesRef.
                child(ImageUri.getLastPathSegment()+ProductRandomKey+".jpg");

        final UploadTask upload= filepath.putFile(ImageUri);


        upload.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                String message=e.toString();
                Toast.makeText(Glimpses.this, "Error:" +  message, Toast.LENGTH_SHORT).show();
                loadingBar.dismiss();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(Glimpses.this, "Image Uploaded successfully", Toast.LENGTH_SHORT).show();
                Task<Uri> urlTask = upload.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                       if(!task.isSuccessful())
                         {
                            throw task.getException();
                        }
                        downloadimageurl = filepath.getDownloadUrl().toString();
                        return filepath.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if(task.isSuccessful())
                        {    downloadimageurl =task.getResult().toString();
                            Toast.makeText(Glimpses.this, "got the Product image url successfully", Toast.LENGTH_SHORT).show();
                            SaveProductInfotodatabase();
                        }
                    }
                });
            }
        });

    }

    private void SaveProductInfotodatabase() {


        HashMap<String,Object> ProductMap  = new HashMap<>();
        ProductMap.put("pid",ProductRandomKey);
        ProductMap.put("date",Savecurrentdate);
        ProductMap.put("time",Savecurrenttime);
        ProductMap.put("image",downloadimageurl);
        ProductMap.put("name",Gname);
        GlimpsesRef.child(ProductRandomKey).updateChildren(ProductMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if(task.isSuccessful())
                        {   Intent a=new Intent(Glimpses.this,Events.class);
                            startActivity(a);
                            loadingBar.dismiss();
                            Toast.makeText(Glimpses.this, "Product is added successfully", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            loadingBar.dismiss();
                            String message=task.getException().toString();
                            Toast.makeText(Glimpses.this, "Error:"+message, Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }
}
