package kz.epamlibrary.app;


import android.app.Application;
import android.content.Context;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import kz.epamlibrary.network.ApiFactory;
import kz.epamlibrary.network.ApiService;

public class AppController extends Application {

    private ApiService apiService;
    private Scheduler scheduler;

    private static AppController get(Context context) {
        return (AppController) context.getApplicationContext();
    }

    public static AppController create(Context context) {
        return AppController.get(context);
    }

    public ApiService getUserService() {
        if (apiService == null) {
            apiService = ApiFactory.create();
        }

        return apiService;
    }

    public Scheduler subscribeScheduler() {
        if (scheduler == null) {
            scheduler = Schedulers.io();
        }

        return scheduler;
    }

    public void setUserService(ApiService apiService) {
        this.apiService = apiService;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

}

