package reactive.android.albul.ru.retrofitapplication.gson.presenters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import reactive.android.albul.ru.retrofitapplication.gson.User;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitApi {

    public Observable<User> request() {

            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();

            GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);
            RetrofitService api = new Retrofit.Builder()
                    .baseUrl("https://api.github.com")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(gsonConverterFactory)
                    .build()
                    .create(RetrofitService.class);
            return api.getUser("JakeWharton").subscribeOn(Schedulers.io());

    }

}
