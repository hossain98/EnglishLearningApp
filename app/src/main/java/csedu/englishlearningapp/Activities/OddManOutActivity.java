package csedu.englishlearningapp.Activities;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.Toast;
import csedu.englishlearningapp.Resources.SimpleGestureFilter;
import csedu.englishlearningapp.Views.CircleTextView;
import csedu.englishlearningapp.Models.OddManWords;
import csedu.englishlearningapp.R;
import com.activeandroid.query.Select;

import java.util.List;
import java.util.Random;

public class OddManOutActivity extends AppCompatActivity implements SimpleGestureFilter.SimpleGestureListener{

    private SimpleGestureFilter detector;
    static int points=4;
    float centerX,centerY,radius ;
    float density;
    float paddingX ;
    float paddingY ;
    private int odd;
    RelativeLayout mainView ;
    private CircleTextView testView[]=new CircleTextView[4];
    // ValueAnimator animatorTest ;
    public   void loadView()
    {
        List<OddManWords> words = new Select().from(OddManWords.class).execute();
        Random random= new Random();
        int res=random.nextInt();
        if(res<0)res=(-res);
        res=res%words.size();
        String problem[]=words.get(res).getWords();
        odd=random.nextInt();
        if(odd<0)odd=-odd;
        odd=odd%4;
        String finalProblem[]=new String[4];
        finalProblem[odd]=problem[3];
        int k=0;
        for(int i=0;i<=3;i++)
        {
            if(i==odd)continue;
            finalProblem[i]=problem[k];
            k++;
        }
        testView[0].setCircleText(finalProblem[0]);
        testView[1].setCircleText(finalProblem[1]);
        testView[2].setCircleText(finalProblem[2]);
        testView[3].setCircleText(finalProblem[3]);




    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Intent intent = new Intent(this,AwsomeActivity.class);
//        startActivity(intent);


        Toast.makeText(OddManOutActivity.this,"Your Current Score: "+points,Toast.LENGTH_LONG).show();

        density = getResources().getDisplayMetrics().density ;
        setContentView(R.layout.activity_odd_man_out);
//        myView = (CircleTextView) findViewById(R.id.circleTextView);
        detector = new SimpleGestureFilter(this,this);
        mainView = (RelativeLayout) findViewById(R.id.myLayout) ;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowmanager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        windowmanager.getDefaultDisplay().getMetrics(displayMetrics);
        int deviceWidth = displayMetrics.widthPixels;
        int deviceHeight = displayMetrics.heightPixels;
        radius = deviceWidth / 2 ;
        centerY= (deviceHeight /2)+50 ;
        centerX = deviceWidth /2 ;
//        Toast.makeText(this,deviceHeight+" "+deviceWidth,Toast.LENGTH_LONG).show();


//        centerX =200;
//        centerY =400;
//        radius  = 100;
//        animatorTest = new ValueAnimator();
//        animatorTest.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                newView.setCenterY((float)animation.getAnimatedValue());
//
//            }
//        });
        List<OddManWords> words = new Select().from(OddManWords.class).execute();
        Random random= new Random();
        int res=random.nextInt();
        if(res<0)res=(-res);
        res=res%words.size();
        String problem[]=words.get(res).getWords();
        odd=random.nextInt();
        if(odd<0)odd=-odd;
        odd=odd%4;
        String finalProblem[]=new String[4];
        finalProblem[odd]=problem[3];
        int k=0;
        for(int i=0;i<=3;i++)
        {
            if(i==odd)continue;
            finalProblem[i]=problem[k];
            k++;
        }
        testView[0] = new CircleTextView(this,centerX-150,centerY,100,finalProblem[0]);
        testView[1] = new CircleTextView(this,centerX+150,centerY,100,finalProblem[1]);
        testView[2] = new CircleTextView(this,centerX,centerY-150,100,finalProblem[2]);
        testView[3] = new CircleTextView(this,centerX,centerY+150,100,finalProblem[3]);


        for(int i=0;i<4;i++)
            mainView.addView(testView[i]);

        paddingX  = mainView.getPaddingLeft();
        paddingY  = mainView.getPaddingTop();
//        animatorTest.setDuration(10000);
//        animatorTest.setFloatValues(400,600);
        //animatorTest.start();

    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent me){
        // Call onTouchEvent of SimpleGestureFilter class
        this.detector.onTouchEvent(me);
        return super.dispatchTouchEvent(me);
    }
    @Override
    public void onSwipe(int direction,MotionEvent e1,MotionEvent e2) throws InterruptedException {
        String str = "";

        switch (direction) {

            case SimpleGestureFilter.SWIPE_RIGHT : str = "Swipe Right";
                break;
            case SimpleGestureFilter.SWIPE_LEFT :  str = "Swipe Left";
                break;
            case SimpleGestureFilter.SWIPE_DOWN :  str = "Swipe Down";
                for (CircleTextView myView:testView) {
                    if(myView.isInsideCircle((e1.getRawX()),
                            (e1.getRawY())))
                    {

                        // Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
                        float shift = radius ;
                        if(myView.equals(testView[odd])){
                            myView.getAnimatorY().setFloatValues(myView.getCenterY(), centerY + shift + 140,myView.getCenterY());
                            myView.getAnimatorY().setInterpolator(new AccelerateDecelerateInterpolator());
                            myView.getAnimatorY().setDuration(1000);
                            myView.getAnimatorY().start();
                            points++;
//                            this.wait(1000);
                            Toast.makeText(OddManOutActivity.this,"Your Current Score: "+points,Toast.LENGTH_LONG).show();
                            loadView();
                            // this.finish();


                        }
                        else {
                            myView.getAnimatorY().setFloatValues(myView.getCenterY(), centerY + shift + 140, myView.getCenterY());
                            myView.getAnimatorY().setInterpolator(new AccelerateDecelerateInterpolator());
                            myView.getAnimatorY().setDuration(1000);
                            myView.getAnimatorY().start();
                            points--;
//                            this.wait(1000);
                            if(points<=0)
                            {
                                points=4;
                                Toast.makeText(OddManOutActivity.this,"Game Over!!!",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(this,GamesActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(OddManOutActivity.this,"Wrong!!!  Your Current Score: "+points,Toast.LENGTH_SHORT).show();
                            }
                        }
                        //myView.getAnimatorY().reverse();
                    }

                }

                break;
            case SimpleGestureFilter.SWIPE_UP :    str = "Swipe Up";
                for (CircleTextView myView:testView
                        ) {
                    if(myView.isInsideCircle((e1.getRawX()),
                            (e1.getRawY())))
                    {
                        //  Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
                        float shift = radius ;
                        if(myView.equals(testView[odd])){
                            myView.getAnimatorY().setFloatValues(myView.getCenterY(), centerY - shift,myView.getCenterY());
                            myView.getAnimatorY().setInterpolator(new AccelerateDecelerateInterpolator());
                            myView.getAnimatorY().setDuration(800);
                            myView.getAnimatorY().start();

                            points++;
                            //this.wait(800);
                            Toast.makeText(OddManOutActivity.this,"Your Current Score: "+points,Toast.LENGTH_LONG).show();
                            loadView();
                            // this.finish();

                        }
                        else {
                            myView.getAnimatorY().setFloatValues(myView.getCenterY(), centerY - shift, myView.getCenterY());
                            myView.getAnimatorY().setInterpolator(new AccelerateDecelerateInterpolator());
                            myView.getAnimatorY().setDuration(800);
                            myView.getAnimatorY().start();
                            points--;
//                            this.wait(1000);

                            if(points<=0)
                            {
                                points=4;
                                Toast.makeText(OddManOutActivity.this,"Game Over!!!",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(this,GamesActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(OddManOutActivity.this,"Wrong!!! Your current score: "+points,Toast.LENGTH_SHORT).show();
                            }
                        }
                        // myView.getAnimatorY().reverse();
                        // myView.getAnimatorY().setStartDelay(1000*2);
                    }
                }

                break;

        }
        // for(int i=0;i<5;i++)
//        Toast.makeText(this, str+" "+(e1.getRawY())
//                +" "+myView.getCenterY()+" "+radius, Toast.LENGTH_SHORT ).show();


    }

    @Override
    public void onDoubleTap() {
        Toast.makeText(this, "Double Tap", Toast.LENGTH_LONG).show();
    }


}

