package ir.harmonyapp.gity.naildesign;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AdapterFavorite extends ArrayAdapter<String> {
    private final Activity context;
    ArrayList<String> textfordisplay;
    Cursor C;
    DbHelper db;
    static int FlagF = 0;


    public AdapterFavorite(Activity context, ArrayList<String> textfordisplay, Cursor C) {
        super(context, R.layout.rowdesignlist, textfordisplay);
        this.textfordisplay = textfordisplay;
        this.context = context;
        this.C = C;

    }


    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        View v1 = convertView;
        if (v1 == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            v1 = inflater.inflate(R.layout.rowfavorite, null);
        }
        ConstraintLayout lyRoot = (ConstraintLayout) v1.findViewById(R.id.lyRoot);
        TextView tx = (TextView) v1.findViewById(R.id.txtfavorite);
        final ImageView delim = (ImageView) v1.findViewById(R.id.deleterowf);
        tx.setText(textfordisplay.get(position));


        lyRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                C.moveToPosition(position);
                if (C.getString(3).equals("design")) {
                    Intent in = new Intent(context, text.class);
                    in.putExtra("URL", "file:///android_asset/" + Design.HtmDesign[Integer.parseInt(C.getString(2))]);
                    in.putExtra("POSITION", C.getString(2));
                    in.putExtra("TYPE", "design");
                    FlagF = 1;

                    context.startActivity(in);
                    context.finish();


                } else if (C.getString(3).equals("lak")) {
                    Intent in = new Intent(context, text.class);
                    in.putExtra("URL", "file:///android_asset/" + Lak.HtmLak[Integer.parseInt(C.getString(2))]);
                    in.putExtra("POSITION", C.getString(2));
                    in.putExtra("TYPE", "lak");
                    FlagF = 1;

                    context.startActivity(in);
                    context.finish();

                } else if (C.getString(3).equals("health")) {
                    Intent in = new Intent(context, text.class);
                    in.putExtra("URL", "file:///android_asset/" + Health.HtmHealth[Integer.parseInt(C.getString(2))]);
                    in.putExtra("POSITION", C.getString(2));
                    in.putExtra("TYPE", "health");
                    FlagF = 1;
                    context.startActivity(in);
                    context.finish();

                }


            }
        });
        delim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = new DbHelper(context);
                C.moveToPosition(position);

                db.delete_field(C.getString(2), C.getString(3));
                textfordisplay.remove(position);


                notifyDataSetChanged();


            }
        });


        return v1;
    }

}
