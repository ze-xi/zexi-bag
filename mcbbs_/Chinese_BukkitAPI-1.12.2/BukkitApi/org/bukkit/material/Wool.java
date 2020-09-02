package org.bukkit.material;

import org.bukkit.DyeColor;
import org.bukkit.Material;

/**
 * 代表羊毛/地毯方块。
 */
public class Wool extends MaterialData implements Colorable {
    public Wool() {
        super(Material.WOOL);
    }

    public Wool(DyeColor color) {
        this();
        setColor(color);
    }

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Wool(final int type) {
        super(type);
    }

    public Wool(final Material type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Wool(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Wool(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 获取颜色。
     * <p>
     * 原文：Gets the current color of this dye
     *
     * @return 颜色
     */
    public DyeColor getColor() {
        return DyeColor.getByWoolData(getData());
    }

    /**
     * 设置颜色。
     * <p>
     * 原文：Sets the color of this dye
     *
     * @param color 新颜色
     */
    public void setColor(DyeColor color) {
        setData(color.getWoolData());
    }

    @Override
    public String toString() {
        return getColor() + " " + super.toString();
    }

    @Override
    public Wool clone() {
        return (Wool) super.clone();
    }
}
