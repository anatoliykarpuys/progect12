package com.example.myapplication.Activity;

import android.os.Bundle;
import android.view.View;
import com.example.myapplication.databinding.ActivityCartBinding;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.Adapter.CartAdapter;
import com.example.myapplication.Helper.ChangeNumberItemsListener;
import com.example.myapplication.Helper.ManagmentCart;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityCartBinding;

public class CartActivity extends AppCompatActivity {
    private ActivityCartBinding binding;
    private double tax;
    private ManagmentCart managmentCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        managmentCart=new ManagmentCart(this);

        calculatorCart();
        setVariable();
        initCartList();

    }

    private void initCartList() {
        if (managmentCart.getListCart().isEmpty()){
            binding.emptyTxt.setVisibility(View.VISIBLE);
            binding.scrollView3.setVisibility(View.GONE);
        }else{
            binding.emptyTxt.setVisibility(View.GONE);
            binding.scrollView3.setVisibility(View.VISIBLE);
        }

        binding.cartView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.cartView.setAdapter(new CartAdapter(managmentCart.getListCart(), this, this::calculatorCart));
    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(v -> finish());
    }

    private void calculatorCart() {
        double percentTax=0.02;
        double delivey=10;
        tax=Math.round(managmentCart.getTotalFee()*percentTax*100.0)/100.0;

        double total=Math.round((managmentCart.getTotalFee()+tax+delivey)*100.0)/100.0;
        double itemTotal=Math.round((managmentCart.getTotalFee()*100.0))/100.0;
        binding.totalFeeTxt.setText("$"+itemTotal);
        binding.taxTxt.setText("$"+delivey);
        binding.deliveryTxt.setText("$"+delivey);
        binding.totalTxt.setText("$"+total);

    }
}