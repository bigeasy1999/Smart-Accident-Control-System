package com.innovativeideas.smartacsvbeta3;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Set;

public class MainActivity extends AppCompatActivity {
    Button button;
    ListView listView;
    BluetoothAdapter mba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        listView=findViewById(R.id.listview);
        mba=BluetoothAdapter.getDefaultAdapter();
        exeButton();

    }

    private void exeButton() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Set<BluetoothDevice> bt=mba.getBondedDevices();
                String[] strings=new String[bt.size()];
                int index=0;

                if(bt.size()>0){
                    for(BluetoothDevice device:bt) {
                        strings[index] = device.getName();
                        index++;
                        }
                    ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,strings);
                    listView.setAdapter(arrayAdapter);
                    }
                }
            });
        }
    }
