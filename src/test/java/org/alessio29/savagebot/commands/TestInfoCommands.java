package org.alessio29.savagebot.commands;

import org.alessio29.savagebot.TestUtils;
import org.alessio29.savagebot.internal.commands.CommandRegistry;
import org.alessio29.savagebot.internal.commands.Commands;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestInfoCommands {
    @Before
    public void setup() {
        CommandRegistry.getInstance().reset();
        Commands.registerDefaultCommands();
    }

    @Ignore
    @Test
    public void testHelp() {
        TestUtils.MessageBuilder mp = TestUtils.createDefaultForTests();
        Assert.assertEquals(
                "<< [guildId='test-guild', channelId='test-channel', userId='test-user', isPrivate=false] '!help'\n" +
                        ">> [private: userId: test-user]\n" +
                        "__**CARDS category**__\n" +
                        "!deal [<card_count>] [<user>]; aliases: !dl\n" +
                        "!put [<card_count>]; aliases: !\n" +
                        "!show; aliases: !sh\n" +
                        "!shuffle\n" +
                        "\n" +
                        "__**CHARACTERS category**__\n" +
                        "!list ; aliases: !\n" +
                        "!remove ; aliases: !rm\n" +
                        "\n" +
                        "__**DICE category**__\n" +
                        "!r <expression1> ... <expressionN> \n" +
                        "!rh <expression_1> ... <expressionN>\n" +
                        "!rs [<heading_1>] <expression_1> ... [<heading_N>] <expression_N>\n" +
                        "\n" +
                        "__**BENNIES category**__\n" +
                        "!benny <character_name>\n" +
                        "!hat [fill]\n" +
                        "!pocket <character_name>\n" +
                        "!use <benny_color> <character_name>\n" +
                        "\n" +
                        "__**INITIATIVE category**__\n" +
                        "!card <character_name>; aliases: !cd\n" +
                        "!di <character_name1> [<modifiers_1>] ... <character_nameN> [<modifiers_N>]\n" +
                        "!drop <character_name>\n"+
                        "!fight; aliases: !f\n" +
                        "!init\n" +
                        "!round [+] [-<char_name>]; aliases: !rd\n" +
                        "\n" +
                        "__**INFO category**__\n" +
                        "!help [<command> or <category>]\n" +
                        "!invite\n" +
                        "\n" +
                        "__**ADMIN category**__\n" +
                        "!info password\n" +
                        "!ping\n" +
                        "!prefix [<character>]\n" +
                        "\n" +
                        "__**TOKENS category**__\n" +
                        "!clear <character_name>/all\n" +
                        "!give <character_name> [<amount of tokens>]\n" +
                        "!take <character_name> [<amount of tokens>]\n" +
                        "\n" +
                        "__**STATES category**__\n" +
                        "!clstate <character_name>/all; aliases: !cs\n" +
                        "!remstate <character_name> <state1> [<state2>] [...]; aliases: !rst\n" +
                        "!state <character_name> <state1> [<state2>] [...]; aliases: !st\n" +
                        "\n" +

                        "For more details, use `!help <command>` or see https://github.com/alessio29/savagebot/blob/master/README.md",
                TestUtils.processMessages(mp.message("!help"))
        );
    }

    @Test
    public void testInvite() {
        TestUtils.MessageBuilder mp = TestUtils.createDefaultForTests();
        Assert.assertEquals(
                "<< [guildId='test-guild', channelId='test-channel', userId='test-user', isPrivate=false] '!invite'\n" +
                        ">> [guildId: test-guild; channelId: test-channel; userId: test-user]\n" +
                        "@test-user\n" +
                        "Invite link: https://discordapp.com/oauth2/authorize?&client_id=448952545784758303&scope=bot&permissions=0",
                TestUtils.processMessages(mp.message("!invite"))
        );
    }
}
