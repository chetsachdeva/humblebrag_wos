package com.statusbrew.chetsachdeva.humblebragwos.show_image;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.statusbrew.chetsachdeva.humblebragwos.R;
import com.statusbrew.chetsachdeva.humblebragwos.adapters.FullScreenImageAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FullScreenActivity extends AppCompatActivity {

    @Bind(R.id.vp_images)
    ViewPager vpImages;

    ArrayList<String> imagesList;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);
        ButterKnife.bind(this);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (getIntent().hasExtra("imagesList")) {
            imagesList = getIntent().getExtras().getStringArrayList("imagesList");
        }
        if (getIntent().hasExtra("position")) {
            position = getIntent().getExtras().getInt("position");
        }

        vpImages.setAdapter(new FullScreenImageAdapter(this, imagesList));
        vpImages.setCurrentItem(position);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
