/*  Totally jacked from Player Beacons
    All credit to Kihira
    The Foxiest Fox
    https://github.com/kihira/PlayerBeacons/
 */

package fox.spiteful.ridiculous;

import com.google.common.collect.Iterables;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.minecraft.client.Minecraft;
import net.minecraft.command.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.StringUtils;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;
import java.util.List;

public class CommandPlayerHead extends CommandBase {

    @Override
    public String getName() {
        return "playerhead";
    }

    @Override
    public String getUsage(ICommandSender commandSender) {
        return "commands.playerhead.usage";
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender commandSender, String[] par2ArrayOfStr, @Nullable BlockPos targetPos) {
        return par2ArrayOfStr.length == 1 ? getListOfStringsMatchingLastWord(par2ArrayOfStr, server.getOnlinePlayerNames()) : null;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender commandSender, String[] args) throws CommandException {
        //EntityPlayer player = commandSender.getEntityWorld().getPlayerEntityByName(commandSender.getCommandSenderName());
        EntityPlayer player = (EntityPlayer)commandSender.getCommandSenderEntity();
        if (args != null && player != null) {
            if (args.length == 0) {
                player.entityDropItem(getHead(server, player.getGameProfile()), 1);
                notifyCommandListener(commandSender, this, "commands.playerhead.success", player.getName(), player.getName());
            }
            else if (args.length > 0 && args[0].length() > 0) {
                player.entityDropItem(getHead(server, new GameProfile(null, args[0])), 1);
                notifyCommandListener(commandSender, this, "commands.playerhead.success", new Object[] {args[0], player.getName()});
            }
            else throw new WrongUsageException("commands.playerhead.usage", args);
        }
        else throw new WrongUsageException("commands.playerhead.usage", args);
    }

    @Override
    public int compareTo(ICommand o) {
        return super.compareTo((ICommand) o);
    }


    private ItemStack getHead(MinecraftServer server, GameProfile owner) {
        ItemStack itemStack = new ItemStack(Items.SKULL, 1, 3);
        if (owner != null) {
            NBTTagCompound tag = new NBTTagCompound();
            NBTTagCompound gameProfileTag = new NBTTagCompound();
            NBTUtil.writeGameProfile(gameProfileTag, refreshGameProfile(server, owner));
            tag.setTag("SkullOwner", gameProfileTag);
            itemStack.setTagCompound(tag);
        }
        return itemStack;
    }

    private GameProfile refreshGameProfile(MinecraftServer server, GameProfile profile) {
        if (profile != null && !StringUtils.isNullOrEmpty(profile.getName())) {
            if (!profile.isComplete() || !profile.getProperties().containsKey("textures")) {
        //This would always need to get textures as textures aren't saved client side
                GameProfile gameprofile = server.getPlayerProfileCache().getGameProfileForUsername(profile.getName());
                if (gameprofile != null) {
                    Property property = (Property) Iterables.getFirst(gameprofile.getProperties().get("textures"), (Object) null);
                    if (property == null) gameprofile = server.getMinecraftSessionService().fillProfileProperties(gameprofile, true);
                    profile = gameprofile;
                }
            }
        }
        return profile;
    }
}
