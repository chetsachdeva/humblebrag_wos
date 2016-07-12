package com.statusbrew.chetsachdeva.humblebragwos.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.statusbrew.chetsachdeva.humblebragwos.R;
import com.statusbrew.chetsachdeva.humblebragwos.widgets.zoomableFrescoImageView.zoomable.ZoomableDraweeView;

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

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.full_screen_image, container, false);

        ZoomableDraweeView sdvImage = (ZoomableDraweeView) viewLayout.findViewById(R.id.sdv_Image);

        DraweeController ctrl = Fresco.newDraweeControllerBuilder().setUri(imagesList.get(position)).build();

        GenericDraweeHierarchy hierarchy = new GenericDraweeHierarchyBuilder(context.getResources())
                .setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER)
                .setProgressBarImage(ContextCompat.getDrawable(context, R.drawable.ic_loading))
                .build();

        sdvImage.setController(ctrl);
        sdvImage.setEnabled(true);
        sdvImage.setHierarchy(hierarchy);
        container.addView(viewLayout);

        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}