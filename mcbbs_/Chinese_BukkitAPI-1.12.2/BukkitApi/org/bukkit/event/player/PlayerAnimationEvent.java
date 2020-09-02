package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 玩家动作事件.
 */
public class PlayerAnimationEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final PlayerAnimationType animationType;
    private boolean isCancelled = false;

    /**
     * 构造一个新的PlayerAnimation事件.
     * <p>
     * 原文:Construct a new PlayerAnimation event
     *
     * @param player 玩家实例
     */
    public PlayerAnimationEvent(final Player player) {
        super(player);

        // Only supported animation type for now:
        animationType = PlayerAnimationType.ARM_SWING;
    }

    /**
     * 获得此事件中玩家的动作类型.
     * <p>
     * 原文:Get the type of this animation event
     *
     * @return 动作类型
     */
    public PlayerAnimationType getAnimationType() {
        return animationType;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCancelled(boolean cancel) {
        this.isCancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}