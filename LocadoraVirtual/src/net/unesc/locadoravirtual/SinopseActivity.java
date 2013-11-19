package net.unesc.locadoravirtual;

import net.unesc.locadoravirtual.utils.MyActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class SinopseActivity extends MyActionBarActivity {

	// ACTIONBAR
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.action_bar_main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.action_carrinho: {
			Intent intent = new Intent(this, CarrinhoActivity.class);
			startActivity(intent);
		}

			break;

		default:
			break;
		}

		return true;
	}

	// CLASSE
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sinopse);
	}
}
