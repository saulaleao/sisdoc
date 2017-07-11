package br.edu.ifrs.poa.inf.aula.sisdoc;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDUtil extends SQLiteOpenHelper {

    private static final String BASE_DE_DADOS = "SISDOC";
    private static final int VERSAO = 1;

    public BDUtil(Context context){
        super(context,BASE_DE_DADOS,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder criarTabela = new StringBuilder();
        criarTabela.append(" CREATE TABLE SERVIDORES (");
        criarTabela.append(" _ID     INTEGER PRIMARY KEY AUTOINCREMENT, ");
        criarTabela.append(" NOME    TEXT    NOT NULL,");
        criarTabela.append(" TORRE   TEXT    NOT NULL,");
        criarTabela.append(" SALA    TEXT    NOT NULL,");
        criarTabela.append(" HORARIO TEXT    NOT NULL)");
        db.execSQL(criarTabela.toString());

        StringBuilder criarTabela2 = new StringBuilder();
        criarTabela2.append(" CREATE TABLE COMUNIDADE (");
        criarTabela2.append(" _ID        INTEGER PRIMARY KEY AUTOINCREMENT, ");
        criarTabela2.append(" NOME       TEXT    NOT NULL,");
        criarTabela2.append(" MATRICULA  TEXT    NOT NULL,");
        criarTabela2.append(" SENHA      TEXT  NOT NULL)");
        db.execSQL(criarTabela2.toString());

    }

    /*Método abaixo é executado quando troa a versão do BD*/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS SERVIDORES");
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS COMUNIDADE");
        onCreate(db);

    }

    /*Método usado para obter a conexão com o BD*/
    public SQLiteDatabase getConexao(){
        return this.getWritableDatabase();
    }




}

