package caoyuan.bway.com.xiangmu2.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.logging.Logger;

import caoyuan.bway.com.xiangmu2.net.HttpNet;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        HttpNet.init();
        
}
}
