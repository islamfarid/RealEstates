package com.example.islam.realestate.realestaeslist;

import com.example.islam.realestate.BasePresenter;
import com.example.islam.realestate.BaseView;
import com.example.islam.realestate.data.models.ItemsItem;

import java.util.List;

/**
 * Created by islam on 23/05/17.
 */

public interface RealEstatesListContract {
    interface View extends BaseView<Presenter> {
        void showAllRealEstates(List<ItemsItem> realEstates);

        void showLoading();

        void showErrorMessage(String errorMsg);

        void hideLoading();
    }

    interface Presenter extends BasePresenter {
        void getAllRealEstates();
    }
}
