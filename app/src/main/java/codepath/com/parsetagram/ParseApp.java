package codepath.com.parsetagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import codepath.com.parsetagram.model.Post;

//This class enables the configuration to the parse server
public class ParseApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();


        ParseObject.registerSubclass(Post.class);
        final Parse.Configuration configuration = new Parse.Configuration.Builder(this)
                .applicationId("turtle")
                .clientKey("deMaster")
                .server("http://nhired-parsetagram.herokuapp.com/parse")
                .build();

        Parse.initialize(configuration);





    }
}


