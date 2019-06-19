package com.amco.tv.presenter;

/**
 * @author isaicastro
 */
public interface BaseViewPresenter<E, O, R> {

    void onFailure(E errorResponse);

    void onSucces(O operations, R response);

}
