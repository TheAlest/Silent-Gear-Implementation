package net.thealest.silentaddons.constants;

import net.silentchaos512.gear.api.util.DataResource;
import net.silentchaos512.gear.gear.trait.Trait;

import static net.thealest.silentaddons.SilentAddons.getId;

public final class Traits {
    public static final DataResource<Trait> SPIKED = trait("spiked");
    public static final DataResource<Trait> FREEZING = trait("freezing");
    public static final DataResource<Trait> BURNING = trait("burning");
    public static final DataResource<Trait> ELECTRIC = trait("electric");
    public static final DataResource<Trait> MAGICAL = trait("magical");
    public static final DataResource<Trait> VAMPIRIC = trait("vampiric");
    public static final DataResource<Trait> BLESSED = trait("blessed");
    public static final DataResource<Trait> DEFLECT_MAGIC = trait("deflect_magic");
    public static final DataResource<Trait> MANA = trait("mana");
    public static final DataResource<Trait> SPELL_POWER = trait("spell_power");
    public static final DataResource<Trait> MANA_REGEN = trait("mana_regen");

    private static  DataResource<Trait> trait(String name) {
        return DataResource.trait(getId(name));
    }

    private Traits(){
    }
}
