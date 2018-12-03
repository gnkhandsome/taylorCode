package test.taylor.com.taylorcode.ui.state_cross_activities;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import test.taylor.com.taylorcode.R;

public class Activity1 extends AppCompatActivity implements View.OnClickListener {
    private TextView tv1;

    /**
     * LiveData case1:observer wont be notified until it's lifecycle component is at STARTED or RESUMED status
     */
    private MutableLiveData<String> mutableLiveData = new MutableLiveData<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activit1);
        tv1 = findViewById(R.id.tv1);
        tv1.setOnClickListener(this);
        findViewById(R.id.btn_start_activity2).setOnClickListener(this);

        /**
         * LiveData case1:observer wont be notified until it's lifecycle component is at STARTED or RESUMED status
         */
        mutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.v("ttaylor", "Activity1.onChanged()" + "  string=" + s);
            }
        });
        mutableLiveData.setValue("oncreate");


        /**
         * LiveData case2:a app lifecycle LiveData
         */
        StringLiveData.getInstance().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tv1.setText(s);
            }
        });
        StringLiveData.getInstance().setValue(String.valueOf(0));
    }

    @Override
    protected void onStart() {
        super.onStart();
        mutableLiveData.setValue("onstart");
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.tv1:
                String s = tv1.getText().toString();
                int integer = Integer.valueOf(s) + 1;
                StringLiveData.getInstance().setValue(String.valueOf(integer));
                break;
            case R.id.btn_start_activity2:
                Intent intent = new Intent(this,Activity2.class);
                startActivity(intent);
                break;
        }
    }
}