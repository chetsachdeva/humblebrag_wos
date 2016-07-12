package com.statusbrew.chetsachdeva.humblebragwos.show_image;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.statusbrew.chetsachdeva.humblebragwos.R;
import com.statusbrew.chetsachdeva.humblebragwos.adapters.FullScreenImageAdapter;
import com.statusbrew.chetsachdeva.humblebragwos.webapi.models.get_tweets.Retweeted_status;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FullScreenActivity extends AppCompatActivity {

    @Bind(R.id.pager)
    ViewPager viewPager;

    ArrayList<String> imagesList;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);
        ButterKnife.bind(this);

        if(getIntent().hasExtra("imagesList")) {
            imagesList = getIntent().getExtras().getStringArrayList("imagesList");
        }
        if(getIntent().hasExtra("position")) {
            position = getIntent().getExtras().getInt("position");
        }

        viewPager.setAdapter(new FullScreenImageAdapter(this,imagesList));
        viewPager.setCurrentItem(position);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
