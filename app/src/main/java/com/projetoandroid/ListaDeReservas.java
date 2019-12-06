package com.projetoandroid;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.projetoandroid.Banco.ReservaDAO;
import com.projetoandroid.Modelos.Reserva;

/**
 * Created by ALUNO on 14/11/2019.
 */

public class ListaDeReservas extends AppCompatActivity {
    private AdaptadorDeReserva adaptador;
    private Reserva res;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_reservas);

        adaptador = new AdaptadorDeReserva(this, new ReservaDAO(this).BuscarDadosReserva());


        ListView lv = findViewById(R.id.listaDeReservas);
        lv.setAdapter(adaptador);

        new ReservaDAO(this).AdcionarReserva(
                new Reserva(
                        "Wendell",0,99903219
                )
        );

        registerForContextMenu(lv);

        FloatingActionButton fabAdicionarReserva = findViewById(R.id.fabAdicionarReserva);
        fabAdicionarReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaDeReservas.this, ActivityAdicionarReserva.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        adaptador.atualizar(new ReservaDAO(this).BuscarDadosReserva());
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu_reserva, menu);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo)
                item.getMenuInfo();

        res = (Reserva) adaptador.getItem(menuInfo.position);

        int id = item.getItemId();

        if (id == R.id.LigarReservante) {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + res.getTelefoneReservante()));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) ==
                    PackageManager.PERMISSION_GRANTED) {
                startActivity(intent);
            }
            else {
                String[] permissoes = { Manifest.permission.CALL_PHONE };

                ActivityCompat.requestPermissions(this, permissoes, 24);
            }
        }


        if (item.getItemId() == R.id.ExcluirReserva) {
            ReservaDAO dao = new ReservaDAO(this);
            dao.ExcluirReserva(0);
            onResume();
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(permissions[0].equals(Manifest.permission.CALL_PHONE) &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + res.getTelefoneReservante()));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) ==
                    PackageManager.PERMISSION_GRANTED) {
                startActivity(intent);
            }
        }
    }

}