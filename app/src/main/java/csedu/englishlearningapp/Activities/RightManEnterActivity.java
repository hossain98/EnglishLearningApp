package csedu.englishlearningapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import csedu.englishlearningapp.Models.RightManEnterWords;
import csedu.englishlearningapp.R;
import csedu.englishlearningapp.Views.RightManEnterView;

public class RightManEnterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_man_enter);
        Button tryButton=(Button) findViewById(R.id.tryButton);
        final TextView question= (TextView) findViewById(R.id.question);
        final RightManEnterView rightManEnterView =(RightManEnterView) findViewById(R.id.rightManEnterView);
        final List<RightManEnterWords> queryList=new RightManEnterWords().getAll();
        int r=new Random().nextInt();
        if(r<0)
        {
            r=-r;
        }
        int size=queryList.size();
        r=r%size;
        RightManEnterWords randomRow=queryList.get(r);
        question.setText(randomRow.getQuestion());
        rightManEnterView.setNames(randomRow.getAllOptions());
        tryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int r=new Random().nextInt();
                if(r<0)
                {
                    r=-r;
                }
                int size=queryList.size();
                r=r%size;
                RightManEnterWords randomRow=queryList.get(r);
                question.setText(randomRow.getQuestion());
                rightManEnterView.setNames(randomRow.getAllOptions());

            }
        });






    }
}
