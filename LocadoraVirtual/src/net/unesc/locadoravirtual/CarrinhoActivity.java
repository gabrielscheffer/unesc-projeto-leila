package net.unesc.locadoravirtual;

import net.unesc.locadoravirtual.utils.CarrinhoAdapter;
import net.unesc.locadoravirtual.utils.MyActionBarActivity;
import net.unesc.locadoravirtual.vo.DataBase;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;

public class CarrinhoActivity extends MyActionBarActivity implements
		OnTouchListener {

	private int _xDelta;
	private int initialX;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_carrinho);
		ListView listaDesejos = getComponente(R.id.carrinho_lv_lista);
		listaDesejos.setAdapter(new CarrinhoAdapter(this, DataBase
				.getFavoritos(), this));
		ListView carrinho = getComponente(R.id.carrinho_lv_carrinho);
		carrinho.setAdapter(new CarrinhoAdapter(this, DataBase.getCarrinho(),
				this));

	}

	@Override
	public boolean onTouch(View view, MotionEvent event) {
		final int X = (int) event.getRawX();
		switch (event.getAction() & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_DOWN:
			initialX = view.getLeft();
			_xDelta = X - initialX;
			break;
		case MotionEvent.ACTION_UP:
			view.setLeft(initialX);
			break;
		case MotionEvent.ACTION_MOVE:
			view.setLeft(X - _xDelta);
			if (initialX - X < 200) {

			}
			break;
		}
		return true;
	}

}
