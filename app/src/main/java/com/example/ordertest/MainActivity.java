package com.example.ordertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_receiving_address, tv_shipping_address, tv_name, tv_telephone_number, tv_distribution;
    private static String[] message = new String[6];
    private int tag = 0;
    private static String receiving_address = "福建省福州市仓山区",
            shipping_address = "北京金山小区12#409",
            name = "王大力",
            telephone_number = "13999999999",
            distribution = "同城配送 免运费";
    private ImageButton ibtn_new_address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        find_view();
        getMessage();
        ibtn_new_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddressActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    public void find_view(){
        tv_receiving_address = findViewById(R.id.tv_receiving_address);
        tv_shipping_address = findViewById(R.id.tv_consignor);
        tv_name = findViewById(R.id.tv_name);
        tv_telephone_number = findViewById(R.id.tv_number);
        tv_distribution = findViewById(R.id.tv_distribution);
        ibtn_new_address = findViewById(R.id.ibtn_new_address);
    }

    public void setMessage(){
        tv_receiving_address.setText(message[2]);
        tv_shipping_address.setText(message[3]);
        tv_name.setText(message[0]);
        tv_telephone_number.setText(message[1]);
        tv_distribution.setText(message[4]);
    }

    public void getMessage(){
        Bundle bundle = this.getIntent().getExtras();
        try {
            tag = bundle.getInt("save_tag");
        }catch (Exception e){

        }
        if(tag == 1){
            String[] consignor_message = new String[5];
            consignor_message = bundle.getStringArray("consignor_message");
            message[0] = consignor_message[0];
            message[1] = consignor_message[1];
            message[2] = consignor_message[2];
            message[3] = consignor_message[3];
            message[4] = "同城配送 免运费";
            setMessage();
        }
    }
}
