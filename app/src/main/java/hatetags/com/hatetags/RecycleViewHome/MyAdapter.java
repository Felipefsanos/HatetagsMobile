package hatetags.com.hatetags.RecycleViewHome;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import hatetags.com.hatetags.Entitys.Tweet;
import hatetags.com.hatetags.R;

public class MyAdapter extends Adapter<MyHolder> {

    private List<Tweet> itens;
    private Context context;

    public MyAdapter(List<Tweet> tweets, Context context) {
        this.itens = tweets;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(context).inflate(R.layout.fragment_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Tweet tweet = itens.get(position);
        holder.userTag.setText(tweet.getTagUser());
        holder.userImage.setImageResource(R.drawable.ic_user_black);
        holder.dataHora.setText(tweet.getDataHora());
        holder.content.setText(tweet.getContent());
        holder.favorite.setText(tweet.getFavorites());
        holder.retweet.setText(tweet.getRetweets());
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }
}
