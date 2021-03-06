package com.opensouce.component.netty.server;

import com.opensouce.component.netty.message.ClientRequestServer;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.function.BiConsumer;


/**
 * @author ZhangLong on 2019/12/7  2:12 下午
 * @version V1.0
 */
public class SimpleServerChannelHandler<ReqData> extends SimpleChannelInboundHandler<ClientRequestServer<ReqData>> {

    private BiConsumer<ChannelHandlerContext, ClientRequestServer<ReqData>> contextReqTBiConsumer;


    public SimpleServerChannelHandler(BiConsumer<ChannelHandlerContext, ClientRequestServer<ReqData>> contextReqTBiConsumer) {
        this.contextReqTBiConsumer = contextReqTBiConsumer;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ClientRequestServer<ReqData> requestData) throws Exception {
        contextReqTBiConsumer.accept(ctx, requestData);
    }



}
