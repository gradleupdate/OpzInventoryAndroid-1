package com.opz.oasu.inventory.ui.start.fragment.view;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.opz.oasu.inventory.R;
import com.opz.oasu.inventory.ui.common.view.fragment.BaseViewFragment;
import com.opz.oasu.inventory.ui.details.fragment.view.DetailsFragment;
import com.opz.oasu.inventory.ui.start.fragment.presenter.StartPresenter;

import javax.inject.Inject;

import butterknife.OnClick;

public class StartFragment extends BaseViewFragment<StartPresenter> implements StartView, StartFragmentActionListener {

    @Inject
    StartFragmentActionListener listener;

    @Override
    public View onCreateView(
            LayoutInflater layoutInflater,
            @Nullable ViewGroup container,
            Bundle savedInstanceState) {
        return layoutInflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    @OnClick(R.id.fragment_start_button_start_new_inventory)
    public void onStartNewInventoryButtonClick() {
        presenter.createNewInventory();

        FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(
                android.R.animator.fade_in,
                android.R.animator.fade_out);
        fragmentTransaction.replace(R.id.common_fragment_container, new DetailsFragment());
        fragmentTransaction.commit();
    }
}
