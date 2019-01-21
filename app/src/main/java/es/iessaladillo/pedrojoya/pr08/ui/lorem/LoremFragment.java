package es.iessaladillo.pedrojoya.pr08.ui.lorem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import es.iessaladillo.pedrojoya.pr08.R;
import es.iessaladillo.pedrojoya.pr08.ui.desc.DescriptionFragment;
import es.iessaladillo.pedrojoya.pr08.ui.settings.SettingFragment;

public class LoremFragment extends Fragment {

    private static final String TAG_DESC_FRAGMENT = "TAG_DESC_FRAGMENT";
    private static final String TAG_SETTINGS_FRAGMENT = "TAG_SETTINGS_FRAGMENT";
    private LoremViewModel mViewModel;
    private FloatingActionButton fab;

    public static LoremFragment newInstance() {
        return new LoremFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.lorem_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LoremViewModel.class);
        setupToolbar(requireView());
        setupFAB(requireView());

    }

    private void setupFAB(View view) {
        fab = ViewCompat.requireViewById(view,R.id.fabMain);
        fab.setOnClickListener(v -> {
            navigateToDetails();
        });
    }

    private void navigateToDetails() {
        DescriptionFragment descriptionFragment = DescriptionFragment.newInstance();
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.description_fragment,descriptionFragment, TAG_DESC_FRAGMENT);
        transaction.commit();
    }


    private void setupToolbar(View view) {
        Toolbar toolbar = ViewCompat.requireViewById(view, R.id.toolbarMainFragment);
        toolbar.setTitle(R.string.app_name);
        toolbar.inflateMenu(R.menu.lorem_fragment_menu);
        toolbar.setOnMenuItemClickListener((MenuItem item) -> {
            switch (item.getItemId()) {
                case R.id.mnuSettings:
                    navigateToSettings();
                default:
                    return false;
            }
        });


    }

    private void navigateToSettings() {
        SettingFragment settingFragment = new SettingFragment();
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.coordinatorLayout,settingFragment, TAG_SETTINGS_FRAGMENT);
        transaction.commit();
    }

}
