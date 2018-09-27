package ir.harmonyapp.gity.naildesign;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class Adapter extends ArrayAdapter<String> {
    private final Activity context;
    String[] textfordisplay;

    public Adapter(Activity context, String[] textfordisplay) {
        super(context, R.layout.rowdesignlist, textfordisplay);
        this.textfordisplay = textfordisplay;
        this.context = context;
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = context.getLayoutInflater().inflate(R.layout.rowdesignlist, null);
        TextView tx = (TextView) v.findViewById(R.id.tx);
        tx.setText(textfordisplay[position]);
        return v;
    }
}
