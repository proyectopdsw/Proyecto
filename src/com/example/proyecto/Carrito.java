package com.example.proyecto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.parcial.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Carrito extends Activity {
	
	
	SimpleCursorAdapter mAdapter;
	ListView listview;
	String[] values = new String[] { "Product1", "Product2",
	        "Product3", "Product4", "Product5" };
	StableArrayAdapter adapter;
	ArrayList<String> list;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_carrito);
		
		listview = (ListView) findViewById(R.id.listView1);		
	    list = new ArrayList<String>();
	    for (int i = 0; i < values.length; ++i) {
	    	Compras a = new Compras();
		    list.add(values[i]);
	    }
	    
	    
	    adapter = new StableArrayAdapter(this,
	        android.R.layout.simple_list_item_1, list);
	    listview.setAdapter(adapter);
	    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
		      @Override
		      public void onItemClick(AdapterView<?> parent, final View view,
		          int position, long id) {
		          	String item = (String) parent.getItemAtPosition(position); 
		            list.remove(position);        
		            adapter.notifyDataSetChanged();   		           
		      }
		    });
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ventas, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.otralista1) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	private class StableArrayAdapter extends ArrayAdapter<String> {

	    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

	    public StableArrayAdapter(Context context, int textViewResourceId,
	        List<String> objects) {
	      super(context, textViewResourceId, objects);
	      for (int i = 0; i < objects.size(); ++i) {
	        mIdMap.put(objects.get(i), i);
	      }
	    }

	    @Override
	    public long getItemId(int position) {
	      String item = getItem(position);
	      return mIdMap.get(item);
	    }

	    @Override
	    public boolean hasStableIds() {
	      return true;
	    }

	  }
}
