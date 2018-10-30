package com.firebase.nikhilmanali.a100pi.presenter;


import com.firebase.nikhilmanali.a100pi.Interface.viewInterface;
import com.firebase.nikhilmanali.a100pi.Model.JSONResponse;
import com.firebase.nikhilmanali.a100pi.Model.JSONSchema;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class presenterPi {


    List<JSONSchema> list;
    public presenterPi(){
        list=new ArrayList<>();
           addItem();

    }

    public void onBindViewAtPosition(int position,viewInterface view) {
                 JSONSchema schema=list.get(position);
                 view.setCurrency(schema.getCurrency());
                 view.setCurrencyLong(schema.getCurrencyLong());
                 view.setTxFee(schema.getTxFee());

    }

    public void addItem(){

        try {
            JSONObject jsonObject=new JSONObject(JSONResponse.response);
            JSONArray array=jsonObject.getJSONArray("result");

            for(int i=0;i<array.length();i++){
                JSONObject object=array.getJSONObject(i);
                list.add(new JSONSchema(object.getString("Currency"),object.getString("CurrencyLong"),object.getString("TxFee")));
            }
        }catch (Exception e){

        }
    }

    public int listSize(){
        return list.size();
    }

}



