package tcc.br.consumoenergia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("LED");

        //objetos

        btn= (Button) findViewById(R.id.btnMudar);
        editText= (EditText) findViewById(R.id.edtDados);
        textView= (TextView) findViewById(R.id.txtView);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fon= editText.getText().toString();
                    //int fon2= Integer.parseInt(fon);
                myRef.setValue(fon);

            }
        });

      myRef.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
               String s = dataSnapshot.getValue(String.class);
               textView.setText(s);
           }

           @Override
           public void onCancelled(DatabaseError databaseError) {

           }
       });
     }
}
