package com.example.workshop8wtabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem tab1, tab2, tab3, tab4;
    public PageAdapter pageradapter;
    ListView lvCustomers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tab1 = (TabItem) findViewById(R.id.CustomerTab);
        tab2 = (TabItem) findViewById(R.id.AgentTab);
        tab3 = (TabItem) findViewById(R.id.BookingTab);
        tab4 = (TabItem) findViewById(R.id.PackageTab);
        viewPager = findViewById(R.id.viewpager);

        lvCustomers = findViewById(R.id.lvCustomers);
        loadCustomers();

        pageradapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageradapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {
                    pageradapter.notifyDataSetChanged();
                } else if (tab.getPosition() == 1) {
                    pageradapter.notifyDataSetChanged();
                } else if (tab.getPosition() == 2) {
                    pageradapter.notifyDataSetChanged();
                } else if (tab.getPosition() == 3) {
                    pageradapter.notifyDataSetChanged();
                } else if (tab.getPosition() == 4) {
                    pageradapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }


    private void loadCustomers() {
        new GetCustomers().execute();
    }

    class GetCustomers extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            StringBuffer buffer = new StringBuffer();
            try {
                URL url = new URL("http://192.168.1.131:8080/lab8/rs/customer/getallcustomers");
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

            ArrayAdapter<Customers> adapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1);

            try {
                JSONArray jsonArray = new JSONArray(s);
                for (int i=0; i<jsonArray.length(); i++)
                {
                    JSONObject c = jsonArray.getJSONObject(i);
                    adapter.add(new Customers(c.getInt("customerId"), c.getInt("agentId"),
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
