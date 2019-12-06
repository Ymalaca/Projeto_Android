package com.projetoandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.projetoandroid.Banco.RestauranteDAO;
import com.projetoandroid.Modelos.Endereco;
import com.projetoandroid.Modelos.Restaurante;


/**
 * Created by ALUNO on 14/11/2019.
 */

public class ActivityAdicionarRestaurante extends AppCompatActivity {

    private EditText editNome;
    private EditText editTelefone;
    private EditText editCnpj;
    private EditText editCep;
    private EditText editRua;
    private EditText editBairro;
    private EditText editUF;
    private EditText editCidade;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_restaurante);

        editNome = findViewById(R.id.NomeRestaurante);
        editTelefone = findViewById(R.id.TelefoneRestaurante);
        editCep = findViewById(R.id.CepRestaurante);
        editRua = findViewById(R.id.RuaRestaurante);
        editBairro = findViewById(R.id.BairroRestaurante);
        editUF = findViewById(R.id.BairroRestaurante);
        editCidade = findViewById(R.id.CidadeRestaurante);
        editCnpj = findViewById(R.id.RestauranteCnpj);


        Button btnCadastrarEvento = findViewById(R.id.botaoCadas);
        btnCadastrarEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editNome.getText().toString();
                String Telefone = editTelefone.getText().toString();
                String cep = editCep.getText().toString();
                String rua = editRua.getText().toString();
                String bairro = editBairro.getText().toString();
                String cidade = editCidade.getText().toString();
                String uf = editUF.getText().toString();
                String Cnpj = editCnpj.getText().toString();

                int cnpj = Integer.parseInt(Cnpj);

                int telefone = Integer.parseInt(Telefone);

                Restaurante novoRestaurante = new Restaurante(nome, 0, telefone, cnpj, new Endereco(0, cep, rua, bairro, cidade, uf));

                new RestauranteDAO(ActivityAdicionarRestaurante.this).AdcionarRestaurante(novoRestaurante);

                finish();
            }
        });
    }
}
