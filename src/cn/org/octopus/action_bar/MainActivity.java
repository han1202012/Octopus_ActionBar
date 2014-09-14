package cn.org.octopus.action_bar;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ActionBar actionBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			/* 获取 Fragment 管理器, 开始 Fragment 事务, 向 R.id.contaner 组件中添加一个 Fragment */
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		actionBar = getActionBar();
		
		/* 设置将左侧图标设置成可点击图标, 并添加一个左箭头 */
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		/* 不显示应用程序图标 */
		actionBar.setDisplayShowHomeEnabled(false);
		
	}


	/**
	 * 自定义一个 Fragment, 该 Fragment 主要存放主界面布局
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			/* 加载布局文件, 初始化组件, 并返回 */
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
	
	/**
	 * 组件中的 onClick 点击回调事件
	 * @param view
	 */
	public void onClick(View view) {
		int id = view.getId();
		switch (id) {
		case R.id.actionbar_show:
			/* 显示 ActionBar */
			actionBar.show();
			toast("显示 ActionBar");
			break;
			
		case R.id.actionbar_hide:
			/* 隐藏 ActionBar */
			actionBar.hide();
			toast("隐藏 ActionBar");
			break;
			
		case R.id.tab_activity:
			/* 启动 ActionBar Tab导航示例 */
			Intent intent = new Intent(getApplicationContext(), TabNavigationActivity.class);
			startActivity(intent);
			break;
			
		case R.id.list_activity:
			/* 启动 ActionBar Tab导航示例 */
			Intent intent1 = new Intent(getApplicationContext(), ListNavigationActivity.class);
			startActivity(intent1);
			break;

		default:
			break;
		}
	}
	
	/**
	 * 创建 ActionBar 中的菜单
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		/* 加载 main.xml 菜单, 在 ActionBar 中显示配置文件中定义的菜单内容 */
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	/**
	 * 设置 ActionBar 菜单 的点击回调事件
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		/*
		 * 点击 menu 菜单中选项回调事件 
		 * id 在 menu.xml 中的 <item /> 标签中的 android:id 属性中定义
		 */
		int id = item.getItemId();
		switch (id) {
		case android.R.id.home:
			finish();
			break;
		case R.id.menu1_item1:
			toast("menu1_item1");
			break;
		case R.id.menu1_item2:
			toast("menu1_item2");
			break;
		case R.id.menu1_item3:
			toast("menu1_item3");
			break;
		case R.id.menu2_item1:
			toast("menu2_item1");
			break;
		case R.id.menu2_item2:
			toast("menu2_item2");
			break;
		case R.id.menu2_item3:
			toast("menu2_item3");
			break;
		case R.id.menu3:
			toast("menu3");
			break;
		default:
			break;
		}
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/**
	 * 打印 Toast 信息
	 */
	private void toast(String toast) {
		Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_LONG).show();;
	}
}
