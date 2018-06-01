package hatetags.com.hatetags;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Graphics_activity extends AppCompatActivity {

    @BindView(R.id.myToolbar)
    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphics_activity);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Gráficos");
    }

    @OnClick(R.id.fab_graphics)
    public void showGraphics(){
        System.out.println("Click!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Toast.makeText(getApplicationContext(),"Mostra mais opções de gráficos",Toast.LENGTH_LONG).show();

    }

}
