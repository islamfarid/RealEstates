package com.example.islam.realestate.data;


import com.example.islam.realestate.data.models.RealEstatesResponseModel;
import com.example.islam.realestate.data.remote.RealEstatesRemoteViewerDataSource;
import com.example.islam.realestate.data.remote.Remote;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


@Singleton
public class RealEstatesRepository implements RealEstatesDataSource {

    private final RealEstatesRemoteViewerDataSource mRealEstatesRemoteViewerDataSource;


    @Inject
    RealEstatesRepository(@Remote RealEstatesRemoteViewerDataSource realEstatesRemoteViewerDataSource) {
        this.mRealEstatesRemoteViewerDataSource = realEstatesRemoteViewerDataSource;
    }

    @Override
    public Observable<RealEstatesResponseModel> getAllRealEstates() {
        return mRealEstatesRemoteViewerDataSource.getAllRealEstates();
    }
}
