package com.example.islam.realestate.data;



import com.example.islam.realestate.data.models.RealEstatesResponseModel;

import io.reactivex.Observable;


public interface RealEstatesDataSource {
    Observable<RealEstatesResponseModel> getAllRealEstates();
}
