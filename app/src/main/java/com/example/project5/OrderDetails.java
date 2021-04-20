package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class OrderDetails extends AppCompatActivity {
    TotalOrder totalOrder = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_details);
        totalOrder = (TotalOrder) getIntent().getSerializableExtra("total_order");
        TextView size = findViewById(R.id.FinalCoffeeSize);
        size.setText(totalOrder.totalCoffeeOrder.size.toString());

        LinearLayout list = findViewById(R.id.CoffeeFinalAddOns);
        for(String id:totalOrder.totalCoffeeOrder.addOns){
            TextView textView = new TextView(this);
            textView.setText(id);
            textView.setGravity(Gravity.RIGHT);
            list.addView(textView);
        }

        TextView salesTax = findViewById(R.id.SalesTax);
        String formatted = new DecimalFormat("#.##").format(totalOrder.salesTax);
        salesTax.setText(formatted);

        TextView totalTextView = findViewById(R.id.OrderTotalTax);
        formatted = new DecimalFormat("#.##").format(totalOrder.total);
        totalTextView.setText(formatted);
    }
}