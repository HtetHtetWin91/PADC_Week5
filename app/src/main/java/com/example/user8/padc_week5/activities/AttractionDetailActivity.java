package com.example.user8.padc_week5.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user8.padc_week5.R;
import com.example.user8.padc_week5.Week5App;
import com.example.user8.padc_week5.data.models.AttractionsModel;
import com.example.user8.padc_week5.data.vos.AttractionsVO;

/**
 * Created by user8 on 7/8/2016.
 */
public class AttractionDetailActivity extends AppCompatActivity {
    private static final String IE_ATTRACTION_TITLE = "IE_ATTRACTION_TITLE";

    private ImageView ivPhoto;
    private TextView tvDesc;

    private String attractionTitle;
    private AttractionsVO attraction ;

    private CollapsingToolbarLayout collapsingToolbar;

    public static Intent newIntent(String attractionTitle) {
        Intent intent = new Intent(Week5App.getContext(), AttractionDetailActivity.class);
        intent.putExtra(IE_ATTRACTION_TITLE, attractionTitle);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {

            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_register);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, attraction.getImgPath());
                startActivity(Intent.createChooser(shareIntent, "Share link using"));
            }
        });




        ivPhoto = (ImageView) findViewById(R.id.iv_stock_photo);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Context context = Week5App.getContext();
            String transitionName = context.getResources().getString(R.string.attraction_photo_shared_transition);
            ivPhoto.setTransitionName(transitionName);
        }
        tvDesc = (TextView) findViewById(R.id.tv_attraction_desc);

        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        attractionTitle = getIntent().getStringExtra(IE_ATTRACTION_TITLE);
        attraction = AttractionsModel.getInstance().getAttractionByTitle(attractionTitle);


        if(attraction == null) {
            throw new RuntimeException("Can't find Event obj with the title : "+attractionTitle);
        } else {
            collapsingToolbar.setTitle(attraction.getTitle());
            tvDesc.setText(attraction.getDesc()  );


            Glide.with(ivPhoto.getContext())
                    .load(attraction.getImgPath())
                    .centerCrop()
                    .placeholder(R.drawable.yangon)
                    .into(ivPhoto);
        }
    }
}
