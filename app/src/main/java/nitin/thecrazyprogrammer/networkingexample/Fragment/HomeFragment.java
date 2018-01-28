package nitin.thecrazyprogrammer.networkingexample.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import nitin.thecrazyprogrammer.generics.Fragments.BasicFragment;
import nitin.thecrazyprogrammer.networkingexample.Activity.ExampleDataActivity;
import nitin.thecrazyprogrammer.networkingexample.R;

/**
 * Created by Nitin Khurana on 1/28/2018.
 */
public class HomeFragment extends BasicFragment{

    LinearLayout root;

    @Override
    protected int setLayout() {
        return R.layout.home_fragment;
    }

    @Override
    protected void onCreateView(View view) {

        root = view.findViewById(R.id.root);
        makeButton("Api Call Task", ExampleDataActivity.class, 0);
        makeButton("Volley", ExampleDataActivity.class, 1);
        makeButton("Retrofit", ExampleDataActivity.class, 2);

    }

    private void makeButton(String title, final Class activity, final int task_type){

        Button button = new Button(getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(20, 20, 20, 20);
        button.setLayoutParams(params);

        button.setText(title);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), activity);
                intent.putExtra(ExampleDataActivity.INTENT_DATA_TASK_TYPE, task_type);
                startActivity(intent);
                if(activity.getSimpleName().equals("HomeScreen"))
                    ((Activity)getContext()).finish();
            }
        });

        root.addView(button);
    }
}
