package edu.app.wannabeesfamilyplaytown.hours.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.app.wannabeesfamilyplaytown.R;

public class HoursAdapter extends RecyclerView.Adapter<HoursAdapter.HoursViewHolder> {
    List<String> weekDaysTexts;
    Context context;

    public HoursAdapter(List<String> weekDaysTexts) {
        this.weekDaysTexts = weekDaysTexts;
    }

    @NonNull
    @Override
    public HoursViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        return new HoursViewHolder(LayoutInflater.from(context).inflate(R.layout.item_weekday_text, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HoursViewHolder hoursViewHolder, int i) {
        hoursViewHolder.tvWeekdayText.setText(weekDaysTexts.get(i));
    }

    @Override
    public int getItemCount() {
        return weekDaysTexts.size();
    }

    public class HoursViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_weekday_text)
        AppCompatTextView tvWeekdayText;
        public HoursViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
