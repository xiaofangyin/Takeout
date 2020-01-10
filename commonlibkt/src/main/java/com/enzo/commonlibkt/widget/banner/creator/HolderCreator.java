package com.enzo.commonlibkt.widget.banner.creator;

import android.content.Context;
import android.view.View;

public interface HolderCreator {
    View createView(Context context, int index, Object o);
}
