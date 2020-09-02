# 自定义合成表

在背包、工作台中, 玩家可以通过指定的物品摆放, 消耗所摆放的物品得到新物品, 这被称作物品的合成. 物品的摆放方式与得到的新物品即为合成表.  

# 合成表物品摆放的文字表述法
如何用文字表述物品在2X2格子或3X3格子中的摆放方式?  

首先我们来使用数学中“方程”的概念, 把金锭设成x, 把铁锭设成y. 打个比方, 我现在想实现八个金锭和一个铁锭合成一个绿宝石, 摆放方式可以这样表示:    
```
xxx
xyx
xxx
```

那现在如果想表示类似“工作台”的合成方式呢? 工作台合成需要四个木板, 在背包的合成区内可以填满木板来合成, 在工作台合成区内可以有这样的摆放方式:  
```
设x为木板
xx空
xx空
空空空

空xx
空xx
空空空

空空空
xx空
xx空

空空空
空xx
空xx
```
对于这样的非3X3的合成方式, 我们可以这样表示:  
```
xx
xx
```
这也意味着, 在用文字表述合成表时, 不一定非得是3x3的表示方式, 还可以2x2, 还可以1x1, 只要是mXn的格式即可(例如门的合成是2X3).

# 新建合成规则
以上文合成金铁锭合成绿宝石为例, 在onEnable方法的适当位置添加如下内容:  
```
ShapedRecipe sr1 = new ShapedRecipe(
new ItemStack(Material.EMERALD)) //合成出的物品(提示: 修改这个ItemStack的Amount可以控制能合成多少个目标物品)
.shape("xxx","xyx","xxx") //这是刚才我们摆出来的文字表述
.setIngredient('x',Material.GOLD_INGOT). //设x为金锭
setIngredient('y',Material.IRON_INGOT); //设y为铁锭

getServer().addRecipe(sr1);
```

在onDisable方法中添加如下内容:  
```
getServer().clearRecipes();
```

经验证可发现, 现在我们可以通过控制台通过在铁锭周围围一圈金锭的方式合成绿宝石了.  

那么设x为金锭, 我想实现像熔炉那样, 八个金锭围一圈合成一个绿宝石, 不需要铁锭了. 就像这样:  
```
xxx
x空x
xxx
```
中间有个位置是空的, 该怎么办? 应该设个y表示AIR吗? 不需要, 空位置可以使用空格表示. 就像下面这个例子:  
```
ShapedRecipe sr2 = new ShapedRecipe(
new ItemStack(Material.EMERALD)) //合成出的物品
.shape("xxx","x x","xxx") //这是刚才我们摆出来的文字表述(中间的y改成了空格)
.setIngredient('x',Material.GOLD_INGOT). //设x为金锭
setIngredient('y',Material.IRON_INGOT); //设y为铁锭

getServer().addRecipe(sr2);
```

shape方法的参数个数不限制, 这也意味着你可以这样表述非3X3摆放方式:  
```
.shape("x") //1X1(就像按钮那样的摆放方式)
.shape("xx","xx","xx") //2X3(就像木门那样的摆放方式)
.shape("xx","xx") //2X2(就像合成台那样的摆放方式)
```

如果你这样设置  
```
.shape("xx ","xx ","   ")
```  

那玩家在游戏中只能这样在合成台合成:  
```
xx空
xx空
空空空
```  
而不能用其他等效的位置摆放合成, 比如这样:  
```
空空空
xx空
xx空
```
