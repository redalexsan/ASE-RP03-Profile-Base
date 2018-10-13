package es.iessaladillo.pedrojoya.pr03.ui.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import es.iessaladillo.pedrojoya.pr03.R;
import es.iessaladillo.pedrojoya.pr03.data.local.Database;
import es.iessaladillo.pedrojoya.pr03.data.local.model.Avatar;

public class MainActivity extends AppCompatActivity {

    private ImageView profileImage;
    private TextView profileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO
        initViews();
        defaultProfile();

    }

    private void defaultProfile() {
        Avatar defaultProfile = Database.getInstance().getDefaultAvatar();
        profileImage.setImageResource(defaultProfile.getImageResId());
        profileName.setText(defaultProfile.getName());
    }

    private void initViews() {
        profileImage = ActivityCompat.requireViewById(this, R.id.imageViewProfile);
        profileName = ActivityCompat.requireViewById(this,R.id.textViewProfileName);
    }

    // DO NOT TOUCH
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // DO NOT TOUCH
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mnuSave) {
            save();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Checks if form is valid or not and shows a Snackbar accordingly
     **/
    private void save() {
        // TODO
    }

}
