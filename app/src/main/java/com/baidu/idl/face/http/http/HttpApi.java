package com.baidu.idl.face.http.http;


import com.baidu.idl.face.http.httputil.BaseEntity;
import com.baidu.idl.face.platform.network.BaseRequest;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface HttpApi {

    //查询人脸
    @POST("SZ-DETECTBUSINESS/baiduAi/searchByBase64")
    Observable<String> getFaceResult(@Body String bas64Image);


//    //查询待出库的医废
//    @POST("api/mwwovenbags/queryMwWovenBagsNotOutbound")
//    Observable<BaseResult<MedicalWasteBean>> getOutList(@Body OutOfStockRequestEntity outOfStockRequestEntity);
//
//
//    //批量入库
//    @POST("api/mwwovenbags/batchWarehousing")
//    Observable<InIDResultEntity> addInIds(@Body IdsBean idsBean);
//
//    //批量出库
//    @POST("api/mwwovenbags/batchOutbound")
//    Observable<OutIDResultEntity> addOutIds(@Body OutIdsBean idsBean);
//
//    //出入库医废记录
//    @POST("api/mwwovenbags/queryWovenBags")
//    Observable<DetailResultEntity> getDetilList(@Body ListRequestBean idsBean);

}
