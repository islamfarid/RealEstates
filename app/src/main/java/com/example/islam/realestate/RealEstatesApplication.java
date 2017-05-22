package com.example.islam.realestate;

import android.app.Application;

import com.example.islam.realestate.data.dagger.DaggerRealEstatesRepositoryComponent;
import com.example.islam.realestate.data.dagger.RealEstatesRepositoryComponent;
import com.example.islam.realestate.data.dagger.RealEstatesRepositoryModule;


public class RealEstatesApplication extends Application {

    private RealEstatesRepositoryComponent mRealEstatesRepositoryComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mRealEstatesRepositoryComponent = DaggerRealEstatesRepositoryComponent.builder()
                .applicationModule(new ApplicationModule((getApplicationContext()))).realEstatesRepositoryModule(new RealEstatesRepositoryModule()).build();
    }

    public RealEstatesRepositoryComponent getRealEstatesRepositoryComponent() {
        return mRealEstatesRepositoryComponent;
    }

}
