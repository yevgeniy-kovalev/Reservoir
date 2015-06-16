package com.anupcowkur.reservoir;

public interface VaultDeleteCallback {
    public void onSuccess();

    public void onFailure(Exception e);
}
