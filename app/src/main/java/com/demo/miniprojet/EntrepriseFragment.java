package com.demo.miniprojet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/**
 * A simple {@link Fragment} subclass.
 */
public class EntrepriseFragment extends Fragment {
    private RecyclerView recyclerView ;
    String s1[];
    int images[] = {R.drawable.flateo,R.drawable.germitec,R.drawable.medinbio,R.drawable.dipole,R.drawable.iwasecosfa};

    public EntrepriseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_entreprise, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        s1 = getResources ().getStringArray(R.array.Entreprises);

        //MyAdapter myAdapter = new MyAdapter(  this, s1, s2, images);
        //recyclerView.setLayoutManager(new LinearLayoutManager());
        // recyclerView.setAdapter(new RandomNumListAdapter(1234));

        MyAdapter2 myAdapter = new MyAdapter2( view.getContext(), s1, images);
        recyclerView.setAdapter (myAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager( view.getContext(),5));
        return view;
    }
}
