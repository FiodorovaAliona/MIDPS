package com.example.alionka.a001pomodoro;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements SoundPool.OnLoadCompleteListener {

    public static SoundPool sp;
    public static int soundIdShot;
    final int MAX_STREAMS = 5;
    final String LOG_TAG = "myLogs";

    static boolean WorkF;
    static int tWork;
    static int tRel;
    static int currentTime;
    static CountDownTimer tim1;
    public static Context c;
    EditText textWork;
    EditText textRelax;
    static TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textWork = (EditText) findViewById(R.id.TextWork);
        textRelax = (EditText) findViewById(R.id.TextRelax);
        time = (TextView) findViewById(R.id.time);
        sp = new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0);
        sp.setOnLoadCompleteListener(this);

        soundIdShot = sp.load(this, R.raw.zvon, 1);
        tWork = tRel = 0;


        WorkF = true;
    }

    public void butStartOnClick(final View view) {
        try {
            tWork = Integer.parseInt(textWork.getText().toString());
            tRel = Integer.parseInt(textRelax.getText().toString());
            currentTime = tWork;
            if(tim1 != null) {
                tim1.cancel();
                WorkF = true;
            }
            c = view.getContext();
            setTimer(c);
        } catch (Exception e) {
            tWork = tRel = 0;
        }
    }

    static public void setTimer(final Context cont) {
        tim1 = new CountDownTimer(currentTime * 60 * 1000, 1000) {
            int i = 1;
            String str = "";

            public void onTick(long millisUntilFinished) {
                int cur = currentTime * 60 - i++;
                str = (cur / 60) + ":" + (cur % 60);
                time.setText(str);

            }

            public void onFinish() {
                sp.play(soundIdShot, 1, 1, 0, 0, 1);
                time.setText("0:00");
                AlertDialog.Builder builder = new AlertDialog.Builder(cont);
                if (WorkF == true) {
                    builder.setTitle("Закончилосьвремя работы!")
                            .setMessage("Время отдыха!")
                            .setCancelable(false)
                            .setNegativeButton("ОК",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            WorkF = false;
                                            currentTime = tRel;
                                            setTimer(cont);
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                } else {
                    builder.setTitle("Время отдыха закончилось!")
                            .setMessage("Ещё круг?")
                            .setCancelable(false)
                            .setNegativeButton("Да",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            currentTime = tWork;
                                            WorkF = true;
                                            setTimer(cont);
                                            dialog.cancel();
                                        }
                                    })
                            .setPositiveButton("Нет",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            }
        }.start();
    }

    @Override
    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {

    }
}
