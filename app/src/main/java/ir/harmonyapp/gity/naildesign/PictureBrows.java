package ir.harmonyapp.gity.naildesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import model.Pic;

public class PictureBrows extends AppCompatActivity implements View.OnClickListener {


    ImageView picdisplay;
    Button next, pre;
    ArrayList<Pic> listp;
    String urlpicc, indexpic;
    static int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_brows);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        picdisplay = (ImageView) findViewById(R.id.picbrows);
        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(this);
        pre = (Button) findViewById(R.id.pre);
        pre.setOnClickListener(this);

        Bundle data = getIntent().getExtras();
        listp = data.getParcelableArrayList("PIC");

        urlpicc = getIntent().getStringExtra("selectedpic");
        indexpic = getIntent().getStringExtra("POSITIONPIC");

        counter = Integer.parseInt(indexpic);
        Picasso.with(PictureBrows.this)
                .load(urlpicc)
                .placeholder(R.drawable.placeholder)
                .into(picdisplay);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.next:

                if ((listp.size() - 1) > counter) {

                    counter = counter + 1;

                    Picasso.with(this)
                            .load(listp.get(counter).getUrlpic())
                            .placeholder(R.drawable.placeholder)
                            .into(picdisplay);
                }
                break;
            case R.id.pre:

                if (!(counter == 0)) {
                    counter = counter - 1;

                    Picasso.with(this)
                            .load(listp.get(counter).getUrlpic())
                            .placeholder(R.drawable.placeholder)
                            .into(picdisplay);
                }
                break;


        }
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
