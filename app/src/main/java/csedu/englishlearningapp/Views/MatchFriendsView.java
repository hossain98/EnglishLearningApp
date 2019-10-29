package csedu.englishlearningapp.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.activeandroid.query.Select;

import java.util.List;
import java.util.Random;
import java.util.Vector;

import csedu.englishlearningapp.Helpers.Line;
import csedu.englishlearningapp.Models.MatchFriendsWords;



public class MatchFriendsView extends View {
    final int TOTAL=5 ;
    final int MAX_SIZE=750 ;
    Context mContext ;
    Paint mPaint ;
    Vector<Line> linesVector ;
    int xdim=getWidth()/3;
    int ydim=getHeight()/10;
    int startX,startY,endX,endY ;



    String wordsSet1[]={"GOOD","LIFE","FRIEND","SORROW","LOVE"};
    String wordsSet2[]={"BETTER","LIVE","SUPPORTER","GRIEVANCE","AFFECTION"};
    int ans[];
    public MatchFriendsView(final Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);
        ans= new int[TOTAL];
        generateAns();
        mContext =context ;
        startX=startY=endX=endY=-1;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linesVector = new Vector<Line>();




    }

    public void generateAns()
    {
        Random random=new Random();
        int start= random.nextInt();
        if(start<0)start=-start ;
        start=start%TOTAL ;
        ans[0]=start;
        int shift=random.nextInt();
        if(shift<0)shift=(-shift);
        else if(shift==0)shift=4;
        shift=3;
        for(int i=1;i<TOTAL;i++)
        {
            ans[i]=(ans[i-1]+shift)%TOTAL;
        }

    }
    private void drawBoxes(Canvas canvas)
    {
        Paint.Style old=mPaint.getStyle();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(5);
        int shift=MAX_SIZE/TOTAL ;

        for(int i=0;i<TOTAL;i++)
        {
            canvas.drawRect(0,1+i*shift,
                    200,shift+i*shift,mPaint);
//            canvas.drawRect((int)party2[i].first,(int)party2 [i].second,
//                    (int)(party2[i].first)+xdim,(int)party2[i].second+ydim,mPaint);
            canvas.drawRect(475,1+i*shift,
                    475+200,shift+i*shift,mPaint);

        }
        mPaint.setStyle(old);
    }
