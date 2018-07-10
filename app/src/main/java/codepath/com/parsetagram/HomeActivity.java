package codepath.com.parsetagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

import codepath.com.parsetagram.model.Post;

public class HomeActivity extends AppCompatActivity {
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //logout button that takes you back to main login screen
        logout = findViewById(R.id.logout_btn);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser();
                Intent intent = new Intent(HomeActivity.this, MainActivity.class );
                startActivity(intent);
            }
        });


    }

    private void createPost(String description, ParseFile imageFile, ParseUser user) {

    }

    private void loadTopPosts() {
        final Post.Query postQuery = new Post.Query();
        postQuery.getTop().withUser();

        postQuery.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> objects, ParseException e) {
                if(e == null) {
                    for(int i = 0; i < objects.size(); i++) {
                        Log.d("Home Activity", "Post[" + i + "]="
                                + objects.get(i).getDescription()
                                + "\nusername = " + objects.get(i).getUser().getUsername());

                    }
                } else {
                    e.printStackTrace();
                }
            }
        });

    }


}
