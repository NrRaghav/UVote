package uvote.app.raghav.com.uvote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import uvote.app.raghav.com.uvote.uvote.R;

public class Register extends AppCompatActivity {
    AutoCompleteTextView regstu1;
    AutoCompleteTextView regsta1;
    users user;
    DatabaseReference mDatabase;
    String uid;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();

        if (mUser != null) {
            // Name, email address, and profile photo Url
            uid=mUser.getUid();}

        regstu1 = (AutoCompleteTextView)findViewById(R.id.regstu1);
        regsta1 = (AutoCompleteTextView)findViewById(R.id.regsta1);
        mDatabase= FirebaseDatabase.getInstance().getReference().child("users");
        Button register = (Button)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean cancel = false;


                View focusView = null;


                final String a = regstu1.getText().toString();
                final String b = regsta1.getText().toString();

                if(isEditTextEmpty(a)&&isEditTextEmpty(b))
                {
                    Toast.makeText(Register.this, "Enter atleast one!!",
                            Toast.LENGTH_SHORT).show();
                    cancel = true;
                }
                if(!isEditTextEmpty(a)&&!isEditTextEmpty(b))
                {
                    Toast.makeText(Register.this, "Remove one!",
                            Toast.LENGTH_SHORT).show();
                    cancel = true;
                }

                if (cancel == false)
                {
                    if(isEditTextEmpty(a)==true)
                    {user=new users(b);}
                    else
                    {user=new users(a);}
                    mDatabase.child(uid).setValue(user);
                    startActivity(new Intent(Register.this, MainActivity.class));
                }
            }
        });

    }
    private boolean isEditTextEmpty(String mInput) {
        return mInput.length() == 0;
    }
}
