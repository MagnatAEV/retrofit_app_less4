package reactive.android.albul.ru.retrofitapplication.gson.presenters;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import reactive.android.albul.ru.retrofitapplication.gson.User;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class RetrofitPresenter {

    private RetrofitApi retrofitApi;
    private String TAG = "RetrfitPresenter";
    private User user;

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    private ImageView imageView;

    public RetrofitPresenter(){
        retrofitApi = new RetrofitApi();
        user = new User();
    }

    public void getRequestString(){
        Observable<User> single = retrofitApi.request();

        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(user -> {
            this.user = user;
            Log.d(TAG, "login: " + user.login);
            Log.d(TAG, "url_avatar: " + user.urlAvatar);
            setImage();
        }, throwable -> {
            Log.d(TAG, "getRequestString: " + throwable);
        });
    }

    public String getAvatarURL(){
        return user.urlAvatar;
    }

    public void setImage(){
        Picasso.get()
                .load(user.urlAvatar)
                .into(imageView);
    }

}
