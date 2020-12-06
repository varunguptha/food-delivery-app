package com.example.food_delivery;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

class food{
    static int id;
    String name;
    int price;
    int quantity;
    food(String name,int price){
        this.name = name;
        this.price = price;
        id++;
        quantity =0;
    }
    void Increment(){
        ++quantity;
    }
    void Decrement(){--quantity;}
    int totalprice(){
        return quantity*price;
    }


}

public class menu extends AppCompatActivity {
    TextView txt1,txt2,txt3,txt4,txt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt8);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);


    }


    food f1 = new food("Hyderabad Biryani",250);
    food f2 = new food("Panner Tikka",150);
    food f3 = new food("Ice-Cream",80);
    food f4 = new food("Milkshake",50);
    food f5 = new food("Chicken Roll",150);

    @SuppressLint("DefaultLocale")
    public void onClickFood1(View view){
        f1.Increment();
        txt1.setText(String.format(" x%d", f1.quantity));
    }
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public void onClickFood2(View view){
        f2.Increment();
        txt2.setText(String.format(" x%d", f2.quantity));
    }
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public void onClickFood3(View view){
        f3.Increment();
        txt3.setText(String.format(" x%d", f3.quantity));
    }
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public void onClickFood4(View view){
        f4.Increment();
        txt4.setText(String.format(" x%d", f4.quantity));
    }
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public void onClickFood5(View view){
        f5.Increment();
        txt5.setText(String.format(" x%d", f5.quantity));
    }

    @SuppressLint("SetTextI18n")
    public void delt1(View view){
        if (f1.quantity>0) {
            f1.Decrement();
            txt1.setText(" x" + f1.quantity);
        }
    }
    @SuppressLint("SetTextI18n")
    public void delt2(View view){
        if (f2.quantity>0) {
            f2.Decrement();
            txt2.setText(" x" + f2.quantity);
        }
    }
    @SuppressLint("SetTextI18n")
    public void delt3(View view){
        if (f3.quantity>0) {
            f3.Decrement();
            txt3.setText(" x" + f3.quantity);
        }
    } @SuppressLint("SetTextI18n")
    public void delt4(View view){
        if (f4.quantity>0) {
            f4.Decrement();
            txt4.setText(" x" + f4.quantity);
        }
    } @SuppressLint("SetTextI18n")
    public void delt5(View view){
        if (f5.quantity>0) {
            f5.Decrement();
            txt5.setText(" x" + f5.quantity);
        }
    }



    public void cartFinal(View view){
        StringBuilder sb = new StringBuilder();
        sb.append(" Your cart Items :\n ----------------------------------------------------\n");
        sb.append("       Name                   ").append("  Price    ").append("  Quantity    ").append("  Total Price    \n--------------------------------------------------------------------------------------\n");
        if (f1.totalprice()>0)
            sb.append(" "+f1.name+"       ").append(f1.price+"             ").append(f1.quantity+"                   ").append(f1.totalprice()+"      \n");
        if (f2.totalprice()>0)
            sb.append(" "+f2.name+"                ").append(f2.price+"             ").append(f2.quantity+"                   ").append(f2.totalprice()+"      \n");
        if (f3.totalprice()>0)
            sb.append(" "+f3.name+"                       ").append(f3.price+"             ").append(f3.quantity+"                   ").append(f3.totalprice()+"      \n");
        if (f4.totalprice()>0)
            sb.append(" "+f4.name+"                       ").append(f4.price+"             ").append(f4.quantity+"                   ").append(f4.totalprice()+"      \n");
        if (f5.totalprice()>0)
            sb.append(" "+f5.name+"                 ").append(f5.price+"             ").append(f5.quantity+"                   ").append(f5.totalprice()+"      \n");

        int total = f1.totalprice()+f2.totalprice()+f3.totalprice()+f4.totalprice()+f5.totalprice();
        sb.append("\n==================================\n" + "CART SUBTOTAL: Rs.").append(total).append("\n==================================\n");

        Intent intent = new Intent(this,end.class);
        intent.putExtra("cart",sb.toString());
        startActivity(intent);

        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }
}