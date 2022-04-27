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


    //region spear values
    private static final int DamageWood = 4;
    private static final int DamageStone = 4;
    private static final int DamageCopper = 5;
    private static final int DamageGold = 5;
    private static final int DamageIron = 5;
    private static final int DamageDiamond = 6;
    private static final int DamageNetherite = 7;

    private static final float SpeedWood = -2.4f;
    private static final float  SpeedStone = -2.5f;
    private static final float  SpeedCopper = -2.6f;
    private static final float  SpeedIron = -2.7f;
    private static final float  SpeedGold = -2.8f;
    private static final float  SpeedDiamond = -2.9f;
    private static final float  SpeedNetherite = -3f;
    //endregion

    //region register spear items
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SpearsMod.MOD_ID);

    public static final RegistryObject<SwordItem> SPEARWOOD = ITEMS.register("spearwood",
            () -> CreateNewSwordItem(Tiers.WOOD));

    public static final RegistryObject<SwordItem> SPEARSTONE = ITEMS.register("spearstone",
            () -> CreateNewSwordItem(Tiers.STONE));

    public static final RegistryObject<SwordItem> SPEARCOPPER = ITEMS.register("spearcopper",
            () -> CreateNewSwordItem(Tiers.STONE)); // NOTE: because copper isn't a tier yet

    public static final RegistryObject<SwordItem> SPEARIRON = ITEMS.register("speariron",
            () -> CreateNewSwordItem(Tiers.IRON));

    public static final RegistryObject<SwordItem> SPEARDIAMOND = ITEMS.register("speardiamond",
            () -> CreateNewSwordItem(Tiers.DIAMOND));

    public static final RegistryObject<SwordItem> SPEARGOLD = ITEMS.register("speargold",
            () -> CreateNewSwordItem(Tiers.GOLD));

    public static final RegistryObject<SwordItem> SPEARNETHERITE = ITEMS.register("spearnetherite",
            () -> CreateNewSwordItem(Tiers.NETHERITE));
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
//            case COPPER: // copper isn't a tier in vanilla (make my own tier?)
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
