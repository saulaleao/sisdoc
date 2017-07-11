package br.edu.ifrs.poa.inf.aula.sisdoc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
//import java.lang.String.*;

/**
 * Created by cleber and saula on 08/07/2017.
 */

public class ServidorHttpJSON {
    public static final String SERVIDORES_URL_JSON = "http://aula.inf.poa.ifrs.edu.br/~0291048/sisdoc/servidor_sala.json";
    private static HttpURLConnection connectar(String urlArquivo) throws IOException {
        final int SEGUNDOS = 1000;
        URL url = new URL(urlArquivo);
        HttpURLConnection conexao = (HttpURLConnection)url.openConnection();
        conexao.setReadTimeout(10 * SEGUNDOS);
        conexao.setConnectTimeout(15 * SEGUNDOS);
        conexao.setRequestMethod("GET");
        conexao.setDoInput(true);
        conexao.setDoOutput(false);
        conexao.connect();
        return conexao;
    }
    public static boolean temConexao(Context ctx) {
        ConnectivityManager cm = (ConnectivityManager)
                ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return (info != null && info.isConnected());
    }
    public static List<Servidor> carregarServidoresJson() {
        try {
            HttpURLConnection conexao = connectar(SERVIDORES_URL_JSON);
            int resposta = conexao.getResponseCode();
            if (resposta ==  HttpURLConnection.HTTP_OK) {
                InputStream is = conexao.getInputStream();
                JSONObject json = new JSONObject(bytesParaString(is));
                return lerJsonServidores(json);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Servidor> lerJsonServidores(JSONObject json) throws JSONException {
        List<Servidor> lista = new ArrayList<>();
        JSONArray jsonServidores = json.getJSONArray("servidores");
        for (int i = 0; i < jsonServidores.length(); i++) {
            JSONObject jsonServidor = jsonServidores.getJSONObject(i);
            Servidor servidor = new Servidor(
                    jsonServidor.getString("nome"),
                    jsonServidor.getString("torre"),
                    jsonServidor.getString("sala"),
                    jsonServidor.getString("horario"));
            lista.add(servidor);
        }
        return lista;
    }

    private static String bytesParaString(InputStream is) throws IOException {
        byte[] buffer = new byte[1024];
        // O bufferzao vai armazenar todos os bytes lidos
        ByteArrayOutputStream bufferzao = new ByteArrayOutputStream();
        // precisamos saber quantos bytes foram lidos
        int bytesLidos;
        // Vamos lendo de 1KB por vez...
        while ((bytesLidos = is.read(buffer)) != -1) {
            // copiando a quantidade de bytes lidos do buffer para o bufferzão
            bufferzao.write(buffer, 0, bytesLidos);
        }
        return new String(bufferzao.toByteArray(), "UTF-8");
    }


}

