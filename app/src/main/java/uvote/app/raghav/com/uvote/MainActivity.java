package uvote.app.raghav.com.uvote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseIndexRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import uvote.app.raghav.com.uvote.uvote.R;

public class MainActivity extends AppCompatActivity {
    private FirebaseIndexRecyclerAdapter<survey, SurveyHolder> mAdapter;
    private List<survey> pli = new ArrayList<>();
    private SurveyAdapter s;


    RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
    private RecyclerView.LayoutManager mLayoutManager;

    DatabaseReference ref;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new FirebaseIndexRecyclerAdapter<survey,SurveyAdapter.SurveyHolder>(survey.class, R.layout.surveycard, SurveyAdapter.SurveyHolder.class, ref.orderByChild("name").startAt(newText.toUpperCase()).endAt(newText.toUpperCase()+"\uf8ff"),ref) {
            @Override
            public void populateViewHolder(SurveyAdapter.SurveyHolder ViewHolder, final survey survey, int position) {
                recyclerView.setAdapter(mAdapter);
            }
        };




        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.keepSynced(true);
        ref = mDatabase.child("surveys");


    }
}
