package com.opz.oasu.inventory.ui.start.fragment.view;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.opz.oasu.inventory.R;
import com.opz.oasu.inventory.ui.common.view.fragment.BaseViewFragment;
import com.opz.oasu.inventory.ui.details.fragment.view.DetailsFragment;
import com.opz.oasu.inventory.ui.start.fragment.presenter.StartPresenter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import butterknife.OnClick;


public class StartFragment extends BaseViewFragment<StartPresenter> implements StartView {

    @Inject
    StartFragmentActionListener listener;

    @Override
    public View onCreateView(
            LayoutInflater layoutInflater,
            @Nullable ViewGroup container,
            Bundle savedInstanceState) {
        return layoutInflater.inflate(R.layout.fragment_start, container, false);
    }

    @OnClick(R.id.fragment_start_start_new_inventory_button)
    void onStartNewInventoryButtonClick() {
        presenter.createNewInventory();

        FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(
                android.R.animator.fade_in,
                android.R.animator.fade_out);
        fragmentTransaction.replace(R.id.common_fragment_container, new DetailsFragment());
        fragmentTransaction.commit();
    }
}
