package csedu.englishlearningapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import csedu.englishlearningapp.R;
import csedu.englishlearningapp.Views.MatchFriendsView;

public class

MatchFriendsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_friends);
        Button homeButton=(Button)findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MatchFriendsActivity.this,HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
        Button wordButton=(Button)findViewById(R.id.homeButton);
        wordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MatchFriendsActivity.this,WordsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
        Button gameButton=(Button)findViewById(R.id.gameButton);
        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MatchFriendsActivity.this,GamesActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
        Button backButton=(Button)findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MatchFriendsActivity.this,GamesActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
        Button tryButton=(Button)findViewById(R.id.tryButton);
        final MatchFriendsView matchFriendsView=(MatchFriendsView)findViewById(R.id.mfv);
        matchFriendsView.loadFromDB();
        tryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                matchFriendsView.reStart();
                //Toast.makeText(MatchFriendsActivity.this,"Try Button",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
