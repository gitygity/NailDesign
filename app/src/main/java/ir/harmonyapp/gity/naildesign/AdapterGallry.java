package ir.harmonyapp.gity.naildesign;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Pic;


public class AdapterGallry extends RecyclerView.Adapter<AdapterGallry.MyViewHolder> {
    private List<Pic> Listpic = Collections.EMPTY_LIST;
    private Context context;
    private LayoutInflater layoutInflater;

    public AdapterGallry(Context context) {

        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }


    public void updateAdapter(List<Pic> Listpic) {
        this.Listpic = Listpic;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.rowsgallery, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Pic currentModel = Listpic.get(position);
        //holder.textID.setText(String.valueOf(currentModel.getId()));

        Picasso.with(context)
                .load(currentModel.getUrlpic())
                .placeholder(R.drawable.placeholder)
                .into(holder.imnail1);

        holder.itemView.setOnClickListener(holder);
    }

    @Override
    public int getItemCount() {
        return Listpic.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imnail1;
        TextView textID;

        public MyViewHolder(View itemView) {
            super(itemView);
            imnail1 = (ImageView) itemView.findViewById(R.id.imgnail);
           // textID = (TextView) itemView.findViewById(R.id.titleqqq);

        }

        @Override
        public void onClick(View v) {
            Intent in = new Intent(context, PictureBrows.class);
            in.putParcelableArrayListExtra("PIC", (ArrayList<? extends Parcelable>) Listpic);
            in.putExtra("POSITIONPIC", getAdapterPosition() + "");
            in.putExtra("selectedpic", Listpic.get(getAdapterPosition()).getUrlpic());
            context.startActivity(in);
        }
    }

}
