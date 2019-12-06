package com.projetoandroid.Services;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;

import com.projetoandroid.ActivityAdicionarRestaurante;
import com.projetoandroid.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;



    public class ConsultaCepTask  extends AsyncTask<String, Object, String> {

        private WeakReference<ActivityAdicionarRestaurante> reference;

        public ConsultaCepTask(Context context) {
            this.reference = new WeakReference<>(
                    (ActivityAdicionarRestaurante) context);
        }

        @Override
        protected String doInBackground(String... listaCep) {
            String cep = listaCep[0];

            WebClient client = new WebClient();
            String response = client.getCep(cep);

            return response;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {

                JSONObject json = new JSONObject(s);
                String rua = json.getString("rua");

                EditText editTextRua = reference.get().findViewById(R.id.RuaRestaurante);
                editTextRua.setText(rua);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

