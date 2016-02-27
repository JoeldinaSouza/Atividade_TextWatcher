package com.example.projetoapp;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

public class NomeAsyncTask extends AsyncTask<JSONObject,Void,Response> {

	String nome;
	
	@Override
    protected Response doInBackground(JSONObject... jsons) {

        Response response = null;

        JSONObject json = jsons[0];
        Log.i("EditTextListener", "doInBackground (JSON): " + json);

        try {

            response = HttpService.sendJSONPostResquest("get-mensagem", json);

        } catch (IOException e) {

            Log.e("EditTextListener", e.getMessage());
        }

        return response;
        }
	
	@Override
    protected void onPostExecute(Response responseServidor) {

        Log.i("EditTextListener", "Código HTTP: " + responseServidor.getStatusCodeHttp()
                + " Conteúdo: " + responseServidor.getContentValue());
        
        ArrayList<String> nomes = new ArrayList<>();

        try {
			JSONArray jsonArray = new JSONArray(response.getContentValue());
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = new JSONObject(jsonArray.getString(i));
                nomes.add(jsonObject.getString("fullName"));
				nomes.add(nome);
                i++;
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
	}
}

