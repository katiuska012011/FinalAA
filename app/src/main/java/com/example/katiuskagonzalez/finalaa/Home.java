package com.example.katiuskagonzalez.finalaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {

	private Button salir;




	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		salir = (Button)findViewById(R.id.salir);

		salir.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				FirebaseAuth.getInstance().signOut();
				startActivity(new Intent(Home.this, Login.class));
			}
		});

	}
}
