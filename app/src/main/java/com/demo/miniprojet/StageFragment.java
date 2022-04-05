package com.demo.miniprojet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class StageFragment extends Fragment {
    private RecyclerView recyclerView ;
    String s1[], s2[];
    int images[] = {R.drawable.flateo,R.drawable.flateo,R.drawable.flateo,R.drawable.flateo,R.drawable.flateo};

    public StageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stage, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        s1 = getResources ().getStringArray(R.array.titres);
        s2 = getResources ().getStringArray (R.array.description);recyclerView.setHasFixedSize(true);

        //MyAdapter myAdapter = new MyAdapter(  this, s1, s2, images);
       //recyclerView.setLayoutManager(new LinearLayoutManager());
       // recyclerView.setAdapter(new RandomNumListAdapter(1234));

        MyAdapter myAdapter = new MyAdapter( view.getContext(), s1, s2, images);
        recyclerView.setAdapter (myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager( view.getContext()));
        return view;
    }
}