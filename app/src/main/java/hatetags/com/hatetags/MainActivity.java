package hatetags.com.hatetags;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hatetags.com.hatetags.Entitys.Tweet;
import hatetags.com.hatetags.RecycleViewHome.EndlessRecyclerViewScrollListener;
import hatetags.com.hatetags.RecycleViewHome.MyAdapter;
import hatetags.com.hatetags.WebServices.ClienteWebService;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.myToolbar)
    public Toolbar toolbar;

    @BindView(R.id.recycleView)
    public RecyclerView recyclerView;

    public List<Tweet> listTweets;

    private Gson gson;

    private long lastId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setNavigationIcon(R.drawable.ic_home);
        setSupportActionBar(toolbar); //Seta ela como minha Action Bar

        lastId = 0;

        gson =  new Gson();

        listTweets = searchTweets();
        setDataToRecycleView();
    }

    public List<Tweet> searchTweets(){

        String retorno;

        try {

            retorno = new ClienteWebService(lastId).execute().get();

            Type type = new TypeToken<List<Tweet>>(){}.getType();

            List<Tweet> Tweetlist = gson.fromJson(retorno, type);

            setLastId(Tweetlist);

            return Tweetlist;

        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public void setDataToRecycleView(){

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        final MyAdapter adapter = new MyAdapter(listTweets, this);
        recyclerView.setAdapter(adapter);
        EndlessRecyclerViewScrollListener scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {

            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                final int size = adapter.getItemCount();
                listTweets.addAll(searchTweets());

                view.post(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyItemRangeInserted(size, listTweets.size() - 1);
                    }
                });
            }
        };

        recyclerView.addOnScrollListener(scrollListener);


    }

    public void setLastId(List<Tweet> list){

        long lastId = 0;

        for (Tweet t:list) {
            if (t.getId() > lastId){
                lastId = t.getId();
            }
        }
         this.lastId = lastId;

    }

    @OnClick(R.id.fab)
    public void showGraphics(){
        startActivity(new Intent(MainActivity.this, Graphics_activity.class));
    }

}
