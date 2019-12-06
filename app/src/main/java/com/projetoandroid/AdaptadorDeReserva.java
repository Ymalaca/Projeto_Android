package com.projetoandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.projetoandroid.Modelos.Reserva;

import java.util.ArrayList;

public class AdaptadorDeReserva extends BaseAdapter {

    private Context context;
    private ArrayList<Reserva> reservas;

    public AdaptadorDeReserva(Context context, ArrayList<Reserva> reservas) {
        this.context = context;
        this.reservas = reservas;
    }

    @Override
    public int getCount() {
        return reservas.size();
    }

    @Override
    public Object getItem(int position) {
        return reservas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return reservas.get(position).getCodigo();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_reserva, null, false);

        TextView nomeDoReservante = view.findViewById(R.id.nome_do_reservante);
        TextView telefoneDoReservante = view.findViewById(R.id.telefone_do_reservante);
        TextView cpfDoReservante = view.findViewById(R.id.cpf_do_reservante);

        nomeDoReservante.setText(reservas.get(position).getNomeReservante());
        telefoneDoReservante.setText(reservas.get(position).getTelefoneReservante() + "");
        cpfDoReservante.setText(reservas.get(position).getCpfReservante() + "");

        return view;
    }

    public void atualizar(ArrayList<Reserva> reservas) {
        this.reservas = reservas;

        notifyDataSetChanged();
    }
}
