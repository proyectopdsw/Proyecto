package com.example.proyecto;

import com.example.parcial.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity {
	
	Button login;
	Context contexto; 
	EditText user;
	EditText password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		contexto=this.getApplicationContext();
		login=(Button) findViewById(R.id.button1);
		user = (EditText)findViewById(R.id.editText1);
		password = (EditText)findViewById(R.id.editText2);
		login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Intent menabrirmain=new Intent(contexto,MainActivity.class);
            	String usuario = user.getText().toString(); 
            	String clave = password.getText().toString(); 
            	
            	if(usuario.equals(clave)){
            		startActivity(menabrirmain);
            	}else{
            		user.setText("Ingrese de nuevo los datos");
            	}
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}