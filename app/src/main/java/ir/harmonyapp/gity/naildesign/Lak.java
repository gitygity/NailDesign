package ir.harmonyapp.gity.naildesign;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Lak extends AppCompatActivity {
    ListView lstlak;


    static String[] LakList = {"انواع لاک ناخن"
            , "آنچه باید درباره لاک ناخن بدانید"
            , "افزایش دوام لاک ناخن"
    };
    static String[] HtmLak = {"typelak.htm", "infolak.htm", "davamlak.htm"};

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lak);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButtonNavigation buttonNavigation = new ButtonNavigation();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerF, buttonNavigation).commit();

        lstlak = (ListView) findViewById(R.id.lstlak);
        Adapter adapter = new Adapter(this, LakList);

        lstlak.setAdapter(adapter);
        lstlak.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {


                    Intent in = new Intent(Lak.this, text.class);
                    in.putExtra("URL", "file:///android_asset/typelak.htm");
                    in.putExtra("POSITION", position + "");
                    in.putExtra("TYPE", "lak");

                    startActivity(in);


                } else if (position == 1) {
                    Intent in = new Intent(Lak.this, text.class);
                    in.putExtra("URL", "file:///android_asset/infolak.htm");
                    in.putExtra("POSITION", position + "");
                    in.putExtra("TYPE", "lak");
                    startActivity(in);


                } else if (position == 2) {
                    Intent in = new Intent(Lak.this, text.class);
                    in.putExtra("URL", "file:///android_asset/davamlak.htm");
                    in.putExtra("POSITION", position + "");
                    in.putExtra("TYPE", "lak");
                    startActivity(in);


                }
            }
        });

    }
}
