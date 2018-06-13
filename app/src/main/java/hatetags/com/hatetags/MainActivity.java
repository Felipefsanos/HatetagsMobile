package hatetags.com.hatetags;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hatetags.com.hatetags.Entitys.Tweet;
import hatetags.com.hatetags.RecycleViewHome.MyAdapter;

public class MainActivity extends AppCompatActivity implements OnRecyclerViewListener {

    @BindView(R.id.myToolbar)
    public Toolbar toolbar;

    @BindView(R.id.recycleView)
    public RecyclerView recyclerView;

    private List<Tweet> listTweets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setNavigationIcon(R.drawable.ic_home);
        setSupportActionBar(toolbar); //Seta ela como minha Action Bar

        //Lista de Tweets a ser exibida

//        ArrayList<Tweet> tweets = new ArrayList<>();

        listTweets = new ArrayList<>();
        Tweet T = new Tweet("@Ciclano","12/12/12","kkkkkkkkk","123","321");
        listTweets.add(T);
        T = new Tweet("@Ciclano","12/12/12","kkkkkkkkk","123","321");
        listTweets.add(T);
        T = new Tweet("@Ciclano","12/12/12","kkkkkkkkk","123","321");
        listTweets.add(T);
        T = new Tweet("@Ciclano","12/12/12","kkkkkkkkk","123","321");
        listTweets.add(T);
        T = new Tweet("@Ciclano","12/12/12","kkkkkkkkk","123","321");
        listTweets.add(T);
        T = new Tweet("@Ciclano","12/12/12","kkkkkkkkk","123","321");
        listTweets.add(T);
        T = new Tweet("@Ciclano","12/12/12","kkkkkkkkk","123","321");
        listTweets.add(T);
        T = new Tweet("@Ciclano","12/12/12","kkkkkkkkk","123","321");
        listTweets.add(T);
        T = new Tweet("@Ciclano","12/12/12","kkkkkkkkk","123","321");
        listTweets.add(T);
        T = new Tweet("@Ciclano","12/12/12","kkkkkkkkk","123","321");
        listTweets.add(T);
        T = new Tweet("@Ciclano","12/12/12","kkkkkkkkk","123","321");
        listTweets.add(T);
        T = new Tweet("@Ciclano","12/12/12","kkkkkkkkk","123","321");
        listTweets.add(T);
        T = new Tweet("@Ciclano","12/12/12","kkkkkkkkk","123","321");
        listTweets.add(T);
        T = new Tweet("@Ciclano","12/12/12","kkkkkkkkk","123","321");
        listTweets.add(T);
        T = new Tweet("@Ciclano","12/12/12","kkkkkkkkk","123","321");
        listTweets.add(T);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new MyAdapter(listTweets, this));
    }

    @OnClick(R.id.fab)
    public void showGraphics(){
        startActivity(new Intent(MainActivity.this, Graphics_activity.class));
    }

    @Override
    public void onItemClick(View view, int position) {
    }

    @Override
    public void onLongItemClick(View view, int position) {
    }
}
