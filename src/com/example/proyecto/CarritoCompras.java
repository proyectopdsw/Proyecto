package com.example.proyecto;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.example.parcial.R;

public class CarritoCompras extends Activity {
	
	private List<Producto> mCartList;
	private ProductoAdaptador mProductAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shoppingcart);
		
		
		mCartList = CarritoComprasH.getCartList();
		
		// Make sure to clear the selections
		for(int i=0; i<mCartList.size(); i++) {
			mCartList.get(i).selected = false;
		}
		
		// Create the list
		final ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
		mProductAdapter = new ProductoAdaptador(mCartList, getLayoutInflater(), true);
		listViewCatalog.setAdapter(mProductAdapter);
		
		listViewCatalog.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Intent productDetailsIntent = new Intent(getBaseContext(),DetallesProducto.class);
				productDetailsIntent.putExtra(CarritoComprasH.PRODUCT_INDEX, position);
				startActivity(productDetailsIntent);
			}
		});
		
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		// Refresh the data
		if(mProductAdapter != null) {
			mProductAdapter.notifyDataSetChanged();
		}
		double subTotal = 0;
		for(Producto p : mCartList) {
		 int quantity = CarritoComprasH.getProductQuantity(p);
		 subTotal += p.getPrice() * quantity;
		}
		 
		TextView productPriceTextView = (TextView) findViewById(R.id.TextViewSubtotal);
		productPriceTextView.setText("total: $" + subTotal);
	}

}
