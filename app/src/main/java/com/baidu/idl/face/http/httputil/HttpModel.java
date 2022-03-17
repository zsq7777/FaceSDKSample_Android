package com.baidu.idl.face.http.httputil;



import com.baidu.idl.face.http.http.Base64ImageEntity;
import com.baidu.idl.face.http.http.HttpApi;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HttpModel {

    private static HttpApi httpService = RetrofitServiceManager.getInstance().create(HttpApi.class);


    public static void getFaceResult(String imageBase64, Observer<String> observer) {
        setSubscribe(httpService.getFaceResult(imageBase64), observer);
    }
//
//    public static void getOutList(OutOfStockRequestEntity outOfStockRequestEntity, Observer<BaseResult<MedicalWasteBean>> observer) {
//        setSubscribe(httpService.getOutList(outOfStockRequestEntity), observer);
//    }
//
//    public static void addInIds(IdsBean ids, Observer<InIDResultEntity> observer) {
//        setSubscribe(httpService.addInIds(ids), observer);
//    }
//    public static void addOutIds(OutIdsBean ids, Observer<OutIDResultEntity> observer) {
//        setSubscribe(httpService.addOutIds(ids), observer);
//    }
//    public static void getDetilList(ListRequestBean listRequestBean, Observer<DetailResultEntity> observer) {
//        setSubscribe(httpService.getDetilList(listRequestBean), observer);
//    }





    private static <T> void setSubscribe(Observable<T> observable, Observer<T> observer) {

        observable.subscribeOn(Schedulers.io())

                .subscribeOn(Schedulers.newThread())

                .observeOn(AndroidSchedulers.mainThread())

                .subscribe(observer);

    }

}

