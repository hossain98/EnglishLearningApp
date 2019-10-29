package csedu.englishlearningapp.Views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;




public class CircleTextView extends View {
    private Paint paint ;
    private  String circleText ;
    private int circleColor ;
    private int circleTextColor ;
    private float circleTextSize ;
    private float radius ;
    ValueAnimator animatorY ;
     float centerX ;
     float centerY ;
   Context mContext ;


    public CircleTextView(Context mcontext, float acenterX, float acenterY, float radius, String circleText) {
        super(mcontext);
        mContext = mcontext ;
        this.centerX = acenterX;
        this.centerY = acenterY;
        this.radius  = radius ;
        this.circleText = circleText ;

        animatorY = new ValueAnimator();
        //  animatorY.setInterpolator(new DecelerateInterpolator());

        animatorY.setDuration(1001);
        animatorY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
               centerY= (float) animation.getAnimatedValue();
                invalidate();
                requestLayout();
            }
        });
        paint = new Paint( ) ;

        circleColor = Color.GREEN ;
        float scale= mContext.getResources().getDisplayMetrics().density ;
        circleTextSize = 20f*scale ;
        circleTextColor = Color.BLACK ;

    }

    public    boolean isInsideCircle(float x, float y)
    {
        if(Math.pow(centerX-x,2)+Math.pow(centerY-y,2)>Math.pow(radius,2))return false ;
        return true ;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(circleColor);



        canvas.drawCircle(centerX,centerY-140,radius,paint);

        paint.setColor(circleTextColor);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(circleTextSize);

        canvas.drawText(circleText,centerX,centerY-135,paint);
    }

    public void setCircleColor(int circleColor) {
        this.circleColor = circleColor;
        invalidate();
        requestLayout();
    }

    public void setCircleTextColor(int circleTextColor) {
        this.circleTextColor = circleTextColor;
        invalidate();
        requestLayout();
    }

    public void setCircleText(String circleText) {
        this.circleText = circleText;
        invalidate();
        requestLayout();
    }

    public void setCircleTextSize(float circleTextSize) {
        this.circleTextSize = circleTextSize;
        invalidate();
        requestLayout();
    }

    public float getCenterY() {
        return centerY;
    }

    public void setRadius(float radius) {
        this.radius = radius;
        invalidate();
        requestLayout();
    }

    public float getCenterX() {
        return centerX;
    }

    public void setCenterX(float centerX) {
        this.centerX = centerX;
        invalidate();
        requestLayout();
    }

    public float getRadius() {

        return radius;
    }

    public void setCenterY(float centerY) {
        this.centerY = centerY;
        invalidate();
        requestLayout();
    }

    public ValueAnimator getAnimatorY() {
        return animatorY;
    }

    public void setAnimatorY(ValueAnimator animatorY) {
        this.animatorY = animatorY;
    }
}

