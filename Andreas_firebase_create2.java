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
package andreas_firebase_create2;

/**
 *
 * @author Andreas
 */
public class Andreas_firebase_create2 {

   FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbRef;

    Button btnIm;

    StorageReference ImStorage;
Button submit;
    EditText editlastname, editfirstname, editemail, edittel, editaddress, editcountry, edittk, editcomments;
    Spinner editrent, edithouse;
    
     public void addVasi() {
        String id = dbRef.push().getKey();
        String editLastname = editlastname.getText().toString().trim();
        String editFirstname = editfirstname.getText().toString().trim();
        String editEmail = editemail.getText().toString().trim();
        String editTel = edittel.getText().toString().trim();
        String editAddress = editaddress.getText().toString().trim();
        String editCountry = editcountry.getText().toString().trim();
        String editTk = edittk.getText().toString().trim();
        String editComments = editcomments.getText().toString().trim();
        String rent = editrent.getSelectedItem().toString();
        String house = edithouse.getSelectedItem().toString();
        Vasi2 vasi = new Vasi2(id, editLastname, editFirstname, editEmail, editTel, rent, house, editAddress, editCountry, editTk, editComments);

        dbRef.child(id).setValue(vasi);

    }
    
}
