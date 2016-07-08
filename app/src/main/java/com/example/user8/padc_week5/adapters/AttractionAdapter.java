package com.example.user8.padc_week5.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user8.padc_week5.R;
import com.example.user8.padc_week5.Week5App;
import com.example.user8.padc_week5.data.vos.AttractionsVO;
import com.example.user8.padc_week5.fragments.AttractionFragment;
import com.example.user8.padc_week5.views.holder.AttractionViewHolder;

import java.util.List;

/**
 * Created by user8 on 7/7/2016.
 */
public class AttractionAdapter extends RecyclerView.Adapter<AttractionViewHolder> {
    private LayoutInflater inflater;
    private List<AttractionsVO> attractionList;
    private AttractionFragment.ControllerAttractionItem mAttractionItemController;




    public AttractionAdapter(List<AttractionsVO> attractionList, AttractionFragment.ControllerAttractionItem attractionItemController) {
        inflater = LayoutInflater.from(Week5App.getContext());
        this.attractionList = attractionList;
        mAttractionItemController = attractionItemController;
    }

    @Override
    public AttractionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.view_item_attraction, parent, false);
        final AttractionViewHolder attractionVH = new AttractionViewHolder(view, mAttractionItemController);
        return attractionVH;
    }

    @Override
    public void onBindViewHolder(AttractionViewHolder holder, int position) {
        holder.setData(attractionList.get(position));
    }

    @Override
    public int getItemCount() {
        return attractionList.size();
    }
}
