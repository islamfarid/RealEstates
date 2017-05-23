package com.example.islam.realestate.realestaeslist.business;

import com.example.islam.realestate.data.RealEstatesRepository;
import com.example.islam.realestate.data.models.ItemsItem;
import com.example.islam.realestate.data.models.RealEstatesResponseModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by islam on 23/05/17.
 */

public class RealEstateListBusiness {
    RealEstatesRepository mRealEstatesRepository;

    @Inject
    public RealEstateListBusiness(RealEstatesRepository realEstatesRepository) {
        mRealEstatesRepository = realEstatesRepository;
    }

    public Observable<List<ItemsItem>> getAllRealEstates() {
        return mRealEstatesRepository.getAllRealEstates().map(
                RealEstatesResponseModel::getItems);
    }
}
