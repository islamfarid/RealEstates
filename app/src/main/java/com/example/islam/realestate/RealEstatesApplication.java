package com.example.islam.realestate;

import android.app.Application;

import com.example.islam.realestate.data.dagger.DaggerRealEstatesRepositoryComponent;
import com.example.islam.realestate.data.dagger.RealEstatesRepositoryComponent;
import com.example.islam.realestate.data.dagger.RealEstatesRepositoryModule;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import timber.log.Timber;


public class RealEstatesApplication extends Application {

    private RealEstatesRepositoryComponent mRealEstatesRepositoryComponent;
    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree() {
                @Override
                protected String createStackElementTag(StackTraceElement element) {
                    return super.createStackElementTag(element) + ":" + element.getLineNumber()
                            + ":" + element.getMethodName();
                }
            });
        }
        refWatcher = LeakCanary.install(this);
        mRealEstatesRepositoryComponent = DaggerRealEstatesRepositoryComponent.builder()
                .applicationModule(new ApplicationModule((getApplicationContext()))).realEstatesRepositoryModule(new RealEstatesRepositoryModule()).build();
    }

    public RealEstatesRepositoryComponent getRealEstatesRepositoryComponent() {
        return mRealEstatesRepositoryComponent;
    }

    public void mustDie(Object object) {
        if (refWatcher != null)
            refWatcher.watch(object);
    }
}
