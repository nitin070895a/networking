package nitin.thecrazyprogrammer.networking;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class AppController extends Application{

    private static AppController instance;

    private RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static synchronized AppController getInstance(){
        return instance;
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue == null)
            requestQueue = Volley.newRequestQueue(getApplicationContext());

        return requestQueue;
    }

    public void addToRequestQueue(Request request, String tag){
        request.setTag(tag);
        getRequestQueue().add(request);
    }

    public void addToRequestQueue(Request request){
        getRequestQueue().add(request);
    }

    public void cancelPendingRequests(String tag){
        if(requestQueue != null)
            requestQueue.cancelAll(tag);
    }
}