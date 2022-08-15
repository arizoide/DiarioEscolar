package com.example.diarioescolar.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.diarioescolar.model.AlunoAreaInteresse;

public class AlunoAreasInteresseDAO extends SQLiteOpenHelper {

    public AlunoAreasInteresseDAO(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    }

    public void salvar (AlunoAreaInteresse alunoAreaInteresse){
        ContentValues c = new ContentValues();
        c.put("ID_ALUNO", alunoAreaInteresse.getIdAluno());
        c.put("AREA_INTERESSE", alunoAreaInteresse.getAreaInteresse());

        SQLiteDatabase db = getWritableDatabase();

        long idSalvo = db.insert("ALUNO_INTERESSE", null, c);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String createTableAlunoInteresse = "CREATE TABLE ALUNO_INTERESSE ( " +
                "ID INTEGER PRIMARY KEY, " +
                "ID_ALUNO INTEGER, " +
                "AREA_INTERESSE TEXT);";

        sqLiteDatabase.execSQL(createTableAlunoInteresse);
    }
}
