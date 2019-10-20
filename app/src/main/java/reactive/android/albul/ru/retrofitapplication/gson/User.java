package reactive.android.albul.ru.retrofitapplication.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @Expose
    @SerializedName("login")
    public String login;

    @Expose
    @SerializedName("avatar_url")
    public String urlAvatar;
}
