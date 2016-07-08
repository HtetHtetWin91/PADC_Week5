package com.example.user8.padc_week5.fragments;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.user8.padc_week5.R;
import com.example.user8.padc_week5.adapters.AttractionAdapter;
import com.example.user8.padc_week5.data.models.AttractionsModel;
import com.example.user8.padc_week5.data.vos.AttractionsVO;

/**
 * A placeholder fragment containing a simple view.
 */
public class AttractionFragment extends Fragment {

    private AttractionAdapter mAttractionAdapter;
    private ControllerAttractionItem mAttractionItemController;

    public static AttractionFragment newInstance() {
        return new AttractionFragment();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mAttractionItemController = (ControllerAttractionItem) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAttractionAdapter = new AttractionAdapter(AttractionsModel.getInstance().getAttractionsList(),mAttractionItemController);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attraction, container, false);
        RecyclerView rvEvent = (RecyclerView) view.findViewById(R.id.rv_attractions);
        rvEvent.setAdapter(mAttractionAdapter);
        rvEvent.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);//ms
            }
        });
        return view;

    }

    public interface ControllerAttractionItem {
        void onTapEvent(AttractionsVO attraction, ImageView ivPhoto);//user action mhan ta mya Controller interface htae mhar htae
    }
}
