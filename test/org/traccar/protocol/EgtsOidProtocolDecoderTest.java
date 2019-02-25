package org.traccar.protocol;

import org.junit.Test;
import org.traccar.Context;
import org.traccar.ProtocolTest;
import org.traccar.config.Keys;

public class EgtsOidProtocolDecoderTest extends ProtocolTest {

    @Test
    public void testDecode() throws Exception {

        boolean old = Context.getConfig().getBoolean(Keys.SERVER_IGNORE_SESSION_CACHE);

        try {
            Context.getConfig().setString(Keys.SERVER_IGNORE_SESSION_CACHE, "true");

            EgtsProtocolDecoder decoder = new EgtsProtocolDecoder(null, true);


            verifyNull(decoder, binary(
                    "0100020b002300020001871c00020000010105190000ab0800006247396e615734366347467a63336476636d513daadf"));

            verifyNull(decoder, binary(
                    "0100020b002300020001871c00020000010105190000ab0800006247396e615734366347467a63336476636d513daadf"));

            verifyNotNull(decoder, binary(
                    "0100020b004600010001b81800030001f299c0d80202101500c9c52f1100552e9c80e4ca7911f5805b00000000031800040001f299c0d80202101500cbc52f1100612e9c00dbca79116c803e00000000037c13"));

            verifyNotNull(decoder, binary(
                    "0100020b005e01030001ed180005000162c72c9a0202101500c4c52f1100477e9f0047c979010000ad000000000318000600017ee0710c0202101500c9c52f11003ee59f8061e97a0100801b00000000031800070001b6eeb6c00202101500c7c52f110077669d00b9707a116a015600000000031800080001b6eeb6c00202101500cdc52f11007c669d004e717a117a0158000000000318000900018b4685f70202101500c8c52f11006ee09f0027ca7c11650079000000000318000a0001f299c0d80202101500c9c52f1100552e9c80e4ca7911f5805b000000000318000b0001f299c0d80202101500cbc52f1100612e9c00dbca79116c803e000000000318000c0001731347010202101500c7c52f1100a3699a80db3c7a010000e5000000000318000d0001c85285f70202101500cbc52f1100e8979900f3497b114d0101000000000318000e0001aa4358810202101500cdc52f11002d689a80ab427a0100009300000000032b9f"));


            verifyNotNull(decoder, binary(
                    "0100000b00ba036b43019014002e0d9579b00000bc23be120202120900000003000000000000150500025a0000000a002f0d9579b00000d723be120202130700030000000000001400300d9579b00000da23be120202120900000003000000000000150500025a0000001800310d9579b000005d4a0efe02021015005d4a0efe00000000000000000a00000000000030000a00320d9579b00000f523be120202130700030000000000001400330d9579b00000f923be120202120900000003000000000000150500025a0000000a00340d9579b000001324be120202130700030000000000001400350d9579b000001724be120202120900000003000000000000150500025a0000001800360d9579b000009a4a0efe02021015009a4a0efe00000000000000000a00000000000030000a00370d9579b000003224be120202130700030000000000001400380d9579b000003524be120202120900000003000000000000150500025a0000000a00390d9579b000005024be1202021307000300000000000014003a0d9579b000005324be120202120900000003000000000000150500025a00000018003b0d9579b00000d74a0efe0202101500d74a0efe00000000000000000a00000000000030000a003c0d9579b000006e24be1202021307000300000000000014003d0d9579b000007224be120202120900000003000000000000150500025a0000000a003e0d9579b000008d24be1202021307000300000000000014003f0d9579b000009024be120202120900000003000000000000150500025a0000001800400d9579b00000144b0efe0202101500144b0efe00000000000000000a00000000000030000a00410d9579b00000ab24be120202130700030000000000001400420d9579b00000ae24be120202120900000003000000000000150500025a0000000a00430d9579b00000c924be120202130700030000000000001400440d9579b00000cc24be120202120900000003000000000000150500025a0000001800450d9579b00000514b0efe0202101500514b0efe00000000000000000a00000000000030000a00460d9579b00000e724be120202130700030000000000001400470d9579b00000eb24be120202120900000003000000000000150500025a0000000a00480d9579b000000625be120202130700030000000000001400490d9579b000000925be120202120900000003000000000000150500025a00000018004a0d9579b000008e4b0efe02021015008e4b0efe00000000000000000a00000000000030000a004b0d9579b000002425be1202021307000300000000000007a1"));
            verifyNull(decoder, binary(
                    "0100000b0003006c430004010000acfb0100000b0003006d430042020000fca2"));
            verifyNull(decoder, binary(
                    "0100000b0003006e430088030000cc950100000b0003006f4300ce0400005c10"));
            verifyNull(decoder, binary(
                    "0100000b000300704300db0500006c270100000b0003007143009d0600003c7e0100000b000300724300570700000c490100000b000300734300110800003d650100000b000300744300f20900000d520100000b000300754300b40a00005d0b0100000b0003007643007e0b00006d3c0100000b000300774300380c0000fdb9"));
            verifyNull(decoder, binary(
                    "0100000b000300784300890d0000cd8e0100000b000300794300cf0e00009dd70100000b0003007a4300050f0000ade0"));
            verifyNull(decoder, binary(
                    "0100000b0003007b430043100000ff8f0100000b0003007c4300a0110000cfb80100000b0003007d4300e61200009fe10100000b0003007e43002c130000afd60100000b0003007f43006a1400003f530100000b000300804300211500000f640100000b000300814300671600005f3d0100000b000300824300ad1700006f0a0100000b000300834300eb1800005e260100000b000300844300081900006e110100000b0003008543004e1a00003e480100000b000300864300841b00000e7f0100000b000300874300c21c00009efa0100000b000300884300731d0000aecd"));

            verifyPositions(decoder, binary(
                    "0100000b0086035ddd016d18004f049579b000001e2fc11002021015001e2fc1107ac3919f59cc5c7a0b0000000000003000180050049579b00000242fc1100202101500242fc1100fb5919f2dbf5c7a0b0000000000003000180051049579b00000312fc1100202101500312fc110b899919f94cf5c7a0b00000000000030001e0052049579b00000ba62a2120202120900000003000000000000150500025c00000013070003000000000000180053049579b000004e2fc11002021015004e2fc11087ba919f8dd45c7a0b0000000000003000180054049579b00000552fc1100202101500552fc1106ecb919f2aec5c7a0b00000000000030001e0055049579b00000d562a2120202120900000003000000000000150500025c00000013070003000000000000180056049579b000005c2fc11002021015005c2fc11059d9919f54fa5c7a0b0000000000003000180057049579b000006e2fc11002021015006e2fc110309f919fc2db5c7a0b0000000000003000180058049579b00000762fc1100202101500762fc1104690919f94cf5c7a0b00000000000030001e0059049579b00000f662a2120202120900000003000000000000150500025c000000130700030000000000001e005a049579b000001463a2120202120900000003000000000000150500025c0000001307000300000000000018005b049579b00000b32fc1100202101500b32fc110c491919fa2c65c7a0b00000000000030001e005c049579b000003363a2120202120900000003000000000000150500025c0000001307000300000000000018005d049579b00000ca2fc1100202101500ca2fc11089b9919fd5f95c7a0b00000000000030001e005e049579b000005163a2120202120900000003000000000000150500025c000000130700030000000000001e005f049579b000006f63a2120202120900000003000000000000150500025c00000013070003000000000000180060049579b00000f42fc1100202101500f42fc11087ba919f43db5c7a0b0000000000003000180061049579b000000730c11002021015000730c110f9c3919fe1c65c7a0b0000000000003000180062049579b000000930c11002021015000930c1106ecb919f3ab65c7a0b00000000000030001e0063049579b000008d63a2120202120900000003000000000000150500025c00000013070003000000000000140064049579b00000ac63a2120202120900000003000000000000150500025c000000ce53"));

            verifyNull(decoder, binary(
                    "0100000b00100091030072000100060000000002020003009203000009"));

            verifyNull(decoder, binary(
                    "0100000b00030095030063100000ff8f0100000b000300960300a9100000ff8f0100000b000300970300ef100000ff8f0100000b0003009803005e100000ff8f0100000b00030099030018100000ff8f"));

            verifyNull(decoder, binary(
                    "0100000b00030060dd005f010000acfb"));

        }finally {

            Context.getConfig().setString(Keys.SERVER_IGNORE_SESSION_CACHE, String.valueOf(old));
        }
    }

}
