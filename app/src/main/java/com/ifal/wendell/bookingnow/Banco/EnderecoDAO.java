package com.ifal.wendell.bookingnow.Banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;

import com.ifal.wendell.bookingnow.Modelos.Endereco;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class EnderecoDAO extends Conexao {

    public EnderecoDAO(Context context) {
        super(context);
    }

    public ContentValues ObterDados(Endereco endereco){
        ContentValues values = new ContentValues();
        values.put("RUA",endereco.getRuaRestaurante());
        values.put("BAIRRO",endereco.getBairroRestaurante());
        values.put("CIDADE",endereco.getCidadeRestaurante());
        values.put("CEP",endereco.getCepRestaurante());
        values.put("UF",endereco.getUFRestaurante());

        return values;
    }

    public void AdcionarEndereco(Endereco endereco){
        ContentValues values = ObterDados(endereco);
        getWritableDatabase().insert("ENDERECO", null,values);
    }

    public void ExcluirEndereco(int Codigo){
        String[] argumentos = { Codigo + "" };

        getWritableDatabase().delete("ENDERECO", "CODIGO = ?", argumentos);
    }

    public void EditarEndereco(Endereco endereco){
        ContentValues values = ObterDados(endereco);

        String[] argumentos = { endereco.getCodigo() + "" };

        getWritableDatabase().update("ENDERECO", values,"CODIGO = ?", argumentos);
    }

     public Endereco buscarUltimoEndereco() {
        Endereco endereco = null;

        try {
            Cursor c = getWritableDatabase().rawQuery("SELECT * FROM ENDERECO ORDER BY CODIGO DESC LIMIT 1",null);

            if(c.moveToNext()) {
                endereco = new Endereco(
                        c.getInt(c.getColumnIndex("CODIGO")),
                        c.getString(c.getColumnIndex("CEP")),
                        c.getString(c.getColumnIndex("RUA")),
                        c.getString(c.getColumnIndex("BAIRRO")),
                        c.getString(c.getColumnIndex("CIDADE")),
                        c.getString(c.getColumnIndex("UF"))
                );
            }
        }
        catch(SQLiteException e) {

        }

        return endereco;
     }

    public Endereco buscarEnderecoPeloCodigo(int codigo) {
        Endereco endereco = null;

        try {
            String[] argumentos = { codigo + "" };

            Cursor c = getWritableDatabase().rawQuery("SELECT * FROM ENDERECO WHERE CODIGO = ?",argumentos);

            if(c.moveToNext()) {
                endereco = new Endereco(
                        c.getInt(c.getColumnIndex("CODIGO")),
                        c.getString(c.getColumnIndex("CEP")),
                        c.getString(c.getColumnIndex("RUA")),
                        c.getString(c.getColumnIndex("BAIRRO")),
                        c.getString(c.getColumnIndex("CIDADE")),
                        c.getString(c.getColumnIndex("UF"))
                );
            }
        }
        catch(SQLiteException e) {

        }

        return endereco;
    }
}
