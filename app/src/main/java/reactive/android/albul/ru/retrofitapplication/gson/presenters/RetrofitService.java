package reactive.android.albul.ru.retrofitapplication.gson.presenters;

import io.reactivex.Observable;
import reactive.android.albul.ru.retrofitapplication.gson.User;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("/users/{user}")
    Observable<User> getUser(@Path("user") String user);
}
