package com.example.katiuskagonzalez.finalaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity  {


	private static final String TAG = "Kat";
	private EditText editTexEmail, editTextpass;
	private Button btnlogin;

	FirebaseAuth.AuthStateListener mAuthListener;
	FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

		mAuth = FirebaseAuth.getInstance();

		editTexEmail = (EditText) findViewById(R.id.editEmail);
		editTextpass = (EditText) findViewById(R.id.editPass);
		btnlogin =       (Button) findViewById(R.id.btnlogin);


		mAuthListener = new FirebaseAuth.AuthStateListener() {
			@Override
			public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

				if(firebaseAuth.getCurrentUser()!=null){
					startActivity(new Intent(Login.this,Home.class));
				}else{
					Toast.makeText(Login.this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
				}
			}
		};

		btnlogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				LoginUsuario();

			}
		});
    }


	@Override
	protected void onStart() {
		super.onStart();
		mAuth.addAuthStateListener(mAuthListener);
	}

	private void LoginUsuario(){
		String email = editTexEmail.getText().toString();
		String pass = editTextpass.getText().toString();

		mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

					@Override
					public void onComplete(@NonNull Task<AuthResult> task) {
						Log.d(TAG, "signInWithEmail: onComplete" + task.isSuccessful());

						if(!task.isSuccessful()){
							Log.w(TAG, "signWithEmail", task.getException());
							Toast.makeText(Login.this,"Authentication  failed.", Toast.LENGTH_SHORT).show();
						}
					}
				});
	}
}
