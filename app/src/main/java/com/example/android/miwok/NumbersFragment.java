package com.example.android.miwok;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {
    MediaPlayer mediaPlayer;
    String TAG = "bhavya";
    ListView list;

    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "under OncreateView");
       ////////Inflating the layout from xml resource/////////////////
        View rootView = inflater.inflate(R.layout.activity_numbers, container, false);
        Log.i(TAG, "After rootView");
        list = (ListView) rootView.findViewById(R.id.list);
        Log.i(TAG, "after listView");
        final ArrayList<info> arrayList = new ArrayList<info>();
        Log.i(TAG, "after arrayList");
        //////ArrayList is generic type it also accepts instance of an class
        /////That's why we gave a instance of info class with set of arguments////////////
        arrayList.add(new info("Bhavya", "Cse", R.drawable.family_father, R.raw.number_one));
        arrayList.add(new info("Preet", "Bca", R.drawable.family_grandfather, R.raw.number_two));
        arrayList.add(new info("Mohit", "Cse", R.drawable.family_older_brother, R.raw.number_three));
        arrayList.add(new info("Deepanshu", "Mech", R.drawable.family_son, R.raw.number_four));
        arrayList.add(new info("Monu", "Cse", R.drawable.family_younger_brother, R.raw.number_five));
        arrayList.add(new info("Lakshay", "Ece", R.drawable.family_father, R.raw.number_six));
        arrayList.add(new info("Ashish", "Cse", R.drawable.family_grandfather, R.raw.number_seven));
        arrayList.add(new info("Shivam", "Eee", R.drawable.family_older_brother, R.raw.number_eight));
        arrayList.add(new info("Ambesh", "Cse", R.drawable.family_son, R.raw.number_nine));
        arrayList.add(new info("Shubham", "Cse-B", R.drawable.family_younger_brother, R.raw.number_ten));
        Log.i(TAG, "Before CustomAdapter");
        ////////MISTAKE----------------It's CustomAdapter----------------
        ///////Customer Adapter is responsible of getting information of each list item from
        ///////the info class of particular instance and putting in list view
        customerAdapter bhavyaAdapter = new customerAdapter(getActivity(), arrayList, R.color.category_numbers);
        Log.i(TAG, "After CustomAdapter");
        list.setAdapter(bhavyaAdapter);
        Log.i(TAG, "After setAdapter");

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                info in = arrayList.get(i);
                Log.v("Numbers", "info " + in);
                releaseResources();
                mediaPlayer = MediaPlayer.create(getActivity(), in.getAudioResourceId());
                mediaPlayer.start();

              //////////This is triggered when mediaplayer is done plYING THE SOng////////
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(getActivity(), "Playing", Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseResources();
    }
////////////THis will check if mediaplayer is alreaddy null
    ///////if not it will release resources and null the mediaplayer object
    public void releaseResources() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}
