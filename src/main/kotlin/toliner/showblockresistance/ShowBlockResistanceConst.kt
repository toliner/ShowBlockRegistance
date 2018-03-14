package toliner.showblockresistance

import net.minecraftforge.fml.common.registry.GameRegistry
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
