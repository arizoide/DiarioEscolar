package com.example.diarioescolar.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.diarioescolar.model.Aluno;
import com.example.diarioescolar.model.AlunoAreaInteresse;

public class AlunoDAO extends SQLiteOpenHelper {
    public AlunoDAO(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE ALUNO ( " +
                "ID INTEGER PRIMARY KEY, " +
                "NOME TEXT, " +
                "CPF TEXT, " +
                "TELEFONE TEXT," +
                "EMAIL TEXT, " +
                "DATA_NASCIMENTO TEXT);";

        sqLiteDatabase.execSQL(createTable);

    }

    public Integer salvar(Aluno aluno){
        ContentValues c = new ContentValues();
        c.put("NOME", aluno.getNome());
        c.put("CPF", aluno.getCPF());
        c.put("TELEFONE", aluno.getTelefone());
        c.put("EMAIL", aluno.getEmail());
        c.put("DATA_NASCIMENTO", aluno.getDataNascimento().toString());

        SQLiteDatabase db = getWritableDatabase();

        return (int) db.insert("ALUNO", null, c);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
