package com.example.cadastroaluno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText cpf;
    private EditText telefone;
    private AlunoDAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.editName);
        cpf = findViewById(R.id.editCPF);
        telefone = findViewById(R.id.editTelefone);
        dao = new AlunoDAO(this);
    }

    public void salvar(View view){
        Aluno al = new Aluno();
        al.setNome(nome.getText().toString());
        al.setCpf(cpf.getText().toString());
        al.setTelefone(telefone.getText().toString());
        long id = dao.inserir(al);
        Toast.makeText(this,"Aluno inserido com id: " + id, Toast.LENGTH_SHORT).show();
    }

    //método para botão irParaListar qdo clicado
    public void irParaListar(View view) {
        Intent intent = new Intent(this, ListarAlunosActivity.class);
        startActivity(intent);
    }
}