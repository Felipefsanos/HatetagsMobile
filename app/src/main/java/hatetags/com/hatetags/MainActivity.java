package hatetags.com.hatetags;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hatetags.com.hatetags.Entitys.Tweet;
import hatetags.com.hatetags.RecycleViewHome.MyAdapter;
import hatetags.com.hatetags.WebServices.ClienteWebService;

public class MainActivity extends AppCompatActivity implements AbsListView.OnScrollListener {

    @BindView(R.id.myToolbar)
    public Toolbar toolbar;

    @BindView(R.id.recycleView)
    public RecyclerView recyclerView;

    public List<Tweet> listTweets;

    private Gson gson;

    private ClienteWebService WS;

    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setNavigationIcon(R.drawable.ic_home);
        setSupportActionBar(toolbar); //Seta ela como minha Action Bar

        gson =  new Gson();
        WS = new ClienteWebService(0);

        searchTweets();
        setDataToRecycleView();
    }

    public void searchTweets(){

        String retorno;

        try {

            retorno = WS.execute().get();
            Type collectionType = new TypeToken<List<Tweet>>() {}.getType();

            listTweets = gson.fromJson(retorno, collectionType);

            WS.setLastId(this.searchLastId());

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void setDataToRecycleView(){

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setOnScrollChangeListener((View.OnScrollChangeListener) MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        if (adapter == null) {
            MyAdapter adapter = new MyAdapter(listTweets, this);
            recyclerView.setAdapter(adapter);
        }
        else{
            adapter.notifyDataSetChanged();
        }
    }

    public long searchLastId(){

        long lastId = 0;

        for (Tweet t:listTweets) {
            if (t.getId() > lastId){
                lastId = t.getId();
            }
        }
        return lastId;

    }

    @OnClick(R.id.fab)
    public void showGraphics(){
        startActivity(new Intent(MainActivity.this, Graphics_activity.class));
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

        if (view.getId() == recyclerView.getId()){
            if (recyclerView.getScrollState() + 1 == listTweets.size()) {
                this.searchTweets();
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
