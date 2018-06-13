package hatetags.com.hatetags;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hatetags.com.hatetags.Graphics.MyXAxisValueFormatter;
import hatetags.com.hatetags.Graphics.MyYAxisValueFormatter;

public class Graphics_activity extends AppCompatActivity {

    @BindView(R.id.myToolbar)
    public Toolbar toolbar;

    @BindView(R.id.chartLine)
    protected LineChart chartLine;

    @BindView(R.id.chartBar)
    protected BarChart chartBar;

    @BindView(R.id.fab_barChart)
    protected FloatingActionButton fab_barChart;

    @BindView(R.id.fab_lineChart)
    protected FloatingActionButton fab_lineChart;

    @BindView(R.id.fab_pieChart)
    protected FloatingActionButton fab_pieChart;

    @BindView(R.id.fab_graphics)
    protected FloatingActionButton fab;

    private boolean isFabOpen = false;

    private Animation fabOpenAnimation;

    private Animation fabCloseAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);   //Deixa a tela em Full Screen
        setContentView(R.layout.activity_graphics_activity);
        ButterKnife.bind(this);
        getAnimations();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Gráficos");

//        ArrayList<Entry> data =  new ArrayList<>();
//        data.add(new Entry(1,10));
//        data.add(new Entry(2,75));
//        data.add(new Entry(3,50));
//        data.add(new Entry(3,100));
//        data.add(new Entry(4,200));

//        Entrada para Linechart

        chartLine.setVisibility(View.GONE);

    }

    @OnClick(R.id.fab_graphics)
    public void fab(){

        if (isFabOpen){
            closeFabMenu();
        }
        else{
            showFabMenu();
        }
//        ArrayList<BarEntry> data =  new ArrayList<>();
//        data.add(new BarEntry(1,10));
//        data.add(new BarEntry(2,75));
//        data.add(new BarEntry(3,50));
//        data.add(new BarEntry(3,100));
//        data.add(new BarEntry(4,200));
//
//        ArrayList<String> labels = new ArrayList<>();
//        labels.add("Label 1");
//        labels.add("Label 2");
//        labels.add("Label 3");
//        labels.add("Label 4");
//        labels.add("Label 5");
//
//        showBarChart(new BarDataSet(data,"Teste"),labels);

    }

    private void showFabMenu(){

        isFabOpen = true;
        ViewCompat.animate(fab).rotation(45.0F).withLayer().setDuration(300).setInterpolator(new OvershootInterpolator(10.0F)).start();
    }

    private void closeFabMenu(){

        isFabOpen = false;
        fab_barChart.animate().translationY(0);
        fab_lineChart.animate().translationY(0);
        fab_pieChart.animate().translationY(0);

    }

    public void showLineChart(LineDataSet data, ArrayList<String> labels){

        XAxis xAxis = chartLine.getXAxis();
        xAxis.setValueFormatter(new MyXAxisValueFormatter(setLabels(labels)));

        // Evita a duplicação dos meses na linha X
        xAxis.setGranularity(1f);

        YAxis yAxis = chartLine.getAxisLeft();
        yAxis.setValueFormatter(new MyYAxisValueFormatter());

        data.setDrawFilled(true);
        data.setDrawValues(false);
        LineData lineData = new LineData(data);
        chartLine.setData(lineData);
        // Desativa o ZOOM do Touch
        chartLine.setDoubleTapToZoomEnabled(false);
        Description D = new Description();
        D.setText("TRETA");
        chartLine.setDescription(D);

        chartLine.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Toast.makeText(Graphics_activity.this, "Valor: " + e.getY(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });

        // Efeito de animação
        chartLine.animateXY(2000, 2000);
        chartLine.invalidate();

    }

    public void showBarChart(BarDataSet data, ArrayList<String> labels) {

        //Define o eixo X
        XAxis xAxis = chartBar.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f);
//        xAxis.setLabelCount(7);     Define quantos labels aparece
        xAxis.setValueFormatter(new MyXAxisValueFormatter(setLabels(labels)));

        //Define o eixo Y
        YAxis yAxis = chartBar.getAxisLeft();
//        yAxis.setLabelCount(7, false); Define quantos labels aparece e o folse impede de forçar
        yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yAxis.setAxisMinimum(0f);
        yAxis.setValueFormatter(new MyYAxisValueFormatter());

        data.setBarBorderColor(Color.BLACK);
        data.setDrawValues(false);
        BarData barData = new BarData(data);
        chartBar.setData(barData);
        // Desativa o ZOOM do Touch
        chartBar.setDoubleTapToZoomEnabled(false);

        chartBar.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Toast.makeText(Graphics_activity.this, "Valor: " + e.getY(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });

        // Efeito de animação
        chartLine.animateXY(2000, 2000);
        chartLine.invalidate();


    }

    public String[] setLabels(ArrayList<String> labels){

        String result[] = new String[labels.size()+1];

        for (int i=0; i < result.length; i++){

            if (i == 0){

                result[i] = "";
            }
            else
            {
                result[i] = labels.get(i-1);
            }
        }

        return result;

    }

    private void getAnimations(){

        fabOpenAnimation = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        fabCloseAnimation = AnimationUtils.loadAnimation(this, R.anim.fab_close);
    }

}
