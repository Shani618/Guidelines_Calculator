package app.com.guidelinescalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import app.com.guidelinescalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    
    ActivityMainBinding binding;
    View view;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);
    }
    
    public void calculate(View view) {
        String leftS = binding.editTextLeft.getText().toString();
        String rightS = binding.editTextLeft.getText().toString();
        String topS = binding.editTextLeft.getText().toString();
        String bottomS = binding.editTextLeft.getText().toString();
        String widthS = binding.editTextLeft.getText().toString();
        String heightS = binding.editTextLeft.getText().toString();
        
        double width = 0;
        double height = 0;
        
        if(!StringChecker.isEmpty(widthS) && !StringChecker.isEmpty(heightS)) {
            width = Double.parseDouble(widthS);
            height = Double.parseDouble(heightS);
        } else {
            Snackbar.make(view,"Width/Height is empty",Snackbar.LENGTH_SHORT);
            return;
        }
        
        if(!StringChecker.isEmpty(leftS)) {
            double left = Double.parseDouble(leftS);
            binding.textViewLeft.setText(getPercent(left,width)+"");
        }
    
        if(!StringChecker.isEmpty(rightS)) {
            double right = Double.parseDouble(rightS);
            right = width - right;
            binding.textViewRight.setText(getPercent(right,width)+"");
        }
    
        if(!StringChecker.isEmpty(topS)) {
            double top = Double.parseDouble(topS);
            binding.textViewTop.setText(getPercent(top,height)+"");
        }
    
        if(!StringChecker.isEmpty(bottomS)) {
            double bottom = Double.parseDouble(bottomS);
            bottom = height - bottom;
            binding.textViewBottom.setText(getPercent(bottom,height)+"");
        }
        
        
    }
    
    public void clear(View view) {
        
        binding.editTextLeft.setText("");
        binding.editTextRight.setText("");
        binding.editTextTop.setText("");
        binding.editTextBottom.setText("");
        
        binding.textViewLeft.setText("");
        binding.textViewRight.setText("");
        binding.textViewTop.setText("");
        binding.textViewBottom.setText("");
        
    }
    public double getPercent(double val, double max) {
        double ans = (val/max);
        return ans;
    }
}