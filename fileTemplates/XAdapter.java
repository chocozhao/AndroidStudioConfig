#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")
package ${PACKAGE_NAME};#end
#parse("File Header.java")
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View.OnClickListener;

import com.yzf.king.R;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.base.SimpleRecAdapter;
import cn.droidlover.xdroidmvp.kit.KnifeKit;

public class ${NAME}  extends SimpleRecAdapter<GetResult.DataBean.DataDtlBean, ${NAME} .ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.adapter_profit_date_tv)
        TextView adapterProfitDateTv;
        @BindView(R.id.adapter_profit_amt_tv)
        TextView adapterProfitAmtTv;

        public ViewHolder(View view) {
            super(view);
            KnifeKit.bind(this, view);
        }
    }

    public int getLayoutId() {
        return R.layout.adapter_profit;
    }

    public ${NAME} (Context context) {
        super(context);
    }

    public ViewHolder newViewHolder(View view) {
        return new ViewHolder(view);
    }

    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getRecItemClick() != null) {
                    getRecItemClick().onItemClick(position, dataBean, TAG_VIEW, viewHolder);
                }
            }
        });
    }
}