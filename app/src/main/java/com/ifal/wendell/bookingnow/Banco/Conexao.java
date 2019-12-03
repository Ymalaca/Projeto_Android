package com.ifal.wendell.bookingnow.Banco;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;



public class Conexao extends SQLiteOpenHelper {

    //DEFINE O NOME E A VERSAO DO BD
    private static String name = "bookingnow";
    private static int version = 1;

    public Conexao(Context context) {
        super(context, name, null, version);
    }

    //CRIAR O BD
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE ENDERECO(RUA TEXT, BAIRRO TEXT, CIDADE TEXT, UF VARCHAR(2), CODIGO INTEGER PRIMARY KEY AUTOINCREMENT);";
        db.execSQL(sql);

        sql = "CREATE TABLE RESTAURANTE(CODIGO INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, NOME TEXT NOT NULL, TELEFONE VARCHAR(14), CNPJ VARCHAR(20), CODIGO_DO_ENDERECO INTEGER, FOREIGN KEY (CODIGO_DO_ENDERECO) REFERENCES ENDERECO(CODIGO));";

        db.execSQL(sql);

        sql = "CREATE TABLE RESERVA " +
                "(CODIGO INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, NOME TEXT NOT NULL, TELEFONE INTEGER NOT NULL, CPF INTEGER NOT NULL UNIQUE, CODIGO_DO_RESTAURANTE INTEGER, FOREIGN KEY (CODIGO_DO_RESTAURANTE) REFERENCES RESTAURANTE(CODIGO));";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE RESERVA;");
        db.execSQL("DROP TABLE RESTAURANTE;");
        db.execSQL("DROP TABLE ENDERECO;");
        this.onCreate(db);
    }

}
