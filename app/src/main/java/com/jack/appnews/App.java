package com.jack.appnews;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.widget.Toast;

import com.jack.appnews.api.NewsApi;
import com.jack.appnews.storage.db.DaoMaster;
import com.jack.appnews.storage.db.DaoSession;

import org.greenrobot.greendao.database.Database;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    private static App mApp;
    private static NewsApi mApiService;
    public boolean ENCRYPTED = false;
    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;

        initRetrofit();

        initDB();
    }

    private void initDB() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ?
                Constants.DB_NAME_ENCRYPTED : Constants.DB_NAME);
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    private void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NewsApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mApiService = retrofit.create(NewsApi.class);
    }

    public static NewsApi getApi() {
        return mApiService;
    }

    public static void toast(@NonNull CharSequence text) {
        Toast.makeText(mApp, text, Toast.LENGTH_SHORT).show();
    }

    public static void toast(@StringRes int stringRes) {
        Toast.makeText(mApp, stringRes, Toast.LENGTH_SHORT).show();
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }
}