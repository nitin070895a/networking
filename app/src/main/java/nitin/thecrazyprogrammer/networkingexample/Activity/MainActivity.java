package nitin.thecrazyprogrammer.networkingexample.Activity;

import nitin.thecrazyprogrammer.generics.Activities.BasicFragmentActivity;
import nitin.thecrazyprogrammer.generics.Fragments.BasicFragment;
import nitin.thecrazyprogrammer.networkingexample.Fragment.HomeFragment;

public class MainActivity extends BasicFragmentActivity {

   //public static final String TEST_DOMAIN = "http://192.168.42.147:8888/firstApp/";
   //public static final String TEST_DOMAIN = "http://192.168.43.40:8888/firstApp/";
    public static final String TEST_DOMAIN = "http://192.168.1.100:8888/firstApp/";

    public static final String TEST_URL = TEST_DOMAIN + "devices/?";

    @Override
    protected BasicFragment setFragment() {
        return new HomeFragment();
    }

    @Override
    protected String setActivityTitle() {
        return "Networking Example";
    }
}
