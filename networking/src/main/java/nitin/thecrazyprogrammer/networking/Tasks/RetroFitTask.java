package nitin.thecrazyprogrammer.networking.Tasks;

import android.content.Context;

import nitin.thecrazyprogrammer.networking.Listeners.ApiCallListener;

public class RetroFitTask{

    Context context;
    private String url;
    private ApiCallListener apiCallListener;

    private boolean success = false;
    private String msg = "";

    public RetroFitTask(Context context, String url, ApiCallListener apiCallListener){

        this.context = context;
        this.url = url;
        this.apiCallListener = apiCallListener;
    }

    public void execute(){

    }

}