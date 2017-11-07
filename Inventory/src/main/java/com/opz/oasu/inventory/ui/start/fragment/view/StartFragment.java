package com.opz.oasu.inventory.ui.start.fragment.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import com.opz.oasu.inventory.R;
import com.opz.oasu.inventory.ui.common.view.fragment.BaseViewFragment;
import com.opz.oasu.inventory.ui.start.fragment.presenter.StartPresenter;


public class StartFragment extends BaseViewFragment<StartPresenter> implements StartView {

    @BindView(R.id.progress_output)
    TextView progressOutputTextView;

    @Override
    public View onCreateView(
            LayoutInflater layoutInflater,
            @Nullable ViewGroup container,
            Bundle savedInstanceState) {
        return layoutInflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        presenter.onFragmentStart();
    }

    @Override
    public void addProgressMessage(String progressMessage) {
        progressOutputTextView.append(progressMessage + "\n");
    }
}
