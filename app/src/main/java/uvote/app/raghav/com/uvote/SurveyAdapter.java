package uvote.app.raghav.com.uvote;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import uvote.app.raghav.com.uvote.uvote.R;

/**
 * Created by Chirag on 10-Apr-17.
 */

public class SurveyAdapter extends RecyclerView.Adapter<SurveyHolder> {


    private List<survey> wList;
    private Context mContext;

    public SurveyAdapter(List<survey> myItems, Context context) {
        this.wList = myItems;
        mContext = context;
    }


    @Override
    public SurveyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SurveyHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.surveycard, parent, false));

    }

    @Override
    public void onBindViewHolder(SurveyHolder holder, int position) {
        final survey c=wList.get(holder.getAdapterPosition());
        holder.tv.setText(c.getTv().toString());
        Glide.with(mContext).load(survey.getIv()).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return wList.size();
    }
}
