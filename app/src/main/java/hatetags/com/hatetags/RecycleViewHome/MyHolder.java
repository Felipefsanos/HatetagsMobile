package hatetags.com.hatetags.RecycleViewHome;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import hatetags.com.hatetags.R;

public class MyHolder extends RecyclerView.ViewHolder {

    public ImageView userImage;
    public TextView dataHora;
    public TextView userTag;
    public TextView content;
    public TextView favorite;
    public TextView retweet;

    public MyHolder(View view) {
        super(view);
        userImage = view.findViewById(R.id.user_image);
        dataHora = view.findViewById(R.id.data_text);
        userTag = view.findViewById(R.id.user_tag);
        content = view.findViewById(R.id.content_tweet);
        favorite = view.findViewById(R.id.favorite_text);
        retweet = view.findViewById(R.id.retweet_text);
    }
}
