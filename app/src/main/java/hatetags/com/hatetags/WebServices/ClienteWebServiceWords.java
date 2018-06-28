package hatetags.com.hatetags.WebServices;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.transform.Result;

public class ClienteWebServiceWords extends AsyncTask<Void, Void, String> {

    public ClienteWebServiceWords(){}
    @Override
    protected String doInBackground(Void... params) {
        // Esta etapa é usada para executar a tarefa em background ou fazer a chamada para o webservice

        try {

            URL url = new URL("http://10.214.177.97:8080/hatetags/tweets/trendingwords");

            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setDoOutput(true);
            urlConnection.setConnectTimeout(20000);
            urlConnection.connect();

            return converterInputStreamToString(url.openStream());

        }catch (Exception ex){
            ex.printStackTrace();
            return "Erro ao conectar com a API";
        }

    }
    @Override
    protected void onPreExecute () {
        // Este passo é usado para configurar a tarefa, por exemplo, mostrando uma barra de progresso na interface do usuário.
    }

    protected void onPostExecute (Result result) {
        // O resultado da execução em background é passado para este passo como um parâmetro.
    }

    private static String converterInputStreamToString(InputStream is){
        StringBuffer buffer = new StringBuffer();
        try{
            BufferedReader br;
            String linha;

            br = new BufferedReader(new InputStreamReader(is));
            while((linha = br.readLine())!=null){
                buffer.append(linha);
            }

            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return buffer.toString();
    }
}
