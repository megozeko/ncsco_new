package net.itechnicians.ncsco.entities;

import android.app.Application;

public class NCSCO extends Application {

    private static NCSCO instance;
    public NCSCO() {
        instance = this;
    }

    public static NCSCO getInstance() {
        return instance;
    }
}