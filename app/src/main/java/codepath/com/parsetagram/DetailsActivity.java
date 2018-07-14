package codepath.com.parsetagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.request.target.Target;
import com.parse.ParseException;
import com.parse.ParseUser;

import java.text.SimpleDateFormat;

import codepath.com.parsetagram.model.Post;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

//This class sets the layout for the details page the shows the post as well as the caption and the time it was created
public class DetailsActivity extends AppCompatActivity {
    ImageView image, avatar;
    TextView caption, date, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        image = findViewById(R.id.dimg_id);
        caption = findViewById(R.id.dCaption_id);
        date = findViewById(R.id.time_id);

        caption.setText(getIntent().getStringExtra("caption"));
        date.setText(getIntent().getStringExtra("created_at").toString());


        GlideApp.with(this)
                .load(getIntent().getStringExtra("image_url"))
                .into(image);



    }
}
