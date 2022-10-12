package com.example.fong_jason_lab5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.fong_jason_lab5.databinding.ActivityMainBinding;
import java.util.regex.Pattern;

/**
 * @author Jason Fong
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {
    /**
     * Holds the ActivityMainBinding, Pattern variable
     */
    private ActivityMainBinding binding;
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^" + "(?=.*[a-z])" + "(?=.*[A-Z])" + "(?=.*\\d)" + "(?=.*[-+_!@#$%^&*., ?])" + ".{10,}" + "$");
    /**
     * Used to start an activity
     * @param savedInstanceState Used to save & recover state information for your activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.login.setOnClickListener( clk -> {
            String password = binding.password.getText().toString().trim();
            checkPasswordComplexity(password);
        });
    }

    /**
     * Checks the password complexity that the user enters
     * @param pw The String object that we are checking
     * @return Returns true if ....
     */
    private boolean checkPasswordComplexity(String pw){

       if(pw.isEmpty()){
           binding.title.setText("Field Cannot Be Empty");
           return false;
       } else if (!PASSWORD_PATTERN.matcher(pw).matches()){
           binding.title.setText("You shall not pass!");
           return false;
       } else {
           binding.title.setText("Your password meets the requirements");
           return true;
       }
    }
}