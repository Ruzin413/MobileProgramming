package com.example.androidproject;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import java.security.PrivateKey;
public class LoginActivity extends AppCompatActivity {
    private EditText Username,Password;
    private TextView txtsignup , fpassword;
    private AppCompatButton loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_signup);
//      ftoolbar();
        findView();
        txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(LoginActivity.this , SignupActivity.class);
                intent.putExtra("data","signup");
                startActivity(intent);
                finish();
            }
        });
        fpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPassword.class);
                startActivity(intent);
                finish();
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Username.getText().toString().trim();
                String password = Password.getText().toString().trim();
                if (email.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Username is empty", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Logging in...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this ,ProductRecyclerViewActivity.class);
//                    intent.putExtra("email" , "hello");
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    private void findView(){
        Username = findViewById(R.id.Username);
        Password = findViewById(R.id.Password);
        loginButton = findViewById(R.id.loginbutton);
        txtsignup = findViewById(R.id.signupquestionmark);
        fpassword = findViewById(R.id.fpassword);
    }
//        private void ftoolbar(){
//        toolbar = findViewById(R.id.toolbar12);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Login");
//        getSupportActionBar().setDisplayShowTitleEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//    }
}
