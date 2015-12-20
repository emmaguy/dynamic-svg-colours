package com.emmaguy.svgtest;

import android.content.res.Resources;
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
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final View button = findViewById(R.id.button);
        button.setOnClickListener(this);

        imageView = (ImageView) findViewById(R.id.imageview);

        final ContextThemeWrapper wrapper = new ContextThemeWrapper(this, R.style.DefaultScene);
        changeTheme(wrapper.getTheme());
    }

    private void changeTheme(@StyleRes final Resources.Theme theme) {
        final Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.christmas, theme);
        imageView.setImageDrawable(drawable);
    }

    @Override public void onClick(final View v) {
        final Resources.Theme theme = getResources().newTheme();

        theme.applyStyle(R.style.BaubleRound, false);
        theme.applyStyle(R.style.BaubleSmall, false);

        changeTheme(theme);
    }
}
