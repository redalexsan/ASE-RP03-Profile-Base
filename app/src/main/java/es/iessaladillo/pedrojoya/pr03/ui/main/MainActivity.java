package es.iessaladillo.pedrojoya.pr03.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import es.iessaladillo.pedrojoya.pr03.R;
import es.iessaladillo.pedrojoya.pr03.data.local.Database;
import es.iessaladillo.pedrojoya.pr03.data.local.model.Avatar;
import es.iessaladillo.pedrojoya.pr03.utils.ValidationUtils;

public class MainActivity extends AppCompatActivity {

    private ImageView profileImage;
    private TextView profileName;
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPhone;
    private EditText editTextAdress;
    private EditText editTextWeb;
    private ImageView emailImage;
    private ImageView phoneImage;
    private ImageView adressImage;
    private ImageView webImage;
    private TextView textViewName;
    private TextView textViewEmail;
    private TextView textViewPhone;
    private TextView textViewAdress;
    private TextView textViewWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        textViewName = ActivityCompat.requireViewById(this,R.id.textViewName);
        editTextName = ActivityCompat.requireViewById(this,R.id.editTextName);
        textViewEmail = ActivityCompat.requireViewById(this,R.id.textViewEmail);
        editTextEmail = ActivityCompat.requireViewById(this,R.id.editTextEmail);
        textViewPhone = ActivityCompat.requireViewById(this,R.id.textViewPhoneNumber);
        editTextPhone = ActivityCompat.requireViewById(this,R.id.editTextPhone);
        textViewAdress = ActivityCompat.requireViewById(this,R.id.textViewAdress);
        editTextAdress = ActivityCompat.requireViewById(this,R.id.editTextAdress);
        textViewWeb = ActivityCompat.requireViewById(this, R.id.textViewWeb);
        editTextWeb = ActivityCompat.requireViewById(this,R.id.editTextWeb);
        emailImage = ActivityCompat.requireViewById(this,R.id.imageEmail);
        phoneImage = ActivityCompat.requireViewById(this,R.id.imagePhone);
        adressImage = ActivityCompat.requireViewById(this,R.id.imageAdress);
        webImage = ActivityCompat.requireViewById(this,R.id.imageWeb);

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

        editTextName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { request(editTextName,textViewName);}

            @Override
            public void afterTextChanged(Editable s) { }
        });

        editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { request(editTextEmail,textViewEmail,emailImage);}

            @Override
            public void afterTextChanged(Editable s) { }
        });

        editTextPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { request(editTextPhone,textViewPhone,phoneImage);}

            @Override
            public void afterTextChanged(Editable s) { }
        });

        editTextAdress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { request(editTextAdress,textViewAdress,adressImage);}

            @Override
            public void afterTextChanged(Editable s) { }
        });

        editTextWeb.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { request(editTextWeb,textViewAdress,webImage);}

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    private void newProfile(){
        Avatar randomAvatar = Database.getInstance().getRandomAvatar();

        profileName.setText(randomAvatar.getName());
        profileImage.setImageResource(randomAvatar.getImageResId());
    }

    private void request(EditText text, TextView textView, ImageView image){
        boolean resultado = true;

        if(text.getId() == editTextEmail.getId())
            if(!ValidationUtils.isValidEmail(String.valueOf(text.getText())))
                resultado = false;
        else if(text.getId() == editTextPhone.getId())
            if(!ValidationUtils.isValidPhone(String.valueOf(text.getText())))
                resultado = false;
        else if(text.getId() == editTextWeb.getId())
            if(!ValidationUtils.isValidUrl(String.valueOf(text.getText())))
                resultado = false;
        else
            if(String.valueOf(text.getText()).equals(""))
                resultado = false;


        if(!resultado) {
            text.setError(getString(R.string.invalid_message));
            textView.setEnabled(false);
            image.setEnabled(false);
         }
        else {
            text.setError(null);
            textView.setEnabled(true);
            image.setEnabled(true);
        }
    }

    private void request(EditText text, TextView textView){

        if(String.valueOf(text.getText()).equals("")) {
            text.setError(getString(R.string.invalid_message));
            textView.setEnabled(false);
        }
        else {
            text.setError(null);
            textView.setEnabled(true);
        }
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

    public void ocultarTeclado(View v){
        if(v != null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(),0);
        }
    }

    /**
     * Checks if form is valid or not and shows a Snackbar accordingly
     **/
    private void save() {
        ocultarTeclado(getCurrentFocus());
        if(validar())
            Snackbar.make(getCurrentFocus(),"Student saved successfully",Snackbar.LENGTH_SHORT).show();
        else
            Snackbar.make(getCurrentFocus(),"Error saving student",Snackbar.LENGTH_SHORT).show();
    }

    @SuppressLint("ResourceType")
    public boolean validar(){
        boolean resultado = true;

        if(String.valueOf(editTextName.getText()).equals("")) {
            editTextName.setError(getString(R.string.invalid_message));
            textViewName.setEnabled(false);
            resultado = false;
        }
        else {
            editTextName.setError(null);
            textViewName.setEnabled(true);
        }

        if(String.valueOf(editTextAdress.getText()).equals("")) {
            editTextAdress.setError(getString(R.string.invalid_message));
            textViewAdress.setEnabled(false);
            adressImage.setEnabled(false);
            resultado = false;
        }
        else {
            editTextAdress.setError(null);
             textViewAdress.setEnabled(true);
            adressImage.setEnabled(true);
        }

        if(!ValidationUtils.isValidPhone(String.valueOf(editTextPhone.getText()))) {
            editTextPhone.setError(getString(R.string.invalid_message));
            textViewPhone.setEnabled(false);
            phoneImage.setEnabled(false);
            resultado = false;
        }
        else {
            editTextPhone.setError(null);
            textViewPhone.setEnabled(true);
            phoneImage.setEnabled(true);
        }
        if( !ValidationUtils.isValidEmail(String.valueOf(editTextEmail.getText()))) {
            editTextEmail.setError(getString(R.string.invalid_message));
            textViewEmail.setEnabled(false);
            emailImage.setEnabled(false);
            resultado = false;
        }
        else {
            editTextEmail.setError(null);
            textViewEmail.setEnabled(true);
            emailImage.setEnabled(true);
        }

        if(!ValidationUtils.isValidUrl(String.valueOf(editTextWeb.getText()))) {
            editTextWeb.setError(getString(R.string.invalid_message));
            textViewWeb.setEnabled(false);
            webImage.setEnabled(false);
            resultado = false;
        }
        else {
            editTextWeb.setError(null);
            textViewWeb.setEnabled(true);
            webImage.setEnabled(true);
        }

        return resultado;
    }

}
