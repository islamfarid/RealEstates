package com.example.islam.realestate.realestaeslist.view;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.islam.realestate.BaseFragment;
import com.example.islam.realestate.R;
import com.example.islam.realestate.data.models.ItemsItem;
import com.example.islam.realestate.realestaeslist.RealEstatesListContract;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by islam on 23/05/17.
 */

public class RealRstatesListFragment extends BaseFragment implements RealEstatesListContract.View {
    @BindView(R.id.recyclerview_real_estates)
    RecyclerView mRealEstatesList;
    @BindView(R.id.progressBar_loading)
    ProgressBar mLoadingProgressBar;
    private RealEstatesListContract.Presenter mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_real_estates_list, container, false);
        ButterKnife.bind(this, root);
        setHasOptionsMenu(true);
        setRetainInstance(true);
        mPresenter.getAllRealEstates();
        return root;
    }


    @Override
    public void setPresenter(RealEstatesListContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);

    }

    @Override
    public void showAllRealEstates(List<ItemsItem> realEstates) {
        Timber.i(this.getClass().getCanonicalName(), realEstates.get(0).getTitle());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRealEstatesList.setLayoutManager(linearLayoutManager);
        RealEstatesListAdapter realEstatesListAdapter = new RealEstatesListAdapter(getActivity(), realEstates);
        mRealEstatesList.setAdapter(realEstatesListAdapter);
    }

    @Override
    public void showLoading() {
        mLoadingProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErrorMessage(String errorMsg) {
        Snackbar.make(mRealEstatesList, errorMsg, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void hideLoading() {
        mLoadingProgressBar.setVisibility(View.GONE);
    }

    public static RealRstatesListFragment newInstance() {
        return new RealRstatesListFragment();
    }

    @Override
    public void onStop() {
        mPresenter.unSubscribe();
        super.onStop();
    }
}
