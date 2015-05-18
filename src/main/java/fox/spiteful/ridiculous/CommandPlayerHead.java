/*  Totally jacked from Player Beacons
    All credit to Kihira
    The Foxiest Fox
    https://github.com/kihira/PlayerBeacons/
 */

package fox.spiteful.ridiculous;

import com.google.common.collect.Iterables;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.StringUtils;

import java.util.List;

public class CommandPlayerHead extends CommandBase {

    @Override
    public String getCommandName() {
        return "playerhead";
    }

    @Override
    public String getCommandUsage(ICommandSender commandSender) {
        return "commands.playerhead.usage";
    }

    @Override
    public List addTabCompletionOptions(ICommandSender commandSender, String[] par2ArrayOfStr) {
        return par2ArrayOfStr.length == 1 ? getListOfStringsMatchingLastWord(par2ArrayOfStr, MinecraftServer.getServer().getAllUsernames()) : null;
    }

    @Override
    public void processCommand(ICommandSender commandSender, String[] args) {
        EntityPlayer player = commandSender.getEntityWorld().getPlayerEntityByName(commandSender.getCommandSenderName());
        if (args != null && player != null) {
            if (args.length == 0) {
                player.entityDropItem(getHead(player.getGameProfile()), 1);
                func_152373_a(commandSender, this, "commands.playerhead.success", player.getCommandSenderName(), player.getCommandSenderName());
            }
            else if (args.length > 0 && args[0].length() > 0) {
                player.entityDropItem(getHead(new GameProfile(null, args[0])), 1);
                func_152373_a(commandSender, this, "commands.playerhead.success", args[0], player.getCommandSenderName());
            }
            else throw new WrongUsageException("commands.playerhead.usage", args);
        }
        else throw new WrongUsageException("commands.playerhead.usage", args);
    }

    @Override
    public int compareTo(Object o) {
        return super.compareTo((ICommand) o);
    }


    private ItemStack getHead(GameProfile owner) {
        ItemStack itemStack = new ItemStack(Items.skull, 1, 3);
        if (owner != null) {
            NBTTagCompound tag = new NBTTagCompound();
            NBTTagCompound gameProfileTag = new NBTTagCompound();
            NBTUtil.func_152460_a(gameProfileTag, refreshGameProfile(owner));
            tag.setTag("SkullOwner", gameProfileTag);
            itemStack.setTagCompound(tag);
        }
        return itemStack;
    }

    private GameProfile refreshGameProfile(GameProfile profile) {
        if (profile != null && !StringUtils.isNullOrEmpty(profile.getName())) {
            if (!profile.isComplete() || !profile.getProperties().containsKey("textures")) {
        //This would always need to get textures as textures aren't saved client side
                GameProfile gameprofile = MinecraftServer.getServer().func_152358_ax().func_152655_a(profile.getName());
                if (gameprofile != null) {
                    Property property = (Property) Iterables.getFirst(gameprofile.getProperties().get("textures"), (Object) null);
                    if (property == null) gameprofile = MinecraftServer.getServer().func_147130_as().fillProfileProperties(gameprofile, true);
                    profile = gameprofile;
                }
            }
        }
        return profile;
    }
}
