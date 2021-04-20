package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CoffeeOrder extends AppCompatActivity {
    TotalOrder totalOrder = null;
    TextView total = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coffee_order);
        total = findViewById(R.id.coffeeTotal);
//        totalOrder = (TotalOrder) getIntent().getSerializableExtra("total_order");
    }

    public void sizeSelected(View sizeSelected) {
        switch (sizeSelected.getId()) {
            case (R.id.short_size):
                totalOrder.totalCoffeeOrder.size = Size.SHORT;
            case (R.id.tall_size):
                totalOrder.totalCoffeeOrder.size = Size.TALL;
            case (R.id.grande_size):
                totalOrder.totalCoffeeOrder.size = Size.GRANDE;
            case (R.id.venti_size):
                totalOrder.totalCoffeeOrder.size = Size.VENTI;
        }
        recalculateTotal();
    }

    public void addOnsSelected(View selected) {
        TextView selectedAddOn = (TextView)selected;
        if (totalOrder.totalCoffeeOrder.addOns.contains(selectedAddOn.getText())) {
            totalOrder.totalCoffeeOrder.addOns.remove(selectedAddOn.getText());
        } else {
            totalOrder.totalCoffeeOrder.addAddOn((String) selectedAddOn.getText());
        }
        if (totalOrder.totalCoffeeOrder.size != null) {
            recalculateTotal();
        }
    }

    public void recalculateTotal() {
        totalOrder.totalCoffeeOrder.total = totalOrder.totalCoffeeOrder.size.price() + (totalOrder.totalCoffeeOrder.addOns.size() * .20);
        totalOrder.setTotal(totalOrder.totalCoffeeOrder.total);
        String formatted = new DecimalFormat("#.##").format(totalOrder.totalCoffeeOrder.total);
        total.setText(formatted);
        this.getIntent().putExtra("total_order", totalOrder);

    }

    public enum Size {
        SHORT {
            public double price() {
                return 1.99;
            }
        },
        TALL {
            public double price() {
                return 2.49;
            }
        },
        GRANDE {
            public double price() { 
                return 2.99;
            }
        },
        VENTI {
            public double price() {
                return 3.49;
            }
        };

        public abstract double price();
    }

    public void OrderDetailButton(View orderDetailButton) {
        Intent intent = new Intent(this, OrderDetails.class);
        intent.putExtra("total_order", totalOrder);
        startActivity(intent);
    }
}