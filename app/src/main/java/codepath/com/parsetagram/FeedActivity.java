package codepath.com.parsetagram;

import android.app.Application;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import codepath.com.parsetagram.model.Post;

//This activity sets up the layout that loads a recycler view of instagram posts as well as
//the bottom navigation bar
public class FeedActivity extends AppCompatActivity {
    PostAdapter postAdapter;
    ArrayList<Post> posts;
    RecyclerView rvPosts;
    private SwipeRefreshLayout swipeContainer;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        //find recycler view
        rvPosts = (RecyclerView) findViewById(R.id.rvPost);
        //init arraylist
        posts = new ArrayList<>();
        //construct adapter from data source
        postAdapter = new PostAdapter(posts);
        //recycler view setup
        rvPosts .setLayoutManager(new LinearLayoutManager(this));
        //set adapter
        rvPosts.setAdapter(postAdapter);

        getParstagramPosts();


        // Lookup the swipe container view
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeContainer.setRefreshing(false);
                fetchTimelineAsync(0);
            }
        });
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,

                android.R.color.holo_red_light);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        return true;
                    case R.id.new_post:
                        Intent post_intent = new Intent(FeedActivity.this, NewPost.class);
                        startActivity(post_intent);
                        return true;
                    case R.id.user:
                        Intent user_intent = new Intent(FeedActivity.this, LogoutActivity.class);
                        startActivity(user_intent);
                        return true;
                        default:
                            return true;
                }
            }
        });

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.icon);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


    }

    public void fetchTimelineAsync(int page) {
        getParstagramPosts();

        }

    private void getParstagramPosts() {
        // Define the class we would like to query
        //ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        Post.Query query = new Post.Query();
        query.getTop().withUser();
        query.orderByDescending("createdAt");
        query.setLimit(20);
        // Define our query conditions

        // Execute the find asynchronously
        query.findInBackground(new FindCallback<Post>() {
            public void done(List<Post> itemList, ParseException e) {
                if (e == null) {
                    // Access the array of results here

                   // String firstItemId = itemList.get(0).getObjectId();

                    posts.clear();
                    posts.addAll(itemList);
                    postAdapter.notifyDataSetChanged();

                    //Toast.makeText(FeedActivity.this, firstItemId, Toast.LENGTH_SHORT).show();
                } else {
                    Log.d("item", "Error");
                }
            }
        });
    }



}
