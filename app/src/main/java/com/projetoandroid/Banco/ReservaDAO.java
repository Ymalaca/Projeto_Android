package com.projetoandroid.Banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.projetoandroid.Modelos.Endereco;
import com.projetoandroid.Modelos.Reserva;

import java.util.ArrayList;

public class ReservaDAO extends Conexao {

    private Context context;
    
    public ReservaDAO(Context context){
        super(context);

        this.context = context;
    }

    public ContentValues ObterDados(Reserva reserva){
        ContentValues values = new ContentValues();
        values.put("NOME",reserva.getNomeReservante());
        values.put("CPF",reserva.getTelefoneReservante());
        values.put("TELEFONE",reserva.getCpfReservante());

        return values;
    }


    public void AdcionarReserva(Reserva reserva){
        try {
            ContentValues values = ObterDados(reserva);
            getWritableDatabase().insert("RESERVA", null,values);
        }
        catch(Exception e ) {
            Log.i("Script", "Ero: " + e);
        }
    }

    public void ExcluirReserva(int Codigo){
        String[] argumentos = { Codigo + "" };

        getWritableDatabase().delete("RESERVA", "CODIGO = ?", argumentos);
    }

    public void EditarReserva(Reserva reserva){
        ContentValues values = ObterDados(reserva);

        String[] argumentos = { reserva.getCodigo() + "" };

        getWritableDatabase().update("RESERVA", values,"CODIGO = ?", argumentos);
    }

    public ArrayList<Reserva> BuscarDadosReserva(){
        ArrayList<Reserva> reservas = new ArrayList<>();

        try {
            Cursor c = getWritableDatabase().rawQuery("SELECT * FROM RESERVA;",null);

            if(c.moveToNext()) {
                reservas.add(new Reserva(
                        c.getString(c.getColumnIndex("NOME")),
                        c.getInt(c.getColumnIndex("TELEFONE")),
                        c.getInt(c.getColumnIndex("CPF"))
                ));
            }
        }
        catch(SQLiteException e) {

        }

        return reservas;
     
    }
}
