package com.example.islam.realestate.data.dagger;


import com.example.islam.realestate.ApplicationModule;
import com.example.islam.realestate.data.RealEstatesRepository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RealEstatesRepositoryModule.class, ApplicationModule.class})
public interface RealEstatesRepositoryComponent {

    RealEstatesRepository getTasksRepository();
}
