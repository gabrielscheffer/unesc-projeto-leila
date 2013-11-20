package net.unesc.locadoravirtual;

import java.text.DecimalFormat;

import net.unesc.locadoravirtual.utils.MyActionBarActivity;
import net.unesc.locadoravirtual.utils.SimpleDialog;
import net.unesc.locadoravirtual.utils.SimpleDialog.FragmentDialogInterface;
import net.unesc.locadoravirtual.vo.Filmes;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SinopseActivity extends MyActionBarActivity implements OnClickListener, FragmentDialogInterface{

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
		Filmes filmes;
		
		
		filmes = (Filmes) getIntent().getExtras().get("filme");
		TextView tv_titulo, tv_sinopse;
		ImageView iv_filme;
		Button btn_trailer, btn_imagens, btn_preco;
		DecimalFormat format = new DecimalFormat("R$ #,##0.00");
		
		if (filmes != null) {
			tv_titulo 	= (TextView) 	findViewById(R.id.tv_titulo);
			iv_filme 	= (ImageView)	findViewById(R.id.iv_filme);
			tv_sinopse	= (TextView) 	findViewById(R.id.tv_sinopse);
			btn_trailer	= (Button) 		findViewById(R.id.btn_trailer);
			btn_imagens = (Button) 		findViewById(R.id.btn_imagens);
			btn_preco 	= (Button) 		findViewById(R.id.btn_preco);
			
			tv_titulo.setText(filmes.getNome().toUpperCase() + " ("
					+ filmes.getAno() + ")");
			iv_filme.setImageDrawable(getResources().getDrawable(filmes.getImage()));
			tv_sinopse.setText(filmes.getSinopse());			
			btn_preco.setText(format.format(filmes.getPreco()));
			
			btn_trailer.setOnClickListener(this);
			btn_imagens.setOnClickListener(this);
			btn_preco.setOnClickListener(this);
			
		}

	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.btn_trailer:{
			Toast.makeText(getApplicationContext(), "Dispara evento que irá abrir o vídeo!", Toast.LENGTH_LONG).show();
		}
			break;
		case R.id.btn_imagens:{
			Toast.makeText(getApplicationContext(), "Dispara evento que irá abrir as imagens!", Toast.LENGTH_LONG).show();
		}
			break;
		case R.id.btn_preco:{
			SimpleDialog dialog = SimpleDialog.newDialog(   
				    0,              // Id do dialog   
				    "Atenção",       // título   
				    "Escolha a opção desejada para o filme",     // mensagem   
				    new int[]{      // texto dos botões   
				      R.string.bt_favoritos,    
				      R.string.bt_carrinho });   
				    dialog.openDialog(getSupportFragmentManager());
		}
			break;
		}
		
	}

	@Override
	public void onClick(int id, int which) {
		Log.d("GABRIEL", "botao: "+which);
		switch(which){
		case -2:{
			//CARRINHO
			Intent intent = new Intent(this, CarrinhoActivity.class);
			startActivity(intent);
		}break;
		case -1:{
			//FAVORITOS
			Intent intent = new Intent(this, CarrinhoActivity.class);
			startActivity(intent);
		}break;
		}
		
	}
}
