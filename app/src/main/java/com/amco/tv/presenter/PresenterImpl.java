package com.amco.tv.presenter;

import com.amco.tv.model.ResponseError;
import com.amco.tv.model.cast.Cast;
import com.amco.tv.model.program.Program;
import com.amco.tv.model.programs.Programs;
import com.amco.tv.service.AbstractServer;
import com.amco.tv.service.RetrofitService;
import com.amco.tv.service.OkHttpClient;
import com.amco.tv.tools.Constans;

import java.util.List;

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

    public void getProgramsList(String country, String date) {
        Call<List<Programs>> call = mTHRetrofitService.getProgramsList(country, date);
        super.attemptRequest(Constans.Operations.listPrograms, call);
    }

    public void getProgram(String programId) {
        Call<Program> call = mTHRetrofitService.getProgram(programId);
        super.attemptRequest(Constans.Operations.getProgram, call);
    }

    public void getProgramCast(String programId) {
        Call<List<Cast>> call = mTHRetrofitService.getProgramCast(programId);
        super.attemptRequest(Constans.Operations.getProgramCast, call);
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
