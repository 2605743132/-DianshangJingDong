package caoyuan.bway.com.xiangmu2.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.logging.Logger;

import caoyuan.bway.com.xiangmu2.net.HttpNet;
import de.hdodenhof.circleimageview.CircleImageView;

public class App extends Application {
    public static Context context;
    public static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);

        HttpNet.init();

        ImageLoaderConfiguration aDefault = ImageLoaderConfiguration.createDefault(this);
      ImageLoader.getInstance().init(aDefault);
      sContext = this;

    }
    
}
