package br.edu.ifrs.poa.inf.aula.sisdoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class DocenteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente);
    }

    public void onClickEnviar(View view)
    {
        Spinner selecao = (Spinner) findViewById(R.id.spnDocente);
        Intent intencao = new Intent(this, SalaActivity.class);

        SisDocRepository sisDocRepository = new SisDocRepository(getBaseContext());

        sisDocRepository.getServidores(String.valueOf(selecao.getSelectedItem()).toString()).getNome();

        intencao.putExtra("nome", sisDocRepository.getServidores(String.valueOf(selecao.getSelectedItem()).toString()).getNome());
        intencao.putExtra("torre", sisDocRepository.getServidores(String.valueOf(selecao.getSelectedItem()).toString()).getTorre()); // Torre Sul, Torre Norte ou sem torre
        intencao.putExtra("sala", sisDocRepository.getServidores(String.valueOf(selecao.getSelectedItem()).toString()).getSala());
        intencao.putExtra("horario",sisDocRepository.getServidores(String.valueOf(selecao.getSelectedItem()).toString()).getHorario());

        startActivity(intencao);
    }

}
