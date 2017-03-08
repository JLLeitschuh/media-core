/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2017, Telestax Inc and individual contributors
 * by the @authors tag. 
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.restcomm.media.control.mgcp.network;

import java.util.List;

import org.restcomm.media.control.mgcp.message.MgcpMessage;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

/**
 * Encoder that converts an {@link MgcpMessage} into a {@link ByteBuf}.
 * 
 * @author Henrique Rosa (henrique.rosa@telestax.com)
 *
 */
public class MgcpMessageToByteEncoder extends MessageToMessageEncoder<MgcpMessage> {

    @Override
    protected void encode(ChannelHandlerContext ctx, MgcpMessage msg, List<Object> out) throws Exception {
        // Convert MGCP message to String
        String string = msg.toString();

        // Convert String to Byte
        byte[] bytes = string.getBytes();

        // Output bytes
        ByteBuf buffer = Unpooled.copiedBuffer(bytes);
        out.add(buffer);
    }

}
