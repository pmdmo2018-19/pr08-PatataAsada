package es.iessaladillo.pedrojoya.pr08;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import es.iessaladillo.pedrojoya.pr08.ui.desc.DescriptionFragment;
import es.iessaladillo.pedrojoya.pr08.ui.lorem.LoremFragment;

public class MainActivity extends AppCompatActivity implements DescriptionFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, LoremFragment.newInstance())
                    .commitNow();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
