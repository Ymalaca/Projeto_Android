package com.projetoandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.projetoandroid.Banco.ReservaDAO;
import com.projetoandroid.Modelos.Reserva;

/**
 * Created by ALUNO on 14/11/2019.
 */

public class ActivityAdicionarReserva extends AppCompatActivity {

    private EditText editNome;
    private EditText editTelefone;
    private EditText editCpf;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_reserva);

        editNome = findViewById(R.id.NomeReservante);
        editTelefone = findViewById(R.id.TelefoneReservante);
        editCpf = findViewById(R.id.CpfReservante);

        Button btnCadastrarEvento = findViewById(R.id.botaoCadastrar);
        btnCadastrarEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editNome.getText().toString();
                String Telefone = editTelefone.getText().toString();
                String Cpf = editCpf.getText().toString();
                int telefone = Integer.parseInt(Telefone);
                int cpf = Integer.parseInt(Cpf);
                Reserva novaReserva = new Reserva(nome, telefone, cpf);

                new ReservaDAO(ActivityAdicionarReserva.this).AdcionarReserva(novaReserva);

                finish();
            }
        });
    }
}
