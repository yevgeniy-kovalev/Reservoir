package com.anupcowkur.reservoir;

public interface VaultGetCallback<T> {
    public void onSuccess(T object);

    public void onFailure(Exception e);
}
