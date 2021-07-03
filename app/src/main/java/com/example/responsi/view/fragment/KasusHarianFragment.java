package com.example.responsi.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.responsi.R;
import com.example.responsi.adapter.KasusHarianAdapter;
import com.example.responsi.model.kasus_harian.ContentItem;
import com.example.responsi.view.viewmodel.KasusHarianViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KasusHarianFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KasusHarianFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private KasusHarianAdapter kasusHarianAdapter;
    private RecyclerView rvKasusHarian;
    private KasusHarianViewModel kasusHarianViewModel;

    public KasusHarianFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KasusFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static KasusHarianFragment newInstance(String param1, String param2) {
        KasusHarianFragment fragment = new KasusHarianFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kasus_harian, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,true);
        linearLayoutManager.setStackFromEnd(true);

        kasusHarianAdapter = new KasusHarianAdapter(getContext());
        kasusHarianAdapter.notifyDataSetChanged();

        rvKasusHarian = view.findViewById(R.id.rv_kasus_harian);
        rvKasusHarian.setLayoutManager(linearLayoutManager);

        kasusHarianViewModel = new ViewModelProvider(this).get(KasusHarianViewModel.class);
        kasusHarianViewModel.setKasusHarian();
        kasusHarianViewModel.getKasusHarian().observe(getViewLifecycleOwner() ,getKasusHarian);

        rvKasusHarian.setAdapter(kasusHarianAdapter);
    }

    private Observer<ArrayList<ContentItem>> getKasusHarian = new Observer<ArrayList<ContentItem>>() {
        @Override
        public void onChanged(ArrayList<ContentItem> kasusHarianDataItems) {
            if(kasusHarianDataItems != null){
                kasusHarianAdapter.setData(kasusHarianDataItems);
            }
        }
    };
}