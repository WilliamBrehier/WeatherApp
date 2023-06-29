package fr.william.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewCityName;
    private View mViewApp;
    private TextView mTextViewNoInternet;
    private Button mButtonFavorite;
    private Button mButton2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            mTextViewCityName = findViewById(R.id.text_view_city_name);
            Toast.makeText(this, getText(R.string.city_name), Toast.LENGTH_SHORT).show();

            mTextViewCityName.setText(getText(R.string.city_name));
        } else {
            mViewApp = findViewById(R.id.layout_content);
            mViewApp.setVisibility(TextView.GONE);

            mButtonFavorite = findViewById(R.id.button_favorite);
            mButtonFavorite.setVisibility(Button.GONE);

            mButton2 = findViewById(R.id.button_2);
            mButton2.setVisibility(Button.GONE);


            mTextViewNoInternet = findViewById(R.id.text_view_no_internet);
            mTextViewNoInternet.setVisibility(TextView.VISIBLE);
            mTextViewNoInternet.setText(getText(R.string.no_internet));
        }
        mButton2 = findViewById(R.id.button_2);
        mButton2.setOnClickListener(view -> Toast.makeText(MainActivity.this, getText(R.string.onclick2), Toast.LENGTH_SHORT).show());
    }

    public void onClick1(View view) {
        Button button = (Button) view;
        String textButton = button.getText().toString();
        String message = getString(R.string.ClickOn, textButton);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}