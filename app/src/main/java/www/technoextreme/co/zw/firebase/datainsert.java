package www.technoextreme.co.zw.firebase;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;


public class datainsert extends Fragment {


    public datainsert() {

    }

    EditText txtname, txtage, txtphone;
    Button btnsave;
   // DatabaseReference reff;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.datainsert, container, false);

        txtname = v.findViewById(R.id.name);
        txtage = v.findViewById(R.id.age);
        txtphone = v.findViewById(R.id.phone);
        btnsave = v.findViewById(R.id.save);





        return v;
    }

}
