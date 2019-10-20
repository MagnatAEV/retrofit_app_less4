package reactive.android.albul.ru.retrofitapplication.gson.gson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import reactive.android.albul.ru.retrofitapplication.R;

public class GsonActivity extends AppCompatActivity {

    private static final String TAG = "JSON";
    private PeriodOfYear periodOfYear;
    private TextView textView;

    String  jsonString = "{\"time_of_year\": \"summer\",\"year\":2019}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);
        textView = findViewById(R.id.text_view);

        Gson gson = new GsonBuilder().create();
        periodOfYear = gson.fromJson(jsonString, PeriodOfYear.class);


    }

    public void onClick(View v){
        String string = "time of year: " + periodOfYear.timeOfYear + ", year: " + periodOfYear.year;
        Log.d(TAG, string);
        textView.setText(string);
    }

}
