package com.gopir.txt2spch;

import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech ts1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText ed=(EditText)findViewById(R.id.editText );
        Button  b=(Button)findViewById(R.id.button );

        ts1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status !=TextToSpeech.ERROR ){
                    ts1.setLanguage(Locale.ENGLISH );
                }

            }
        }) ;
        b.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                String s1=ed.getText().toString();
                ts1.speak(s1,TextToSpeech.QUEUE_FLUSH ,null,null) ;
            }
        }) ;

    }
    public void onPause(){
        if(ts1!=null ){
            ts1.stop();
            ts1.shutdown();
        }
        super.onPause();
    }
}
