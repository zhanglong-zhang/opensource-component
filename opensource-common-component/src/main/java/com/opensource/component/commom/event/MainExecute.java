package com.opensource.component.commom.event;

/**
 * @author zhanglong and since  2019/12/30  4:04 下午
 * @description: 基于事件驱动
 */
public class MainExecute {
    /**
     * description
     * 第一步注册监听器
     * 第二部发布事件，执行回调
     */
    public static void main( String[] args ) {
        final ApplicationEventContext applicationEventContext = new ApplicationEventContext();
        applicationEventContext.addApplicationListener(new BaseEventListener() {
            /**
             * description 监听回调的逻辑
             */
            @Override
            void onEventListener( EventSource eventSource ) {
                System.out.println("执行事件,我是"+eventSource);
            }
        });
        applicationEventContext.publishEvent(new EventSource("zhanglong"));
    }

}
