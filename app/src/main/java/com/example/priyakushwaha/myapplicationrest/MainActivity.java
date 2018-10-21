package com.example.priyakushwaha.myapplicationrest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    private static final String url = "http://api.jyinfotech.co.in/demo/danikpanchag.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.hello);
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        //RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("VOLLEY", response);
                t1.setText(response);
                JSONObject jsonObject= null;
                try {
                    jsonObject = new JSONObject(response);
                    String temp=jsonObject.getString("code");
                   // JSONObject jsonObject1=jsonObject.getJSONObject("hindu_maah");
                  //  String temp1= jsonObject1.getString("amanta");
                   // Log.i("code",temp1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // JSONObject c=jsonObject.getString("day");




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Log.i("VOLLEY", error.toString());

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("category", "tula");

                return params;
            }


        };
        requestQueue.add(request);
    }

}

