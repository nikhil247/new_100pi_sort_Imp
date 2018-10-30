package com.firebase.nikhilmanali.a100pi.View;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import com.firebase.nikhilmanali.a100pi.R;
import com.firebase.nikhilmanali.a100pi.presenter.presenterPi;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    Adapter adapter;
    presenterPi presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init(); // Intialize all the views
        recyclerView.setAdapter(adapter);   // Set adapter in recycler view without any filter
    }

    public void init(){
        presenter=new presenterPi();
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new Adapter(presenter.addItem());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.sort_dialog: // Dialog Box will appear to sort the item Ascending and Descending accordingly.

                final Dialog dialog = new Dialog(MainActivity.this);

                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.sorting_dialog);

                final Button sort_btn=(Button) dialog.findViewById(R.id.sort_btn);
                final RadioButton asc=(RadioButton) dialog.findViewById(R.id.asc);
                final RadioButton dsc=(RadioButton) dialog.findViewById(R.id.asc);

                final RadioButton Currency=(RadioButton) dialog.findViewById(R.id.sort_currency);
                final RadioButton MinConfirmation=(RadioButton) dialog.findViewById(R.id.sort_minconfirm);
                final RadioButton TxFee=(RadioButton) dialog.findViewById(R.id.sort_txfee);


                sort_btn.setOnClickListener(new View.OnClickListener() { // On clicking sort Button
                    @Override
                    public void onClick(View v) {

                        if(asc.isChecked()) {  // If ascending is checked then sort

                            if(Currency.isChecked()){  // Currency in ASC
                                adapter=new Adapter(presenter.addItem(),"asc","Currency");
                            }else if(MinConfirmation.isChecked()){   // MinConfirmation in ASC
                                adapter=new Adapter(presenter.addItem(),"asc","MinConfirmation");
                            }else{   // TxFee in ASC
                                adapter=new Adapter(presenter.addItem(),"asc","TxFee");
                            }

                        }else {   //If descending is checked then sort

                            if(Currency.isChecked()){ // Currency in DSC
                                adapter=new Adapter(presenter.addItem(),"dsc","Currency");
                            }else if(MinConfirmation.isChecked()){ // MinConfirmation in DSC
                                adapter=new Adapter(presenter.addItem(),"dsc","MinConfirmation");
                            }else{ // TxFee in DSC
                                adapter=new Adapter(presenter.addItem(),"dsc","TxFee");
                            }
                        }

                        recyclerView.setAdapter(adapter);
                        dialog.cancel();
                    }
                });
                dialog.show();
                break;
            default:
                break;
        }
        return true;
    }

}
