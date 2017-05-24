package com.example.islam.realestate.realestaeslist.view;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.islam.realestate.R;
import com.example.islam.realestate.data.models.ItemsItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by islam on 23/05/17.
 */

public class RealEstatesListAdapter extends RecyclerView.Adapter {
    List<ItemsItem> mItemsItems;
    List<ItemsItem>  mDisplayedItems;
    Activity mActivity;
    private static final int REAL_ESTATE_LIST_TYPE = 0;
    private static final int ADVERTISE_TYPE = 1;
    private static final int ADVERTISE_FIXED_POSITION_IN_LIST = 3;

    public RealEstatesListAdapter(Activity activity, List<ItemsItem> itemsItems) {
        this.mActivity = activity;
        this.mItemsItems = itemsItems;
        mDisplayedItems = new ArrayList<>();
        mDisplayedItems.addAll(mItemsItems);
        int sizeAfterAddingAdvertisements = (mItemsItems.size() + mItemsItems.size()/2);
        for (int i = 1; i < sizeAfterAddingAdvertisements ;
             i += ADVERTISE_FIXED_POSITION_IN_LIST) {
            mDisplayedItems.add(i+1 , null);
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (i) {
            case ADVERTISE_TYPE:
                View advertiseType = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_real_estate_advertise_images_item, viewGroup, false);
                return new AdvertiseViewHolder(advertiseType);
            default:
                View realEstateType = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_real_estate_item, viewGroup, false);
                return new RealEstateViewHolder(realEstateType);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mDisplayedItems.get(position)!= null ? REAL_ESTATE_LIST_TYPE : ADVERTISE_TYPE;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof RealEstateViewHolder) {
            if (mDisplayedItems.get(position) != null) {
                RealEstatesImagesAdapter realEstatesImagesAdapter = new RealEstatesImagesAdapter(mActivity, mDisplayedItems.get(position).getImages());
                ((RealEstateViewHolder) viewHolder).realeEstateImagesViewPager.setAdapter(realEstatesImagesAdapter);
                ((RealEstateViewHolder) viewHolder).indicator.setViewPager(((RealEstateViewHolder) viewHolder).realeEstateImagesViewPager);
                ((RealEstateViewHolder) viewHolder).realeEstateTitleTextView.setText(mDisplayedItems.get(position).getTitle());
                ((RealEstateViewHolder) viewHolder).realeEstatePriceTextView.setText(String.valueOf(mActivity.getString(R.string.real_estate_price, mDisplayedItems.get(position).getPrice())));
            }
        } else if (viewHolder instanceof AdvertiseViewHolder) {
            ((AdvertiseViewHolder) viewHolder).advertiseNumberTextView.setText(String.valueOf(position + 1));
        }
    }

    @Override
    public int getItemCount() {
        return mDisplayedItems.size();
    }

    class RealEstateViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.viewpager_real_estates_images)
        ViewPager realeEstateImagesViewPager;
        @BindView(R.id.textview_title)
        TextView realeEstateTitleTextView;
        @BindView(R.id.textview_price)
        TextView realeEstatePriceTextView;
        @BindView(R.id.indicator)
        CircleIndicator indicator;

        public RealEstateViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    class AdvertiseViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageview_advertise)
        ImageView advertiseImageView;
        @BindView(R.id.textview_advertise_number)
        TextView advertiseNumberTextView;

        public AdvertiseViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
