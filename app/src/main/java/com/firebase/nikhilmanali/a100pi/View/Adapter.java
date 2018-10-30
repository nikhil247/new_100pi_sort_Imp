package com.firebase.nikhilmanali.a100pi.View;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.nikhilmanali.a100pi.Interface.viewInterface;
import com.firebase.nikhilmanali.a100pi.R;
import com.firebase.nikhilmanali.a100pi.presenter.presenterPi;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

     presenterPi presenter;

    public Adapter(){
        presenter=new presenterPi();
    }



    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Adapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_recycler_view, parent, false));
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
           presenter.onBindViewAtPosition(position,holder);
    }

    @Override
    public int getItemCount() {
        return presenter.listSize();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements viewInterface {

        TextView Currency,CurrencyLong,TxFee;
        public ViewHolder(View itemView) {
            super(itemView);
            Currency=(TextView) itemView.findViewById(R.id.currency);
            CurrencyLong=(TextView) itemView.findViewById(R.id.currencyLong);
            TxFee=(TextView) itemView.findViewById(R.id.txfee);
        }

        @Override
        public void setCurrency(String currency) {
              Currency.setText(currency);
        }

        @Override
        public void setCurrencyLong(String currencyLong) {
            CurrencyLong.setText(currencyLong);

        }

        @Override
        public void setTxFee(String fee) {
            TxFee.setText(fee);
        }
    }
}
