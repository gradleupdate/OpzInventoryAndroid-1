package com.opz.oasu.inventory.ui.settings.fragment.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import com.opz.oasu.inventory.R;
import com.opz.oasu.inventory.IntentRequestCodes;
import com.opz.oasu.inventory.ui.settings.fragment.presenter.SettingsPresenter;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

import static com.opz.oasu.inventory.IntentRequestCodes.SOURCE_SPREADSHEET_FILE_SELECT_REQUEST_CODE;

public class SettingsFragment extends PreferenceFragment implements SettingsView {

    @Inject
    SettingsPresenter settingsPresenter;

    private Resources resources;
    private String sourceFile;
    private Preference sourceFilePreference;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        this.resources = getResources();
        this.sourceFile = resources.getString(R.string.pref_source_file_key);
        this.sourceFilePreference = findPreference(sourceFile);

        sourceFilePreference.setSummary(
                PreferenceManager.getDefaultSharedPreferences(
                        getActivity())
                .getString(sourceFile, sourceFile));

        sourceFilePreference.setOnPreferenceClickListener(
                new Preference.OnPreferenceClickListener() {

                    @Override
                    public boolean onPreferenceClick(Preference preference) {
                        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                        intent.addCategory(Intent.CATEGORY_OPENABLE);
                        intent.setType(resources.getString(R.string.pref_source_file_root_mime_type));
                        intent.putExtra(
                                Intent.EXTRA_MIME_TYPES,
                                resources.getStringArray(R.array.pref_source_file_mime_types));
                        startActivityForResult(
                                Intent.createChooser(
                                        intent,
                                        resources.getString(R.string.pref_source_file_chooser_title)),
                                SOURCE_SPREADSHEET_FILE_SELECT_REQUEST_CODE.ordinal());
                        return true;
                    }
                });
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        settingsPresenter.onFragmentStarts();
    }

    @Override
    public void onAttach(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            // Perform injection here before M, L (API 22) and below because onAttach(Context)
            // is not yet available at L.
            AndroidInjection.inject(this);
        }
        super.onAttach(activity);
    }

    @Override
    public void onAttach(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Perform injection here for M (API 23) due to deprecation of onAttach(Activity).
            AndroidInjection.inject(this);
        }
        super.onAttach(context);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {
        super.onActivityResult(requestCode, resultCode, resultData);
        if (resultData != null)
            settingsPresenter.processActivityResult(
                    IntentRequestCodes.values()[requestCode],
                    resultCode,
                    resultData);
        this.sourceFilePreference.setSummary(
                PreferenceManager.getDefaultSharedPreferences(getActivity())
                        .getString(sourceFile, sourceFile));
    }

}
