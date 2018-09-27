package ir.harmonyapp.gity.naildesign;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import it.gmariotti.recyclerview.adapter.ScaleInAnimatorAdapter;
import model.Pic;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import webservice.APIClient;
import webservice.APIinterface;

public class GalleyNail extends AppCompatActivity {
    RecyclerView MyRecycler;
    AdapterGallry adapterGallry;
    List<Pic> LISTPIC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galley_nail);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButtonNavigation buttonNavigation = new ButtonNavigation();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerF, buttonNavigation).commit();
        Bundle bundle = new Bundle();
        bundle.putInt("index", 1);
        buttonNavigation.setArguments(bundle);

        MyRecycler = (RecyclerView) findViewById(R.id.listpic);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        adapterGallry = new AdapterGallry(this);


        ScaleInAnimatorAdapter animatorAdapter = new ScaleInAnimatorAdapter(adapterGallry, MyRecycler);
        MyRecycler.setLayoutManager(gridLayoutManager);
        MyRecycler.setAdapter(animatorAdapter);

        APIinterface apIinterface = APIClient.getClient().create(APIinterface.class);
        GetDataServer(apIinterface);


    }

    private void GetDataServer(APIinterface apIinterface) {
        Call<List<Pic>> call = apIinterface.getpic();
        call.enqueue(new Callback<List<Pic>>() {
            @Override
            public void onResponse(Call<List<Pic>> call, Response<List<Pic>> response) {
                if (response.isSuccessful()) {

                    adapterGallry.updateAdapter(response.body());
                    adapterGallry.notifyDataSetChanged();


                }
            }

            @Override
            public void onFailure(Call<List<Pic>> call, Throwable throwable) {
                if (throwable instanceof IOException) {
                    Toast.makeText(GalleyNail.this, "کانکشن دچار مشکل است !", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

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

}
