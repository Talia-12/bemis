package at.petrak.bemis.forge;

import at.petrak.bemis.api.BemisApi;
import at.petrak.bemis.impl.BemisBookRegistry;
import net.minecraft.client.Minecraft;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(BemisApi.MOD_ID)
public class ForgeBemisEntrypoint {
    public ForgeBemisEntrypoint() {
        FMLJavaModLoadingContext.get().getModEventBus().register(ForgeBemisEntrypoint.class);
    }

    @SubscribeEvent
    public static void onLoaded(FMLLoadCompleteEvent evt) {
        var recman = Minecraft.getInstance().getResourceManager();
        BemisBookRegistry.scanAndLoadBooks(recman);
    }
}