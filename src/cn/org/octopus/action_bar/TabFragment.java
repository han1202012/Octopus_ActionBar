package cn.org.octopus.action_bar;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

public class TabFragment extends Fragment {

	public static final String key = "key";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		/* 获取该 Fragment 被嵌入的 上下文对象 */
		Activity activity = getActivity();
		
		/* 获取从 Activity 传入的数据 */
		Bundle bundle = getArguments();
		int tab = bundle.getInt(key);
		
		/* 设置一个充满全屏的图片 */
		ImageView imageView = new ImageView(activity);
		LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		imageView.setLayoutParams(layoutParams);
		switch (tab) {
		case 1:
			imageView.setImageResource(R.drawable.a);
			break;
		case 2:
			imageView.setImageResource(R.drawable.b);
			break;
		case 3:
			imageView.setImageResource(R.drawable.c);
			break;

		default:
			break;
		}
		
		return imageView;
	}
}
