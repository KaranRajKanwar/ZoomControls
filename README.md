# ZoomControls

## The Introduction

ZoomControls is a android widget class and Its main focus is to display simple controls for zooming in and zooming out for certain events. This can be used when zooming into any type of view, for example a textview, imageview , button and many other views. What happens when you place the Zoomcontrols library in the .xml file is it creates the  + and - icon for zooming in and zooming out but doesnt have functionality until you dont give it any logic. Once the button is given a id and declared as a resource in the activity you have functionality to either hide or show the zoom controls using a button declared in the resources. Those buttons must be in a  setOnClickListener for them to function when clicked, to be able to click the + and - in the zoomcontrols you must declare the id for the zoomController in the activity and then set the click by doing this "ZoomControls.setOnZoomInClickListener" which will respond to clicks on the + icon for zooming in and "ZoomControls.setOnZoomOutClickListener" which will respond to clicks on the - icon for zooming out. But now that you can click the zoomcontrols you must add logic into the onclicks, the code will look similar doe both + and - as the only difference will be the fact that one button is for zooming in and one is for zooming out. Inside both onclicks delcare variables for x and y floats as imagename.getScaleX() and imagename.getScaleY() and then on the next line add the values to imagename.getScale((float)(x+0.3)) you would rewrite that statement except with the value y. Then for - button we would do the same stuff except now instead of + we use - as so imagename.getScale((float)(x-0.3)). The zoomControls can also be used by the cellphone camera and can control the zoom of your camera.

## The History
The ZoomControl class was was introduced in API 1 and its included in the android.view.View, android.view.ViewGroup and android.widgetLinearLayout.

## The Major Methods / Attributes
|                            METHOD                            |                                USAGE 
|--------------------------------------------------------------|---------------------------------------------------------------|
|void show()                                                   |  Used to show ZoomControls if hidden                          |
|void hide()                                                   | Used to hide ZoomControls if visable                          |
|void setZoomSpeed(long speed)                                 |  Used to increase or decrease the zoom time                   |
|void setOnZoomOutClickListener(View.OnClickListener listener) |  Creates a onclick listener for the ZoomOut button on the Zoom| |                                                              |  Control allowing for us to zoom out.                         |
|void setOnZoomInClickListener(View.OnClickListener listener)  | Creates a onclick listener for the ZoomIn button on the Zoom  | |                                                              | Control allowing for us to zoom in.                           |
|void setIsZoomOutEnabled(Boolean isEnabled)                   | If enabled ZoomOut is allowed                                 |
|void setIsZoomInEnabled(Boolean isEnabled)                    | If enabled ZoomIn is allowed                                  |
|boolean onTouchEvent(MotionEvent event)                       | Used for when handling touch screen events                    |
|boolean hasFocus()                                            | Returns true if this view has or contains focus               |

## The Example Project

https://github.com/KaranRajKanwar/ZoomControls.git

## The Code

                                              MainActivity.Java
                                             
```Java
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
```

                                              activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    tools:layout_editor_absoluteY="81sp">
  
<!--Whatever picture I want to use the zoom functionality-->
    <ImageView
        android:id="@+id/imageView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="39sp"
        android:layout_marginBottom="12sp"
        android:src="@drawable/bmw"
        android:layout_centerInParent="true"
        app:layout_constraintBottom_toTopOf="@+id/ZoomControl"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
<!-- Creating the zoomcontrols button for the project-->
    <ZoomControls
        android:id="@+id/ZoomControl"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="15sp"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        app:layout_constraintBottom_toTopOf="@+id/hidebtn"
        app:layout_constraintEnd_toStartOf="@+id/hidebtn"
        app:layout_constraintTop_toBottomOf="@+id/imageView" />

  <!--button for showing the zoomcontrol button-->
    <Button
        android:id="@+id/showbtn"
        android:layout_width="80sp"
        android:layout_height="80sp"
        android:layout_marginStart="32sp"
        android:layout_marginEnd="167sp"
        android:text="@string/show"
        app:layout_constraintBottom_toBottomOf="@+id/hidebtn"
        app:layout_constraintEnd_toStartOf="@+id/hidebtn"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="@+id/hidebtn" />
  <!--button for hiding the zoomcontrol button-->
    <Button
        android:id="@+id/hidebtn"
        android:layout_width="80sp"
        android:layout_height="80sp"
        android:layout_marginEnd="25sp"
        android:layout_marginBottom="30sp"
        android:text="@string/hide"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/showbtn"
        app:layout_constraintTop_toBottomOf="@+id/ZoomControl" />

</android.support.constraint.ConstraintLayout>
```
                                                  strings.xml
```xml
<!--All of the strings required in the program-->
<resources>
    <string name="app_name">ZoomControls</string>
    <string name="show">Show</string>
    <string name="hide">Hide</string>
</resources>
```
## The Reference

-https://developer.android.com/reference/android/widget/ZoomControls

-https://abhiandroid.com/ui/zoomcontrols
