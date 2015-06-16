package com.anupcowkur.reservoir;

public interface VaultPutCallback {
    public void onSuccess();

    public void onFailure(Exception e);
}
