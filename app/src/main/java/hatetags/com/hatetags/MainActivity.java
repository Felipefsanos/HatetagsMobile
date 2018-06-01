package hatetags.com.hatetags;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.myToolbar)
    public Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        toolbar.setNavigationIcon(R.drawable.ic_home);
        setSupportActionBar(toolbar); //Seta ela como minha Action Bar
        System.out.println("TRETA!!!!!!!!!!!!!!!!!!!!!!1");

    }

    @OnClick(R.id.fab)
    public void showGraphics(){
        startActivity(new Intent(MainActivity.this, Graphics_activity.class));
    }


}
