package com.example.user8.padc_week5.data.models;

import com.example.user8.padc_week5.data.vos.AttractionsVO;
import com.example.user8.padc_week5.utils.CommonInstances;
import com.example.user8.padc_week5.utils.JsonUtils;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user8 on 7/7/2016.
 */
public class AttractionsModel {
    private static final String DUMMY_ATTRACTIONS_LIST = "myanmar_attractions.json";

    private static AttractionsModel objInstance;

    private List<AttractionsVO> attractionsList;

    private AttractionsModel(){
        attractionsList = initializeAttractionsList();
    }

    public static AttractionsModel getInstance(){
        if(objInstance == null) {
            objInstance = new AttractionsModel();
        }

        return objInstance;
    }

    private List<AttractionsVO> initializeAttractionsList() {
        List<AttractionsVO> attractionsList = new ArrayList<>();

        try {
            String dummyAttractionsList = JsonUtils.getInstance().loadDummyData(DUMMY_ATTRACTIONS_LIST);
            Type listType = new TypeToken<List<AttractionsVO>>() {
            }.getType();
            attractionsList = CommonInstances.getGsonInstance().fromJson(dummyAttractionsList, listType);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return attractionsList;
    }

    public List<AttractionsVO> getAttractionsList() {
        return attractionsList;
    }


    public AttractionsVO getAttractionByTitle(String title) {
        for (AttractionsVO attraction : attractionsList) {
            if (attraction.getTitle().equals(title)) {
                return attraction;
            }
        }
        return null;
    }
}
