package toliner.showblockresistance

import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import net.minecraftforge.oredict.ShapedOreRecipe
import toliner.showblockresistance.item.ItemResistanceViewer

const val MOD_ID = "show_block_resistance"
const val MOD_NAME = "ShowBlockResistance"
const val VERSION = "1.0.0"

val resistanceViewer = ItemResistanceViewer()

fun register() {
    GameRegistry.register(resistanceViewer)
}

fun recipe() {
    GameRegistry.addRecipe(ShapedOreRecipe(resistanceViewer, "SIS", "IRI", "SRS", 'S', "stone", 'R', "dustRedstone", 'I', "ingotIron"))
}

fun texture() {
    setTexture(resistanceViewer)
}

@SideOnly(Side.CLIENT)
private fun setTexture(item: Item) {
    ModelLoader.setCustomModelResourceLocation(item, 0, getModelResourceLocation(item))
}

@SideOnly(Side.CLIENT)
private fun getModelResourceLocation(item: Item): ModelResourceLocation {
    return ModelResourceLocation(item.registryName!!, "inventory")
}
