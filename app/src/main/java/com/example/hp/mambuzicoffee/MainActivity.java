package com.example.hp.mambuzicoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView quantity;
    Button numOfCups;
    TextView price;
    int cups=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantity=(TextView)findViewById(R.id.quantity_text_view);
        numOfCups=(Button)findViewById(R.id.number_of_cups);
        price=(TextView)findViewById(R.id.price);

        }

    public void addCups(View view)
    {
        cups=cups+1;
        String strCups=String.valueOf(cups);
        quantity.setText(strCups+"cups Ordered");
        setPrice(view);
    }
    public void reduceCups(View view){
        if (cups>0)

        {
            cups = cups - 1;
            String strCups = String.valueOf(cups);
            quantity.setText(strCups+"cups Ordered");
            setPrice(view);
        }
        else{
            Toast.makeText(this, "You must order at least 1 cup of coffee", Toast.LENGTH_SHORT).show();
        }
    }
    public void setPrice(View view)
    {
        int priceInt=20*cups;
        String strPrice=String.valueOf(priceInt);
        price.setText("The cost is KSH"+strPrice);

    }
    public void feedback(View view)
    {
        Toast.makeText(this,
                "Thank you customer for purchasing coffee here", Toast.LENGTH_SHORT).show();
        openMessage(view);
    }
    public void openMessage(View view)
    {
        Intent intent=new Intent(this,Message.class);
        startActivity(intent);
    }
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.white_coffee_radiobutton:
                if (checked)
                    break;
            case R.id.black_coffee_radiobutton:
                if (checked)
                    break;
        }
    }
}
