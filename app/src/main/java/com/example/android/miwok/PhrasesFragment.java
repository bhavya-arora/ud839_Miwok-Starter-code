package com.example.android.miwok;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhrasesFragment extends Fragment {

    LinearLayout rootLayout;
    ListView list_phrase;


    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_phrases, container, false);
        ArrayList<info> arrayList = new ArrayList<info>();
        arrayList.add(new info("Bhavya", "Cse", R.raw.family_daughter));
        arrayList.add(new info("Preet", "Bca", R.raw.family_father));
        arrayList.add(new info("Mohit", "Cse", R.raw.family_grandfather));
        arrayList.add(new info("Deepanshu", "Mech", R.raw.family_grandmother));
        arrayList.add(new info("Monu", "Cse", R.raw.family_mother));
        arrayList.add(new info("Lakshay", "Ece", R.raw.family_older_brother));
        arrayList.add(new info("Ashish", "Cse", R.raw.family_son));
        arrayList.add(new info("Shivam", "Eee", R.raw.family_younger_brother));
        arrayList.add(new info("Ambesh", "Cse", R.raw.family_younger_sister));
        arrayList.add(new info("Shubham", "Cse-B", R.raw.family_mother));
        list_phrase = new ListView(getActivity());
        customerAdapter bhavyaAdapter = new customerAdapter(getActivity(), arrayList, R.color.category_phrases);
        list_phrase = (ListView) rootView.findViewById(R.id.list_phrase);
        list_phrase.setAdapter(bhavyaAdapter);
        return rootView;
    }

}
