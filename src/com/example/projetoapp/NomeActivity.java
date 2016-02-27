package com.example.projetoapp;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class NomeActivity extends Activity implements TextWatcher {

	private static final int TAMANHO_MINIMO_TEXTO = 4;

	private EditText nomeEditText;
    List<String> nomes;
    ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		nomeEditText = (EditText) findViewById(R.id.nomeEditText);
        nomeEditText.addTextChangedListener(this);

        ListView nomesListView = (ListView) findViewById(R.id.list);
        nomes = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                nomes);

        nomesListView.setAdapter(adapter);
    }

	@Override
    public void afterTextChanged(Editable editable) {

        Log.i("EditTextListener","afterTextChanged: " + editable);
    }

	@Override
    public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
        Log.i("EditTExtListener", "beforeTextChanged: " + charSequence);
    }

	@Override
	public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
		Log.i("EditTExtListener", "beforeTextChanged: " + charSequence);
		
		Log.i("EditTextListener", "onTextChanged: " + charSequence);
        String nome = charSequence.toString();

        if (nome.length() >= TAMANHO_MINIMO_TEXTO) {
		    // JSON
		    JSONObject json = new JSONObject();
		    try{
		    json.put("fullName", nome);
		    } catch (JSONException e) {
		    e.printStackTrace();
		}

		    NomeActivity nomeActivity = new NomeActivity();
		    nomeActivity.execute(json);
		 // Adicionar ao ListView.
		    nomes.add(nome);
		    adapter.notifyDataSetChanged();
		}

		if (nome.length() == 0) {
		    nomes.clear();
		    adapter.notifyDataSetChanged();
		}
	}

	private void execute(JSONObject json) {		
	}
}
