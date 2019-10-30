package csedu.englishlearningapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.activeandroid.query.Select;

import java.util.List;

import csedu.englishlearningapp.Models.Words;
import csedu.englishlearningapp.R;

public class NoviceWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novice_word);
        LinearLayout linearView=(LinearLayout)findViewById(R.id.linearView);
        List<Words> wordsList=new Select().from(Words.class).execute();
        for(Words word: wordsList){

            if(word.getType().equalsIgnoreCase("n")) {
                TextView textView=new TextView(this);
                textView.setText(word.getWord()+" : "+word.getMeaning() );
                textView.setTextSize(20);
                linearView.addView(textView);
            }
        }

    }
}
