package br.edu.ifrs.poa.inf.aula.sisdoc;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SalaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sala);
        Intent intencao = getIntent();
        String nome = intencao.getStringExtra("nome");
        String torre = intencao.getStringExtra("torre");
        String sala = intencao.getStringExtra("sala");
        String horario = intencao.getStringExtra("horario");
        TextView txtEnviado = (TextView) findViewById(R.id.txtMsgRecebida);
        txtEnviado.setText(nome);
        TextView txtSala = (TextView) findViewById(R.id.txtSalaPredio);
        txtSala.setText(sala+"/"+torre);
        TextView txtHorario = (TextView) findViewById(R.id.txtHorarioSala);
        txtHorario.setText(horario+" h");

        ImageView imagemTorre  =  (ImageView)findViewById(R.id.imageViewTorre);

        if(torre.equalsIgnoreCase("Torre Sul")){
            imagemTorre.setImageResource(R.mipmap.torre_sul);
        }
        else {
               if(torre.equalsIgnoreCase("Torre Norte")){
                   imagemTorre.setImageResource(R.mipmap.torre_norte);
               }
               else {
                imagemTorre.setImageResource(R.mipmap.torre_sem);
               }
        }

    }
    public void onClickButtonVoltar(View view)
    {
        Intent intencao = new Intent(this, DocenteActivity.class);
        startActivity(intencao);
    }

}
