package uvote.app.raghav.com.uvote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import uvote.app.raghav.com.uvote.uvote.R;

public class Register extends AppCompatActivity {
    AutoCompleteTextView regstu1;
    AutoCompleteTextView regsta1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regstu1 = (AutoCompleteTextView)findViewById(R.id.regstu1);
        regsta1 = (AutoCompleteTextView)findViewById(R.id.regsta1);

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
                    startActivity(new Intent(Register.this, MainActivity.class));
                }
            }
        });

    }
    private boolean isEditTextEmpty(String mInput) {
        return mInput.length() == 0;
    }
}
