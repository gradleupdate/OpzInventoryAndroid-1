package com.opz.oasu.inventory.ui.details.fragment.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.opz.oasu.inventory.R;
import com.opz.oasu.inventory.ui.common.view.fragment.BaseViewFragment;
import com.opz.oasu.inventory.ui.details.fragment.presenter.DetailsPresenter;

import javax.annotation.Nullable;


public class DetailsFragment extends BaseViewFragment<DetailsPresenter> implements DetailsView {

    @Override
    public View onCreateView(
            LayoutInflater layoutInflater,
            @Nullable ViewGroup container,
            Bundle savedInstanceState) {
        return layoutInflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        presenter.onFragmentStart();
    }
    /*
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    */
}
