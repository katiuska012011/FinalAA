package com.example.katiuskagonzalez.finalaa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class registro extends AppCompatActivity implements View.OnClickListener {

	private EditText editTextEmail, editTextpass;
	private Button btnAceder;

	FirebaseAuth.AuthStateListener mAuthListener;
	FirebaseAuth mAuth;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro);


		mAuth = FirebaseAuth.getInstance();
		editTextEmail = (EditText) findViewById(R.id.editEmail);
		editTextpass = (EditText) findViewById(R.id.editPass);
		btnAceder = (Button) findViewById(R.id.btnAcess);

		btnAceder.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

			}
		});
	}

	@Override
	public void onClick(View view) {

	}
}