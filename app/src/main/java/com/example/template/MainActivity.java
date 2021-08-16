package com.example.template;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.template.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initOCL();
        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(helloWorldFromOCL());
    }
    @Override
    public void onPause() {
        super.onPause();
    }
    @Override
    public void onDestroy() {
        closeOCL();
        super.onDestroy();
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native void initOCL();
    public native void closeOCL();
    public native String helloWorldFromOCL();

}