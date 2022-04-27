package com.swordforthelord.spearsmod.item;

import com.swordforthelord.spearsmod.SpearsMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SpearsMod.MOD_ID);

    public static final RegistryObject<SwordItem> SPEARWOOD = ITEMS.register("spearwood",
            () -> CreateNewSwordItem(Tiers.WOOD));

    public static final RegistryObject<SwordItem> SPEARSTONE = ITEMS.register("spearstone",
            () -> CreateNewSwordItem(Tiers.STONE));

    public static final RegistryObject<SwordItem> SPEARCOPPER = ITEMS.register("spearcopper",
            () -> CreateNewSwordItem(Tiers.STONE));

    public static final RegistryObject<SwordItem> SPEARIRON = ITEMS.register("speariron",
            () -> CreateNewSwordItem(Tiers.IRON));

    public static final RegistryObject<SwordItem> SPEARDIAMOND = ITEMS.register("speardiamond",
            () -> CreateNewSwordItem(Tiers.DIAMOND));

    public static final RegistryObject<SwordItem> SPEARGOLD = ITEMS.register("speargold",
            () -> CreateNewSwordItem(Tiers.GOLD));

    public static final RegistryObject<SwordItem> SPEARNETHERITE = ITEMS.register("spearnetherite",
            () -> CreateNewSwordItem(Tiers.NETHERITE));

    //region spear values
    private static final int DamageWood = 1;
    private static final int DamageStone = 2;
    //private static final int DamageCopper = 3;
    private static final int DamageIron = 4;
    private static final int DamageGold = 5;
    private static final int DamageDiamond = 6;
    private static final int DamageNetherite = 7;

    private static final int SpeedWood = 1;
    private static final int SpeedStone = 1;
    //private static final int SpeedCopper = 1;
    private static final int SpeedIron = 1;
    private static final int SpeedGold = 1;
    private static final int SpeedDiamond = 1;
    private static final int SpeedNetherite = 1;
    //endregion

    private static SwordItem CreateNewSwordItem(Tiers t) {

        Item.Properties p = new Item.Properties().tab(CreativeModeTab.TAB_COMBAT);
        SwordItem item = null;
        switch(t)
        {
            case WOOD:
                item = new SwordItem(t, DamageWood, SpeedWood, p);
                break;
            case STONE:
                item = new SwordItem(t, DamageStone, SpeedStone, p);
                break;
//            case COPPER:
//                item = new SwordItem(t, DamageCopper, SpeedCopper, p);
//                break;
            case IRON:
                item = new SwordItem(t, DamageIron, SpeedIron, p);
                break;
            case DIAMOND:
                item = new SwordItem(t, DamageDiamond, SpeedDiamond, p);
                break;
            case GOLD:
                item = new SwordItem(t, DamageGold, SpeedGold, p);
                break;
            case NETHERITE:
                item = new SwordItem(t, DamageNetherite, SpeedNetherite, p);
                break;
            default:
                throw new IllegalStateException("Unexpected spear tier: " + t);
        }
        
        return item;
    }

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
