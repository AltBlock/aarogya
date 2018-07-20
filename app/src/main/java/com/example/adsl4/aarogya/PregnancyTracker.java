package com.example.adsl4.aarogya;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.DateFormatSymbols;
import java.util.Calendar;

public class PregnancyTracker extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=4000;
    CalendarView calendarView;
    private Context context;

    TextView txtDate;
Calendar calendar;
    private NotificationCompat.Builder builder;
    private NotificationManager notificationManager;
    private int notification_id=1;
    Button btnPregSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregnancy_tracker);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Aarogya: Pregnancy Tracker");

        context=this;
        final int radioNotification=notification_id+1;
        notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent button_intent= new Intent("Button_clicked");
        button_intent.putExtra("id",radioNotification);

        btnPregSubmit=findViewById(R.id.btnPregSubmit);
        btnPregSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(PregnancyTracker.this)
                        .setIcon(R.drawable.logo1)
                        .setTitle("Aarogya")
                        .setMessage("Your date is being recorded.")
                        .setCancelable(false)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent=new Intent(context,MainActivity.class);
                                startActivity(intent);
                            }
                        })
                        .show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent notification_intent=new Intent(context,PregnancyTracker.class);
                        PendingIntent pendingIntent=PendingIntent.getActivity(context,0,notification_intent,0);

                        builder=new NotificationCompat.Builder(context,"hello");
                        builder.setSmallIcon(R.drawable.logo1)
                                .setContentTitle("Due Date")
                                .setContentText("Its your time for 1st checkup.")
                                .setContentIntent(pendingIntent);
                        notificationManager.notify(radioNotification,builder.build());
                    }
                },SPLASH_TIME_OUT);
            }
        });

        calendarView=findViewById(R.id.calendarView);
        txtDate=findViewById(R.id.txtDate);
        calendarView.setOnDateChangeListener( new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
              // calendar= new GregorianCalendar( year, month, dayOfMonth );
               txtDate.setText(new DateFormatSymbols().getMonths()[month]+" "+dayOfMonth+", "+year);

            }
        });


    }
}
