package com.example.user8.padc_week5.data.vos;

import java.util.Date;

/**
 * Created by user8 on 7/7/2016.
 */
public class AttractionsVO {

    private String title;

    private String desc;

    private String imgPath;

    public AttractionsVO(String title, String imgPath, String desc) {
        this.title = title;
        this.imgPath = imgPath;
        this.desc = desc;

    }

    public String getTitle() {
        return title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getDesc() {
        return desc;
    }



}
