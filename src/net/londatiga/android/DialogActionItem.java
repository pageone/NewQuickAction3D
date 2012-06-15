package net.londatiga.android;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class DialogActionItem implements ActionItem {
	
	private final String title;
	private String initialValue;
	
	public DialogActionItem(String title, String initialValue) {
		this.title = title;
		this.initialValue = initialValue;
	}
	
	@Override
	public int getActionId() {
		// doesn't matter
		return 0;
	}

	@Override
	public View getView(final LayoutInflater inflater, int orientation) {
		
		View container = inflater.inflate(R.layout.dialog_item_vertical, null);
		TextView tv = (TextView) container.findViewById(R.id.txt_title);
		tv.setText(title);
		
		container.setFocusable(true);
		container.setClickable(true);
		
		container.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				AlertDialog.Builder builder = new AlertDialog.Builder(inflater.getContext());
				builder.setTitle("hello dialog");
				builder.setMessage("This is the message");
				builder.setPositiveButton("Hello, i worked", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Log.d("DialogActionItem", "Positive button pressed");
						dialog.dismiss();
					}
				});
				
				AlertDialog dialog = builder.create();
				dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {					
					@Override
					public void onDismiss(DialogInterface dialog) {
						Log.d("DialogActionItem", "I was dismissed... booo!");
					}
				});
				
				dialog.show();
				
			}
		});
		
		return container;
	}

	@Override
	public boolean isSticky() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean respondsToClicks() {
		return false;
	}

}
