package reactive.android.albul.ru.retrofitapplication.gson.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PeriodOfYear {

    @Expose
    @SerializedName("time_of_year")
    public String timeOfYear;

    @Expose
    @SerializedName("year")
    public int year;


}
