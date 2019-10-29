#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")
package ${PACKAGE_NAME};#end
#parse("File Header.java")
import com.yzf.king.kit.Version;
import com.yzf.king.kit.utils.ResultCode;
import com.yzf.king.net.Api;

import cn.droidlover.xdroidmvp.mvp.XPresent;
import cn.droidlover.xdroidmvp.net.ApiSubcriber;
import cn.droidlover.xdroidmvp.net.NetError;
import cn.droidlover.xdroidmvp.net.XApi;

public class ${NAME} extends XPresent<Activity> {

    public void getAcctInfo(String merchId) {
        String version = Version..version();
        Api.getAPPService().getInfo(merchId, version)
                .compose(XApi.<GetInfoResult>getApiTransformer())//异常转换
                .compose(XApi.<GetInfoResult>getScheduler())//线程变换
                .compose(getV().<GetInfoResult>bindToLifecycle())//绑定生命周期，防止内存泄漏
                .subscribe(new ApiSubcriber<GetInfoResult>() {
                    @Override
                    public void onNext(GetInfoResult result) {
                        if (result.getCode() == ResultCode.SUCCESS.code()) {
                            if (result.getData() != null) {
                                getV().setAdapter(result.getData());
                            } else {
                                getV().showEmptyView(result.getMessage());
                            }
                        } else {
                            getV().showErrorView(result.getMessage());
                        }
                    }

                    @Override
                    protected void onFail(NetError error) {
                        getV().showError(error);
                    }
                });
    }
}