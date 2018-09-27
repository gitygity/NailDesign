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


public class Design extends AppCompatActivity {
    ListView lstdesign;


    static String[] DesignList = {"فرنچ ناخن در خانه"
            , "روشهای مختلف طراحی ناخن و مواد به کار رفته"
            , "انواع طراحی ناخن و وسایل مورد نیاز آن"
            , "دیزاین ناخن برای ولنتاین"
            , "طراحی و دیزاین ناخن به کمک نوار چسب"
            , "توصیه های نگهداری و دیزاین ناخن"
            , "چند مدل مانیکور برای ناخنهای کوتاه و متوسط"};
    static String[] HtmDesign = {"french.htm", "waysmaterial.htm", "tools.htm", "valentine.htm", "designnavar.htm", "manipulate.htm", "kotahmotavaset.htm"};

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


        setContentView(R.layout.activity_design);
        ButtonNavigation buttonNavigation = new ButtonNavigation();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerF, buttonNavigation).commit();
        Bundle bundle = new Bundle();
        bundle.putInt("index", 0);
        buttonNavigation.setArguments(bundle);

        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        lstdesign = (ListView) findViewById(R.id.lstdesign);
        Adapter adapter = new Adapter(this, DesignList);

        lstdesign.setAdapter(adapter);
        lstdesign.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent in = new Intent(Design.this, text.class);
                    in.putExtra("URL", "file:///android_asset/french.htm");
                    in.putExtra("POSITION", position + "");
                    in.putExtra("TYPE", "design");
                    startActivity(in);


                } else if (position == 1) {
                    Intent in = new Intent(Design.this, text.class);
                    in.putExtra("URL", "file:///android_asset/waysmaterial.htm");
                    in.putExtra("POSITION", position + "");
                    in.putExtra("TYPE", "design");
                    startActivity(in);


                } else if (position == 2) {
                    Intent in = new Intent(Design.this, text.class);
                    in.putExtra("URL", "file:///android_asset/tools.htm");
                    in.putExtra("POSITION", position + "");
                    in.putExtra("TYPE", "design");
                    startActivity(in);


                } else if (position == 3) {
                    Intent in = new Intent(Design.this, text.class);
                    in.putExtra("URL", "file:///android_asset/valentine.htm");
                    in.putExtra("POSITION", position + "");
                    in.putExtra("TYPE", "design");
                    startActivity(in);


                } else if (position == 4) {
                    Intent in = new Intent(Design.this, text.class);
                    in.putExtra("URL", "file:///android_asset/designnavar.htm");
                    in.putExtra("POSITION", position + "");
                    in.putExtra("TYPE", "design");
                    startActivity(in);


                } else if (position == 5) {
                    Intent in = new Intent(Design.this, text.class);
                    in.putExtra("URL", "file:///android_asset/manipulate.htm");
                    in.putExtra("POSITION", position + "");
                    in.putExtra("TYPE", "design");
                    startActivity(in);


                } else if (position == 6) {
                    Intent in = new Intent(Design.this, text.class);
                    in.putExtra("URL", "file:///android_asset/kotahmotavaset.htm");
                    in.putExtra("POSITION", position + "");
                    in.putExtra("TYPE", "design");
                    startActivity(in);


                }

            }
        });

    }
}
