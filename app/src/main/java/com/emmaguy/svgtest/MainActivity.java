package com.emmaguy.svgtest;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.StyleRes;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final View button = findViewById(R.id.button);
        button.setOnClickListener(this);

        imageView = (ImageView) findViewById(R.id.imageview);
        changeTheme(R.style.DefaultScene);
    }

    private void changeTheme(@StyleRes int styleId) {
        final ContextThemeWrapper wrapper = new ContextThemeWrapper(this, styleId);
        final Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.christmas, wrapper.getTheme());
        imageView.setImageDrawable(drawable);
    }

    @Override public void onClick(View v) {
        changeTheme(R.style.UpdatedScene);
    }
}
