package csedu.englishlearningapp.Views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RightManEnterView extends View {
    final int NUM_BUBLES = 4 ;
    int radius = 80;
    Paint paint ;
    Paint newPaint;
    int radiusBig = 150;
    List<Pair<Float,Float > > positions = new ArrayList<Pair<Float, Float>>() ;
    int activeIndex = -1 ;
    float activeX = 0;
    float activeY = 0;

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names=new String[names.length];
        Random random=new Random();
        int res=random.nextInt();
        if(res<0)res=-res ;


        for(int i=0;i<names.length;i++)
        this.names[(i+res)%names.length] = names[i];

        ans=(3+res)%names.length;

        float centerX=getWidth() /2 ;
        float centerY=getHeight() /2 ;
        if(activeRadius==radiusBig) {
            activeRadius=radius;
            activeX=(float) positions.get(activeIndex).first;
            activeY=positions.get(activeIndex).second;
//            animatorX.setFloatValues((float) positions.get(activeIndex).first, centerX);
//            animatorY.setFloatValues(positions.get(activeIndex).second, centerY);


        }
        invalidate();
    }

    public int getAns() {
        return ans;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }

    float activeRadius = 60 ;
    ValueAnimator animatorX ;
    ValueAnimator animatorY ;
    ValueAnimator animatorRadius ;
    public  String names [] ={"eat","go","sleep","play"};
    int ans=0;

    int colors []= {Color.RED,Color.MAGENTA,Color.CYAN,Color.GREEN,Color.CYAN};
    Context mContext ;
    public RightManEnterView(final Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);
        mContext =context ;
        paint = new Paint();
        newPaint = new Paint();
        animatorX = new ValueAnimator();
        animatorY = new ValueAnimator() ;
        animatorRadius = new ValueAnimator();
        animatorX.setDuration(1000);
        animatorY.setDuration(1000);
        animatorRadius.setDuration(1000);

        animatorX.setInterpolator(new DecelerateInterpolator());
        animatorY.setInterpolator(new BounceInterpolator());
        animatorRadius.setFloatValues(radius,radiusBig);
        animatorRadius.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                activeRadius = (float)animation.getAnimatedValue();
                RightManEnterView.this.invalidate();
            }
        });

        animatorX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                activeX =(float)animation.getAnimatedValue();
                RightManEnterView.this.invalidate();
            }
        });

        animatorY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                activeY = (float)animation.getAnimatedValue();
               RightManEnterView.this.invalidate();
            }
        });
        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                activeIndex = isInsideCircle(event.getX(),event.getY());
                float centerX=getWidth() /2 ;
                float centerY=getHeight() /2 ;
                if(activeIndex> -1){
                    //Toast.makeText(context,"Got x:"+event.getX()+" y:"+event.getY(),Toast.LENGTH_SHORT).show();

                    if(activeIndex!=ans) {
                        animatorRadius.setFloatValues(radius,radiusBig,radius);
                        animatorX.setFloatValues((float) positions.get(activeIndex).first, centerX, (float) positions.get(activeIndex).first);
                        animatorY.setFloatValues(positions.get(activeIndex).second, centerY, positions.get(activeIndex).second);
                    }
                    else
                    {
                        animatorRadius.setFloatValues(radius,radiusBig);
                        animatorX.setFloatValues((float) positions.get(activeIndex).first, centerX);
                        animatorY.setFloatValues(positions.get(activeIndex).second, centerY);
                    }
                    animatorX.start();
                    animatorY.start();
                    animatorRadius.start();


                    if(activeIndex==ans)
                    {
                        Toast.makeText(mContext,"Congrats!!!",Toast.LENGTH_SHORT).show();

                    }
                    else{
                        Toast.makeText(mContext,"Wrong!!!",Toast.LENGTH_SHORT).show();
                    }
                }

                return  false ;
            }
        });
    }
    private int isInsideCircle(float x,float y)
    {
        for(int i=0;i<positions.size() ;i++)
        {
            float centerX = positions.get(i).first ;
            float centerY = positions.get(i).second ;

            if(Math.pow(x-centerX,2)+Math.pow(y-centerY,2)<Math.pow(radius,2))
                return  i ;
        }
        return  -1 ;
    }
    private  void initPostions(){
        if(positions.size()==0)
        {
            float spacing =getWidth()/ NUM_BUBLES ;
            float shift = spacing /2 ;
            int bottomMargin = 10 ;

            for(int i =0 ;i < NUM_BUBLES ; i++)
            {
                float x = i * spacing + shift ;
                float y = getHeight() - radius * 2 - bottomMargin ;
                positions.add(new Pair<Float, Float>(x,y));
            }
        }
    }
    private void drawBigCircle(Canvas canvas)
    {
        if(activeIndex>-1) {
            paint.setColor(colors[activeIndex]);
            canvas.drawCircle(activeX, activeY, activeRadius, paint);
            float scale= mContext.getResources().getDisplayMetrics().density ;
            paint.setColor(Color.BLACK);
            paint.setTextSize(20f*scale);
            paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(names[activeIndex],activeX,activeY+radius/2,paint);

        }
    }

    private void drawSmallCircle(Canvas canvas)
    {
        initPostions();
        paint.setColor(Color.WHITE);

        for(int i=0;i<NUM_BUBLES ; i++)
        {
            if(activeIndex == i)continue;
            paint.setColor(colors[i]);
            float x = (float)positions.get(i).first ;
            float y = (float)positions.get(i).second ;
            canvas.drawCircle(x,y,radius,paint);
            paint.setColor(Color.BLACK);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(20f*mContext.getResources().getDisplayMetrics().density);
            canvas.drawText(names[i],x,y+radius/2-20,paint);
        }
    }



    public  void drawParmanentCircle(Canvas canvas)
    {
        newPaint.setColor(Color.BLACK);
        newPaint.setStyle(Paint.Style.STROKE);
        newPaint.setStrokeWidth(12);
        float centerX=getWidth() /2 ;
        float centerY=getHeight() /2 ;

        canvas.drawCircle(centerX,centerY,radiusBig+5,newPaint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawSmallCircle(canvas);
        drawBigCircle(canvas);
        drawParmanentCircle(canvas);


    }

}
