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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by islam on 23/05/17.
 */

public class RealEstatesListAdapter extends RecyclerView.Adapter {
    List<ItemsItem> mItemsItems;
    Activity mActivity;
    private static final int REAL_ESTATE_LIST_TYPE = 0;
    private static final int ADVERTISE_TYPE = 1;

    public RealEstatesListAdapter(Activity activity, List<ItemsItem> itemsItems) {
        this.mActivity = activity;
        this.mItemsItems = itemsItems;
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
        return (position + 1) % 3 != 0 ? REAL_ESTATE_LIST_TYPE : ADVERTISE_TYPE;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof RealEstateViewHolder) {
            RealEstatesImagesAdapter realEstatesImagesAdapter = new RealEstatesImagesAdapter(mActivity, mItemsItems.get(i).getImages());
            ((RealEstateViewHolder) viewHolder).realeEstateImagesViewPager.setAdapter(realEstatesImagesAdapter);
            ((RealEstateViewHolder) viewHolder).indicator.setViewPager(((RealEstateViewHolder) viewHolder).realeEstateImagesViewPager);
            ((RealEstateViewHolder) viewHolder).realeEstateTitleTextView.setText(mItemsItems.get(i).getTitle());
            ((RealEstateViewHolder) viewHolder).realeEstatePriceTextView.setText(String.valueOf(mActivity.getString(R.string.real_estate_price, mItemsItems.get(i).getPrice())));
        } else if (viewHolder instanceof AdvertiseViewHolder) {
            ((AdvertiseViewHolder) viewHolder).advertiseNumberTextView.setText(String.valueOf(i + 1));
        }
    }

    @Override
    public int getItemCount() {
        return mItemsItems.size();
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
