package edu.app.wannabeesfamilyplaytown.home.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.app.wannabeesfamilyplaytown.R;
import edu.app.wannabeesfamilyplaytown.hours.activities.HoursActivity;

public class MainActivity extends AppCompatActivity{


    @BindView(R.id.tv_opening_hours)
    AppCompatButton tvOpeningHours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }


    @OnClick(R.id.tv_opening_hours)
    public void onViewClicked() {
        HoursActivity.openHoursDetailActivity(this);
    }
}

