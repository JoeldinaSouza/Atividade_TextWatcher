package com.example.projetoapp;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

public class BuscarNomeTextWatcher implements TextWatcher {

	@Override
    public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
        Log.i("EditTExtListener", "beforeTextChanged: " + charSequence);
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
        Log.i("EditTExtListener","onTextChanged: " + charSequence);


    }

    @Override
    public void afterTextChanged(Editable editable) {
        Log.i("EditTExtListener","afterTextChanged: " + editable);
    }

	
}
