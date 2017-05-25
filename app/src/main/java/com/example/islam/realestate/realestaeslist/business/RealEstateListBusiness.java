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

/**
 * the business in this class is very basic but it is important to do it in a class because may be
 * the same functionality needed in a different screen so we can reuse it
 * this class has no unit test methods because it has no business but in normal situations every
 * screen has yts own business and of course its own unit test class
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
