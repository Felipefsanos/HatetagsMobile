package hatetags.com.hatetags.Graphics;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class GraphicFactory {

    public DataSet prepararDataSet(Chart chart, ArrayList<Entry> data, String title) {

        boolean bar = chart instanceof BarChart;
        boolean line = chart instanceof LineChart;
        boolean pie = chart instanceof PieChart;

        if (bar) {
            ArrayList<BarEntry> barData = new ArrayList<>();

            for (Entry e : data) {
                barData.add(new BarEntry(e.getX(),e.getY()));
            }

            return new BarDataSet(barData, title);
        }

        if (line) {
            return new LineDataSet(data, title);
        }

        if (pie) {
            ArrayList<PieEntry> pieData = new ArrayList<>();

            for (Entry e : data) {
                pieData.add(new PieEntry(e.getY()));
            }

            return new PieDataSet(pieData, title);
        }

        return null;
    }
}
