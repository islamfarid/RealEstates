package com.example.islam.realestate.realestaeslist.presenter;

import com.example.islam.realestate.realestaeslist.RealEstatesListContract;
import com.example.islam.realestate.realestaeslist.business.RealEstateListBusiness;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.plugins.RxJavaPlugins;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by islam on 24/05/17.
 */
public class RealEstatesListPresenterTest {
    private RealEstatesListPresenter mRealEstatesListPresenter;
    @Mock
    private RealEstateListBusiness mRealEstateListBusiness;
    @Mock
    private RealEstatesListContract.View mRealEstatesView;

    @BeforeClass
    public static void setUpClass() {
        Scheduler immediate = new Scheduler() {
            @Override
            public Worker createWorker() {
                return new ExecutorScheduler.ExecutorWorker(Runnable::run);
            }
        };
        RxJavaPlugins.setInitIoSchedulerHandler(scheduler -> immediate);
        RxJavaPlugins.setInitComputationSchedulerHandler(scheduler -> immediate);
        RxJavaPlugins.setInitNewThreadSchedulerHandler(scheduler -> immediate);
        RxJavaPlugins.setInitSingleSchedulerHandler(scheduler -> immediate);
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> immediate);    }

    @Before
    public void setupTasksPresenter() {
        MockitoAnnotations.initMocks(this);
        mRealEstatesListPresenter = new RealEstatesListPresenter(mRealEstatesView);
        mRealEstatesListPresenter.setmRealEstateListBusiness(mRealEstateListBusiness);
    }

    @Test
    public void testWhenGetAllRealEstates_ShowLoadingISCalled() {
        when(mRealEstateListBusiness.getAllRealEstates()).thenReturn(Observable.create(sub -> {
            sub.onNext(new ArrayList<>());
            sub.onComplete();
        }));
        mRealEstatesListPresenter.getAllRealEstates();
        verify(mRealEstatesView, times(1)).showLoading();
    }

    @Test
    public void testWhenGetAllRealEstatesSuccess_HideLoadingISCalled() {
        when(mRealEstateListBusiness.getAllRealEstates()).thenReturn(Observable.create(sub -> {
            sub.onNext(new ArrayList<>());
            sub.onComplete();
        }));
        mRealEstatesListPresenter.getAllRealEstates();
        verify(mRealEstatesView, times(1)).hideLoading();
    }

    @Test
    public void testWhenGetAllRealEstatesError_HideLoadingISCalled() {
        when(mRealEstateListBusiness.getAllRealEstates()).thenReturn(Observable.create(sub -> {
            sub.onError(new Throwable());
        }));
        mRealEstatesListPresenter.getAllRealEstates();
        verify(mRealEstatesView, times(1)).hideLoading();
    }

    @Test
    public void testWhenGetAllRealEstatesError_ShowErrorIsCalled() {
        when(mRealEstateListBusiness.getAllRealEstates()).thenReturn(Observable.create(sub -> {
            sub.onError(new Throwable(""));
        }));
        mRealEstatesListPresenter.getAllRealEstates();
        verify(mRealEstatesView, times(1)).showErrorMessage("");
    }

    @AfterClass
    public static void tearDownClass() {
        RxJavaPlugins.reset();
        RxAndroidPlugins.reset();    }
}