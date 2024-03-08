package com.example.practical132;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn= findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(MainActivity.this);

                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("File Downloading");
                progressDialog.setProgress(100);

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int progress = 0;
                        while (progress <= 100) {
                            try {
                                progressDialog.setProgress(progress);
                                progress++;
                                Thread.sleep(200);
                            } catch (Exception ex) {
                            }
                        }
                        progressDialog.dismiss();
                    }
                });
                t.start();
                progressDialog.show();
            }
        });
    }
}