///
    public Pair<Integer,Integer> checkInBox(int x,int y) ///
    {
        int shift=MAX_SIZE/TOTAL ;
        Pair<Integer, Integer> myPair=new Pair<>(-1,-1);
        if(x>0 && x<200){
            if(y>1 && y<MAX_SIZE)
            {
                myPair= new Pair<>(1,y/shift);
            }
        }
        else if(x>475 && x<675 )
        {
            if(y>1 && y<MAX_SIZE)
            {
                myPair= new Pair<>(2,y/shift);
            }
        }
        return  myPair ;
    }
    private void drawTexts(Canvas canvas)
    {
        float scale= mContext.getResources().getDisplayMetrics().density ;
        mPaint.setColor(Color.BLACK);
        int shift=MAX_SIZE/TOTAL;
        mPaint.setTextSize(15f*scale);
       // mPaint.setTextAlign(Paint.Align.CENTER);
        for(int i=0;i<TOTAL;i++) {
            canvas.drawText(wordsSet1[i], 20, shift/2+5+i*shift, mPaint);
            canvas.drawText(wordsSet2[ans[i]], 475+20, shift/2+5+i*shift, mPaint);
        }
    }
    private void drawLines(Canvas canvas)
    {
        mPaint.setColor(Color.GREEN);
        float old=mPaint.getStrokeWidth();
        mPaint.setStrokeWidth(12);
        if(linesVector.size()<TOTAL) {
            for (Line line : linesVector) {
                canvas.drawLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY(), mPaint);
            }
//        mPaint.setColor(Color.YELLOW);
            if (!(startX == -1 || startY == -1 || endX == -1 || endY == -1))
                canvas.drawLine(startX, startY, endX, endY, mPaint);
        }
        else {
            for (Line line : linesVector) {
                int i=checkInBox(line.getStartX(),line.getStartY()).second ;
                int j=checkInBox(line.getEndX(),line.getEndY()).second ;
                if(wordsSet2[i].equalsIgnoreCase(wordsSet2[ans[j]])==false)
                    mPaint.setColor(Color.RED);
                else mPaint.setColor(Color.GREEN);
                canvas.drawLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY(), mPaint);
            }
        }
        mPaint.setStrokeWidth(old);
    }
    public boolean isEqualLines(Line line1,Line line2)
    {
        Pair<Integer,Integer> startPair1,endPair1,startPair2,endPair2;
        startPair1=checkInBox(line1.getStartX(),line1.getStartY());
        endPair1=checkInBox(line1.getEndX(),line1.getEndY());
        startPair2=checkInBox(line2.getStartX(),line2.getStartY());
        endPair2=checkInBox(line2.getEndX(),line2.getEndY());

        if(startPair1.first==startPair2.first
                && startPair1.second==startPair2.second
                && endPair1.first==endPair2.first
                &&endPair1.second==endPair2.second)
            return true;
        else  return false;

    }
    public boolean isCommonPoint(Line line1,Line line2){
        Pair<Integer,Integer> startPair1,endPair1,startPair2,endPair2;
        startPair1=checkInBox(line1.getStartX(),line1.getStartY());
        endPair1=checkInBox(line1.getEndX(),line1.getEndY());
        startPair2=checkInBox(line2.getStartX(),line2.getStartY());
        endPair2=checkInBox(line2.getEndX(),line2.getEndY());

        if(startPair1.first!=endPair1.first &&
             startPair2.first!=endPair2.first
        &&!(startPair1.first==startPair2.first
                        && startPair1.second==startPair2.second
                        || endPair1.first==endPair2.first
                        &&endPair1.second==endPair2.second))
            return false;
        else  return true;
    }

    public boolean isDuplicate(int startX,int startY,int endX,int endY)
    {


        Line line1=new Line(startX,startY,endX,endY);
        for(Line line:linesVector)
        {
//            if(isEqualLines(line1,line))
              if(isCommonPoint(line1,line))
                return true;
        }

        return false;
    }
    public  void loadFromDB()
    {

        List<MatchFriendsWords> words= new Select().from(MatchFriendsWords.class).execute();

        Random random= new Random();
        int res=random.nextInt();
        if(res<0)res=(-res);
        res=res%words.size();





        for(int i=0;i<5;i++)
        {
            wordsSet1[i]=words.get((i+res)%words.size()).getFirst();
            wordsSet2[i]=words.get((i+res)%words.size()).getSecond();
        }



    }
    public void reStart()
    {
        startX=startY=endX=endY=-1;
        linesVector.clear();
        loadFromDB();
        generateAns();
        invalidate();
       // Toast.makeText(mContext, "RestartClicked", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        //drawSmallCircle(canvas);
        //drawBigCircle(canvas);

        drawBoxes(canvas);
        drawTexts(canvas);
        drawLines(canvas);
    }
    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX =(int) event.getX();
                startY =(int) event.getY();
                if(checkInBox(startX,startY).first==-1 ){
                    startX=startY=endX=endY=-1;
                    break;
                }
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                if(startX==-1 )break;
                endX = (int)event.getX();
                endY = (int)event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                if(startX==-1)break;
                endX = (int)event.getX();
                endY =(int) event.getY();
                if(checkInBox(endX,endY).first==-1)
                {
                    startX=startY=endX=endY=-1;
                    invalidate();
                    break;
                }
                else
                {
                    if(startX>endX)
                    {
                        int R=startX;
                        startX=endX;
                        endX=R;

                        R=startY;
                        startY=endY;
                        endY=R;

                    }

                    if(isDuplicate(startX,startY,endX,endY)==false)
                    {
                        Line line=new Line(startX,startY,endX,endY);
                        linesVector.add(line);
                        invalidate();

                    }
                    else
                    {
                        startX=startY=endX=endY=-1;
                        invalidate();
                    }
                    invalidate();
                }
                invalidate();
                break;
        }
        if(linesVector.size()==TOTAL)
        {
            int points=0;
            for(Line line:linesVector)
            {
                int i,j;
                i=checkInBox(line.getStartX(),line.getStartY()).second ;
                j=checkInBox(line.getEndX(),line.getEndY()).second ;

                if(wordsSet2[i].equalsIgnoreCase(wordsSet2[ans[j]]))points++;
            }

            Toast.makeText(mContext,"You Got :"+points,Toast.LENGTH_LONG).show();
           for(int i=0;i<TOTAL;i++)
               Toast.makeText(mContext,wordsSet1[i]+" : "+wordsSet2[i],Toast.LENGTH_SHORT).show();

        }

        return true;
    }


}

