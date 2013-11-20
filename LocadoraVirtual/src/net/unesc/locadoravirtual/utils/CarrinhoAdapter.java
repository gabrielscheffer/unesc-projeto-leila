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

	public CarrinhoAdapter(Context context, List<Filmes> filmes,
			OnTouchListener onTouchListener) {
		this.context = context;
		this.setFilmes(filmes);
		this.onTouchListener = onTouchListener;
		format = new DecimalFormat("R$ #,##0.00");
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
		ViewHolder holder;
		Filmes item = (Filmes) getItem(position);
		if (convertView == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			convertView = inflater.inflate(R.layout.carrinho_adapter, parent,
					false);
			convertView.setTag(item);
			convertView.setOnTouchListener(onTouchListener);
			holder = new ViewHolder();
			holder.titulo = (TextView) convertView
					.findViewById(R.id.carrinho_tv_nome);
			holder.preco = (TextView) convertView
					.findViewById(R.id.carrinho_tv_preco);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.titulo.setText(item.getNome());
		holder.preco.setText(format.format(item.getPreco()));
		return convertView;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public List<Filmes> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filmes> filmes) {
		this.filmes = filmes;
	}

	private static class ViewHolder {
		TextView titulo;
		TextView preco;
	}
}
