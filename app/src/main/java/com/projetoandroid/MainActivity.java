package com.projetoandroid;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.projetoandroid.Banco.ReservaDAO;
import com.projetoandroid.Banco.RestauranteDAO;
import com.projetoandroid.Modelos.Endereco;
import com.projetoandroid.Modelos.Restaurante;

public class MainActivity extends AppCompatActivity {

    private AdaptadorDeRestaurante adaptador;
    private Restaurante res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adaptador = new AdaptadorDeRestaurante(this, new RestauranteDAO(this).BuscarDadosRestaurante());

        ListView lv = findViewById(R.id.listaDeRestaurantes);
        lv.setAdapter(adaptador);

        registerForContextMenu(lv);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabAdicionarRestaurante);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityAdicionarRestaurante.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu_restaurante, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo)
                item.getMenuInfo();

        res = (Restaurante) adaptador.getItem(menuInfo.position);

        int id = item.getItemId();

        if (id == R.id.LigarRestaurante) {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + res.getTelefoneRestaurante()));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) ==
                    PackageManager.PERMISSION_GRANTED) {
                startActivity(intent);
            }
            else {
                String[] permissoes = { Manifest.permission.CALL_PHONE };

                ActivityCompat.requestPermissions(this, permissoes, 24);
            }
        }
        else if(id == R.id.ReservarRestaurante) {
            Intent intent = new Intent(this, ActivityAdicionarReserva.class);
            intent.putExtra("res", res);
            startActivity(intent);
        }
        else if(id == R.id.VerReservas) {
            Intent intent = new Intent(this, ListaDeReservas.class);
            intent.putExtra("res", res);
            startActivity(intent);
        }
        else if(id == R.id.VerLocalizacao){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:0,0?q=" + res.getEndereco().getCepRestaurante()));
            startActivity(intent);
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.VerTotalReservas) {
            int qtdDeReservas = new ReservaDAO(this).BuscarDadosReserva().size();

            Toast.makeText(this, "Quantidade total de reservas: " + qtdDeReservas, Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(permissions[0].equals(Manifest.permission.CALL_PHONE) &&
            grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + res.getTelefoneRestaurante()));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) ==
                    PackageManager.PERMISSION_GRANTED) {
                startActivity(intent);
            }
        }
    }
}
