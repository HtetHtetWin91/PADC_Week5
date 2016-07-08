package com.example.user8.padc_week5.views.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user8.padc_week5.R;
import com.example.user8.padc_week5.data.vos.AttractionsVO;
import com.example.user8.padc_week5.fragments.AttractionFragment;

/**
 * Created by user8 on 7/7/2016.
 */
public class AttractionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView tvTitle;
    private ImageView ivPhoto;
    private TextView tvDesc;

    private AttractionsVO mAttraction;
   private AttractionFragment.ControllerAttractionItem mAttractionItemController;

    public AttractionViewHolder(View view, AttractionFragment.ControllerAttractionItem attractionItemController) {
        super(view);
        view.setOnClickListener(this);
        mAttractionItemController = attractionItemController;

        tvTitle = (TextView) view.findViewById(R.id.tv_attraction_title);
        ivPhoto = (ImageView) view.findViewById(R.id.iv_attraction_photo);
        tvDesc = (TextView) view.findViewById(R.id.tv_attraction_desc);

    }

    public void setData(AttractionsVO attraction) {
        this.mAttraction = attraction;

        tvTitle.setText(attraction.getTitle());
        tvDesc.setText(attraction.getDesc());

        Glide.with(ivPhoto.getContext())
                .load(attraction.getImgPath())
                .centerCrop()
              .placeholder(R.drawable.mrauku)
                .into(ivPhoto);
    }

    @Override
    public void onClick(View view)
    {
        mAttractionItemController.onTapEvent(mAttraction, ivPhoto);
    }

}
