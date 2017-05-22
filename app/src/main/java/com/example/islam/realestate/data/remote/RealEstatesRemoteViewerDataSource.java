package com.example.islam.realestate.data.remote;


import com.example.islam.realestate.data.models.RealEstatesResponseModel;

import io.reactivex.Observable;

import retrofit2.http.GET;


public interface RealEstatesRemoteViewerDataSource {

    @GET("/realestates")
    Observable<RealEstatesResponseModel> getAllRealEstates();
}
