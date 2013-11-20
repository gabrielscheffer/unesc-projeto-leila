package net.unesc.locadoravirtual.utils;

import java.text.DecimalFormat;
import java.util.List;

import net.unesc.locadoravirtual.R;
import net.unesc.locadoravirtual.vo.Filmes;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CarrinhoAdapter extends BaseAdapter {

	private Context context;
	private List<Filmes> filmes;
	private static DecimalFormat format;
	private OnTouchListener onTouchListener;
	private String TAG_LIST;

	public CarrinhoAdapter(Context context, List<Filmes> filmes,
			OnTouchListener onTouchListener, String TAG_LIST) {
		this.context = context;
		this.filmes = filmes;
		this.onTouchListener = onTouchListener;
		this.TAG_LIST = TAG_LIST;
		format = new DecimalFormat("R$ #,##0.00");
	}

	public List<Filmes> getList() {
		return this.filmes;
	}

	@Override
	public int getCount() {
		if (filmes != null) {
			return filmes.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int index) {
		if (filmes != null) {
			return filmes.get(index);
		}
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Filmes item = (Filmes) getItem(position);
		LayoutInflater inflater = ((Activity) context).getLayoutInflater();
		convertView = inflater
				.inflate(R.layout.carrinho_adapter, parent, false);
		convertView.setTag(item);
		convertView.setOnTouchListener(onTouchListener);
		TextView titulo = (TextView) convertView
				.findViewById(R.id.carrinho_tv_nome);
		TextView preco = (TextView) convertView
				.findViewById(R.id.carrinho_tv_preco);
		CarrinhoTag carrinhoTag = new CarrinhoTag(item, TAG_LIST);
		convertView.setTag(carrinhoTag);
		titulo.setText(item.getNome());
		preco.setText(format.format(item.getPreco()));
		return convertView;
	}

	public static class CarrinhoTag {
		private Filmes filmes;
		private String lsit;

		public CarrinhoTag(Filmes filmes, String lsit) {
			super();
			this.setFilmes(filmes);
			this.setLsit(lsit);
		}

		public String getLsit() {
			return lsit;
		}

		public void setLsit(String lsit) {
			this.lsit = lsit;
		}

		public Filmes getFilmes() {
			return filmes;
		}

		public void setFilmes(Filmes filmes) {
			this.filmes = filmes;
		}

	}
}
