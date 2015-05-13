package com.example.parcial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import com.example.proyecto.*;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Registro extends Activity {
	Button volver;
	Context contexto; 
	EditText id;
	EditText nombre;
	EditText direccion;
	EditText telefono;
	EditText clave;
	Usuario usuario;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro);
		contexto=this.getApplicationContext();
		volver=(Button) findViewById(R.id.adicionar);
		
		id=(EditText) findViewById(R.id.ide);
		nombre=(EditText) findViewById(R.id.nombree);
		direccion=(EditText) findViewById(R.id.direccione);
		telefono=(EditText) findViewById(R.id.telefonoe);
		clave=(EditText) findViewById(R.id.clavee);
	
	volver.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String id1 = ""+id.getText();
			String nombre1 = ""+nombre.getText().toString();
			String direccion1= ""+direccion.getText().toString();
			String telefono1 = ""+telefono.getText();
			String clave1 = ""+clave.getText().toString();
			
			
			try {
				   int id2= Integer.parseInt(id1);
				   int telefono2=Integer.parseInt(telefono1);
				   if(id1==""||nombre1==""||direccion1==""||telefono1==""||clave1==""){
				   		Toast.makeText(getBaseContext(), "Hay espacios vacíos", Toast.LENGTH_LONG).show();
				   } else {
						new HttpAsyncTask().execute("https://1-dot-poetic-bongo-841.appspot.com/_ah/api/tiendaapi/v1/addUsuario/"+""+id2+"/"+""+nombre1+"/"+""+direccion1+"/"+telefono2+"/"+clave1);
				   }
				   
				   } catch (NumberFormatException ex) {
				   
						Toast.makeText(getBaseContext(), "Id y teléfono deben ser números", Toast.LENGTH_LONG).show();
				   
				   }		
			
			
			}
		});
	}

	public static String POST(String url, Usuario usuario){
        InputStream inputStream = null;
        String result = "";
        
        try {
 
            HttpClient httpclient = new DefaultHttpClient();
 
            HttpPost httpPost = new HttpPost(url);
 
            String json = "";
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("id", usuario.getId());
            jsonObject.accumulate("nombre", usuario.getNombre());
            jsonObject.accumulate("direccion", usuario.getDireccion());
            jsonObject.accumulate("telefono", usuario.getTelefono());
            jsonObject.accumulate("clave", usuario.getClave());
           
            json = jsonObject.toString();
 
       
            StringEntity se = new StringEntity(json);
 
            httpPost.setEntity(se);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
 
            HttpResponse httpResponse = httpclient.execute(httpPost);
 
            inputStream = httpResponse.getEntity().getContent();
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";
 
        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }
 
        return result;
    }
	
	private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
 
           Usuario u=new Usuario(Integer.parseInt(id.getText().toString()),nombre.getText().toString(),direccion.getText().toString(),Integer.parseInt(telefono.getText().toString()),clave.getText().toString());
            u.setId(Integer.parseInt(id.getText().toString()));
            u.setNombre(nombre.getText().toString());
            u.setDireccion(direccion.getText().toString());
            u.setTelefono(Integer.parseInt(telefono.getText().toString()));
 
            return POST(urls[0],u);
        }
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "Datos Enviados", Toast.LENGTH_LONG).show();
        	}
		}
    
    
    	private static String convertInputStreamToString(InputStream inputStream) throws IOException{
    		BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
    		String line = "";
    		String result = "";
    		while((line = bufferedReader.readLine()) != null)
    			result += line;
 
    		inputStream.close();
    		return result;
 
    	}   
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registro, menu);
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