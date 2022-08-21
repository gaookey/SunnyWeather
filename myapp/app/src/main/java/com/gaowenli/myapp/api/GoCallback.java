package com.gaowenli.myapp.api;

public interface GoCallback {

    void onSuccess(String res);
    void onFailure(Exception e);
}
