package com.firebase.nikhilmanali.a100pi.presenter;


import android.util.Log;

import com.firebase.nikhilmanali.a100pi.Interface.viewInterface;
import com.firebase.nikhilmanali.a100pi.Model.JSONResponse;
import com.firebase.nikhilmanali.a100pi.Model.JSONSchema;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class presenterPi {

    public presenterPi(){}  // Self intializing constructor for presenter

    public List<JSONSchema> addItem(){    /// This method will return a list with which store Data in JSONSchema elements
        List<JSONSchema> list=new ArrayList<>();

        try {
            JSONObject jsonObject=new JSONObject(JSONResponse.response);
            JSONArray array=jsonObject.getJSONArray("result");

            for(int i=0;i<array.length();i++){
                JSONObject object=array.getJSONObject(i);
                list.add(new JSONSchema(object.getString("Currency"),object.getString("CurrencyLong"),object.getDouble("TxFee"),object.getInt("MinConfirmation")));
            }
        }catch (Exception e){
            Log.d("error",e+"");
        }
        return list;
    }



}



