package com.example.androidproject;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
public class SignupActivity extends AppCompatActivity {
    private EditText Username,Password,cpassword;
    private TextView txtsignup , questionmark;
    private AppCompatButton loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        findView();
        questionmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               AlertDialog d1= createdialog();
               d1.show();
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Username.getText().toString().trim();
                String password = Password.getText().toString().trim();
                String cpassword = Password.getText().toString().trim();
                if (email.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Username is empty", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (cpassword.isEmpty()) {
                Toast.makeText(SignupActivity.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(SignupActivity.this, "Logging in...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignupActivity.this ,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    private void findView() {
        Username = findViewById(R.id.Username);
        Password = findViewById(R.id.Password);
        cpassword = findViewById(R.id.cPassword);
        loginButton = findViewById(R.id.loginbutton);
        questionmark = findViewById(R.id.signupquestionmark);
    }
    AlertDialog createdialog(){
        AlertDialog.Builder b1 = new AlertDialog.Builder(SignupActivity.this);
        b1.setMessage("Do you want to leave this page?");
        b1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        b1.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(SignupActivity.this,"Account not created",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        return b1.create();
    }
}
