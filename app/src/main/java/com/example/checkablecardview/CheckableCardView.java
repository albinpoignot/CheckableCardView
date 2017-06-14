package com.example.checkablecardview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Checkable;
import android.widget.TextView;

public class CheckableCardView extends CardView implements Checkable {

    private static final int[] CHECKED_STATE_SET = {
            android.R.attr.state_checked,
    };

    private boolean isChecked;

    public CheckableCardView(Context context) {
        super(context);
        init(null);
    }

    public CheckableCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CheckableCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        LayoutInflater.from(getContext()).inflate(R.layout.checkable_card_view, this, true);

        setClickable(true);
        setChecked(false);

        setCardBackgroundColor(ContextCompat.getColorStateList(getContext(), R.color.selector_card_view_background));

        if (attrs != null) {
            TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.CheckableCardView, 0, 0);
            try {
                String text = ta.getString(R.styleable.CheckableCardView_card_text);
                TextView itemText = (TextView) findViewById(R.id.text);

                if (text != null) {
                    itemText.setText(text);
                }

            } finally {
                ta.recycle();
            }
        }
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }

    @Override
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override
    public void setChecked(boolean checked) {
        this.isChecked = checked;
    }

    @Override
    public boolean isChecked() {
        return isChecked;
    }

    @Override
    public void toggle() {
        setChecked(!this.isChecked);
    }
}
