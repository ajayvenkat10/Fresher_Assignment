package com.nuclei.question4;

import java.util.ArrayList;

import static com.nuclei.question4.CoreFunctions.*;

public class TaxLogic implements Runnable {
    ApplicationState state = ApplicationState.getInstance();

    CoreFunctions core;

    TaxLogic(CoreFunctions core){
        this.core = core;
        new Thread(this, "TaxCompute").start();
    }

    @Override
    public void run() {
        Logger.log("Tax thread started");

        while(true){
//            Logger.log("TaxLogic run");
            core.computeTax();
            if(state.getTerminate()){
                break;
            }

        }
        Utilities.display();

    }
}
