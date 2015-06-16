package com.anupcowkur.reservoir;

public interface VaultClearCallback {
    public void onSuccess();

    public void onFailure(Exception e);
}
