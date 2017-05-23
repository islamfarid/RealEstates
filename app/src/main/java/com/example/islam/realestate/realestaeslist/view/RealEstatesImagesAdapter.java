package com.example.islam.realestate.realestaeslist.view;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.islam.realestate.R;
import com.example.islam.realestate.data.models.ImagesItem;

import java.util.List;


/**
 * Created by islam on 23/05/17.
 */

public class RealEstatesImagesAdapter extends PagerAdapter {

    private Activity mActivity;
    private List<ImagesItem> mImagesList;

    public RealEstatesImagesAdapter(Activity mActivity, List<ImagesItem> imagesList) {
        this.mActivity = mActivity;
        mImagesList = imagesList;
    }

    @Override
    public int getCount() {
        return mImagesList != null ? mImagesList.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater mLayoutInflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = mLayoutInflater.inflate(R.layout.layout_real_estate_images_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageview_real_estate_image);
        Glide.with(mActivity)
                .load(mImagesList.get(position).getUrl())
                .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE))
                .into( imageView);
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
