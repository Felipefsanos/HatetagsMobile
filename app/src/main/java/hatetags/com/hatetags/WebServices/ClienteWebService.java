package hatetags.com.hatetags.WebServices;

import android.os.AsyncTask;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.xml.transform.Result;

public class ClienteWebService extends AsyncTask<Void, Void, String> {

    private long lastId;

    public ClienteWebService(long lastId) {
        this.lastId = lastId;
    }

    public void setLastId(long lastId) {
        this.lastId = lastId;
    }

    @Override
    protected String doInBackground(Void... params) {
        // Esta etapa é usada para executar a tarefa em background ou fazer a chamada para o webservice

        try {

            URL url = new URL("http://192.168.15.4:8080/hatetags/tweets/limited/"+lastId);

            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setDoOutput(true);
            urlConnection.setConnectTimeout(15000);
            urlConnection.connect();
            StringBuilder resposta = new StringBuilder();

            try {
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    resposta.append(scanner.next());
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }

            return resposta.toString();

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
}
