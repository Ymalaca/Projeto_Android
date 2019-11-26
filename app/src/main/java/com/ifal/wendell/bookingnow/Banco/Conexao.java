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

    public Conexao(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public Conexao(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    //CRIAR O BD
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE RESERVA " +
                "(CODIGO INTEGER NOT NULL, NomeReservante TEXT NOT NULL, TelefoneReservante INTEGER NOT NULL, CpfReservante INTEGER NOT NULL UNIQUE, " +
                "PRIMARY KEY(CODIGO));";
        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
