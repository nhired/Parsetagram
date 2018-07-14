package codepath.com.parsetagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.parse.ParseUser;

//This activity includes the logout button as well as allows the user to set their profile avatar
public class LogoutActivity extends AppCompatActivity {

    Button logout, setPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        logout = findViewById(R.id.logoutBtn);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser();
                Intent intent = new Intent(LogoutActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        setPic = findViewById(R.id.profilePic_id);
        setPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(LogoutActivity.this, NewProfilePic.class);
                startActivity(i);

            }
        });



    }
}
