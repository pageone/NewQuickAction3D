package net.londatiga.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class CheckItem implements ActionItem {

	private final String title;
	private final int actionId;
    private boolean selected;
    private boolean sticky;
    private boolean initiallyChecked;
    
    private CheckBox checkbox;
    
    public CheckItem (int actionId, String title, boolean initiallyChecked) {
    	this.actionId = actionId;
    	this.title = title;
    	this.initiallyChecked = initiallyChecked;
    }
    
	public String getTitle() {
		return title;
	}
	public int getActionId() {
		return actionId;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public boolean isSticky() {
		return sticky;
	}
	public void setSticky(boolean sticky) {
		this.sticky = sticky;
	}
 
	@Override
	public View getView(LayoutInflater inflater, int orientation) {
		View container = inflater.inflate(R.layout.check_item_vertical, null);
		checkbox = (CheckBox) container.findViewById(R.id.chk_item);
		checkbox.setChecked(initiallyChecked);
		
		TextView tv = (TextView) container.findViewById(R.id.txt_chktext);
		tv.setText(title);
		
		container.setFocusable(true);
		container.setClickable(true);
		
		container.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (checkbox != null) {
					checkbox.toggle();
				}
			}
		});
		
		return container;
	}
	
	/**
	 * Returns the state of the checkbox.  If the view has not been created, this will
	 * return the initiallyChecked state that was passed in during construction. 
	 * 
	 * @return
	 */
	public boolean isChecked() {
		if (checkbox == null) {
			return initiallyChecked;
		}
		return checkbox.isChecked();
	}
	
	@Override
	public boolean respondsToClicks() {
		return false;
	}
    
}
