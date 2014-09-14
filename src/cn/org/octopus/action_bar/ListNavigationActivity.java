package cn.org.octopus.action_bar;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

public class ListNavigationActivity extends Activity implements ActionBar.OnNavigationListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		
		/* 获取 ActionBar */
		ActionBar actionBar = getActionBar();
		
		/* 设置 ActionBar 的导航方式
		 * 	-- ActionBar.NAVIGATION_MODE_TABS : Tab 导航 
		 *  -- ActionBar.NAVIGATION_MODE_LIST : List 导航
		 *  -- ActionBar.NAVIGATION_MODE_STANDARD : 普通导航 */
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		
		/* 设置 ActionBar 左侧图标可点击, 添加箭头 */
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		/* 设置标题 */
		String[] strs = new String[]{"第一页", "第二页", "第三页"};
		/* 设置 List导航 适配器 */
		SpinnerAdapter adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, strs);
		/* 为 ActionBar 设置适配器和回调接口 */
		actionBar.setListNavigationCallbacks(adapter, this);
	}

	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		/* 创建 Fragement */
		Fragment fragment = new TabFragment();
		
		/* 设置 Fragement 参数 */
		Bundle bundle = new Bundle();
		bundle.putInt(TabFragment.key, itemPosition + 1);
		fragment.setArguments(bundle);
		
		/* 置换 Fragement */
		FragmentManager manager = getFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.replace(R.id.list_holder, fragment);
		transaction.commit();
		
		return true;
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
}
