package com.example.diarioescolar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.diarioescolar.dao.AlunoDAO;
import com.example.diarioescolar.model.Aluno;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CadastrarAluno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_aluno);

        Button salvar = findViewById(R.id.buttonSalvarAluno);

        EditText editNome = findViewById(R.id.editTextNomeAluno);
        EditText editCPF = findViewById(R.id.editTextCPFAluno);
        EditText editEmail = findViewById(R.id.editTextEmailAluno);
        EditText editDataNascimento = findViewById(R.id.editTextDataNascimentoAluno);
        EditText editTelefone = findViewById(R.id.editTextTelefoneAluno);

        CheckBox chkbxTI = findViewById(R.id.checkBoxTI);
        CheckBox chkbxOutros = findViewById(R.id.checkBoxOutros);
        CheckBox chkbxSaude = findViewById(R.id.checkBoxSaude);
        CheckBox chkbxTST = findViewById(R.id.checkBoxTST);
        CheckBox chkbxEngenharia = findViewById(R.id.checkBoxEngenharia);
        CheckBox chkbxTeatro = findViewById(R.id.checkBoxTeatro);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Preencher os campos da tela em um objeto Aluno
                Aluno aluno = new Aluno();
                aluno.setNome(editNome.getText().toString());
                aluno.setCPF(editCPF.getText().toString());
                aluno.setEmail(editEmail.getText().toString());
                aluno.setTelefone(editTelefone.getText().toString());
                //DD/MM/YYYY
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    aluno.setDataNascimento(sdf.parse(editDataNascimento.getText().toString()));
                } catch (ParseException e) {
                    Toast.makeText(CadastrarAluno.this, "Data inválida", Toast.LENGTH_LONG);
                }
                //Áreas de interesse
                if (chkbxTI.isChecked()) {
                    aluno.setAreasInteresse("TI");
                }
                if (chkbxEngenharia.isChecked()) {
                    aluno.setAreasInteresse("Engenharia");
                }
                if (chkbxOutros.isChecked()) {
                    aluno.setAreasInteresse("Outros");
                }
                if (chkbxSaude.isChecked()) {
                    aluno.setAreasInteresse("Saude");
                }
                if (chkbxTeatro.isChecked()) {
                    aluno.setAreasInteresse("Teatro");
                }
                if (chkbxTST.isChecked()) {
                    aluno.setAreasInteresse("TST");
                }

                AlunoDAO dao = new AlunoDAO(CadastrarAluno.this, "DIARIO", null, 1);
                dao.salvar(aluno);
            }
        });

    }
}