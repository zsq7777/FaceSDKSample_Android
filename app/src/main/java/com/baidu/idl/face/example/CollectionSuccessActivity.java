package com.baidu.idl.face.example;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.baidu.idl.face.http.DataEntity;
import com.baidu.idl.face.http.http.Base64ImageEntity;
import com.baidu.idl.face.http.httputil.BaseEntity;
import com.baidu.idl.face.http.httputil.HttpModel;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.ui.BaseActivity;
import com.baidu.idl.face.platform.ui.utils.IntentUtils;
import com.baidu.idl.face.platform.ui.widget.CircleImageView;
import com.baidu.idl.face.platform.utils.Base64Utils;
import com.baidu.idl.face.platform.utils.DensityUtils;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.DES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * 采集成功页面
 * Created by v_liujialu01 on 2020/4/1.
 */

public class CollectionSuccessActivity extends BaseActivity {
    private static final String TAG = CollectionSuccessActivity.class.getSimpleName();

    private CircleImageView mCircleHead;
    protected String mDestroyType;
    private ImageView mImageCircle;
    private ImageView mImageStar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_success);
        initView();
        initData();
    }

    private void initView() {
        mCircleHead = (CircleImageView) findViewById(R.id.circle_head);
        mImageCircle = (ImageView) findViewById(R.id.image_circle);
        mImageStar = (ImageView) findViewById(R.id.image_star);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            mDestroyType = intent.getStringExtra("destroyType");
            String bmpStr = IntentUtils.getInstance().getBitmap();
            if (TextUtils.isEmpty(bmpStr)) {
                return;
            }
            Bitmap bmp = base64ToBitmap(bmpStr);
            bmp = FaceSDKManager.getInstance().scaleImage(bmp,
                    DensityUtils.dip2px(getApplicationContext(), 97),
                    DensityUtils.dip2px(getApplicationContext(), 97));


            mCircleHead.setImageBitmap(bmp);
            Base64ImageEntity base64ImageEntity = new Base64ImageEntity(bitmapToBase64(bmp));
            String json = new Gson().toJson(base64ImageEntity);
            HttpModel.getFaceResult(json, new Observer<String>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onNext(@NonNull String stringBaseEntity) {
//                    DES des = SecureUtil.des("1234567887654321".getBytes());
                    SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, "1234567887654321".getBytes());
                    String dataStr = aes.decryptStr(stringBaseEntity);
                    try {
                        Log.i("JSON消息", dataStr);
                        Gson gson = new Gson();
                        DataEntity dataEntity = gson.fromJson(dataStr, DataEntity.class);
                        new AlertDialog.Builder(CollectionSuccessActivity.this).setMessage(dataEntity.getData().getName() + "\n" + dataEntity.getData().getFaceScore()).show();
//                        Toast.makeText(CollectionSuccessActivity.this, dataEntity.getData().getName()+"\n"+dataEntity.getData().getFaceScore(), Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        new AlertDialog.Builder(CollectionSuccessActivity.this).setMessage(dataStr+"--"+e.getLocalizedMessage()).show();
                    }

                }

                @Override
                public void onError(@NonNull Throwable e) {
                    Log.i("异常", e.getLocalizedMessage());
                }

                @Override
                public void onComplete() {

                }
            });
        }

//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mImageCircle.setVisibility(View.VISIBLE);
//                mImageStar.setVisibility(View.VISIBLE);
//            }
//        }, 500);
    }

    // 回到首页
    public void onReturnHome(View v) {
        if ("FaceLivenessExpActivity".equals(mDestroyType)) {
            ExampleApplication.destroyActivity("FaceLivenessExpActivity");
        }
        if ("FaceDetectExpActivity".equals(mDestroyType)) {
            ExampleApplication.destroyActivity("FaceDetectExpActivity");
        }
        finish();
    }

    // 重新采集
    public void onRecollect(View v) {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        IntentUtils.getInstance().release();
    }

    private Bitmap base64ToBitmap(String base64Data) {
        byte[] bytes = Base64Utils.decode(base64Data, Base64Utils.NO_WRAP);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    private String bitmapToBase64(Bitmap bitmap) {

        String result = null;
        ByteArrayOutputStream baos = null;
        try {
            if (bitmap != null) {
                baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);

                baos.flush();
                baos.close();

                byte[] bitmapBytes = baos.toByteArray();
                result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


}
