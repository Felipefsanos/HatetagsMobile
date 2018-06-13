package hatetags.com.hatetags.Graphics;

import android.util.Log;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

public class MyXAxisValueFormatter implements IAxisValueFormatter {

    private String[] mValues;

    //TODO: Lembrar que o array de Labels tem que ter seu primeiro resultado nulo ou vazio

    public MyXAxisValueFormatter(String[] labels){
        mValues = labels;
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        return mValues[(int) value];
    }
}
