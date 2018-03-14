package toliner.showblockresistance.item

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.EnumActionResult
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.BlockPos
import net.minecraft.util.text.TextComponentString
import net.minecraft.world.World
import toliner.showblockresistance.MOD_ID

class ItemResistanceViewer : Item() {
    init {
        unlocalizedName = "resistanceViewer"
        registryName = ResourceLocation(MOD_ID, "resistance_viewer")
        creativeTab = CreativeTabs.TOOLS
    }

    override fun onItemUse(stack: ItemStack?, player: EntityPlayer?, world: World?, pos: BlockPos?, hand: EnumHand?, facing: EnumFacing?, hitX: Float, hitY: Float, hitZ: Float): EnumActionResult {
        if (stack == null || player == null || world == null || pos == null) return EnumActionResult.PASS
        val block = world.getBlockState(pos).block
        if (!world.isRemote) {
            player.addChatComponentMessage(TextComponentString("${block.localizedName} : ${block.getExplosionResistance(player) * 5}"))
        }
        return EnumActionResult.SUCCESS
    }
}