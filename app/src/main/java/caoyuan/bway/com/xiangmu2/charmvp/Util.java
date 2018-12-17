package caoyuan.bway.com.xiangmu2.charmvp;



import caoyuan.bway.com.xiangmu2.enity.CharBean;
import caoyuan.bway.com.xiangmu2.enity.CircleBean;
import caoyuan.bway.com.xiangmu2.enity.InformBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Query;


public interface Util {
    //登录
    String LOGIN_URL = "http://172.17.8.100/small/user/v1/login";
    //注册
    String REGISTER_URL = "http://172.17.8.100/small/user/v1/register";
    //轮播图
    String BANNER_URL = "http://172.17.8.100/small/commodity/v1/bannerShow";
    //首页展示
    String HOME_URL = "http://172.17.8.100/small/commodity/v1/commodityList";

    //更多商品
//    @GET("findCommodityListByLabe")
//    Observable<LabelBean> getlabel(@Query("labelId") String labelId, @Query("page") String page, @Query("count") String count);


   @GET("user/verify/v1/getUserById")
  Observable<InformBean> getInform();


   @GET("circle/v1/findCircleList")
   Observable<CircleBean> getcircle(@Query("page") int page, @Query("count") int count);

//    //购物车
    @GET("order/verify/v1/findShoppingCart")
    Observable<CharBean> getcar();
}
