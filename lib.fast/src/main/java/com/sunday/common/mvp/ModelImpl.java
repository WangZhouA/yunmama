package com.sunday.common.mvp;

import android.database.sqlite.SQLiteDatabase;

import com.sunday.common.activity.BaseApplication;
import com.sunday.common.cache.ACache;
import com.sunday.common.http.HttpFactory;

import org.litepal.LitePal;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by siwei on 2018/3/13.
 * Model层封装，后续会封装一些数据访问的工具类在其中，方便数据层去访问数据
 */

public class ModelImpl implements IModel {

    private CompositeDisposable compositeDisposable =new CompositeDisposable();


    protected <T> T createRetorfitService(Class<T> service) {
        return HttpFactory.instance().createApiService(service);
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    /**add Disposable*/
    protected void addDisposable(Disposable disposable){
        compositeDisposable.add(disposable);
    }

    /**add Disposable*/
    protected void addAllDisposable(Disposable... disposables){
        compositeDisposable.addAll(disposables);
    }

    /**取消掉所有的订阅*/
    private void disposedAll(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
        compositeDisposable.clear();
    }

    /**
     * 获取缓存
     */
    protected ACache getCache() {
        return BaseApplication.getInstance().getCache();
    }

    /**
     * 获取数据库操作(LitePal:<a>https://www.jianshu.com/p/bc68e763c7a2</a>)
     * 数据库映射关系在asset/litepal.xml中
     */
    protected SQLiteDatabase getDB() {
        return LitePal.getDatabase();
    }

    //其余一些数据操作的封装....

    @Override
    public void onRelease() {
        disposedAll();
    }

}
