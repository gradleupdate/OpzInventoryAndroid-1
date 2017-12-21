package com.opz.oasu.inventory.ui.details.fragment.view;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TableRow;
import android.widget.TextView;

import com.opz.oasu.inventory.R;
import com.opz.oasu.inventory.ui.common.view.fragment.BaseViewFragment;
import com.opz.oasu.inventory.ui.details.fragment.presenter.DetailsPresenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import butterknife.BindView;


public class DetailsFragment extends BaseViewFragment<DetailsPresenter> implements DetailsView {

    @BindView(R.id.fragment_details_content_header)
    TableRow headerCellsContainer;

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

        setTableHeader();

        presenter.onFragmentStart();
    }

    private void setTableHeader() {
        Resources resources = getResources();
        String[] columnNames = resources.getStringArray(R.array.pref_content_column_headers);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String columnNamesPreferenceKey = resources.getString(R.string.pref_key_table_columns);
        List<Integer> columnNamesIndices = new ArrayList<>();
        Set<String> columnNamesIndicesString =
                sharedPreferences.getStringSet(columnNamesPreferenceKey, new HashSet<String>());
        for (String columnIndexString : columnNamesIndicesString)
            columnNamesIndices.add(Integer.parseInt(columnIndexString));
        Collections.sort(columnNamesIndices);
        TextView numberOfRowColumnHeader = new TextView(getActivity());
        numberOfRowColumnHeader.setText(R.string.textview_fragment_details_objects_position_by_order);
        numberOfRowColumnHeader.setBackgroundColor(Color.GRAY);
        numberOfRowColumnHeader.setSingleLine();
        numberOfRowColumnHeader.setPadding(20,20,10,10);
        //numberOfRowColumnHeader.layout();
        headerCellsContainer.addView(numberOfRowColumnHeader);
        for (int columnNameIndex : columnNamesIndices) {
            String columnName = columnNames[columnNameIndex - 1];
            TextView columnHeader = new TextView(getActivity());
            columnHeader.setSingleLine();
            columnHeader.setText(columnName);
            if (columnNamesIndices.indexOf(columnNameIndex) != columnNamesIndices.size() - 1)
                columnHeader.setPadding(10,20,10,10);
            else
                columnHeader.setPadding(10,20,20,10);
            columnHeader.setBackgroundColor(Color.LTGRAY);
            headerCellsContainer.addView(columnHeader);
        }

    }
}
