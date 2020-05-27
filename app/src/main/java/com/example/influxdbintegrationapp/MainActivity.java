package com.example.influxdbintegrationapp;

import android.os.Bundle;
import android.widget.TextView;
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
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    InfluxLambdaService service;
    MetricDataWrapper metric;
    Timer taskTimer = new Timer();
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView = findViewById(R.id.textView);
        textView.setText(Integer.toString(0));

        FloatingActionButton fab = findViewById(R.id.fab);

        // Create service
        this.service = InfluxLambdaServiceBuilder.getRetrofitInstance()
                .create(InfluxLambdaService.class);

        // Creates a Sensor Data Object (example with dummy data)

        metric = new MetricDataWrapper(
                new StaticGateway(
                        1,
                        1,
                        "example"),
                new ArrayList<>()
        );

        // Create job
        TimerTask sendToInfluxTask = new TimerTask() {
            @Override
            public void run() {

                // only send data if one or more datapoint has been received
                if (metric != null && metric.getValues()
                        .size() > 0) {
                    sendTestDataToInflux(metric);
                }
            }
        };

        // this task mocks ble input
        TimerTask receiveTask = new TimerTask() {
            @Override
            public void run() {
                // create new sensor Data Object create new Sensor wrapper
                // Partector Object
                SensorDataWrapper sensorData = new SensorDataWrapper(
                        new PartectorData(1,
                                          2,
                                          3,
                                          4,
                                          5,
                                          6,
                                          7,
                                          8,
                                          9),
                        new GatewayData(1,
                                        2,
                                        3),
                        new LocationData(1,
                                         2),
                        10,
                        "robin");
                // add data to datapoint list
                metric.getValues()
                        .add(sensorData);
                setListLengthText(metric.getValues()
                                          .size());
            }
        };

        taskTimer.scheduleAtFixedRate(sendToInfluxTask, 0l, 10000);
        taskTimer.scheduleAtFixedRate(receiveTask, 0l, 1000);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendTestDataToInflux(metric);
            }
        });

    }

    public void showToast(final String toast) {
        runOnUiThread(() -> Toast.makeText(MainActivity.this, toast, Toast.LENGTH_SHORT)
                .show());
    }

    public void setListLengthText(final int lengthText) {
        runOnUiThread(() -> this.textView.setText(Integer.toString(lengthText) + " datapoints stored"));
    }

    // sends message non blocking to  Influx and shows error or status code in toast
    private void sendTestDataToInflux(MetricDataWrapper metric) {
        Call<ResponseBody> res = this.service.uploadMetric(metric);
        res.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                metric.setValues(new ArrayList<>());
                System.out.println(metric.getValues()
                                           .size());
                showToast("Success");
                setListLengthText(metric.getValues()
                                          .size());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                showToast("Error");
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
