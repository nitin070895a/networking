package nitin.thecrazyprogrammer.networkingexample.Fragment;

import nitin.thecrazyprogrammer.generics.Adapters.CardViewRecyclerAdapter;
import nitin.thecrazyprogrammer.generics.Fragments.BasicRecyclerViewFragment;

/**
 * Created by Nitin Khurana on 1/28/2018.
 */
public class VolleyFragment extends BasicRecyclerViewFragment<CardViewRecyclerAdapter>{

    @Override
    protected void loadOrReload() {
        loadComplete(false);
    }
}
