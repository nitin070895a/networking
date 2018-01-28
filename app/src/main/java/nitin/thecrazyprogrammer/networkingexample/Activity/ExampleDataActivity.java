package nitin.thecrazyprogrammer.networkingexample.Activity;

import nitin.thecrazyprogrammer.generics.Activities.BasicFragmentActivity;
import nitin.thecrazyprogrammer.generics.Fragments.BasicFragment;
import nitin.thecrazyprogrammer.networkingexample.Fragment.DataFetchFragment;
import nitin.thecrazyprogrammer.networkingexample.R;

/**
 * Created by Nitin Khurana on 1/28/2018.
 */
public class ExampleDataActivity extends BasicFragmentActivity{

    public static final String INTENT_DATA_TASK_TYPE = "type";
    public int taskType;

    @Override
    protected BasicFragment setFragment() {
        return new DataFetchFragment();
    }

    @Override
    protected String setActivityTitle() {
        taskType = getIntent().getIntExtra(INTENT_DATA_TASK_TYPE, 0);

        switch (taskType){
            case 0: return "Samsung Devices";
            case 1: return "Apple Devices";
            case 2: return "Motorola Devices";
        }

        return getResources().getString(R.string.app_name);
    }
}
