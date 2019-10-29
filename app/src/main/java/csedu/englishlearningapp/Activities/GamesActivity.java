package csedu.englishlearningapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import csedu.englishlearningapp.R;

public class GamesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        Button oddManOutButton = (Button) findViewById(R.id.oddManOutButton);
        oddManOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GamesActivity.this,OddManOutActivity.class);
                startActivity(intent);
            }
        });

        Button matchFriendsButton=(Button)findViewById(R.id.matchFriendsButton);
        matchFriendsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GamesActivity.this,MatchFriendsActivity.class);
                startActivity(intent);
            }
        });



        Button rightManEnterButton =(Button) findViewById(R.id.rightManEnterButton);
        rightManEnterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GamesActivity.this,RightManEnterActivity.class);
                startActivity(intent);
            }
        });
    }
}

