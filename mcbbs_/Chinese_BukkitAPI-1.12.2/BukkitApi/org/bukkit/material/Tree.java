package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.bukkit.block.BlockFace;

/**
 * Represents the different types of Tree block that face a direction.
 *
 * @see Material#LOG
 * @see Material#LOG_2
 */
public class Tree extends Wood {
    protected static final Material DEFAULT_TYPE = Material.LOG;
    protected static final BlockFace DEFAULT_DIRECTION = BlockFace.UP;

    /**
     * 构造一个树木方块.
     * <p>
     * 原文:Constructs a tree block.
     */
    public Tree() {
        this(DEFAULT_TYPE, DEFAULT_SPECIES, DEFAULT_DIRECTION);
    }

    /**
     * Constructs a tree block of the given tree species.
     *
     * @param species the species of the tree block
     */
    public Tree(TreeSpecies species) {
        this(DEFAULT_TYPE, species, DEFAULT_DIRECTION);
    }

    /**
     * Constructs a tree block of the given tree species, and facing the given
     * direction.
     *
     * @param species the species of the tree block
     * @param dir the direction the tree block is facing
     */
    public Tree(TreeSpecies species, BlockFace dir) {
        this(DEFAULT_TYPE, species, dir);
    }

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Tree(final int type) {
        super(type);
    }

    /**
     * Constructs a tree block of the given type.
     *
     * @param type the type of tree block
     */
    public Tree(final Material type) {
        this(type, DEFAULT_SPECIES, DEFAULT_DIRECTION);
    }

    /**
     * Constructs a tree block of the given type and tree species.
     *
     * @param type the type of tree block
     * @param species the species of the tree block
     */
    public Tree(final Material type, TreeSpecies species) {
        this(type, species, DEFAULT_DIRECTION);
    }

    /**
     * Constructs a tree block of the given type and tree species, and facing
     * the given direction.
     *
     * @param type the type of tree block
     * @param species the species of the tree block
     * @param dir the direction the tree block is facing
     */
    public Tree(final Material type, TreeSpecies species, BlockFace dir) {
        super(type, species);
        setDirection(dir);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Tree(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Tree(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 获取木头的朝向.
     * <p>
     * 原文:Get direction of the log
     *
     * @return 其中之一:
     * <ul>
     * <li>BlockFace.TOP 直立 (默认)
     * <li>BlockFace.NORTH (东西朝向)
     * <li>BlockFace.WEST (南北朝向)
     * <li>BlockFace.SELF 无朝向 (仅树皮)
     * </ul>
     */
    @SuppressWarnings("deprecation")
    public BlockFace getDirection() {
        switch ((getData() >> 2) & 0x3) {
            case 0: // Up-down
            default:
                return BlockFace.UP;
            case 1: // North-south
                return BlockFace.WEST;
            case 2: // East-west
                return BlockFace.NORTH;
            case 3: // Directionless (bark on all sides)
                return BlockFace.SELF;
        }
    }

    /**
     * 设置木头的朝向.
     * <p>
     * 原文:Set direction of the log
     *
     * @param dir - 木头一端的朝向，BlockFace.SELF 即为无朝向(仅树皮)
     */
    @SuppressWarnings("deprecation")
    public void setDirection(BlockFace dir) {
        int dat;
        switch (dir) {
            case UP:
            case DOWN:
            default:
                dat = 0;
                break;
            case WEST:
            case EAST:
                dat = 4; // 1<<2
                break;
            case NORTH:
            case SOUTH:
                dat = 8; // 2<<2
                break;
            case SELF:
                dat = 12; // 3<<2
                break;
        }
        setData((byte) ((getData() & 0x3) | dat));
    }

    @Override
    public String toString() {
        return getSpecies() + " " + getDirection() + " " + super.toString();
    }

    @Override
    public Tree clone() {
        return (Tree) super.clone();
    }
}