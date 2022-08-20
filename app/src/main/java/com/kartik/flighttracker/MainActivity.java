package com.kartik.flighttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String num = "";
    String name = "";
    String date;
    String api_key = "63006abcddef1bf408405032";
    String url = "https://api.flightapi.io/airline/"+api_key+"?num="+num+"&name="+name+"&date="+date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText flight_num = findViewById(R.id.flight_num);
        EditText flight_name = findViewById(R.id.flight_name);
        EditText flight_date = findViewById(R.id.flight_date);
        num = flight_num.getText().toString();
        name = flight_name.getText().toString();
        date = flight_date.getText().toString();
        TextView tv = findViewById(R.id.textView);
        tv.setText("");

        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create())
                .build();


        myapi api = retrofit.create(myapi.class);
        Call<List<model>> call =  api.getmodel();

        call.enqueue(new Callback<List<model>>() {
            @Override
            public void onResponse(Call<List<model>> call, Response<List<model>> response) {
                List<model> data = response.body();
//                for (int i=0;i<data.size();i++){
                    tv.append("Airport name: "+ data.getAAname()+"\n Arrival Time "+data.get(i).getAtime()+
                            "\n Destination Airport Name: "+data.get(i).getDAname()+"\n Destination arrival time: "+data.get(i).Dtime);
//                }
            }
            @Override
            public void onFailure(Call<List<model>> call, Throwable t) {
            }
        });

    }
}