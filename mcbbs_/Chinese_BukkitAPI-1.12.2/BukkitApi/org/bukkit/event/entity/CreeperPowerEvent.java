package org.bukkit.event.entity;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.LightningStrike;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当爬行者被闪电击中时触发该事件.
 * <p>
 * 若该事件被取消,那么爬行者将不会被强化.
 */
public class CreeperPowerEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean canceled;
    private final PowerCause cause;
    private LightningStrike bolt;

    public CreeperPowerEvent(final Creeper creeper, final LightningStrike bolt, final PowerCause cause) {
        this(creeper, cause);
        this.bolt = bolt;
    }

    public CreeperPowerEvent(final Creeper creeper, final PowerCause cause) {
        super(creeper);
        this.cause = cause;
    }

    public boolean isCancelled() {
        return canceled;
    }

    public void setCancelled(boolean cancel) {
        canceled = cancel;
    }

    @Override
    public Creeper getEntity() {
        return (Creeper) entity;
    }

    /**
     * 返回击中爬行者的闪电
     * <p>
     * 原文:
     * Gets the lightning bolt which is striking the Creeper.
     *
     * @return 击中爬行者的闪电实体
     */
    public LightningStrike getLightning() {
        return bolt;
    }

    /**
     * 返回爬行者被强(弱)化的原因
     * <p>
     * 原文:
     * Gets the cause of the creeper being (un)powered.
     *
     * @return 爬行者被强(弱)化的原因
     */
    public PowerCause getCause() {
        return cause;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * 造成这次强化的原因
     */
    public enum PowerCause {

        /**
         * 由于闪电击中导致的强化
         * <p>
         * Powered state: true (强化)
         */
        LIGHTNING,
        /**
         * 由于其他原因造成的强化 (可能是插件)
         * <p>
         * Powered state: true (强化)
         */
        SET_ON,
        /**
         * 由于其他原因造成的弱化 (可能是插件)
         * <p>
         * Powered state: false (弱化)
         */
        SET_OFF
    }
}