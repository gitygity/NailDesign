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

public class Health extends AppCompatActivity {
    ListView lsthealth;


    static String[] HealthList = {"معرفی بیماری ناخنک و روشهای پیشگیری و درمان"
            , "قوی تر کردن ناخن ها"
            , "مراقب ناخنتان باشید"
            , "تقویت ناخن با استفاده از روغن"
            , "رازهای داشتن ناخن های زیبا"
            , "ناخنهای سالم را بشناسیم"
            , "انواع بیماری های ناخن را بشناسید"
            , "مواد مغذی برای ناخن ها(1)"
            , "مواد مغذی برای ناخن ها(2)"
            , "نکاتی در مورد داشتن ناخن های سالم و قوی"
            , "مراحل مانیکور و فواید آن"
            , "ناخن های پایتان را پدیکور کنید!"
            , "توصیه هایی برای پیر نشدن دست هایتان"};
    static String[] HtmHealth = {"nakhonak.htm", "strongnail.htm", "carenail.htm", "oil.htm", "secret.htm",
            "healthnail.htm", "illnail.htm", "materialfood2.htm", "materialfoodnail.htm",
            "healthstrongnail.htm", "manikorstep.htm", "padikor.htm", "oldnail.htm"};

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
        setContentView(R.layout.activity_health);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButtonNavigation buttonNavigation = new ButtonNavigation();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerF, buttonNavigation).commit();

        lsthealth = (ListView) findViewById(R.id.lsthealth);
        Adapter adapter = new Adapter(this, HealthList);

        lsthealth.setAdapter(adapter);
        lsthealth.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent in = new Intent(Health.this, text.class);
                    in.putExtra("URL", "file:///android_asset/nakhonak.htm");
                    in.putExtra("POSITION", position + "");
                    in.putExtra("TYPE", "health");
                    startActivity(in);


                } else if (position == 1) {
                    Intent in = new Intent(Health.this, text.class);
                    in.putExtra("URL", "file:///android_asset/strongnail.htm");
                    in.putExtra("POSITION", position + "");
                    in.putExtra("TYPE", "health");
                    startActivity(in);


                } else if (position == 2) {
                    Intent in = new Intent(Health.this, text.class);
                    in.putExtra("URL", "file:///android_asset/carenail.htm");
                    in.putExtra("POSITION", position + "");
                    in.putExtra("TYPE", "health");
                    startActivity(in);


                } else if (position == 3) {
                    Intent in = new Intent(Health.this, text.class);
                    in.putExtra("URL", "file:///android_asset/oil.htm");
                    in.putExtra("POSITION", position + "");
                    in.putExtra("TYPE", "health");
                    startActivity(in);


                } else if (position == 4) {
                    Intent in = new Intent(Health.this, text.class);
                    in.putExtra("URL", "file:///android_asset/secret.htm");
                    in.putExtra("POSITION", position + "");
                    in.putExtra("TYPE", "health");
                    startActivity(in);


                } else if (position == 5) {
                    Intent in = new Intent(Health.this, text.class);
                    in.putExtra("URL", "file:///android_asset/healthnail.htm");
                    in.putExtra("POSITION", position + "");
                    in.putExtra("TYPE", "health");
                    startActivity(in);


                } else if (position == 6) {
                    Intent in = new Intent(Health.this, text.class);
                    in.putExtra("URL", "file:///android_asset/illnail.htm");
                    in.putExtra("POSITION", position + "");
                    in.putExtra("TYPE", "health");
                    startActivity(in);


                } else if (position == 7) {
                    Intent in = new Intent(Health.this, text.class);
                    in.putExtra("URL", "file:///android_asset/materialfood2.htm");
                    in.putExtra("POSITION", position + "");
                    in.putExtra("TYPE", "health");
                    startActivity(in);


                } else if (position == 8) {
                    Intent in = new Intent(Health.this, text.class);
                    in.putExtra("URL", "file:///android_asset/materialfoodnail.htm");
                    in.putExtra("POSITION", position + "");
                    in.putExtra("TYPE", "health");
                    startActivity(in);


                } else if (position == 9) {
                    Intent in = new Intent(Health.this, text.class);
                    in.putExtra("URL", "file:///android_asset/healthstrongnail.htm");
                    in.putExtra("POSITION", position + "");
                    in.putExtra("TYPE", "health");
                    startActivity(in);


                } else if (position == 10) {
                    Intent in = new Intent(Health.this, text.class);
                    in.putExtra("URL", "file:///android_asset/manikorstep.htm");
                    in.putExtra("POSITION", position + "");
                    in.putExtra("TYPE", "health");
                    startActivity(in);


                } else if (position == 11) {
                    Intent in = new Intent(Health.this, text.class);
                    in.putExtra("URL", "file:///android_asset/padikor.htm");
                    in.putExtra("POSITION", position + "");
                    in.putExtra("TYPE", "health");
                    startActivity(in);


                } else if (position == 12) {
                    Intent in = new Intent(Health.this, text.class);
                    in.putExtra("URL", "file:///android_asset/oldnail.htm");
                    in.putExtra("POSITION", position + "");
                    in.putExtra("TYPE", "health");
                    startActivity(in);


                }


            }
        });

    }
}
