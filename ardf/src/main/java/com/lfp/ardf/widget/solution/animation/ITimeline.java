package com.lfp.ardf.widget.solution.animation;

import com.lfp.ardf.debug.LogUtil;

import java.text.MessageFormat;
import java.util.LinkedList;

/**
 * <pre>
 * desc:
 *      表示一条时间线
 *
 * function:
 *
 * Created by LiFuPing on 2018/7/25.
 * </pre>
 */
public interface ITimeline {

    /**
     * 将附着物添加到时间线中
     *
     * @param attachment 附着物
     */
    void attach(TimelineAttachment attachment);

    /**
     * 将附着物从时间线中分离
     *
     * @param attachment 附着物
     */
    void detach(TimelineAttachment attachment);


}
