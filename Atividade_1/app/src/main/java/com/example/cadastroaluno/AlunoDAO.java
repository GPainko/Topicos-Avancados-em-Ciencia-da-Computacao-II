package com.example.cadastroaluno;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public AlunoDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Aluno aluno){
        ContentValues values = new ContentValues();
        values.put("Nome", aluno.getNome());
        values.put("cpf", aluno.getCpf());
        values.put("telefone",aluno.getTelefone());
        return banco.insert("aluno",null,values);
    }

    public List<Aluno> obterTodos(){
        List<Aluno> alunos = new ArrayList<>();
        Cursor cursor = banco.query("aluno",new String[]{"id","nome","cpf","telefone"},
                null,null,null,null,null);
        while(cursor.moveToNext()){
            Aluno al = new Aluno();
            al.setId(cursor.getInt(0));
            al.setNome(cursor.getString(1));
            al.setCpf(cursor.getString(2));
            al.setTelefone(cursor.getString(3));
            alunos.add(al);
        }
        return alunos;
    }
}
