package com.projetoandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.projetoandroid.Modelos.Restaurante;

import java.util.ArrayList;

public class AdaptadorDeRestaurante extends BaseAdapter {

    private Context context;
    private ArrayList<Restaurante> restaurantes;

    public AdaptadorDeRestaurante(Context context, ArrayList<Restaurante> restaurantes) {
        this.context = context;
        this.restaurantes = restaurantes;
    }

    @Override
    public int getCount() {
        return restaurantes.size();
    }

    @Override
    public Object getItem(int position) {
        return restaurantes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return restaurantes.get(position).getCodigo();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_restaurante, null, false);

        TextView nomeDoRestaurante = view.findViewById(R.id.nome_do_restaurante);
        TextView telefoneDoRestaurante = view.findViewById(R.id.telefone_do_restaurante);
        TextView cepDoRestaurante = view.findViewById(R.id.cep_do_restaurante);

        nomeDoRestaurante.setText(restaurantes.get(position).getNomeRestaurante());
        telefoneDoRestaurante.setText(restaurantes.get(position).getTelefoneRestaurante() + "");
        cepDoRestaurante.setText("aaa");

        return view;
    }
}
