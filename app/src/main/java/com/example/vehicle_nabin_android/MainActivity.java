package com.example.vehicle_nabin_android;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private EditText etName, etPurchase, etEngine, etColor, etYear;
    private Button btnCalculateCar;
    private TextView tvRes;
    private int vehicleCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        etYear = findViewById(R.id.etYear);
        etColor = findViewById(R.id.etColor);
        etEngine = findViewById(R.id.etEngin);
        etPurchase = findViewById(R.id.etPurchase);
        btnCalculateCar = findViewById(R.id.btnCar);
        tvRes = findViewById(R.id.tvRes);
        btnCalculateCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validate()) {
                    return;
                }
                String name = etName.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                String color = etColor.getText().toString();
                float engineSize = Float.parseFloat(etEngine.getText().toString());
                float price = Float.parseFloat(etPurchase.getText().toString());
                vehicleCount++;
                String heading = "This is vehicle no." + vehicleCount + "\n";
                String content = "Manufacture: " + name + " | Color: " + color + " " +
                        "| Price: " + price + "\n" + "  Engine Size" + engineSize+"\n \n" ;
                tvRes.append(heading + content);
            }
        });
    }

    private boolean validate() {
        if (TextUtils.isEmpty(etName.getText().toString())) {
            etName.setError("Please enter name");
            etName.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(etYear.getText().toString())) {
            etYear.setError("Please enter year");
            etYear.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(etColor.getText().toString())) {
            etColor.setError("Please enter color");
            etColor.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(etEngine.getText().toString())) {
            etEngine.setError("Please enter engine size");
            etEngine.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(etPurchase.getText().toString())) {
            etPurchase.setError("Please enter purchase");
            etPurchase.requestFocus();
            return false;
        }
        return true;
    }
}
