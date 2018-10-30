package com.firebase.nikhilmanali.a100pi.View;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.firebase.nikhilmanali.a100pi.Model.JSONSchema;
import com.firebase.nikhilmanali.a100pi.R;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{


    List<JSONSchema> list;

    public Adapter(List<JSONSchema> list){
        this.list=list;  // intialize the unsorted list
    }

    public Adapter(List<JSONSchema> list,String order,String category){
        this.list=list;
        if(order.equals("asc")){  // Sort the list in Ascending order

            if(category.equals("Currency")){
                Collections.sort(list, new sortbycurrency());
            }else if(category.equals("MinConfirmation")){
                Collections.sort(list, new sortbyminConfirmation());
            }else {
                Collections.sort(list, new sortbyTxfee());
            }
        }else {  // Sort the list in Descending order

            if(category.equals("Currency")){
               Collections.sort(list, new sortbycurrency());
               Collections.reverse(list);  // sort in reverse order i.e In Descending order
           }else if(category.equals("MinConfirmation")){
               Collections.sort(list, new sortbyminConfirmation());
               Collections.reverse(list);
           }else {
               Collections.sort(list, new sortbyTxfee());
               Collections.reverse(list);
           }

       }

    }



    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Adapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_recycler_view, parent, false));
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        holder.Currency.setText(list.get(position).getCurrency());
        holder.CurrencyLong.setText(list.get(position).getCurrencyLong());
        holder.TxFee.setText(list.get(position).getTxFee()+"");
        holder.MinConfirmation.setText(list.get(position).getMinConfirmation()+"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        TextView Currency,CurrencyLong,TxFee,MinConfirmation;
        public ViewHolder(View itemView) {
            super(itemView);
            Currency=(TextView) itemView.findViewById(R.id.currency);
            CurrencyLong=(TextView) itemView.findViewById(R.id.currencyLong);
            TxFee=(TextView) itemView.findViewById(R.id.txfee);
            MinConfirmation=(TextView) itemView.findViewById(R.id.minConf);
        }

    }


// Sorting Interface

    class sortbycurrency implements Comparator<JSONSchema>  // Sort the Currency in Ascending order
    {
        public int compare(JSONSchema a, JSONSchema b)
        {
            return a.getCurrency().compareTo(b.getCurrency());
        }
    }

    class sortbyTxfee implements Comparator<JSONSchema>   // Sort the TxFee in Descending order
    {
        public int compare(JSONSchema a, JSONSchema b)
        {
            if (a.getTxFee() < b.getTxFee()) return -1;
            if (a.getTxFee() > b.getTxFee()) return 1;
            return 0;
        }
    }

    class sortbyminConfirmation implements Comparator<JSONSchema>  // Sort the MinConfirmation in Descending order
    {
        public int compare(JSONSchema a, JSONSchema b)
        {
            return a.getMinConfirmation() - b.getMinConfirmation();
        }
    }

}
