package codepath.com.parsetagram;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.io.File;
import java.util.List;

import codepath.com.parsetagram.model.Post;

public class HomeActivity extends AppCompatActivity {
    Button logout, post;
    int REQUEST_CODE = 20;
    ParseFile image;


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
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        post = findViewById(R.id.create_btn);

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, NewPost.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Intent intent = new Intent(HomeActivity.this, FeedActivity.class);
        startActivity(intent);

       /* if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            // Extract name value from result extras
            String object_id = data.getStringExtra("object_id");
            final String caption = data.getStringExtra("caption");

            ParseQuery<Post> query = ParseQuery.getQuery(Post.class);

            // Execute the query to find the object with ID
            query.getInBackground(object_id, new GetCallback<Post>() {
                public void done(Post item, ParseException e) {
                    if (e == null) {
                        View view = findViewById(R.id.homeView);

                        //set imageview
                        ImageView homeImage = findViewById(R.id.postImg_id);
                        Glide.with(view.getContext()).load(item.getImage().getUrl()).into(homeImage);

                        //set text
                        TextView text = findViewById(R.id.parseTxt_id);
                        text.setText(caption);

                        item.setCaption(caption);
                    } else {
                        Log.e("QueryError", "Query did not post picture and caption");
                    }
                }
            });

        }*/

    }




}
