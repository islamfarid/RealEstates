package com.example.islam.realestate.realestaeslist.dagger;


import com.example.islam.realestate.realestaeslist.RealEstatesListContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by islam on 03/12/16.
 */
@Module
public class RealEstatesListModule {
    private final RealEstatesListContract.View mView;


    public RealEstatesListModule(RealEstatesListContract.View view) {
        this.mView = view;
    }

    @Provides
    RealEstatesListContract.View provideRealEstatesView() {
        return mView;
    }

}
