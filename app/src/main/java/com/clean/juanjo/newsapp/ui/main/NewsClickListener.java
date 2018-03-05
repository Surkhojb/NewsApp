package com.clean.juanjo.newsapp.ui.main;

import android.view.View;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 05/03/2018.
 */

public interface NewsClickListener {
    void onNewClick(View v, int position);
    void onBooksMarkClick(View v, int position);
    void onShareClick(View v, int position);
}
