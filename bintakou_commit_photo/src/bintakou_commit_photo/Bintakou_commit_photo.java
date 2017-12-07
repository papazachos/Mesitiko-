
package bintakou_commit_photo;

/**
 *
 * @author Bintakou
 */
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;




public class Bintakou_commit_photo {

Button btnIm;

    StorageReference ImStorage;

    int GALLERY_INTENT = 2;
    ProgressDialog mPro;
    
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create2);
        
    ImStorage = FirebaseStorage.getInstance().getReference();

        btnIm = (Button) findViewById(R.id.selectImage);

        btnIm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK);

                intent.setType("image/*");

                startActivityForResult(intent, GALLERY_INTENT);
            }

        });
        
        @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GALLERY_INTENT && resultCode == RESULT_OK) {

            mPro.setMessage("Uploading your photo");
            mPro.show();
            Uri uri = data.getData();

            StorageReference filepath = ImStorage.child("Photos").child(uri.getLastPathSegment());

            filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(Create2.this, "Uploading", Toast.LENGTH_LONG);
                    mPro.show();
                }
            });
        }
    }
}
