package com.varhzj.lab.netty.timeserver.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TimeClientHandler extends SimpleChannelInboundHandler<String> {

	private final byte[] req;
	private int counter;
	private final String separator = System.getProperty("line.separator");

	public TimeClientHandler() {
		req = ("QUERY TIME" + separator).getBytes();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ByteBuf order = null;
		for (int i = 0; i < 100; i++) {
			order = Unpooled.buffer(req.length);
			order.writeBytes(req);
			ctx.writeAndFlush(order);
		}
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		System.out.println("Now is: " + msg + ", the counter is: " + ++counter);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

}
