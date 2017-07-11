package br.edu.ifrs.poa.inf.aula.sisdoc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by 0291048 on 05/07/2017.
 */

public class SisDocRepository {
    private BDUtil bdUtil;

    public SisDocRepository(Context context){
        bdUtil =  new BDUtil(context);
    }

    public String insert_servidores(String nome, String torre, String sala,String horario){
        ContentValues valores = new ContentValues();
        valores.put("NOME", nome);
        valores.put("TORRE", torre);
        valores.put("SALA", sala);
        valores.put("HORARIO", horario);
        long resultado = bdUtil.getConexao().insert("SERVIDORES", null, valores);
        if (resultado ==-1)
            return "Erro ao inserir registro";
        return "Registro Inserido com sucesso";
    }
    public Servidor getServidores(String nome){
        Cursor cursor =  bdUtil.getConexao().rawQuery("SELECT * FROM SERVIDORES WHERE NOME = '"+ nome+"'",null);
        cursor.moveToFirst();
        Servidor s = new Servidor();
        s.set_id(cursor.getInt(cursor.getColumnIndex("_ID")));
        s.setNome(cursor.getString(cursor.getColumnIndex("NOME")));
        s.setTorre(cursor.getString(cursor.getColumnIndex("TORRE")));
        s.setSala(cursor.getString(cursor.getColumnIndex("SALA")));
        s.setHorario(cursor.getString(cursor.getColumnIndex("HORARIO")));
        return s;
    }

    public String insert_comunidade(String nome, String matricula, String senha){
        ContentValues valores = new ContentValues();
        valores.put("NOME", nome);
        valores.put("MATRICULA", matricula);
        valores.put("SENHA", senha);
        long resultado = bdUtil.getConexao().insert("COMUNIDADE", null, valores);
        if (resultado ==-1)
            return "Erro ao inserir registro";
        return "Registro Inserido com sucesso";
    }
    public Servidor getComunidade(String matricula, String senha){
        Cursor cursor =  bdUtil.getConexao().rawQuery("SELECT * FROM COMUNIDADE WHERE MATRICULA = '"+ matricula+"' AND SENHA = '"+ senha+"'",null);
        Servidor c = new Servidor();
        if(cursor.getCount()>0) {
            cursor.moveToFirst();
            c.set_id(cursor.getInt(cursor.getColumnIndex("_ID")));
            c.setNome(cursor.getString(cursor.getColumnIndex("NOME")));
            c.setTorre(cursor.getString(cursor.getColumnIndex("MATRICULA")));
            c.setSala(cursor.getString(cursor.getColumnIndex("SENHA")));
            return c;
        }
        else
        {
            c.set_id(0);
            c.setNome("");
            c.setTorre("");
            c.setSala("");
            return c;
        }
    }
}
