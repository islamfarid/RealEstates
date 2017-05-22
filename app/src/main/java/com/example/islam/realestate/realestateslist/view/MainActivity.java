package com.example.islam.realestate.realestateslist.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.islam.realestate.R;
import com.example.islam.realestate.data.RealEstatesRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
