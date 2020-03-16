package www.technoextreme.co.zw.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    EditText txtname, txtage, txtphone;
    Button btnsave;
    DatabaseReference reff;
    RequestTowing mRequestTowing;
    long maxid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtname = (EditText) findViewById(R.id.name);
        txtage = (EditText) findViewById(R.id.age);
        txtphone = (EditText) findViewById(R.id.phone);
        btnsave = (Button) findViewById(R.id.save);
        mRequestTowing = new RequestTowing();
        reff = FirebaseDatabase.getInstance().getReference().child("RequestTowing");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    maxid=(dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int Age=Integer.parseInt(txtage.getText().toString().trim());
                Long ph= Long.parseLong(txtphone.getText().toString().trim());
                mRequestTowing.setName(txtname.getText().toString().trim());
                mRequestTowing.setAge(Age);
                mRequestTowing.setPh(ph);

                reff.child(String.valueOf(maxid+1)).setValue(mRequestTowing);
                Toast.makeText(MainActivity.this, "Data inserted successfully",Toast.LENGTH_SHORT).show();
            }
        });

     //   Toast.makeText(MainActivity.this, "Firebase connection Success",Toast.LENGTH_SHORT).show();
    }
}
