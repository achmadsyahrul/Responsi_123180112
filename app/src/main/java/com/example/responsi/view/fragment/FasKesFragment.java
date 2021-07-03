package com.example.responsi.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.responsi.R;
import com.example.responsi.adapter.FasKesAdapter;
import com.example.responsi.model.fas_kes.DataItem;
import com.example.responsi.view.viewmodel.FasKesViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FasKesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FasKesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FasKesAdapter fasKesAdapter;
    private RecyclerView recyclerView;
    private FasKesViewModel fasKesViewModel;

    public FasKesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RujukanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FasKesFragment newInstance(String param1, String param2) {
        FasKesFragment fragment = new FasKesFragment();
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
        return inflater.inflate(R.layout.fragment_fas_kes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fasKesAdapter = new FasKesAdapter(getContext());
        fasKesAdapter.notifyDataSetChanged();

        recyclerView = view.findViewById(R.id.rv_fas_kes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        fasKesViewModel = new ViewModelProvider(this).get(FasKesViewModel.class);
        fasKesViewModel.setFasKes();
        fasKesViewModel.getFasKes().observe(getViewLifecycleOwner(),getFasKes);

        recyclerView.setAdapter(fasKesAdapter);
    }

    private Observer<ArrayList<DataItem>> getFasKes = new Observer<ArrayList<DataItem>>() {
        @Override
        public void onChanged(ArrayList<DataItem> fasKesDataItems) {
            if (fasKesDataItems != null){
                fasKesAdapter.setData(fasKesDataItems);
            }
        }
    };
}