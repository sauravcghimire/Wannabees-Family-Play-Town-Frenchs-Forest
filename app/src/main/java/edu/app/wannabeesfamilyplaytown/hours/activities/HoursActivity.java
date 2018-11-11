package edu.app.wannabeesfamilyplaytown.hours.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.app.wannabeesfamilyplaytown.R;
import edu.app.wannabeesfamilyplaytown.hours.adapters.HoursAdapter;
import edu.app.wannabeesfamilyplaytown.https.ServiceGenerators;
import edu.app.wannabeesfamilyplaytown.model.OpeningHours;
import edu.app.wannabeesfamilyplaytown.model.PlaceResult;
import edu.app.wannabeesfamilyplaytown.utils.AppConstants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HoursActivity extends AppCompatActivity {

    @BindView(R.id.progressbar)
    ProgressBar progressbar;
    @BindView(R.id.rv_hours)
    RecyclerView rvHours;

    LinearLayoutManager manager;
    HoursAdapter adapter;
    @BindView(R.id.tv_open_now)
    AppCompatTextView tvOpenNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hours);
        ButterKnife.bind(this);
        ServiceGenerators.createService().getPlaceDetail(AppConstants.WANNABEES_PLACE_ID, AppConstants.API_KEY).enqueue(new Callback<PlaceResult>() {
            @Override
            public void onResponse(Call<PlaceResult> call, Response<PlaceResult> response) {
                progressbar.setVisibility(View.GONE);
                if(response.body().getStatus().equals("OVER_QUERY_LIMIT")){
                    Toast.makeText(HoursActivity.this, response.body().getStatus(), Toast.LENGTH_SHORT).show();
                }else{
                    OpeningHours hours = response.body().getResult().getOpeningHours();
                    showOpeningHours(hours);
                }
            }

            @Override
            public void onFailure(Call<PlaceResult> call, Throwable t) {

            }
        });
    }

    private void showOpeningHours(OpeningHours hours) {
        if (hours.getOpenNow()) {
            tvOpenNow.setText("Open Now");
            tvOpenNow.setTextColor(getResources().getColor(R.color.green));
        } else {

            tvOpenNow.setText("Closed");
            tvOpenNow.setTextColor(getResources().getColor(R.color.red));
        }
        manager = new LinearLayoutManager(this);
        adapter = new HoursAdapter(hours.getWeekdayText());
        rvHours.setLayoutManager(manager);
        rvHours.setAdapter(adapter);
    }

    public static void openHoursDetailActivity(Context context) {
        context.startActivity(new Intent(context, HoursActivity.class));
    }
}
