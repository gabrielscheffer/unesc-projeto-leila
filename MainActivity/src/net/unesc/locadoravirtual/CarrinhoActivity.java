package net.unesc.locadoravirtual;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class CarrinhoActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_carrinho);
		String[] filmes = new String[]{"Filme 1","Filme 2"};
		((ListView)findViewById(R.id.carrinho_lv_lista)).setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,filmes));
		filmes = new String[]{"Filme 3","Filme 4","Filme 5"};
		((ListView)findViewById(R.id.carrinho_lv_carrinho)).setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,filmes));
	}
}
