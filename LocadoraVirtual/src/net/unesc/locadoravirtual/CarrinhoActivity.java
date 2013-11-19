package net.unesc.locadoravirtual;

import net.unesc.locadoravirtual.utils.CarrinhoAdapter;
import net.unesc.locadoravirtual.utils.MyActionBarActivity;
import net.unesc.locadoravirtual.vo.DataBase;
import android.os.Bundle;
import android.widget.ListView;

public class CarrinhoActivity extends MyActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_carrinho);
		ListView listaDesejos = getComponente(R.id.carrinho_lv_lista);
		listaDesejos.setAdapter(new CarrinhoAdapter(this, DataBase
				.getFavoritos()));
		ListView carrinho = getComponente(R.id.carrinho_lv_carrinho);
		carrinho.setAdapter(new CarrinhoAdapter(this, DataBase.getCarrinho()));
	}
}
