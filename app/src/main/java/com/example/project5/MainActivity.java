package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    TotalOrder totalOrder = new TotalOrder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TotalOrder total = (TotalOrder) getIntent().getSerializableExtra("total_order");
        if(total != null){
            this.totalOrder = total;
        }
    }

    public void orderCoffee(View view){
        Intent intent = new Intent(this, CoffeeOrder.class);
        intent.putExtra("total_order", totalOrder);
        startActivity(intent);
    }

}