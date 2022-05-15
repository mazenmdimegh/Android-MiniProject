package com.demo.miniprojet;

import android.app.AlertDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EntrepriseFragment extends Fragment implements MyAdapter2.OnNoteListener {
    private RecyclerView recyclerView ;
    private AlertDialog dialog;
    private  AlertDialog.Builder dialogBuilder;
    // Dynamic Company List for the test (will be removed after the database connexion)
    //String s1[];

    // Dynamic Images List for the test (will be removed after the database connexion)
    int images[] = {R.drawable.download,R.drawable.compucity,R.drawable.flateo,R.drawable.sofrecom,R.drawable.technocode,R.drawable.tt};
    // database reference
    DatabaseReference dataBase;
    // Dynamic Company List for the test
    ArrayList<Entreprise> Companies = new ArrayList<>();

    // Entreprise fragment constructor (Required)
    public EntrepriseFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_entreprise, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);

//        Dynamic List will be commented after test
//        s1 = getResources ().getStringArray(R.array.Entreprises);

        //Creating Instance of my costomized  adapter

        MyAdapter2 myAdapter = new MyAdapter2( view.getContext(), Companies, images,this);
        recyclerView.setAdapter (myAdapter);
        // Selecting the Table named "Entreprises"

        dataBase = FirebaseDatabase.getInstance().getReference("Entreprises");
//        recyclerView.setHasFixedSize(true);
        dataBase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //fetching Data from the DataBase
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Entreprise entreprise = dataSnapshot.getValue(Entreprise.class);
                    Companies.add(entreprise);
//                    System.out.println(entreprise);
//                    Toast.makeText(EntrepriseFragment.this,"firebase connexion success",Toast.LENGTH_LONG).show();

                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //display 2 elements by line
        recyclerView.setLayoutManager(new GridLayoutManager( view.getContext(),2));
        return view;
    }

    @Override
    public void onNoteClick(int position) {

        Entreprise compan = Companies.get(position);
        //dynamic display of data from DataBase
        dialogBuilder =new AlertDialog.Builder(getActivity());
         View contactPopupView=getLayoutInflater().inflate(R.layout.activity_entreprise_details,  null);
        TextView textView = (TextView)contactPopupView.findViewById(R.id.Titre);
        textView.setText(compan.getNom());
        TextView textView1 = (TextView)contactPopupView.findViewById(R.id.description);
        textView1.setText(compan.getDescription());
            TextView textView2 = (TextView)contactPopupView.findViewById(R.id.lieu);
        textView2.setText(compan.getLieu());
        TextView textView3 = (TextView)contactPopupView.findViewById(R.id.secteur);
        textView3.setText(compan.getSecteur());
        TextView textView4 = (TextView)contactPopupView.findViewById(R.id.taille);
        textView4.setText(compan.getTaille());
        ImageView imageView = (ImageView)contactPopupView.findViewById(R.id.myImageView);
        imageView.setImageResource(images[position]);
        dialogBuilder.setView(contactPopupView);
//        dialogBuilder.
        dialog=dialogBuilder.create();
        dialog.show();
    }
}
