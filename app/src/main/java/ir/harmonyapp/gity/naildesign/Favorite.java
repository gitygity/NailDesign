package ir.harmonyapp.gity.naildesign;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class Favorite extends AppCompatActivity {
    ListView lstfavorite;
    DbHelper db;
    Cursor c;


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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButtonNavigation buttonNavigation = new ButtonNavigation();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerF, buttonNavigation).commit();
        Bundle bundle = new Bundle();
        bundle.putInt("index", 2);
        buttonNavigation.setArguments(bundle);
        lstfavorite = (ListView) findViewById(R.id.lstfavorite);
        displayall();


    }

    public void displayall() {
        db = new DbHelper(this);
        c = db.selectall();

        ArrayList<String> FavoriteList = new ArrayList<>();
        c.moveToFirst();


        for (int i = 0; i <= ((c.getCount()) - 1); i++) {

            FavoriteList.add(c.getString(1));

            c.moveToNext();
        }

        AdapterFavorite adapter = new AdapterFavorite(this, FavoriteList, c);
        lstfavorite.setAdapter(adapter);


    }

}
