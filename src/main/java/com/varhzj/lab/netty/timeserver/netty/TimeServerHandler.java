package com.varhzj.lab.netty.timeserver.netty;

import java.util.Date;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeServerHandler extends ChannelInboundHandlerAdapter {

	private int counter;
	private final String separator = System.getProperty("line.separator");

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		String req = (String) msg;
		System.out.println("TimeServer recevie order: " + req + ", the counter is:" + ++counter);
		String resp = "QUERY TIME".equalsIgnoreCase(req) ? new Date().toString() : "BAD ORDER";
		resp += separator;
		ctx.writeAndFlush(Unpooled.copiedBuffer(resp.getBytes()));
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

}
