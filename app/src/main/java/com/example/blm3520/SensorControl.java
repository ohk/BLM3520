package com.example.blm3520;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SensorControl extends AppCompatActivity implements SensorEventListener {
    TextView ligthText ;
    TextView accelerometerText;
    LinearLayout layout;

    SensorManager sensorManager;

    Sensor lightSensor;
    Sensor accelerometerSensor;

    Float X;
    Float Y;
    Float Z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        ligthText = findViewById(R.id.textView_sensor_light);
        accelerometerText = findViewById(R.id.textView_sensor_accelerometer);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        layout = findViewById(R.id.sensor_layout);

        (findViewById(R.id.btn_sensor_back)).setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent menu = new Intent(SensorControl.this,Menu.class);
                startActivity(menu);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,lightSensor,SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this,accelerometerSensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() ==Sensor.TYPE_LIGHT){
            ligthText.setText("***Sensor karanlık sınırı 650'dir***\n\nLight Sensor Value:"+event.values[0]);
            if(event.values[0]<650){
                layout.setBackgroundColor(-16777216);
                accelerometerText.setTextColor(-1);
                ligthText.setTextColor(-1);
            } else {
                layout.setBackgroundColor(-1);
                accelerometerText.setTextColor(-16777216);
                ligthText.setTextColor(-16777216);
            }
        }

        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            X = event.values[0];
            Y = event.values[1];
            Z = event.values[2];
            accelerometerText.setText("\n\nAccelerometer Values\nX: " + X.toString() + "Y: " + Y.toString() + "Z: " + Z.toString());
            new Thread(new Runnable() {
                public void run(){
                    try {

                        float backX = X;
                        float backY = Y;
                        float backZ = Z;
                        Thread.sleep(5000);
                        if (backX < X*1.30 && backX > X*0.7 && -backY < Y*1.30 && -backY > Y*0.7  && backZ < Z*1.30 && backZ > Z*0.7) {
                            Toast.makeText(getApplicationContext(), "Application Closed", Toast.LENGTH_LONG).show();
                            Thread.sleep(2000);
                            finish();
                            System.exit(0);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
    }

    @Override
    public void onAccuracyChanged(android.hardware.Sensor sensor, int accuracy) {

    }
}
