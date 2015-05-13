package com.example.parcial;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

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
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Agregar extends Activity {
	Button volver2;
	Context contexto; 
	EditText id;
	EditText producto;
	EditText descripcion;
	EditText precio;
	EditText clave;
	Producto product;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agregar);
		contexto=this.getApplicationContext();
		volver2=(Button) findViewById(R.id.adicionar2);
		
		id=(EditText) findViewById(R.id.ide);
		producto=(EditText) findViewById(R.id.productoe);
		descripcion=(EditText) findViewById(R.id.descripcione);
		precio=(EditText) findViewById(R.id.precioe);
	
	volver2.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String id1 = ""+id.getText();
			String producto1 = ""+producto.getText().toString();
			String descripcion1= ""+descripcion.getText().toString();
			String precio1 = ""+precio.getText();
			
			
			try {
				   int id2= Integer.parseInt(id1);
				   int precio2=Integer.parseInt(precio1);
				   if(id1==""||producto1==""||descripcion1==""||precio1==""){
				   		Toast.makeText(getBaseContext(), "Hay espacios vacíos", Toast.LENGTH_LONG).show();
				   } else {
						new HttpAsyncTask().execute("https://1-dot-poetic-bongo-841.appspot.com/_ah/api/tiendaapi/v1/addProducto/"+""+id2+"/"+""+producto1+"/"+""+descripcion1+"/"+precio2);
				   }
				   
				   } catch (NumberFormatException ex) {
				   
						Toast.makeText(getBaseContext(), "Id y teléfono deben ser números", Toast.LENGTH_LONG).show();
				   
				   }		
			
			
			}
		});
	}

	public static String POST(String url, Producto product){
        InputStream inputStream = null;
        String result = "";
        
        try {
 
            HttpClient httpclient = new DefaultHttpClient();
 
            HttpPost httpPost = new HttpPost(url);
 
            String json = "";
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("id", product.getId());
            jsonObject.accumulate("producto", product.getTitle());
            jsonObject.accumulate("descripcion", product.getDescription());
            jsonObject.accumulate("precio", product.getPrice());
         
           
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
 
           
            product.setId(Integer.parseInt(id.getText().toString()));
            product.setTitle(producto.getText().toString());
            product.setDescription(descripcion.getText().toString());
            product.setPrice(Integer.parseInt(precio.getText().toString()));
 
            return POST(urls[0],product);
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
		getMenuInflater().inflate(R.menu.agregar, menu);
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
