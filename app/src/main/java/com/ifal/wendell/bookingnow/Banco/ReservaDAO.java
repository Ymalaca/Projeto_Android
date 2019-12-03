package com.ifal.wendell.bookingnow.Banco;

import android.content.Context;

import com.ifal.wendell.bookingnow.Modelos.Reserva;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ReservaDAO extends Conexao {
    
    public ReservaDAO(Context context){
        super(context);
    }

    public ContentValues ObterDados(Reserva reserva){
        ContentValues values = new ContentValues();
        values.put("NOME",reserva.getNomereserva());
        values.put("CPF",reserva.getTelefonereserva());
        values.put("TELEFONE",reserva.getCNPJreserva());

        return values;
    }


    public void AdcionarReserva(Reserva rerserva){
        ContentValues values = ObterDados(reserva);
        getWritableDatabase().insert("RESERVA", null,values);   
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
        ArrayList<Reserva> reserva = null;

        try {
            Cursor c = getWritableDatabase().rawQuery("SELECT * FROM RESERVA;",null);

            if(c.moveToNext()) {
                Endereco endereco = new EnderecoDAO(this.context).buscarEnderecoPeloCodigo(c.getInt(c.getColumnIndex("CODIGO_DO_ENDERECO")));

                restaurantes.add(new Reserva(
                        c.getString(c.getColumnIndex("NOME")),
                        c.getInt(c.getColumnIndex("CODIGO")),
                        c.getInt(c.getColumnIndex("TELEFONE")),
                        c.getInt(c.getColumnIndex("CPF")),
                        endereco
                ));
            }
        }
        catch(SQLiteException e) {

        }

        return reservas;
     
    }
}
