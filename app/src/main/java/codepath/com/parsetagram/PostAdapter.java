package codepath.com.parsetagram;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.request.target.Target;
import com.parse.ParseException;
import com.parse.ParseUser;

import java.text.SimpleDateFormat;
import java.util.List;

import codepath.com.parsetagram.model.Post;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

//This class conects the arraylist of posts and UI into a recycler view to display the posts in the main feed activity
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder>{

    private List<Post> fPosts;
    Context context;


    //pass in tweets array into constructor
    public PostAdapter(List<Post> posts) {
        fPosts = posts;
    }


    //for each row, inflate layout and cache references into viewholder

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View tweetView = inflater.inflate(R.layout.parsta_post, parent, false);
        ViewHolder viewHolder = new ViewHolder(tweetView);

        return viewHolder;
    }


    //bind values based on position of element
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //get data according to position
        Post post = fPosts.get(position);

        //set caption
        holder.text.setText(post.getDescription());

        //set time
        String date;
        SimpleDateFormat sdfr = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy");
        date = sdfr.format(post.getCreatedAt());
        holder.time.setText(ParseRelativeDate.getRelativeTimeAgo(date));

       //set username
        holder.username.setText(post.getUser().getUsername());
        int radius = 50; // corner radius, higher value = more rounded
        int margin = 0;

        //set parsta post image
        GlideApp.with(context)
                .load(post.getImage().getUrl())
                .into(holder.image);

        ParseUser user = ParseUser.getCurrentUser();

        try {
            if(post.getUser().fetchIfNeeded().getParseFile("profilePic") != null) {
                String avi = post.getUser().fetchIfNeeded().getParseFile("profilePic").getUrl();

                if(avi != null) {
                    GlideApp.with(context)
                            .load(avi)
                            .fitCenter()
                            .override(100, Target.SIZE_ORIGINAL)
                            .transform(new RoundedCornersTransformation(radius, margin))
                            .into(holder.avatar);
                }

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    //create viewholder class
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image, avatar;
        TextView text, username, time;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //lookup view object by id
            image = itemView.findViewById(R.id.parstaImg_id);
            avatar = itemView.findViewById(R.id.avatar_id);
            text = itemView.findViewById(R.id.pCaption_id);
            username = itemView.findViewById(R.id.username_id);
            time = itemView.findViewById(R.id.time_id);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            // make sure the position is valid, i.e. actually exists in the view
            if (position != RecyclerView.NO_POSITION) {
                // get the movie at the position, this won't work if the class is static
                Post post = fPosts.get(position);
                // create intent for the new activity
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("image_url", post.getImage().getUrl());
                intent.putExtra("caption", post.getDescription());

                String date;
                SimpleDateFormat sdfr = new SimpleDateFormat("HH:mm:ss");
                date = sdfr.format(post.getCreatedAt());
                intent.putExtra("created_at", date);

                // show the activity
                context.startActivity(intent);

            }
        }
    }

    @Override
    public int getItemCount() {
        return fPosts.size();
    }

    // Clean all elements of the recycler
    public void clear() {
        fPosts.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Post> list) {
        fPosts.addAll(list);
        notifyDataSetChanged();
    }



}

