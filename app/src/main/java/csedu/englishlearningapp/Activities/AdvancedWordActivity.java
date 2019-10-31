package csedu.englishlearningapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.activeandroid.query.Select;

import java.util.List;

import csedu.englishlearningapp.Models.Words;
import csedu.englishlearningapp.R;

public class AdvancedWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_word);
        Button homeButton=(Button)findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(AdvancedWordActivity.this,HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
        Button wordButton=(Button)findViewById(R.id.wordButton);
        wordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(AdvancedWordActivity.this,WordsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
        Button gameButton=(Button)findViewById(R.id.homeButton);
        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(AdvancedWordActivity.this,GamesActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
        Button backButton=(Button)findViewById(R.id.homeButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(AdvancedWordActivity.this,WordsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

                LinearLayout linearView=(LinearLayout) findViewById(R.id.linearView);
        List<Words> wordsList= new Select().from(Words.class).execute();
        for(Words word :wordsList)
        {
            if(word.getType().equalsIgnoreCase("a"))
            {
                TextView textView = new TextView(this);
                textView.setText(word.getWord()+" : "+word.getMeaning() );
                textView.setTextSize(20);
                linearView.addView(textView);
            }
        }

    }
}
