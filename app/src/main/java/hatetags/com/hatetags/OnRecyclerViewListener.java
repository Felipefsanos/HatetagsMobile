package hatetags.com.hatetags;

import android.view.View;

public interface OnRecyclerViewListener {
    public void onItemClick(View view, int position);
    public void onLongItemClick(View view, int position);
}
