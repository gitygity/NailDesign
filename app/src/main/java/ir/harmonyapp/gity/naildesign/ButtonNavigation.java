package ir.harmonyapp.gity.naildesign;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonNavigation extends Fragment {
    BottomNavigationView bottomNavigationView;

    public ButtonNavigation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.fragment_botton_navigation, container, false);
        bottomNavigationView = (BottomNavigationView) V.findViewById(R.id.bottomNavigationView);

        if (!(getArguments() == null)) {
            Integer index = getArguments().getInt("index");
            bottomNavigationView.getMenu().getItem(index).setChecked(true);
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.favorites) {
                    Intent in = new Intent(getActivity(), Favorite.class);

                    startActivity(in);
                    return true;
                } else if (item.getItemId() == R.id.home) {
                    Intent in = new Intent(getActivity(), Main.class);

                    startActivity(in);
                    return true;
                } else if (item.getItemId() == R.id.gall) {
                    Intent in = new Intent(getActivity(), GalleyNail.class);

                    startActivity(in);
                    return true;
                }
                return false;
            }
        });

        return V;
    }


}
