package net.londatiga.android;

import android.view.LayoutInflater;
import android.view.View;

public interface ActionItem {

	public int getActionId();
	
	public View getView(LayoutInflater inflater, int orientation);
	
	public boolean isSticky();
	
	public boolean respondsToClicks();
	
}
