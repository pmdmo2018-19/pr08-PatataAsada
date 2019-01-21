package es.iessaladillo.pedrojoya.pr08;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import es.iessaladillo.pedrojoya.pr08.ui.lorem.LoremFragment;

public class MainActivity extends AppCompatActivity  {

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
}
