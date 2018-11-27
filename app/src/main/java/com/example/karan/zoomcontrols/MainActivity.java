package com.example.karan.zoomcontrols;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ZoomControls;


public class MainActivity extends AppCompatActivity {
    //TODO Declare variables to use in the code
    private Button show, hide;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO Gathers resources and allows for them to be utilized
        final ZoomControls ZoomControls = (ZoomControls) findViewById(R.id.ZoomControl);
        hide = (Button) findViewById(R.id.hidebtn);
        show = (Button) findViewById(R.id.showbtn);
        image = (ImageView) findViewById(R.id.imageView);

        //TODO creates a onclick listener for the show button, shows the Zoomcontrol
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomControls.show();
            }
        });

        //TODO creates a onclick listener for the hide button, hides the Zoom control
        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomControls.hide();
            }
        });

        //TODO creates a onclick listener for the zoomin button on the Zoom Control allowing for us to zoom in
        ZoomControls.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = image.getScaleX();
                float y = image.getScaleY();
                // set increased value of scale x and y to perform zoom in functionality
                image.setScaleX((float) (x + 0.3));
                image.setScaleY((float) (y + 0.3));
            }
        });

        //TODO creates a onclick listener for the zoomout button on the Zoom control allowing for us to zoom out
        ZoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = image.getScaleX();
                float y = image.getScaleY();
                // set decreased value of scale x and y to perform zoom out functionality
                image.setScaleX((float) (x - 0.3));
                image.setScaleY((float) (y - 0.3));
            }
        });
    }
}

