package com.example.ordertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class AddressActivity extends AppCompatActivity {

    private ImageButton ibtn_back, ibtn_change;
    private EditText et_name, et_number, et_address, et_detailed_address;
    private Button btn_save;
    private int tag = 0;
    private int is_save = 0;
    private String[] message = new String[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        findview();
        ibtn_change.setBackgroundResource(R.drawable.off);
        ibtn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tag == 0) {
                    ibtn_change.setBackgroundResource(R.drawable.on);
                    tag = 1;
                }
                else{
                    ibtn_change.setBackgroundResource(R.drawable.off);
                    tag = 0;
                }
            }
        });
        ibtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddressActivity.this, MainActivity.class);
                if(is_save == 1){
//                    intent.putExtra("consignor_message", message);
//                    getIntent().putExtra("save_tag", 1);
                    Bundle bundle = new Bundle();
                    bundle.putStringArray("consignor_message", message);
                    bundle.putInt("save_tag", 1);
                    intent.putExtras(bundle);
                }
                startActivity(intent);
            }
        });
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                is_save = 1;
                message[0] = et_name.getText().toString();
                message[1] = et_number.getText().toString();
                message[2] = et_address.getText().toString();
                message[3] = et_detailed_address.getText().toString();

//                getIntent().putExtra("consignor_message", message);
//                getIntent().putExtra("save_tag", 1);

//                Toast.makeText(AddressActivity.this, "保存成功", Toast.LENGTH_SHORT);
            }
        });
    }

    public void findview(){
        ibtn_back = findViewById(R.id.ibtn_back);
        ibtn_change = findViewById(R.id.ibtn_change);
        btn_save = findViewById(R.id.btn_save);
        et_name = findViewById(R.id.et_name);
        et_address = findViewById(R.id.et_address);
        et_detailed_address = findViewById(R.id.et_detailed_address);
        et_number = findViewById(R.id.et_number);
    }
}
