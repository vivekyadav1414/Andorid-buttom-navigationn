package com.vivek.musicapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private LinearLayout navLocal, navSearch, navOnline;
    private ImageView iconLocal, iconSearch, iconOnline;
    private TextView textLocal, textSearch, textOnline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        views();
    }

    private void views() {
        navLocal = findViewById(R.id.nav_local);
        navSearch = findViewById(R.id.nav_search);
        navOnline = findViewById(R.id.nav_online);

        iconLocal = findViewById(R.id.icon_local);
        iconSearch = findViewById(R.id.icon_search);
        iconOnline = findViewById(R.id.icon_online);

        textLocal = findViewById(R.id.text_local);
        textSearch = findViewById(R.id.text_search);
        textOnline = findViewById(R.id.text_online);

        navLocal.setOnClickListener(v -> selectTab("local"));
        navSearch.setOnClickListener(v -> selectTab("search"));
        navOnline.setOnClickListener(v -> selectTab("online"));
    }


    private void selectTab(String tab) {
        resetTabs();

        if (tab.equals("local")) {
            navLocal.setBackground(getDrawable(R.drawable.bg_selected));
            iconLocal.setColorFilter(getColor(R.color.purple));
            textLocal.setTextColor(getColor(R.color.purple));

        } else if (tab.equals("search")) {
            navSearch.setBackground(getDrawable(R.drawable.bg_selected));
            iconSearch.setColorFilter(getColor(R.color.purple));
            textSearch.setTextColor(getColor(R.color.purple));

        } else {
            navOnline.setBackground(getDrawable(R.drawable.bg_selected));
            iconOnline.setColorFilter(getColor(R.color.purple));
            textOnline.setTextColor(getColor(R.color.purple));
        }
    }

    private void resetTabs() {
        navLocal.setBackground(null);
        navSearch.setBackground(null);
        navOnline.setBackground(null);

        int defaultColor = getColor(R.color.gray);

        iconLocal.setColorFilter(defaultColor);
        iconSearch.setColorFilter(defaultColor);
        iconOnline.setColorFilter(defaultColor);

        textLocal.setTextColor(defaultColor);
        textSearch.setTextColor(defaultColor);
        textOnline.setTextColor(defaultColor);
    }
}