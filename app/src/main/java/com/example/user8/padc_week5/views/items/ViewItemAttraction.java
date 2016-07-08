package com.example.user8.padc_week5.views.items;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.example.user8.padc_week5.R;
import com.example.user8.padc_week5.data.vos.AttractionsVO;

/**
 * Created by user8 on 7/7/2016.
 */
public class ViewItemAttraction extends CardView {

    private TextView tvTitle;
    private ImageView ivPhoto;
    private TextView tvDesc;


    public ViewItemAttraction(Context context) {
        super(context);
    }

    public ViewItemAttraction(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewItemAttraction(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        tvTitle = (TextView) findViewById(R.id.tv_attraction_title);
        ivPhoto = (ImageView) findViewById(R.id.iv_attraction_photo);
        tvDesc = (TextView) findViewById(R.id.tv_attraction_desc);

    }

    public void setData(AttractionsVO attraction) {
        tvTitle.setText(attraction.getTitle());
        tvDesc.setText(attraction.getDesc());


        Glide.with(getContext())
                .load(attraction.getImgPath())
                .centerCrop()
               .placeholder(R.drawable.mrauku)
                .into(ivPhoto);
    }
}
