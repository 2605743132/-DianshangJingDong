package caoyuan.bway.com.xiangmu2.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.logging.Logger;

import caoyuan.bway.com.xiangmu2.net.HttpNet;

public class App extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        HttpNet.init();
        ImageLoaderConfiguration aDefault = ImageLoaderConfiguration.createDefault(this);
      ImageLoader.getInstance().init(aDefault);

    }
    
}
