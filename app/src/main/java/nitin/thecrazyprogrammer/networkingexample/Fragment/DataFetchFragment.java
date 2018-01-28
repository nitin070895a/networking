package nitin.thecrazyprogrammer.networkingexample.Fragment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;

import nitin.thecrazyprogrammer.generics.Adapters.CardViewRecyclerAdapter;
import nitin.thecrazyprogrammer.generics.Fragments.BasicRecyclerViewFragment;
import nitin.thecrazyprogrammer.networking.Listeners.ApiCallListener;
import nitin.thecrazyprogrammer.networking.Tasks.ApiCallTask;
import nitin.thecrazyprogrammer.networking.Tasks.RetroFitTask;
import nitin.thecrazyprogrammer.networking.Tasks.VolleyTask;
import nitin.thecrazyprogrammer.networkingexample.Activity.ExampleDataActivity;
import nitin.thecrazyprogrammer.networkingexample.Activity.MainActivity;
import nitin.thecrazyprogrammer.networkingexample.Models.Device;

/**
 * Created by Nitin Khurana on 1/28/2018.
 */
public class DataFetchFragment extends BasicRecyclerViewFragment<CardViewRecyclerAdapter> implements ApiCallListener {

    String[] titles = new String[10];
    String[] desc = new String [10];

    ExampleDataActivity dataActivity;

    @Override
    protected void loadOrReload() {
        dataActivity = (ExampleDataActivity) getContext();
        String url = MainActivity.TEST_URL + "brand=";

        // make Api Call here
        switch (dataActivity.taskType){
            case 1: new VolleyTask(getContext(), url + "Apple", this).execute(); return;
            case 2: new RetroFitTask(getContext(), url + "Motorola", this).execute(); return;
        }
        new ApiCallTask(getContext(), url + "Samsung", this).execute();
    }

    @Override
    public void onApiResult(boolean success, String msg, String callingUrl) {

        loadComplete(success, msg);
        setAdapter(new CardViewRecyclerAdapter(titles, desc));
    }

    @Override
    public void parseResult(JSONArray result, String callingUrl) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Device[] devices = gson.fromJson(String.valueOf(result), Device[].class);

        for(int i=0; i<devices.length; i++){
            titles[i] = devices[i].getId() + ". " + devices[i].getName();
            desc[i] =
                    devices[i].getNtwTech() + "\n" +
                            devices[i].getStatus() + "\n" +
                            devices[i].getDimensions() + "\n" +
                            devices[i].getWeight() + "\n" +
                            devices[i].getSim() + "\n" +
                            devices[i].getDisplaySize() + "\n" +
                            devices[i].getDisplayResolution() + "\n" +
                            devices[i].getMultitouch() + "\n" +
                            devices[i].getOs() + "\n" +
                            devices[i].getChipset() + "\n" +
                            devices[i].getCpu() + "\n" +
                            devices[i].getGps() + "\n" +
                            devices[i].getRam() + "\n" +
                            devices[i].getCardSlot() + "\n" +
                            devices[i].getStorage() + "\n" +
                            devices[i].getRCamera() + "\n" +
                            devices[i].getRCameraFeatures() + "\n" +
                            devices[i].getRCameraVideo() + "\n" +
                            devices[i].getFCamera() + "\n" +
                            devices[i].getLoudspeaker() + "\n" +
                            devices[i].getHJack() + "\n" +
                            devices[i].getWlan() + "\n" +
                            devices[i].getBluetooth() + "\n" +
                            devices[i].getGps() + "\n" +
                            devices[i].getInfrared() + "\n" +
                            devices[i].getRadio() + "\n" +
                            devices[i].getUsb() + "\n" +
                            devices[i].getSensors() + "\n" +
                            devices[i].getJava() + "\n" +
                            devices[i].getBattery() + "\n" +
                            devices[i].getColors() + "\n" +
                            devices[i].getPrice() + "\n" +
                            devices[i].getPerformance() + "\n";
        }
    }
}
