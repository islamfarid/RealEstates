package com.example.islam.realestate;

/**
 * Created by islam on 23/05/17.
 */

import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v7.app.AppCompatActivity;

import com.example.islam.realestate.utils.EspressoIdlingResource;

/**
 * it is used for may reasons for example analytics and detect leaks
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((RealEstatesApplication) getApplication()).mustDie(this);
    }

    @VisibleForTesting
    public IdlingResource getCountingIdlingResource() {
        return EspressoIdlingResource.getIdlingResource();
    }
}
