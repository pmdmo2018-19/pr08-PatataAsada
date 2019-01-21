package es.iessaladillo.pedrojoya.pr08.ui.desc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import es.iessaladillo.pedrojoya.pr08.R;

public class DescriptionFragment extends Fragment {

    private FloatingActionButton fab;

    public static DescriptionFragment newInstance() {
        return new DescriptionFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.description_fargment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupToolbar(requireView());
        setupFAB(requireView());

    }

    private void setupFAB(View view) {
        fab = ViewCompat.requireViewById(view,R.id.fabDetail);
        fab.setOnClickListener(v -> {
            SendToast();
        });
    }

    private void SendToast() {
        Toast toast;
    }


    private void setupToolbar(View view) {
        Toolbar toolbar = ViewCompat.requireViewById(view, R.id.toolbarMainFragment);
        toolbar.setTitle(R.string.app_name);
        toolbar.inflateMenu(R.menu.description_menu);


    }

}