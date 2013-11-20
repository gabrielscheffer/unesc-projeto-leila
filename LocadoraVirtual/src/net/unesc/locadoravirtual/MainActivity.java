package net.unesc.locadoravirtual;

import net.unesc.locadoravirtual.utils.CoverFlow;
import net.unesc.locadoravirtual.utils.ImageAdapter;
import net.unesc.locadoravirtual.utils.MyActionBarActivity;
import net.unesc.locadoravirtual.vo.DataBase;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;

public class MainActivity extends MyActionBarActivity implements
		OnItemClickListener, OnItemLongClickListener, OnDragListener {

	Integer gifilmeselecionado;
	ImageView dropCarrinho;
	ImageView dropFavoritos;
	private LayoutParams layoutParams;

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

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		DataBase.init();
		CoverFlow coverFlow = (CoverFlow) findViewById(R.id.main_coverflow);
		ImageAdapter coverImageAdapter = new ImageAdapter(this);
		coverImageAdapter.createReflectedImages();
		coverFlow.setAdapter(coverImageAdapter);
		coverFlow.setOnItemClickListener(this);
		coverFlow.setOnItemLongClickListener(this);
		coverFlow.setSelection(2, true);
		dropCarrinho = getComponente(R.id.drop_carrinho);
		dropCarrinho.setOnDragListener(this);
		dropFavoritos = getComponente(R.id.drop_favoritos);
		dropFavoritos.setOnDragListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position,
			long arg3) {
		if (gifilmeselecionado != null && position == gifilmeselecionado) {
			Intent intent = new Intent(getApplicationContext(),
					SinopseActivity.class);
			intent.putExtra("filme", DataBase.getFilmes().get(position));
			startActivity(intent);
			gifilmeselecionado = null;
		} else {
			gifilmeselecionado = position;
		}
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> adapter, View view,
			int position, long id) {
		ClipData.Item item = new ClipData.Item((CharSequence) view.getTag()
				.toString());
		String[] mimeTypes = { ClipDescription.MIMETYPE_TEXT_PLAIN };
		ClipData dragData = new ClipData(view.getTag().toString(), mimeTypes,
				item);
		View.DragShadowBuilder myShadow = new DragShadowBuilder(view);
		view.startDrag(dragData, myShadow, null, 0);
		dropCarrinho.setVisibility(View.VISIBLE);
		dropFavoritos.setVisibility(View.VISIBLE);
		return true;
	}

	@Override
	public boolean onDrag(View v, DragEvent event) {
		switch (event.getAction()) {
		case DragEvent.ACTION_DRAG_STARTED:
			Log.d("GABRIEL", "Drag ACTION_DRAG_STARTED");
			layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
			break;
		case DragEvent.ACTION_DRAG_ENTERED:
			Log.d("GABRIEL", "Drag ACTION_DRAG_ENTERED");
			int x_cord = (int) event.getX();
			int y_cord = (int) event.getY();
			break;
		case DragEvent.ACTION_DRAG_EXITED:
			Log.d("GABRIEL", "Drag ACTION_DRAG_EXITED");
			x_cord = (int) event.getX();
			y_cord = (int) event.getY();
			layoutParams.leftMargin = x_cord;
			layoutParams.topMargin = y_cord;
			v.setLayoutParams(layoutParams);
			break;
		case DragEvent.ACTION_DRAG_LOCATION:
			Log.d("GABRIEL", "Drag ACTION_DRAG_LOCATION");
			x_cord = (int) event.getX();
			y_cord = (int) event.getY();
			break;
		case DragEvent.ACTION_DRAG_ENDED:
			Log.d("GABRIEL", "Drag ACTION_DRAG_ENDED");
			dropCarrinho.setVisibility(View.INVISIBLE);
			dropFavoritos.setVisibility(View.INVISIBLE);
			break;
		case DragEvent.ACTION_DROP:
			if (R.id.drop_carrinho == v.getId()) {
				Log.d("GABRIEL", "Drag ACTION_DROP carrinho");
				Toast.makeText(getBaseContext(), "Adicionado ao carrinho.",
						Toast.LENGTH_LONG).show();
			} else if (R.id.drop_favoritos == v.getId()) {
				Log.d("GABRIEL", "Drag ACTION_DROP favoritos");
				Toast.makeText(getBaseContext(),
						"Adicionado a lista de desejos.", Toast.LENGTH_LONG)
						.show();
			}
			dropCarrinho.setVisibility(View.INVISIBLE);
			dropFavoritos.setVisibility(View.INVISIBLE);
			break;
		default:
			break;
		}
		return true;
	}
}