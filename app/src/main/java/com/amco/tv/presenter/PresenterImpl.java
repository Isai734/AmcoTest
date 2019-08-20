package com.amco.tv.presenter;

import com.amco.tv.model.MoviesRate;
import com.amco.tv.model.ResponseError;
import com.amco.tv.service.AbstractServer;
import com.amco.tv.service.RetrofitService;
import com.amco.tv.service.OkHttpClient;
import com.amco.tv.tools.Constans;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * @author isaicastro
 */

public class PresenterImpl extends AbstractServer {
    private static final String TAG = PresenterImpl.class.getSimpleName();
    private RetrofitService mTHRetrofitService;
    private BaseViewPresenter<ResponseError, Constans.Operations, Response> vListener;

    public PresenterImpl(BaseViewPresenter vListener) {
        this.vListener = vListener;
        Retrofit mRestAdapter = new Retrofit.Builder().baseUrl(RetrofitService.BASE_URL)
                .client(OkHttpClient.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
        mTHRetrofitService = mRestAdapter.create(RetrofitService.class);
    }

    public void getMoviesRate( String api_key, String language) {
        Call<MoviesRate> call = mTHRetrofitService.getMoviesRate(api_key,language);
        super.attemptRequest(Constans.Operations.getMoviesRate, call);
    }

    @Override
    public void onError(ResponseError response) {
        vListener.onFailure(response);
    }

    @Override
    public void onSucces(Constans.Operations operations, Response response) {
        if (response.code() == 200)
            vListener.onSucces(operations, response);
        else
            onError(new ResponseError(0, "Error al conectarse al servidor", "Error al conectarse al servidor", 404));
    }
}
