package com.ifal.wendell.bookingnow.Banco;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;

import com.ifal.wendell.bookingnow.Modelos.Endereco;
import com.ifal.wendell.bookingnow.Modelos.Restaurante;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RestauranteDAO extends Conexao {

    private Context context;

    public RestauranteDAO(Context context){
        super(context);
        this.context = context;
    }

    public ContentValues ObterDados(Restaurante restaurante){
        ContentValues values = new ContentValues();
        values.put("NOME",restaurante.getNomeRestaurante());
        values.put("CNPJ",restaurante.getTelefoneRestaurante());
        values.put("TELEFONE",restaurante.getCNPJRestaurante());

        return values;
    }

    public void AdcionarRestaurante(Restaurante restaurante){
        ContentValues values = ObterDados(restaurante);
        getWritableDatabase().insert("RESTAURANTE", null,values);
    }

    public void ExcluirRestaurante(int Codigo){
        String[] argumentos = { Codigo + "" };

        getWritableDatabase().delete("RESTAURANTE", "CODIGO = ?", argumentos);
    }

    public void EditarRestaurante(Restaurante restaurante){
        ContentValues values = ObterDados(restaurante);

        String[] argumentos = { restaurante.getCodigo() + "" };

        getWritableDatabase().update("RESTAURANTE", values,"CODIGO = ?", argumentos);
    }

    public ArrayList<Restaurante> BuscarDadosRestaurante(){
        ArrayList<Restaurante> restaurantes = null;

        try {
            Cursor c = getWritableDatabase().rawQuery("SELECT * FROM RESTAURANTE;",null);

            if(c.moveToNext()) {
                Endereco endereco = new EnderecoDAO(this.context).buscarEnderecoPeloCodigo(c.getInt(c.getColumnIndex("CODIGO_DO_ENDERECO")));

                restaurantes.add(new Restaurante(
                        c.getString(c.getColumnIndex("NOME")),
                        c.getInt(c.getColumnIndex("CODIGO")),
                        c.getInt(c.getColumnIndex("TELEFONE")),
                        c.getInt(c.getColumnIndex("CNPJ")),
                        endereco
                ));
            }
        }
        catch(SQLiteException e) {

        }

        return restaurantes;
    }
}
