package reactive.android.albul.ru.retrofitapplication.gson;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import reactive.android.albul.ru.retrofitapplication.R;
import reactive.android.albul.ru.retrofitapplication.gson.presenters.RetrofitPresenter;

public class RetroActivity extends AppCompatActivity {

    private RetrofitPresenter retrofitPresenter;
    @BindView(R.id.avatar_imview)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retro);
        ButterKnife.bind(this);

        retrofitPresenter = new RetrofitPresenter();
    }

    @OnClick(R.id.btn_request_server)
    public void onClickBtnRequestServer(View view){
        Log.d("PressButton", "onClickBtnRequestServer: ");
        retrofitPresenter.setImageView(imageView);
        retrofitPresenter.getRequestString();

//        String avatarURL = retrofitPresenter.getAvatarURL();
//        Log.d("AvatarURL", "onClickBtnRequestServer: " + avatarURL);

//        Picasso.get()
//                .load(avatarURL)
//                .into(imageView);

    }

}
