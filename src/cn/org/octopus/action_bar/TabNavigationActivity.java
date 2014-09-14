package cn.org.octopus.action_bar;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;

public class TabNavigationActivity extends Activity implements TabListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab);
		
		/* 获取 ActionBar */
		ActionBar actionBar = getActionBar();
		
		/* 设置 ActionBar 的导航方式
		 * 	-- ActionBar.NAVIGATION_MODE_TABS : Tab 导航 
		 *  -- ActionBar.NAVIGATION_MODE_LIST : List 导航
		 *  -- ActionBar.NAVIGATION_MODE_STANDARD : 普通导航 */
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		/* 设置 ActionBar 左侧图标可点击, 添加箭头 */
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		Tab tab1 = actionBar.newTab().setText("第一页").setTabListener(this);
		Tab tab2 = actionBar.newTab().setText("第二页").setTabListener(this);
		Tab tab3 = actionBar.newTab().setText("第三页").setTabListener(this);
		
		actionBar.addTab(tab1);
		actionBar.addTab(tab2);
		actionBar.addTab(tab3);
		
	}
	
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		switch (id) {
		/* 设置的点击图标按钮回退 */
		case android.R.id.home:
			finish();
			break;

		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}



	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		Fragment fragment = new TabFragment();
		
		/* 设置参数传递 */
		Bundle bundle = new Bundle();
		bundle.putInt(TabFragment.key, tab.getPosition() + 1);
		fragment.setArguments(bundle);
		
		/* 创建 Fragment 管理器 */
		FragmentManager manager = getFragmentManager();
		/* 开启事务 */
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.replace(R.id.holder, fragment);
		transaction.commit();
	}


	/**
	 * Tab 取消选中时回调
	 */
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}
	/**
	 * Tab 释放时回调
	 */
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}
	
}
