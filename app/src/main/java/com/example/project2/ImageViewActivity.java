package com.example.project2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ImageViewActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the Intent used to start this Activity
        final Intent intent = getIntent();

        // Make a new ImageView
          ImageView imageView = new ImageView(getApplicationContext());

        // Get the ID of the image to display and set it as the image for this ImageView
        imageView.setImageResource(intent.getIntExtra(MainActivity.EXTRA_RES_ID, 0));

        setContentView(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Parse the uri string
                Uri uri = Uri.parse(intent.getStringExtra(MainActivity.URL));
                Intent uriIntent = new Intent(Intent.ACTION_VIEW);
                uriIntent.setData(uri);
                uriIntent.addCategory(uriIntent.CATEGORY_BROWSABLE);
                startActivity(uriIntent);
            }
        });
    }
}
