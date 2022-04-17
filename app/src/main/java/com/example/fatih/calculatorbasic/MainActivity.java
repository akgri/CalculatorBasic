package com.example.fatih.calculatorbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.fatih.calculatorbasic.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("test",String.valueOf(0));
        super.onCreate(savedInstanceState);
        binding= binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        binding.textView.setText("0");
        binding.button0.setOnClickListener(this::onClick);
        binding.button1.setOnClickListener(this::onClick);
        binding.button2.setOnClickListener(this::onClick);
        binding.button3.setOnClickListener(this::onClick);
        binding.button4.setOnClickListener(this::onClick);
        binding.button5.setOnClickListener(this::onClick);
        binding.button6.setOnClickListener(this::onClick);
        binding.button7.setOnClickListener(this::onClick);
        binding.button8.setOnClickListener(this::onClick);
        binding.button9.setOnClickListener(this::onClick);
        binding.buttonRemove.setOnClickListener(view1 -> {
            String s;
            s=binding.textView.getText().toString();
            if (s.length() > 0) {
                s = s.substring(0, (s.length() - 1));
            }
           binding.textView.setText(s);
        });
        binding.buttonClear.setOnClickListener(view1 -> {
            binding.textView.setText("");
        });
        ArrayList<Double> numbers=new ArrayList<Double>();
        binding.buttonPlus.setOnClickListener(view1 -> {
            Double numb=Double.parseDouble(binding.textView.getText().toString());
            binding.textView.setText("");
            numbers.add(numb);
            Log.e("NUMBER SİZE",String.valueOf(numbers.size()));

        });
        binding.buttonResult.setOnClickListener(view1 -> {
            
          double sum=  sumArray(numbers);
          binding.textView.setText(String.valueOf(sum));
        });

        binding.buttonClear.setOnClickListener(view1 -> {
            numbers.clear();
            binding.textView.setText("");
        });




        setContentView(view);

    }



    @Override
    public void onClick(View view) {
        // 1) Possibly check for instance of first
        Button b = (Button) view;
        String buttonText = b.getText().toString();
        binding.textView.setText(binding.textView.getText().toString()+buttonText);
    }
    public static Double sumArray(ArrayList<Double> N){
        Double sum=0.0;
        for (Double n : N) {
            sum+=n;
        }
        return sum;
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}