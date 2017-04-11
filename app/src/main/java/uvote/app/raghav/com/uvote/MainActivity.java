package uvote.app.raghav.com.uvote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseIndexRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import uvote.app.raghav.com.uvote.uvote.R;

public class MainActivity extends AppCompatActivity {
    private FirebaseRecyclerAdapter<survey, SurveyHolder> mAdapter;
    private List<survey> pli = new ArrayList<>();
    private SurveyAdapter s;



    private RecyclerView.LayoutManager mLayoutManager;

    DatabaseReference ref;
    users u = new users();
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview);

        getUser();

        ref = FirebaseDatabase.getInstance().getReference().child("surveys");
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new FirebaseRecyclerAdapter<survey,SurveyHolder>(survey.class, R.layout.surveycard, SurveyHolder.class, ref) {
            @Override
            public void populateViewHolder(SurveyHolder ViewHolder, final survey survey, int position)
            {
                ViewHolder.yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    ArrayList<String> yea;
                        ArrayList<String> no;
                        yea=survey.getYes();
                        no=survey.getNo();
                        if (yea==null)
                        {
                            yea=new ArrayList<String>();
                            yea.add(u.getRno());
                            ref.child(survey.getSid()).child("yea").setValue(yea);
                        }
                        else if (!yea.contains(u.getRno())&&!no.contains(u.getRno())){
                            yea.add(u.getRno());
                            ref.child(survey.getSid()).child("yes").setValue(yea);
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "You can only vote once!!",
                                    Toast.LENGTH_SHORT).show();
                        }



                    }
                });
                ViewHolder.no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ArrayList<String> yea;
                        ArrayList<String> no;
                        yea=survey.getYes();
                        no=survey.getNo();
                        if (no==null)
                        {
                            no=new ArrayList<String>();
                            no.add(u.getRno());
                            ref.child(survey.getSid()).child("no").setValue(no);
                        }
                        else if (!yea.contains(u.getRno())&&!no.contains(u.getRno())){
                            no.add(u.getRno());
                            ref.child(survey.getSid()).child("no").setValue(no);
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "You can only vote once!!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                ViewHolder.tv.setText(survey.getDescription());
                Glide.with(MainActivity.this).load(survey.getPicture()).into(ViewHolder.iv);
            }
        };
        recyclerView.setAdapter(mAdapter);




        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.keepSynced(true);
        ref = mDatabase.child("surveys");


    }
    void getUser()
    {
        FirebaseUser mUser = FirebaseAuth.getInstance().getCurrentUser();
        final String uid=mUser.getUid();
        final DatabaseReference mDatabase= FirebaseDatabase.getInstance().getReference().child("users").child(uid);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                u=dataSnapshot.getValue(users.class);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
