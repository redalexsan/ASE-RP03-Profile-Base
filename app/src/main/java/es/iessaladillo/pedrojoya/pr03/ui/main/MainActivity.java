package es.iessaladillo.pedrojoya.pr03.ui.main;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

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
        TextView textViewName = ActivityCompat.requireViewById(this,R.id.textViewName);
        EditText editTextName = ActivityCompat.requireViewById(this,R.id.editTextName);
        TextView textViewEmail = ActivityCompat.requireViewById(this,R.id.textViewEmail);
        EditText editTextEmail = ActivityCompat.requireViewById(this,R.id.editTextEmail);
        TextView textViewPhone = ActivityCompat.requireViewById(this,R.id.textViewPhoneNumber);
        EditText editTextPhone = ActivityCompat.requireViewById(this,R.id.editTextPhone);
        TextView textViewAdress = ActivityCompat.requireViewById(this,R.id.textViewAdress);
        EditText editTextAdress = ActivityCompat.requireViewById(this,R.id.editTextAdress);
        TextView textViewWeb = ActivityCompat.requireViewById(this, R.id.textViewWeb);
        EditText editTextWeb = ActivityCompat.requireViewById(thos,R.id.editTextWeb);

        profileName.setOnClickListener(v -> newProfile());
        profileImage.setOnClickListener(v -> newProfile());

        editTextName.setOnFocusChangeListener((v, hasFocus) -> {
            if(hasFocus)
                textViewName.setTypeface(Typeface.DEFAULT_BOLD);
            else
                textViewName.setTypeface(Typeface.DEFAULT);
        });

        editTextEmail.setOnFocusChangeListener((v, hasFocus) -> {
            if(hasFocus)
                textViewEmail.setTypeface(Typeface.DEFAULT_BOLD);
            else
                textViewEmail.setTypeface(Typeface.DEFAULT);
        });

        editTextPhone.setOnFocusChangeListener((v, hasFocus) -> {
            if(hasFocus)
                textViewPhone.setTypeface(Typeface.DEFAULT_BOLD);
            else
                textViewPhone.setTypeface(Typeface.DEFAULT);
        });

        editTextAdress.setOnFocusChangeListener((v, hasFocus) -> {
            if(hasFocus)
                textViewAdress.setTypeface(Typeface.DEFAULT_BOLD);
            else
                textViewAdress.setTypeface(Typeface.DEFAULT);
        });

        editTextWeb.setOnFocusChangeListener((v, hasFocus) -> {
            if(hasFocus)
                textViewWeb.setTypeface(Typeface.DEFAULT_BOLD);
            else
                textViewWeb.setTypeface(Typeface.DEFAULT);
        });


    }

    private void newProfile(){
        Avatar randomAvatar = Database.getInstance().getRandomAvatar();

        profileName.setText(randomAvatar.getName());
        profileImage.setImageResource(randomAvatar.getImageResId());
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
