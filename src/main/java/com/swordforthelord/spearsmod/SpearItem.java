package com.swordforthelord.spearsmod;

import net.minecraft.world.item.Tier;

public class SpearItem extends net.minecraft.world.item.SwordItem implements IExtendedReach
{
    public SpearItem(Tier t, int dmg, float speed, Properties p){
        super(t,dmg, speed, p);
    }

    @Override
    public float getReach()
    {
        return 20.0F;
    }
}
