package com.statusbrew.chetsachdeva.humblebragwos.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.statusbrew.chetsachdeva.humblebragwos.R;

public class FullScreenImageAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<String> imagesList;
    private LayoutInflater inflater;

    public FullScreenImageAdapter(Context context, ArrayList<String> imagesList) {
        this.context = context;
        this.imagesList = imagesList;
    }

    @Override
    public int getCount() {
        return this.imagesList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        SimpleDraweeView sdvImage;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.full_screen_image, container, false);

        sdvImage = (SimpleDraweeView) viewLayout.findViewById(R.id.sdv_Image);
        sdvImage.setImageURI(Uri.parse(imagesList.get(position)));

        container.addView(viewLayout);

        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}