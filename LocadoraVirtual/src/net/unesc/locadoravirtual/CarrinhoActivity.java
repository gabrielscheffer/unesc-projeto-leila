package net.unesc.locadoravirtual;

import net.unesc.locadoravirtual.utils.CarrinhoAdapter;
import net.unesc.locadoravirtual.utils.CarrinhoAdapter.CarrinhoTag;
import net.unesc.locadoravirtual.utils.MyActionBarActivity;
import net.unesc.locadoravirtual.vo.DataBase;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;

public class CarrinhoActivity extends MyActionBarActivity implements
		OnTouchListener {

	private static final String TAG_CARRINHO_LIST = "carrinhoList";
	private static final String TAG_LISTA_DESEJOS = "listaDesejos";
	private int _xDelta;
	private int initialX;
	private CarrinhoAdapter listaDesejosAdapter;
	private CarrinhoAdapter carrinhoAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_carrinho);
		ListView listaDesejos = getComponente(R.id.carrinho_lv_lista);
		listaDesejosAdapter = new CarrinhoAdapter(this,
				DataBase.getFavoritos(), this, TAG_LISTA_DESEJOS);
		listaDesejos.setAdapter(listaDesejosAdapter);
		ListView carrinhoList = getComponente(R.id.carrinho_lv_carrinho);
		carrinhoAdapter = new CarrinhoAdapter(this, DataBase.getCarrinho(),
				this, TAG_CARRINHO_LIST);
		carrinhoList.setAdapter(carrinhoAdapter);

	}

	@Override
	public boolean onTouch(View view, MotionEvent event) {
		final int X = (int) event.getRawX();
		switch (event.getAction() & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_DOWN:
			initialX = view.getLeft();
			_xDelta = X - initialX;
			break;
		case MotionEvent.ACTION_CANCEL:
		case MotionEvent.ACTION_UP: {
			CarrinhoTag carrinhoTag = (CarrinhoTag) view.getTag();
			if (TAG_CARRINHO_LIST.equals(carrinhoTag.getLsit())) {
				carrinhoAdapter.notifyDataSetInvalidated();
			} else if (TAG_LISTA_DESEJOS.equals(carrinhoTag.getLsit())) {
				listaDesejosAdapter.notifyDataSetInvalidated();
			}
		}
			break;
		case MotionEvent.ACTION_MOVE:
			if (initialX + (X - _xDelta) < -50 || initialX + (X - _xDelta) > 50) {
				view.setLeft(X - _xDelta);
			}
			if (initialX + (X - _xDelta) < -200) {
				// esquerda
				CarrinhoTag carrinhoTag = (CarrinhoTag) view.getTag();
				if (TAG_LISTA_DESEJOS.equals(carrinhoTag.getLsit())) {
					listaDesejosAdapter.getList().remove(
							carrinhoTag.getFilmes());
					listaDesejosAdapter.notifyDataSetChanged();
				} else if (TAG_CARRINHO_LIST.equals(carrinhoTag.getLsit())) {
					carrinhoAdapter.getList().remove(carrinhoTag.getFilmes());
					carrinhoAdapter.notifyDataSetChanged();
					listaDesejosAdapter.getList().add(carrinhoTag.getFilmes());
					listaDesejosAdapter.notifyDataSetChanged();
				}
			}
			if (initialX + (X - _xDelta) > 200) {
				// Direita
				CarrinhoTag carrinhoTag = (CarrinhoTag) view.getTag();
				if (TAG_LISTA_DESEJOS.equals(carrinhoTag.getLsit())) {
					carrinhoAdapter.getList().add(carrinhoTag.getFilmes());
					carrinhoAdapter.notifyDataSetChanged();
					listaDesejosAdapter.getList().remove(
							carrinhoTag.getFilmes());
					listaDesejosAdapter.notifyDataSetChanged();
				} else if (TAG_CARRINHO_LIST.equals(carrinhoTag.getLsit())) {
					carrinhoAdapter.getList().remove(carrinhoTag.getFilmes());
					carrinhoAdapter.notifyDataSetChanged();
				}
			}
			break;
		}
		return true;
	}
}
