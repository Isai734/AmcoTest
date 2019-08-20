package com.amco.tv.view.custom;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Isai on 28/12/18.
 * Se crea viewpager personalizado que permite la vista escalada y con padding del paperless
 */

public class ITMyViewPager extends ViewPager implements ViewPager.PageTransformer {

    /**
     * Los siguinetes parametros determinal la elevacion asi como la distancia entre las vistas.
     */
    private final static int BASE_ELEVATION = 50;
    private final static int RAISING_ELEVATION = 50;
    private final static float SMALLER_SCALE = 0.9f;
    private float START_OFFSET;

    public ITMyViewPager(@NonNull Context context) {
        super(context);
        init(context);
    }

    public ITMyViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        float density = getResources().getDisplayMetrics().density;
        float pageMargin = 16 * density;

        float viewPagerPadding = 4 * pageMargin;
        Log.i("PagerActivity", "viewPagerPadding: " + (int) viewPagerPadding);
        setClipToPadding(false);
        setPageMargin((int) pageMargin);
        setPadding((int) viewPagerPadding, 15, (int) viewPagerPadding, 5);

        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        START_OFFSET = (float) (viewPagerPadding) / (float) (widthPixels - 2 * viewPagerPadding);

        setPageTransformer(false, this);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void transformPage(View page, float position) {
        float absPosition = Math.abs(position - START_OFFSET);

        int currentapiVersion = Build.VERSION.SDK_INT;
        if (currentapiVersion >= Build.VERSION_CODES.LOLLIPOP) {
            if (absPosition >= 1) {
                page.setElevation(BASE_ELEVATION);
                page.setScaleY(SMALLER_SCALE);
            } else {
                page.setElevation(((1 - absPosition) * RAISING_ELEVATION + BASE_ELEVATION));
                page.setScaleY((SMALLER_SCALE - 1) * absPosition + 1);
            }
        } else {
            if (absPosition >= 1) {
                page.setScaleY(SMALLER_SCALE);
            } else {
                page.setScaleY((SMALLER_SCALE - 1) * absPosition + 1);
            }
        }
    }
}
