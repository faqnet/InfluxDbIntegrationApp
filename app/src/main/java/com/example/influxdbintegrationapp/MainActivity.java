package com.example.influxdbintegrationapp;

import android.os.Bundle;
import android.widget.Toast;
import com.example.metrics.*;
import com.example.retroFitServiceBuilder.InfluxLambdaServiceBuilder;
import com.example.services.InfluxLambdaService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    InfluxLambdaService service;
    MetricDataWrapper metric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);

        // Create service
        this.service = InfluxLambdaServiceBuilder.getRetrofitInstance().create(InfluxLambdaService.class);

        // Creates a Sensor Data Object (example with dummy data)
        SensorDataWrapper sensorData = new SensorDataWrapper(
                new PartectorData(1,
                                  2,
                                  3,
                                  4,
                                  5,
                                  6,
                                  7,
                                  8,
                                  9), new GatewayData(1, 2, 3),
                new LocationData(1, 2), 10, "dsf");
        List<SensorDataWrapper> sensorsDatas = new ArrayList<SensorDataWrapper>();
        sensorsDatas.add(sensorData);
        metric = new MetricDataWrapper(new StaticGateway(1, 1, "example"),
                                       sensorsDatas);

        // send message to Influx
        this.sendTestDataToInflux();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendTestDataToInflux();
            }
        });

    }

    // sends message non blocking to  Influx and shows error or status code in toast
    private void sendTestDataToInflux() {
        Call<ResponseBody> res = this.service.uploadMetric(metric);
        res.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(MainActivity.this, Integer.toString(response.code()), Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }










    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
