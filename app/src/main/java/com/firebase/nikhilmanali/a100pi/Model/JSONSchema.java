package com.firebase.nikhilmanali.a100pi.Model;

/**
 * Created by Nikhil Manali on 10/30/2018.
 */

public class JSONSchema {

    String Currency;
    String CurrencyLong;
    Double TxFee;
    int MinConfirmation;


   public JSONSchema(String Currency,String CurrencyLong,Double TxFee,int MinConfirmation){
       this.Currency=Currency;
       this.CurrencyLong=CurrencyLong;
       this.TxFee=TxFee;
       this.MinConfirmation=MinConfirmation;
   }


    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public String getCurrencyLong() {
        return CurrencyLong;
    }

    public void setCurrencyLong(String currencyLong) {
        CurrencyLong = currencyLong;
    }

    public Double getTxFee() {
        return TxFee;
    }

    public void setTxFee(double txFee) {
        TxFee = txFee;
    }


    public int getMinConfirmation() {
        return MinConfirmation;
    }

    public void setMinConfirmation(int minConfirmation) {
        MinConfirmation = minConfirmation;
    }


}
