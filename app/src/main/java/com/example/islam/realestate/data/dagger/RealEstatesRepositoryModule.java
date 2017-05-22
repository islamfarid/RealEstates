package com.example.islam.realestate.data.dagger;



import com.example.islam.realestate.data.remote.RealEstatesRemoteViewerDataSource;
import com.example.islam.realestate.data.remote.Remote;
import com.example.islam.realestate.data.remote.ServiceGenerator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * This is used by Dagger to inject the required arguments into the {@link RealEstatesRepository}.
 */
@Module
public class RealEstatesRepositoryModule {

    @Singleton
    @Provides
    @Remote
    RealEstatesRemoteViewerDataSource provideTasksRemoteDataSource() {
        return ServiceGenerator.createService(RealEstatesRemoteViewerDataSource.class);
    }

}
