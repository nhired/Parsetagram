package codepath.com.parsetagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {
    EditText username, password, email;
    ParseUser user = new ParseUser();
    Button signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        user.setUsername(username.getText().toString());
        user.setPassword(password.getText().toString());
        user.setEmail(email.getText().toString());



        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               signUp();
            }
        });



    }

    private void signUp() {

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Log.d("SignUpActivity", "Sign Up Successful");
                    final Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Log.e("SignUpActivity", "Sign Up Failure");
                    e.printStackTrace();
                }

            }
        });

    }


}
