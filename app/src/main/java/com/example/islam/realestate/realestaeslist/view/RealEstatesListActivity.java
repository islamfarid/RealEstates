package com.example.islam.realestate.realestaeslist.view;

import android.os.Bundle;

import com.example.islam.realestate.BaseActivity;
import com.example.islam.realestate.R;
import com.example.islam.realestate.RealEstatesApplication;
import com.example.islam.realestate.realestaeslist.dagger.DaggerRealEstatesComponent;
import com.example.islam.realestate.realestaeslist.dagger.RealEstatesListModule;
import com.example.islam.realestate.realestaeslist.presenter.RealEstatesListPresenter;
import com.example.islam.realestate.utils.ActivityUtils;

import javax.inject.Inject;

public class RealEstatesListActivity extends BaseActivity {
    @Inject
    RealEstatesListPresenter mRealEstatesListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_estates_list);
        RealRstatesListFragment realRstatesListFragment =
                (RealRstatesListFragment) getFragmentManager().findFragmentById(R.id.contentFrame);
        if (realRstatesListFragment == null) {
            // Create the fragment
            realRstatesListFragment = RealRstatesListFragment.newInstance();
            realRstatesListFragment.setArguments(getIntent().getExtras());
            ActivityUtils.addFragmentToActivity(
                    getFragmentManager(), realRstatesListFragment, R.id.contentFrame);
        }
        DaggerRealEstatesComponent.builder().
                realEstatesRepositoryComponent(((RealEstatesApplication) getApplication()).
                        getRealEstatesRepositoryComponent()).realEstatesListModule(new RealEstatesListModule(realRstatesListFragment)).build().inject(this);
    }

}
