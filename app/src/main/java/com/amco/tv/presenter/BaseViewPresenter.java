package com.amco.tv.presenter;

import com.amco.tv.tools.Constans;

public interface BaseViewPresenter<E, O, R> {

    void onFailure(E errorResponse);

    void onSucces(O operations, R response);

}
