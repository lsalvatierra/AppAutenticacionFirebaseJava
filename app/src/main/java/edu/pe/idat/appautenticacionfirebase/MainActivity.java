package edu.pe.idat.appautenticacionfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etusuario, etpassword;
    private Button btnloginfirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etusuario = findViewById(R.id.etusuario);
        etpassword = findViewById(R.id.etpassword);
        btnloginfirebase = findViewById(R.id.btnloginfirebase);
        btnloginfirebase.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(etusuario.getText().toString() != ""
                && etpassword.getText().toString() != ""){
            FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    etusuario.getText().toString(), etpassword.getText().toString()
            ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        startActivity(new Intent(MainActivity.this,
                                HomeActivity.class));
                    }
                }
            });
        }
    }
}