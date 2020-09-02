package org.bukkit.command;

import org.bukkit.block.Block;

public interface BlockCommandSender extends CommandSender {

    /**
     * 返回命令发送者的方块.
     * <p>
     * 原文:
     * Returns the block this command sender belongs to
     *
     * @return 命令发送者的方块
     */
    public Block getBlock();
}