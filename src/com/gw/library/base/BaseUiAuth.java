package com.gw.library.base;

import com.gw.library.R;
import com.gw.library.ui.HistoryActivity;
import com.gw.library.ui.RecommendActivity;
import com.gw.library.ui.RemindActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.TextView;

public class BaseUiAuth extends BaseUi {
	
	//底部mainTab 的几个button
	public RadioButton recommendBtn;
	public RadioButton remindBtn;
	public RadioButton historyBtn;
	
	//当前界面的标题
	public TextView mainTitle;
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	
	@Override
	public void onStart() {
		super.onStart();
		bindTabEvent();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);
	}
	
	public void bindTabEvent(){
		recommendBtn = (RadioButton)findViewById(R.id.tab_recommend);
		remindBtn = (RadioButton)findViewById(R.id.tab_remind);
		historyBtn = (RadioButton)findViewById(R.id.tab_history);
		
		mainTitle = (TextView)findViewById(R.id.main_title);
		
		if (recommendBtn == null || remindBtn == null || historyBtn == null) {
			Log.e("baseUiAuth--bindTabEvent", "false");
			return;
		}
		
		OnClickListener onClickListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.tab_recommend:
					forward(RecommendActivity.class);
					break;
				case R.id.tab_remind:
					forward(RemindActivity.class);
					break;
				case R.id.tab_history:
					forward(HistoryActivity.class);
					break;
				}
				
			}
		};
		
		recommendBtn.setOnClickListener(onClickListener);
		historyBtn.setOnClickListener(onClickListener);
		remindBtn.setOnClickListener(onClickListener);
		
		//设置main_tab 中 radiobutton 的 drawableTop的背景图片
		if (this instanceof RecommendActivity) {
			mainTitle.setText(R.string.recommend);
			recommendBtn.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.hover_recommend, 0, 0);
		}else if (this instanceof HistoryActivity) {
			mainTitle.setText(R.string.history);
			historyBtn.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.hover_history, 0, 0);
		}else if (this instanceof RemindActivity){
			mainTitle.setText(R.string.remind);
			remindBtn.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.hover_remind, 0, 0);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}