package com.example.islam.realestate.realestaeslist.dagger;


import com.example.islam.realestate.data.dagger.RealEstatesRepositoryComponent;
import com.example.islam.realestate.realestaeslist.view.RealEstatesListActivity;
import com.example.islam.realestate.utils.FragmentScoped;

import dagger.Component;

/**
 * Created by islam on 03/12/16.
 */

@FragmentScoped
@Component(dependencies = RealEstatesRepositoryComponent.class,
        modules = RealEstatesListModule.class)
public interface RealEstatesComponent {
    void inject(RealEstatesListActivity realEstatesListActivity);
}
