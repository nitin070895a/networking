package nitin.thecrazyprogrammer.networking.Tasks;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import nitin.thecrazyprogrammer.networking.AppController;
import nitin.thecrazyprogrammer.networking.Helper.NetworkHelper;
import nitin.thecrazyprogrammer.networking.Listeners.ApiCallListener;
import nitin.thecrazyprogrammer.networking.R;

public class VolleyTask implements Response.ErrorListener, Response.Listener<JSONObject> {

    Context context;
    String URL;
    ApiCallListener apiCallListener;
    JsonObjectRequest jsonObjectRequest;

    boolean success = false;
    String msg;

    public VolleyTask(Context context, String URL, ApiCallListener apiCallListener){

        this.context = context;
        this.URL = URL;
        this.apiCallListener = apiCallListener;

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, this, this);

    }

    public void execute(){

        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
    }

    @Override
    public final void onErrorResponse(VolleyError error) {

        success = false;
        msg = context.getString(R.string.could_not_connect);
        apiCallListener.onApiResult(success, msg, URL);
    }

    @Override
    public final void onResponse(JSONObject apiAnswer) {

        try {

            JSONObject response = apiAnswer.getJSONObject(ApiCallTask.KEY_RESPONSE_OBJECT);
            success = Boolean.parseBoolean(response.optString(ApiCallTask.KEY_RESPONSE_OBJECT_STATUS).toLowerCase());
            msg = response.optString(ApiCallTask.KEY_RESPONSE_OBJECT_MESSAGE);

            JSONArray result = apiAnswer.getJSONArray(ApiCallTask.KEY_RESULT_ARRAY);
            //BasicFunctions.showVeryLongLog("API Result : " +  result.toString());
            success = true;
            apiCallListener.parseResult(result, URL);

        } catch (JSONException e) {
            success = false;
            msg = context.getString(R.string.there_was_a_problem);  // server/api error
            e.printStackTrace();
        } catch (Exception e) {
            success = false;
            msg = context.getString(R.string.could_not_connect);  // null pointer exception
            e.printStackTrace();
        }

        apiCallListener.onApiResult(success, msg, URL);
    }
}