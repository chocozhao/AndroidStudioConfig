#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")
package ${PACKAGE_NAME};#end
/**
 * ClaseName：${NAME}
 * Description：
 * Author：chocozhao
 * QQ: 1027313530
 * Createtime：${DATE} ${HOUR}:${MINUTE} 
 * Modified By：
 * Fixtime：${DATE} ${HOUR}:${MINUTE} 
 * FixDescription：
 **/

#parse("File Header.java")
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.os.Bundle;

import com.yzf.king.R;
import com.yzf.king.widget.MultipleStatusView;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.mvp.XActivity;
import cn.droidlover.xdroidmvp.net.NetError;
import cn.droidlover.xdroidmvp.router.Router;
public class ${NAME} extends XActivity<Object> {
 @BindView(R.id.title)
    TextView title;
 @BindView(R.id.toolbar)
    Toolbar toolbar;
 @BindView(R.id.tram_detail_multiplestatusview)
    MultipleStatusView multiplestatusview;

@Override
public void initData(Bundle savedInstanceState) {
    initView();
}

@Override
public int getLayoutId() {
    return R.layout.activity_main;
}

@Override
public Object newP() {
    return null;
}

/**
 * 初始化界面
 */
private void initView() {
    initToolbar();
}
/**
 * 初始化Toolbar
 */
private void initToolbar() {
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeButtonEnabled(true);
    getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_white_24dp);
    getSupportActionBar().setDisplayShowTitleEnabled(false);
    title.setText("标题");
}

/**
 * 标题栏监听
 * @param item
 * @return
 */
@Override
public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
        finish();
        return true;
    }
    return super.onOptionsItemSelected(item);
}

/**
 * activity跳转
 */
public void JumpActivity(Class<?> activity, boolean isfinish) {
    getvDelegate().dismissLoading();
    Router.newIntent(context)
            .to(activity)
            .launch();
    if (isfinish) {
        Router.pop(context);
    }
}
/**
 * activity跳转
 */
public void JumpActivity(Class<?> activity) {
        Router.newIntent(context)
                .to(activity)
                .launch();
    }

/**
 * 显示Toast
 * @param msg
 */
public void showToast(String msg) {
    getvDelegate().toastShort(msg);
}

/**
 * 显示单按钮对话框
 * @param msg
 */
public void showErrorDialog(String msg) {
    getvDelegate().showErrorDialog(msg);
}

/**
 * 显示错误信息
 * @param error
 */
public void showError(NetError error) {
    getvDelegate().showError(error);
}
public void showEmptyView(String msg) {
    multiplestatusview.showEmpty(msg);
}

public void showErrorView(String msg) {
    multiplestatusview.showError(msg);
}

public void showErrorView(NetError error) {
    multiplestatusview.showError(getvDelegate().getErrorType(error));
}

 
}
