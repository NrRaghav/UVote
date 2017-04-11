package uvote.app.raghav.com.uvote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseIndexRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import uvote.app.raghav.com.uvote.uvote.R;

public class MainActivity extends AppCompatActivity {
    private FirebaseRecyclerAdapter<survey, SurveyHolder> mAdapter;
    private List<survey> pli = new ArrayList<>();
    private SurveyAdapter s;



    private RecyclerView.LayoutManager mLayoutManager;

    DatabaseReference ref;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview);

        ref = FirebaseDatabase.getInstance().getReference().child("surveys");
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new FirebaseRecyclerAdapter<survey,SurveyHolder>(survey.class, R.layout.surveycard, SurveyHolder.class, ref) {
            @Override
            public void populateViewHolder(SurveyHolder ViewHolder, final survey survey, int position) {
                ViewHolder.tv.setText(survey.getDescription());
                Glide.with(MainActivity.this).load(survey.getPicture()).into(ViewHolder.iv);
            }
        };
        recyclerView.setAdapter(mAdapter);




        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.keepSynced(true);
        ref = mDatabase.child("surveys");


    }
}
