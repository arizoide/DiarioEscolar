package com.example.diarioescolar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.diarioescolar.dao.AlunoAreasInteresseDAO;
import com.example.diarioescolar.dao.AlunoDAO;
import com.example.diarioescolar.model.Aluno;
import com.example.diarioescolar.model.AlunoAreaInteresse;

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

                List<String> areas = new ArrayList<>();
                //Áreas de interesse
                if (chkbxTI.isChecked()) {
                    areas.add("TI");
                }
                if (chkbxEngenharia.isChecked()) {
                    areas.add("Engenharia");
                }
                if (chkbxOutros.isChecked()) {
                    areas.add("Outros");
                }
                if (chkbxSaude.isChecked()) {
                    areas.add("Saude");
                }
                if (chkbxTeatro.isChecked()) {
                    areas.add("Teatro");
                }
                if (chkbxTST.isChecked()) {
                    areas.add("TST");
                }

                aluno.setAreasInteresse(areas);

                AlunoDAO dao = new AlunoDAO(CadastrarAluno.this, "DIARIO", null, 1);
                Integer idSalvo = dao.salvar(aluno);

                AlunoAreasInteresseDAO daoAreaInteresse = new AlunoAreasInteresseDAO(CadastrarAluno.this, "DIARIO", null, 2);

                //Salvar as áreas de interesse
                for (String areaInteresse : aluno.getAreasInteresse()) {
                    AlunoAreaInteresse alunoAreaInteresse = new AlunoAreaInteresse();
                    alunoAreaInteresse.setIdAluno((int) idSalvo);
                    alunoAreaInteresse.setAreaInteresse(areaInteresse);

                    daoAreaInteresse.salvar(alunoAreaInteresse);
                }
            }
        });

    }
}