package ir.harmonyapp.gity.naildesign;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

public class text extends AppCompatActivity {
    ImageView setfavorite;
    int position;
    String type;
    DbHelper db;
    Cursor C;


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


    @Override
    public void onBackPressed() {
        if (AdapterFavorite.FlagF == 1) {
            Intent in = new Intent(text.this, Favorite.class);
            startActivity(in);
        }
        finish();


        super.onBackPressed();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        db = new DbHelper(this);
        setfavorite = (ImageView) findViewById(R.id.setfavorite);
        position = Integer.parseInt(getIntent().getStringExtra("POSITION"));
        type = getIntent().getStringExtra("TYPE");
        if (type.equals("lak")) {
            C = db.findfavorite(position + "", type);
            if (C.getCount() > 0) {
                setfavorite.setImageResource(R.drawable.ic_favorite_red_500_24dp);
            }


        } else if (type.equals("design")) {
            C = db.findfavorite(position + "", type);
            if (C.getCount() > 0) {

                setfavorite.setImageResource(R.drawable.ic_favorite_red_500_24dp);
            }

        } else if (type.equals("health")) {
            C = db.findfavorite(position + "", type);
            if (C.getCount() > 0) {

                setfavorite.setImageResource(R.drawable.ic_favorite_red_500_24dp);
            }
        }


        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.favorites) {
                    Intent in = new Intent(text.this, Favorite.class);
                    startActivity(in);
                    return true;
                } else if (item.getItemId() == R.id.home) {
                    Intent in = new Intent(text.this, Main.class);
                    startActivity(in);
                    return true;
                } else if (item.getItemId() == R.id.gall) {
                    Intent in = new Intent(text.this, GalleyNail.class);
                    startActivity(in);
                    return true;
                }
                return false;
            }
        });


        setfavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                C = db.findfavorite(position + "", type);

                if (type.equals("lak")) {

                    if (C.getCount() == 0) {
                        db.InsertFavorite(type, Lak.LakList[position], position + "");
                        setfavorite.setImageResource(R.drawable.ic_favorite_red_500_24dp);


                    } else {
                        db.delete_field(position + "", type);

                        setfavorite.setImageResource(R.drawable.ic_favorite_black_24dp);


                    }


                } else if (type.equals("design")) {
                    if (C.getCount() == 0) {

                        db.InsertFavorite(type, Design.DesignList[position], position + "");
                        setfavorite.setImageResource(R.drawable.ic_favorite_red_500_24dp);
                    } else {
                        db.delete_field(position + "", type);
                        setfavorite.setImageResource(R.drawable.ic_favorite_black_24dp);
                    }


                } else if (type.equals("health")) {
                    if (C.getCount() == 0) {

                        db.InsertFavorite(type, Health.HealthList[position], position + "");
                        setfavorite.setImageResource(R.drawable.ic_favorite_red_500_24dp);
                    } else {
                        db.delete_field(position + "", type);
                        setfavorite.setImageResource(R.drawable.ic_favorite_black_24dp);
                    }
                }
            }
        });

        String url = getIntent().getStringExtra("URL");
        WebView text = (WebView) findViewById(R.id.webviewtext);
        text.loadUrl(url);
    }

}
