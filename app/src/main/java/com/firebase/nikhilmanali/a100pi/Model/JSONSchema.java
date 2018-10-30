package com.firebase.nikhilmanali.a100pi.Model;

/**
 * Created by Nikhil Manali on 10/30/2018.
 */

public class JSONSchema {

    String Currency;
    String CurrencyLong;
    String TxFee;


   public JSONSchema(String Currency,String CurrencyLong,String TxFee){
       this.Currency=Currency;
       this.CurrencyLong=CurrencyLong;
       this.TxFee=TxFee;
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

    public String getTxFee() {
        return TxFee;
    }

    public void setTxFee(String txFee) {
        TxFee = txFee;
    }



}
