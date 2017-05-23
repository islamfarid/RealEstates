package com.example.islam.realestate.realestaeslist.presenter;

import com.example.islam.realestate.realestaeslist.RealEstatesListContract;
import com.example.islam.realestate.realestaeslist.business.RealEstateListBusiness;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by islam on 23/05/17.
 */

public class RealEstatesListPresenter implements RealEstatesListContract.Presenter {

    private RealEstatesListContract.View mView;
    private RealEstateListBusiness mRealEstateListBusiness;
    private CompositeDisposable mSubscriptions;

    @Inject
    public RealEstatesListPresenter(RealEstatesListContract.View view) {
        this.mView = view;
        mSubscriptions = new CompositeDisposable();
    }

    @Inject
    public void setmRealEstateListBusiness(RealEstateListBusiness mRealEstateListBusiness) {
        this.mRealEstateListBusiness = mRealEstateListBusiness;
    }
    @Inject
    public void setupListeners() {
        mView.setPresenter(this);
    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public void getAllRealEstates() {
        mSubscriptions.add(mRealEstateListBusiness.getAllRealEstates().observeOn(AndroidSchedulers.
                mainThread()).subscribeOn(Schedulers.io()).subscribe((realEstatesItems) -> {
            mView.hideLoading();
            mView.showAllRealEstates(realEstatesItems);
        }));
    }
}
