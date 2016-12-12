package com.meguillaume.customviewindrawer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Vidar on 12/9/16.
 */

public class MyCustomView extends View {

    // cirle and text colors
    private int squareCol, labelCol;
    // lable text
    private String squareText;
    // paint for drawing custom view
    private Paint squarePaint;


    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // paint object for drawing in onDraw
        squarePaint = new Paint();

        // get the attributes specified in attrs.xml
        // using the name you included
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyCustomView, 0, 0);

        try {
            // get the text and colors specified using
            // the names in attrs.xml
            squareText = a.getString(R.styleable.MyCustomView_squareLabel);
            squareCol = a.getInteger(R.styleable.MyCustomView_squareColor, 0); // is default
            labelCol = a.getInteger(R.styleable.MyCustomView_LabelColor, 0);
        } finally {
            a.recycle();
        }

    }

    public int getSquareCol() {
        return squareCol;
    }

    public void setSquareCol(int newColor) {
        // update the instance variable
        squareCol = newColor;
        // redraw the view
        invalidate();
        requestLayout();
    }

    public int getLabelCol() {
        return labelCol;
    }

    public void setLabelCol(int newColor) {
        // update the instance variable
        labelCol = newColor;
        // redraw the view
        invalidate();
        requestLayout();
    }

    public String getSquareText() {
        return squareText;
    }

    public void setSquareText(String newSquareText) {
        // update the instance variable
        this.squareText = newSquareText;
        // redraw the view
        invalidate();
        requestLayout();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // set drawing properties
        squarePaint.setStyle(Paint.Style.FILL);
        squarePaint.setAntiAlias(true);

        // set the paint color using the circle color specified
        squarePaint.setColor(squareCol);

        // draw the Square using the properties defined
        canvas.drawRect(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight(), squarePaint);

        // set the text color using the color specified
        squarePaint.setColor(labelCol);

        // set text properties
        squarePaint.setTextAlign(Paint.Align.CENTER);
        squarePaint.setTextSize(50);

        // draw the text using the string attribute and chosen properties
        canvas.drawText(squareText, this.getMeasuredWidth() / 2, this.getMeasuredHeight() / 2, squarePaint);

    }

}

