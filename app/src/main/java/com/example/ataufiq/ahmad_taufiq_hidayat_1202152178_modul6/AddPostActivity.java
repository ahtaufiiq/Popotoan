package com.example.ataufiq.ahmad_taufiq_hidayat_1202152178_modul6;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ataufiq.ahmad_taufiq_hidayat_1202152178_modul6.model.Post;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.Map;


public class AddPostActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 1;

    EditText ToDo, Description, Priority;
    ImageView imageView;
    //our database reference object
    DatabaseReference databaseFood;
    FirebaseAuth mAuth;

    private Uri imageUri;

    private StorageReference mStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        imageUri = null;

        mStorage = FirebaseStorage.getInstance().getReference().child("images");
        //getting the reference of artists node
        databaseFood = FirebaseDatabase.getInstance().getReference(MainActivity.table1);

        mAuth = FirebaseAuth.getInstance();
        //Find View by ID
        ToDo = (EditText) findViewById(R.id.et_todo);
        Description = (EditText) findViewById(R.id.et_description);
        Priority = (EditText) findViewById(R.id.et_priority);
        imageView=findViewById(R.id.img_post);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);

            }
        });
    }

    public void add(View view) {

        final String name= ToDo.getText().toString().trim();
        final String title= Description.getText().toString();
        final String postMessage= Priority.getText().toString();
        final String id = databaseFood.push().getKey();
        final String userId= mAuth.getUid();

        if(imageUri != null && !TextUtils.isEmpty(name)){



            final StorageReference image = mStorage.child(id + ".jpg");

            image.putFile(imageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> uploadTask) {

                    if(uploadTask.isSuccessful()){

                        String download_url = uploadTask.getResult().getDownloadUrl().toString();
                        Post post = new Post(id,userId ,name, download_url,title, postMessage);
                        databaseFood.child(id).setValue(post);

                    } else {

                        Toast.makeText(AddPostActivity.this, "Error : " + uploadTask.getException().getMessage(), Toast.LENGTH_LONG).show();

                    }

                }
            });


            //displaying a success toast
            Toast.makeText(this, "Post added", Toast.LENGTH_LONG).show();
            Intent i = new Intent(AddPostActivity.this,MainActivity.class);
            startActivity(i);
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }

    } @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE){

            imageUri = data.getData();
            imageView.setImageURI(imageUri);

        }

    }
}
