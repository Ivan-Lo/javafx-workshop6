package com.example.workshop8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ListView lvCustomers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCustomers = findViewById(R.id.lvCustomers);

        loadCustomers();
    }

    private void loadCustomers() {
        new GetCustomers().execute();
    }

    class GetCustomers extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            StringBuffer buffer = new StringBuffer();
            try {
                URL url = new URL("http://192.168.0.18:8080/Lab8-1/rs/customer/getallcustomers");
                BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
                String json;
                while ((json = br.readLine()) != null) {
                    buffer.append(json);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return buffer.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            ArrayAdapter<Customer> adapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1);

            try {
                JSONArray jsonArray = new JSONArray(s);
                for (int i=0; i<jsonArray.length(); i++)
                {
                    JSONObject c = jsonArray.getJSONObject(i);
                    adapter.add(new Customer(c.getInt("customerId"), c.getInt("agentId"),
                            c.getString("custAddress"), c.getString("custBusPhone"),
                            c.getString("custCity"), c.getString("custCountry"),
                            c.getString("custEmail"), c.getString("custFirstName"),
                            c.getString("custHomePhone"), c.getString("custLastName"),
                            c.getString("custPostal"), c.getString("custProv")));
                }
                lvCustomers.setAdapter(adapter);
            } catch (JSONException e){
                e.printStackTrace();
            }
        }
    }
}