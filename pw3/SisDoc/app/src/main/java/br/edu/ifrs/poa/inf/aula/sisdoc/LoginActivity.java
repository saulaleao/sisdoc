package br.edu.ifrs.poa.inf.aula.sisdoc;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void onClickButtonEntrar(View view)
    {
        SisDocRepository sisDocRepository = new SisDocRepository(getBaseContext());
        String resultado;

        resultado = sisDocRepository.insert_servidores("Adriana Oliveira de Pinho","Torre Sul","215","18:50");
        resultado = sisDocRepository.insert_servidores("Alessandra Nejar Bruno","Torre Norte","200","19:00");
        resultado = sisDocRepository.insert_servidores("Alex Dias Gonsales","-------","-----", "-----");


        resultado = sisDocRepository.insert_comunidade("Saula", "001", "1234");
        resultado = sisDocRepository.insert_comunidade("Cleber", "002", "1234");

        EditText usuario = (EditText) findViewById(R.id.edtxtMatricula);
        EditText senha = (EditText) findViewById(R.id.edtxtSenha);
        resultado = sisDocRepository.getComunidade(usuario.getText().toString(),senha.getText().toString()).getNome();
        if (!(resultado.equalsIgnoreCase("")))
        {
            Intent intencao = new Intent(this, DocenteActivity.class);
            startActivity(intencao);
        }
        else
        {
            exibirAlerta();
        }
        //txtMatricula.setText(usuario.getText()+" "+senha.getText());
    }
    public void exibirAlerta(){
        AlertDialog.Builder msgbox = new AlertDialog.Builder(this);
        msgbox.setTitle("Alerta");
        msgbox.setMessage("Usuário ou senha inválida!");
        msgbox.setIcon(android.R.drawable.ic_dialog_alert);
        msgbox.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });
        msgbox.show();
    }
}
