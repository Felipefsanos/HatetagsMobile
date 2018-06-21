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
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;
import hatetags.com.hatetags.Graphics.GraphicFactory;
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
    protected com.github.clans.fab.FloatingActionButton fab_barChart;

    @BindView(R.id.fab_lineChart)
    protected com.github.clans.fab.FloatingActionButton fab_lineChart;

    @BindView(R.id.fab_pieChart)
    protected com.github.clans.fab.FloatingActionButton fab_pieChart;

    @BindView(R.id.fab_graphics)
    protected com.github.clans.fab.FloatingActionMenu fab;

    private ArrayList<Entry> data;

    private String[] labels;

    private GraphicFactory graphicFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);   //Deixa a tela em Full Screen
        setContentView(R.layout.activity_graphics_activity);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Gráficos");

        graphicFactory = new GraphicFactory();

        ArrayList<String> Testelabels = new ArrayList<>();
        Testelabels.add("Label 1");
        Testelabels.add("Label 2");
        Testelabels.add("Label 3");
        Testelabels.add("Label 4");
        Testelabels.add("Label 5");

        setData(data);
        setLabels(Testelabels);



    }

    @OnClick(R.id.fab_lineChart)
    public void showLineChart(){

        LineDataSet lineDataSet = (LineDataSet) graphicFactory.prepararDataSet(chartLine, data, "Teste");

        XAxis xAxis = chartLine.getXAxis();
        xAxis.setValueFormatter(new MyXAxisValueFormatter(labels));

        // Evita a duplicação dos meses na linha X
        xAxis.setGranularity(1f);

        YAxis yAxis = chartLine.getAxisLeft();
        yAxis.setValueFormatter(new MyYAxisValueFormatter());

        lineDataSet.setDrawFilled(true);
        lineDataSet.setDrawValues(false);
        LineData lineData = new LineData(lineDataSet);
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

        chartLine.setVisibility(View.VISIBLE);
        chartBar.setVisibility(View.GONE);

    }

    @OnClick(R.id.fab_barChart)
    public void showBarChart() {

        BarDataSet barDataSet = (BarDataSet) graphicFactory.prepararDataSet(chartBar, data, "Teste");

        //Define o eixo X
        XAxis xAxis = chartBar.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f);
//        xAxis.setLabelCount(7);     Define quantos labels aparece
        xAxis.setValueFormatter(new MyXAxisValueFormatter(labels));

        //Define o eixo Y
        YAxis yAxis = chartBar.getAxisLeft();
//        yAxis.setLabelCount(7, false); Define quantos labels aparece e o folse impede de forçar
        yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yAxis.setAxisMinimum(0f);
        yAxis.setValueFormatter(new MyYAxisValueFormatter());

        barDataSet.setBarBorderColor(Color.BLACK);
        barDataSet.setDrawValues(false);
        BarData barData = new BarData(barDataSet);
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
        chartBar.animateXY(2000, 2000);
        chartBar.invalidate();

        chartBar.setVisibility(View.VISIBLE);
        chartLine.setVisibility(View.GONE);


    }

    private void setData(ArrayList<Entry> data){

        this.data =  new ArrayList<>();
        this.data.add(new Entry(1,10));
        this.data.add(new Entry(2,75));
        this.data.add(new Entry(3,50));
        this.data.add(new Entry(3,100));
        this.data.add(new Entry(4,200));

    }

    private void setLabels(ArrayList<String> newLabels){

       labels = new String[newLabels.size()+1];

        for (int i=0; i < labels.length; i++){

            if (i == 0){

                labels[i] = "";
            }
            else
            {
                labels[i] = newLabels.get(i-1);
            }
        }

    }

}
