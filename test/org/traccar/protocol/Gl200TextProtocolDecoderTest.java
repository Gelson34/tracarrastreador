package org.traccar.protocol;

import org.junit.Test;
import org.traccar.ProtocolTest;

public class Gl200TextProtocolDecoderTest extends ProtocolTest {

    @Test
    public void testDecode() throws Exception {

        Gl200TextProtocolDecoder decoder = new Gl200TextProtocolDecoder(null);

        verifyAttributes(decoder, buffer(
                "+BUFF:GTSTC,410301,864802030022424,,,0,,,,,,,0228,0002,4EE8,1BFF489,00,20181207134332,EC90$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,1A0900,860599000306845,G3-313,0,0,4,1,2.1,0,426.7,8.611466,47.681639,20181214134603,0228,0001,077F,4812,25.2,1,5.7,34,437.3,8.611600,47.681846,20181214134619,0228,0001,077F,4812,25.2,1,4.4,62,438.2,8.611893,47.681983,20181214134633,0228,0001,077F,4812,25.2,1,4.8,78,436.6,8.612236,47.682040,20181214134648,0228,0001,077F,4812,25.2,83,20181214134702,0654$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTCAN,270703,867162025056839,gv300w,0,1,E07FFFFF,,2,H9307659,368713.50,1291,90,91,,P82.40,,61,10.10,6.76,3.34,524.08,,,0000,,00,,,007FFFFF,,,,,,,,,,,,,,,,,,,,,0000,2,0,,,0,88.6,104,117.6,-116.886007,32.543697,20181031202959,0334,0020,5234,7FCC3D0,00,20181031203002,9F50$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTERI,310701,863286023712855,,00000004,28378,10,1,1,0.0,294,358.4,14.271475,50.110771,20181111185001,0230,0003,94D4,3B30,00,14.5,,,,110000,2,0,C03FFFFF,,0,H46400,12310.70,0,0,83,,,,0,,0.53,3.43,,,,40,,0,,,20181111185252,2DFF"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTCAN,310701,863286023712855,,10,0,003FFFFF,,2,H46358,12305.50,601,0,83,,P53.00,,0,2749.15,0.19,2.80,,,,40,,0,,,20181110103016,2945$"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTCAN,310701,863286023712855,,10,0,203FFFFF,,2,H46358,12305.50,601,0,83,,P53.00,,0,2749.15,0.19,2.80,,,,40,,0,,,007FFFFF,,,,,,0,,,134,37,6,0.19,,0.00,0,,,,,,0,0,0,20181110112126,299F$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTCAN,310701,863286023712855,,10,0,E03FFFFF,,2,H46358,12305.50,601,0,83,,P53.00,,0,2749.15,0.19,2.80,,,,40,,0,,,007FFFFF,,,,,,0,,,134,37,6,0.19,,0.00,0,,,,,,0,0,0,0,0.0,312,358.4,14.271460,50.110796,20181110103130,0230,0003,94D4,3B30,00,20181110105348,2969$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,1F0301,862193022001432,WF0GXXGBBGBM26503,,14900,41,1,1,11.6,74,356.0,14.120023,50.167894,20181104080703,0230,0003,9B14,5891,00,74.1,,,,83,220000,799,7.3,,20181104080703,099B$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTCAN,4B0201,867995030001575,,10,0,C03FFFFF,,0,H0,,,,,,,,,,0.00,0.03,,,,0,,0,,,0,10.0,310,404.3,14.096743,50.143363,20181102110535,0230,0003,9B14,5066,00,20181102112101,03E0$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTSTR,440502,866427030112088,GL530,0,0,2,,100,3,0.6,0,127.5,2.413963,48.877096,20180704180102,0208,0001,0310,E625,,,0000,20180704180100,004C$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTLSW,300500,860599002636595,,0,0,0,0.0,0,2886.5,-78.467145,-0.165335,20180518221815,,,,,,20180518221817,B6FD$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTLSW,300500,860599002636595,,0,1,0,0.0,0,2886.5,-78.467145,-0.165335,20180518221818,,,,,,20180518221819,B6FF$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTTSW,1A0100,135790246811220,,1,0,0,4.3,92,70.0,121.354335,31.222073,20090214013254,0460,0000,18d8,6141,00,20100214093254,11F0$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTLSW,1A0100,135790246811220,,0,1,0,4.3,92,70.0,121.354335,31.222073,20090214013254,0460,0000,18d8,6141,00,20100214093254,11F0$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTIGF,270302,867162025085234,,3519,0,0.0,92,111.2,-116.867638,32.450321,20180327070835,0334,0020,2B24,52CC3DE,00,,243.1,20180327070837,2A98$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTDIS,270302,867162025086950,,,21,1,1,0.0,81,117.8,-116.862025,32.453497,20180309084516,0334,0020,2B24,52CA916,00,1286.2,20180309084517,357E$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTIGL,270302,867162025085234,,,01,1,1,0.0,92,111.2,-116.867638,32.450321,20180327070838,0334,0020,2B24,52CC3DE,00,243.1,20180327070839,2A9A$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTERI,310603,863286023345490,,00000002,,10,1,2,0.3,0,155.7,8.000000,52.000000,20171215213040,0262,0002,1450,9F13,00,1130.3,00539:27:19,,,110000,2,1,28FFD5239115034E,1,,20171215213041,27C7$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTERI,250C02,868789023691057,,00000019,,10,1,1,0.0,196,2258.0,-99.201807,19.559242,20180214002957,0334,0003,235B,7F8D,00,6786.7,,,,100,110000,1,0394,1,4,100.0,100.0,20180214003006,C72B$"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTCAN,310603,863286023335723,gv65,00,1,C03FFFFF,,0,,719601.00,,,,,,,,274.99,179.02,95.98,84761.00,,,0,,0,,,0,0.0,216,29.8,-2.155296,51.899400,20180209172714,0234,0010,53F3,8D38,00,20180211002128,E94E$"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTCAN,310201,153759012347650,gv65,0,1,C03FFFFF,,2,H89394,63.14,200,0,87,,P43.60,0,0,17.53,11.61,5.92,0.00,0,0,4002,0,1,0.76,35.00,0,,,,0,0,,0000,0000,0000,0000,00,20040101000052,05A6$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTCAN,310603,863286023346480,gv65,00,1,C03FFFFF,,2,H2843820,373.76,1440,44,77,M23,P35.00,1810,,59.48,42.68,16.80,15.42,,,610,,0,,,0,42.7,263,27.2,-2.156478,51.899989,20171021151805,0234,0010,15D6,9AD2,00,20171021151807,0B28$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTCAN,310603,863286023346480,gv65,02,1,C03FFFFF,,0,H2843820,373.80,0,4,75,M12,,1800,,59.49,42.69,16.80,15.42,,,0,,0,,,0,0.7,75,24.3,-2.155148,51.899400,20171021151837,0234,0010,15D6,9AD2,00,20171021152355,0B2E$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTERI,380603,869606020025833,gv65,00000002,12003,10,1,1,0.0,172,24.6,-81.931875,26.577439,20171002045352,0310,0260,72BD,8E5B,00,1052.1,01383:52:12,0,100,210700,2,1,28FF4560A3150483,1,05B0,20171002045402,9548$"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTINF,04040E,861074023747143,gv200,41,8959301000648637556f,24,0,1,0,1,4.4,0,1,0,0,20170912221854,0,00,01,-0500,1,20170912193448,1D5B$"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTINF,210102,354524044950583,,42,89011702272048900184,11,99,0,,,4.08,0,1,1,0,0,20170831170831,87,0.00,,,,20170831171010,0064$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTOBD,360701,864251020253807,LSGTC58UX7Y067312,GV500,0,70FFFF,LSGTC58UX7Y067312,1,12309,983A8140,0,0,33,nan,,0,0,0,,10,0,,0,4.4,0,83.7,36.235142,49.967324,20170829112348,0255,0001,2760,9017,00,690.1,20170829112400,3456$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTERI,060502,861074023620928,,00000002,27822,10,1,1,0.0,84,2870.9,-78.531796,-0.277329,20170825045344,,,,,,0.0,01138:30:24,,,83,220104,2,1,28FF2776A2150308,1,FFAD,0,20170825045348,A88C$"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTINF,280500,A1000043D20139,GL300VC,41,,31,0,0,,,3.87,0,1,1,,,20170802150751,70,,48.0,,,20170802112145,03AC$"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTINF,2D0300,A1000043D20139,1G1JC5444R7252367,,11,,31,0,1,12986,,4.16,0,2,,,20170802145640,,,,,,+0000,0,20170802145643,CD5A$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTMPN,450102,865084030001323,gb100,0,1.6,0,-93.1,121.393023,31.164105,20170619103113,0460,0000,1806,2142,00,20170619103143,0512$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTTRI,862370030005908,1,0,99,1,0.0,354,18.5,18.821100,-34.084002,20170607152024,0655,0001,00DD,1CAE,00,0103010100,20170607172115,3E7D$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTERI,060800,861074023677175,,00000002,12351,10,1,1,0.0,0,2862.4,-78.467273,-0.164998,20170529181717,,,,,,0.0,00259:11:50,,,0,210104,2,1,28E17436060000E2,1,015F,0,20170529181723,2824$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTSWG,110100,358688000000158,,1,0,2.1,0,27.1,121.390717,31.164424,20110901073917,0460,0000,1878,0873,,20110901154653,0015$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTTMP,110100,358688000000158,,2,60,1,1,4.3,92,70.0,121.354335,31.222073,20110214013254,0460,0000,18d8,6141,00,80,20110214093254,000F$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTSTT,110100,358688000000158,,41,0,4.3,92,70.0,121.354335,31.222073,20110214013254,0460,0000,18d8,6141,,20110214093254,0022$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTBPL,110100,358688000000158,,3.53,0,4.3,92,70.0,121.354335,31.222073,20110214013254,0460,0000,18d8,6141,,20110214093254,001F$"));

        verifyNotNull(decoder, buffer(
                "+BUFF:GTIGL,060228,862894020180553,,,00,1,1,3.4,199,409.6,-63.174466,-17.739317,20170407121823,0000,0000,0000,0000,00,15989.5,20170407081824,9606$"));

        verifyNotNull(decoder, buffer(
                "+RESP:GTFRI,060228,862894020180553,,14827,10,1,1,3.4,199,409.6,-63.174466,-17.739317,20170407121823,0000,0000,0000,0000,00,15989.5,01070:43:13,13,180,0,220101,,,,20170407081824,9607$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTERI,060502,861074023376992,,00000002,27239,10,1,1,0.2,312,183.3,-79.320820,-2.499110,20170401212005,0740,0000,EE4E,C98F,00,0.0,02114:36:35,,,90,220504,2,0,0,20170401212007,9E3D$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,060502,861074023689626,,25202,10,1,1,0.0,0,2744.1,-78.261047,0.023452,20170401211940,,,,,,0.0,00079:19:15,,,51,110000,,,,20170401212003,4DA7$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,060100,135790246811220,,,00,1,1,4.3,92,70.0,121.354335,31.222073,20090214013254,0460,0000,18d8,6141,00,2000.0,12345:12:34,,,80,210100,,,,20090214093254,11F0$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTERI,06020B,862170010196747,,00000000,,10,1,2,1.8,0,-2.5,117.198440,31.845219,20120802061037,0460,0000,5663,0358,00,0.0,,,,0,410000,20120802061040,0012$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTERI,060502,861074023692562,,00000002,14197,10,1,1,0.2,220,491.8,-79.064212,-2.159754,20170401212007,0740,0000,EE49,CE25,00,0.0,01509:10:58,,,87,220104,2,0,0,20170401212010,D14D$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,210102,354524044925825,,1,1,1,29,2.8,0,133.7,-90.203063,32.265473,20170318005208,,,,,10800,4,20170318005208,0002$"));

        verifyPositions(decoder, false, buffer(
                "+RESP:GTFRI,210102,354524044925825,,1,1,1,,,,,,,,310,410,51bc,ca1dae6,10800,1,20170318214333,0002$"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTGSM,400201,862365030025161,STR,0234,0015,003a,62a2,16,,0234,0015,003a,56a2,14,,0234,0015,003a,062a,13,,0234,0015,003a,32d9,11,,0234,0015,003a,56a0,11,,,,,,,,0234,0015,003a,7489,17,,20170219200048,0033$"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTGSM,400201,862365030025161,STR,0234,0015,003a,56a2,18,,0234,0015,003a,77bc,14,,0234,0015,003a,32d9,12,,0234,0015,003a,062a,12,,0234,0015,003a,62a2,11,,0234,0015,003a,56a0,10,,0234,0015,003a,7489,15,,20170219080049,0030$"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTGSM,400201,862365030034940,STR,0234,0030,0870,2469,19,,0234,0030,0870,35ee,18,,0234,0030,0870,16ac,12,,0234,0030,0870,16b2,11,,0234,0030,0870,360f,6,,0234,0030,0870,165d,6,,0234,0030,0870,35ef,17,,20170215220049,008D$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTSTR,400201,862365030034940,GL500,0,0,2,21.1,86,0,1.6,0,5.8,0.622831,51.582688,20170215090422,0234,0030,0870,35EF,,,,20170215220049,008C$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,2C0402,867162020000816,,0,0,1,2,0.3,337,245.7,-82.373387,34.634011,20170215003054,,,,,,63,20170215003241,3EAB$"));

        verifyNotNull(decoder, buffer(
                "+RESP:GTWIF,210102,354524044608058,,4,c413e200ff14,-39,,,,c413e2010e55,-39,,,,c8d3ff04a837,-43,,,,42490f997c6d,-57,,,,,,,,100,20170201020055,0001$"));

        verifyNotNull(decoder, buffer(
                "+RESP:GTWIF,210102,354524044484948,,1,08626693fb98,-36,,,,,,,,97,20170119071300,05E3$"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTINF,210102,A100004D9EF2AE,,41,,8,99,0,17.7,21,3.58,0,1,1,0,0,20161216135038,4,,,,,20161216135038,00AB$"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTSTR,400201,862365030034957,GL500,0,0,2,23.1,5,2,0.2,0,36.0,0.623089,51.582744,20161129174625,0234,0015,03C3,3550,,,,20161129174625,0026$"));

        verifyNotNull(decoder, buffer(
                "+RESP:GTSTR,400201,862365030034957,GL500,0,1,2,21.8,100,0,,,,,,,0234,0015,03C3,3550,,,,20161129174009,0023$"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTINF,210102,A10000499AEF9B,,41,,0,0,0,15.0,9,3.87,0,1,1,0,0,20161101140211,72,,,,,20161101140211,00A3$"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTNMR,210102,A10000499AEF9B,,0,0,1,9,0.0,0,288.0,-76.902364,39.578828,20161101134145,,,,,00,73,20161101134145,009F$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,210102,A10000499AEF9B,,0,1,1,9,0.5,0,288.0,-76.902364,39.578828,20161101134124,,,,,00,73,20161101134123,009D$"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTRTL,210102,A10000499AEF9B,,0,0,1,10,0.2,0,305.4,-76.902274,39.578517,20161101155001,,,,,00,73,20161101155001,00A6$"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTINF,110100,358688000000158,,41,898600810906F8048812,18,99,0,33.23,1,4.19,1,1,1,0,0,20110714104934,100,,,,,20110714104934,0014$"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTINF,080100,135790246811220,,16,898600810906F8048812,16,0,1,11870,,4.1,0,0,0,,20090214013254,,12340,,00,00,+0800,0,20090214093254,11F0$"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTINF,040100,135790246811220,,16,898600810906F8048812,16,0,1,,0,4.4,0,0,0,0,20090214013254,13000,00,00,+0800,0,20090214093254,11F0$"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTINF,060100,135790246811220,,16,898600810906F8048812,16,0,1,12000,,4.4,0,0,0,0,20090214013254,0,1300,2000,00,00,+0800,0,20090214093254,11F0$"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTINF,1A0800,860599000773978,GL300,41,89701016426133851978,17,0,1,26.6,,3.90,1,1,0,0,0,20161003184043,69,1,44,,,20161004040811,022C$"));

        verifyAttributes(decoder, buffer(
                "+BUFF:GTINF,1A0800,860599000773978,GL300,41,89701016426133851978,23,0,1,204.7,,3.84,1,1,0,0,0,20161006072548,62,1,38,,,20161006082343,0C98$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,360100,864251020141408,3VWGW6AJ0FM237324,gv500,,10,1,1,0.0,0,2258.4,-99.256948,19.555800,20160929214743,0334,0020,0084,65AC,00,0.0,,,,100,410000,0,nan,,20160929214743,13BA$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTOBD,360201,864251020186064,4T1BE46KX7U018210,,0,19FFFF,4T1BE46KX7U018210,1,14283,983901C0,799,36,18,,33792,0,0,0,,,38,,6,53557,0,0.0,0,219.5,-76.661456,39.832588,20160507132153,20160507132154,0230$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,360201,864251020186064,1G1JC5444R7252367,,12802,10,1,0,0.0,0,219.5,-76.661456,39.832588,20160507132235,,,,,,20460.9,00080:03:37,,,100,210000,791,,56,20160507132239,0233$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,1F0101,135790246811220,1G1JC5444R7252367,,,00,2,1,4.3,92,70.0,121.354335,31.222073,20090214013254,0460,0000,18d8,6141,00,0,4.3,92,70.0,121.354335,31.222073,20090101000000,0460,0000,18d8,6141,00,2000.0,12345:12:34,,,80,210100,,,50,20090214093254,11F0$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,1F0101,135790246811220,1G1JC5444R7252367,,,00,1,1,4.3,92,70.0,121.354335,31.222073,20090214013254,0460,0000,18d8,6141,00,2000.0,12345:12:34,,92,80,210100,,,50,20090214093254,11F0$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTSTT,060228,862894020178276,,21,0,0.0,0,411.3,-63.169745,-17.776330,20160319132220,0736,0003,6AD4,5BAA,00,20160319092223,1FBD$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTNMR,210102,A10000458356CE,,0,1,1,9,0.0,8,190.7,-85.765865,42.894837,20160316123202,,,,,60,30,20160316123202,0137$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTIDA,060228,862894020178276,,,01C68011010000C7,1,1,0,0.0,0,413.0,-63.169675,-17.776349,20160317222129,0736,0003,6AD4,32CF,00,34.9,,,,,20160317182130,1626$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTIGN,060228,862894020180553,,9860,0,0.2,189,420.0,-63.158195,-17.800608,20160309022951,0736,0003,6AD4,3471,00,,881.2,20160308222956,129A$"));

        verifyPosition(decoder, buffer(
                "+BUFF:GTIGF,060228,862894020180553,,1958,0,0.0,240,390.3,-63.089213,-17.764712,20160309122854,0736,0003,6AB8,5A23,00,,936.8,20160309082858,1368$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,060228,862894020180553,,,10,1,1,20.0,147,329.7,-62.899703,-17.720434,20160309113548,0736,0003,6AAE,3381,00,913.3,,,,0,220101,,,,20160309073554,132B$"));

        verifyPositions(decoder, buffer(
                "+BUFF:GTFRI,060402,862894021808798,,,10,1,1,0.0,349,394.3,-63.287717,-17.662410,20160116234031,0736,0003,6ABA,8305,00,3326.8,,,,94,220100,,,,20160116194035,4D83"));

        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,2C0204,867162020003125,GL300W,0,0,2,1,1.7,205,2867.0,-78.481127,-0.206828,20160215210433,0740,0000,7596,5891C,0.0,1,1.7,205,2867.0,-78.481127,-0.206828,20160215210503,0740,0000,7596,5891C,0.0,88,20160215210506,1E78$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,060228,862894020178276,,15153,10,1,1,0.0,0,431.7,-63.169571,-17.776235,20160210153458,0736,0003,6AD4,80EF,00,34.9,00117:31:26,13442,15163,0,210101,,,,20160210113503,38EE$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,110100,A5868800000015,,0,0,1,1,4.3,92,70.0,121.354335,31.222073,20110214013254,0460,0000,18d8,6141,00,80,20110214013254,000C"));

        verifyNotNull(decoder, buffer(
                "+RESP:GTFRI,210102,A10000458356CE,,0,1,1,15,1.4,0,190.6,-85.765763,42.894896,20160208164505,4126,210,0,18673,00,92,20160208164507,00A6"));

        verifyPositions(decoder, buffer(
                "+BUFF:GTFRI,060402,862894021808798,,,10,1,1,0.0,349,394.3,-63.287717,-17.662410,20160116234031,0736,0003,6ABA,8305,00,3326.8,,,,94,220100,,,,20160116194035,4D83"));

        verifyPosition(decoder, buffer(
                "+RESP:GTIDA,06020A,862170013895931,,,D2C4FBC5,1,1,1,0.8,0,22.2,117.198630,31.845229,20120802121626,0460,0000,5663,2BB9,00,0.0,,,,,20120802121627,008E$"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTINF,1F0101,135790246811220,1G1JC5444R7252367,,16,898600810906F8048812,16,0,1,12000,,4.2,0,0,,,20090214013254,,,,,,+0800,0,20090214093254,11F0$"));

        verifyPositions(decoder, false, buffer(
                "+RESP:GTFRI,120113,555564055560555,,1,1,1,,,,,,,,0282,0380,f080,cabf,6900,79,20140824165629,0001$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,0F0106,862193020451183,,,10,1,1,0.0,163,,-57.513617,-25.368191,20150918182145,,,,,,21235.0,,,,0,210100,,,,20150918182149,00B8$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTOBD,1F0109,864251020135483,,gv500,0,78FFFF,,1,12613,,,,,,,,,,,,,,1286,0,0.0,0,17.1,3.379630,6.529701,20150813074639,0621,0030,51C0,A2B3,00,0.0,20150813074641,A7E6$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTOBD,1F0109,864251020135483,4T1BE46KX7U018210,gv500,0,78FFFF,4T1BE46KX7U018210,1,13411,981B81C0,787,3,43,,921,463,1,10,0300030103030304001200310351035203530354,20,55,,1286,0,6.5,74,21.6,3.379710,6.529714,20150813074824,0621,0030,51C0,A2B3,00,0.0,20150813074828,A7E9$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTSTT,1A0401,860599000508846,,41,0,0.0,84,107.5,-76.657998,39.497203,20150623160622,0310,0260,B435,3B81,,20150623160622,0F54$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,1A0401,860599000508846,,0,0,1,1,134.8,154,278.7,-76.671089,39.778885,20150623154301,0310,0260,043F,7761,,99,20150623154314,0F24$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,1A0200,860599000165464,CRI001,0,0,1,2,,41,,-71.153137,42.301634,20150328020301,,,,,280.3,55,20150327220351,320C"));
        
        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,02010D,867844001675407,,0,0,1,2,0.0,0,28.9,8.591011,56.476397,20140915213209,0238,0001,03CB,2871,,97,20140915213459,009A"));

        verifyNull(decoder, buffer(
                "+RESP:GTINF,359464030073766,8938003990320469804f,18,99,100,1,0,+2.00,0,20131018084015,00EE,0103090402"));

        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,04040C,359231038939904,,,10,1,2,0.0,117,346.0,8.924243,50.798077,20130618122040,0262,0002,0299,109C,00,0.0,,,,,,,,,20130618122045,00F6"));
        
        verifyPosition(decoder, buffer(
                "+RESP:GTSTT,04040C,359231038939904,,42,0,0.0,117,346.0,8.924243,50.798077,20130618125152,0262,0002,0299,109C,00,20130618125154,017A"));
        
        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,020102,000035988863964,,0,0,1,1,4.3,92,70.0,121.354335,31.222073,20090214013254,0460,0000,18d8,6141,00,,20090214093254,11F0"));

        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,020102,135790246811220,,0,0,1,1,4.3,92,70.0,121.354335,31.222073,20090214013254,0460,0000,18d8,6141,00,,20090214093254,11F0"));

        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,020102,135790246811220,,0,0,2,1,4.3,92,70.0,121.354335,31.222073,20090214013254,0460,0000,18d8,6141,00,0,4.3,92,70.0,121.354335,31.222073,20090101000000,0460,0000,18d8,6141,00,,20090214093254,11F0"));

        verifyPosition(decoder, buffer(
                "+RESP:GTDOG,020102,135790246811220,,0,0,1,1,4.3,92,70.0,121.354335,31.222073,20090214013254,0460,0000,18d8,6141,00,2000.0,20090214093254,11F0"));

        verifyPosition(decoder, buffer(
                "+RESP:GTLBC,020102,135790246811220,,+8613800000000,1,4.3,92,70.0,121.354335,31.222073,20090214013254,0460,0000,18d8,6141,00,,20090214093254,11F0"));

        verifyPosition(decoder, buffer(
                "+RESP:GTGCR,020102,135790246811220,,3,50,180,2,0.4,296,-5.4,121.391055,31.164473,20100714104934,0460,0000,1878,0873,00,,20100714104934,000C"));

        verifyPosition(decoder, buffer(
                "+RESP:GTFRI,07000D,868487001005941,,0,0,1,1,0.0,0,46.3,-77.039627,38.907573,20120731175232,0310,0260,B44B,EBC9,0015e96913a7,-58,,100,20120731175244,0114"));

        verifyPosition(decoder, buffer(
                "+RESP:GTHBM,0F0100,135790246811220,,,10,1,1,4.3,92,70.0,121.354335,31.222073,20090214013254,0460,0000,18d8,6141,00,2000.0,20090214093254,11F0$"));

        verifyPosition(decoder, buffer(
                "+RESP:GTHBM,0F0100,135790246811220,,,11,1,1,24.3,92,70.0,121.354335,31.222073,20090214013254,0460,0000,18d8,6141,00,2000.0,20090214093254,11F0$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,02010C,867844001274144,,0,0,1,1,18.0,233,118.1,7.615551,51.515600,20140106130516,0262,0007,79E6,B956,,72,20140106140524,09CE$"));
        
        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,02010C,867844001274649,,0,0,1,1,0.0,0,122.5,7.684216,51.524512,20140106233722,0262,0007,79EE,1D22,,93,20140107003805,03C4$"));

        verifyPositions(decoder, buffer(
                "+BUFF:GTFRI,210101,863286020016706,,,10,1,1,,,,49.903915,40.391669,20140818105815,,,,,,,,,,,210100,,,,,000C$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,240100,135790246811220,,,10,1,1,4.3,92,70.0,121.354335,31.222073,20090214013254,0460,0000,18d8,6141,00,2000.0,12345:12:34,,80,,,,,,20090214093254,11F0$"));

        verifyPositions(decoder, buffer(
                "+RESP:GTFRI,240100,135790246811220,,,10,2,1,4.3,92,70.0,121.354335,31.222073,20090214013254,0460,0000,18d8,6141,00,0,4.3,92,70.0,121.354335,31.222073,20090101000000,0460,0000,18d8,6141,00,2000.0,12345:12:34,,,80,,,,,20090214093254,11F0$"));

        verifyNotNull(decoder, buffer(
                "+RESP:GTSTT,280100,A1000043D20139,,42,0,0.1,321,228.6,-76.660884,39.832552,20150615120628,0310,0484,00600019,0A52,,20150615085741,0320$"));

        verifyNotNull(decoder, buffer(
                "+RESP:GTRTL,280100,A1000043D20139,,0,0,1,1,0.1,321,239.1,-76.661047,39.832501,20150615114455,0310,0484,00600019,0A52,,87,20150615074456,031E$"));
        
        verifyAttributes(decoder, buffer(
                "+BUFF:GTBPL,1A0800,860599000773978,GL300,3.55,0,0.0,0,257.1,60.565437,56.818277,20161006070553,,,,,204.7,20161006071028,0C75$"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTTEM,1A0102,860599000000448,,3,33,0,5.8,0,33.4,117.201191,31.832502,20130109061410,0460,0000,5678,2079,,20130109061517,0091$"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTJDR,0A0102,135790246811220,,0,4.3,92,70.0,121.354335,31.222073,20090214013254,0460,0000,18d8,6141,00,20090214093254,11F0$"));

        verifyAttributes(decoder, buffer(
                "+RESP:GTJDS,0A0102,135790246811220,,2,0,4.3,92,70.0,121.354335,31.222073,20090214013254,0460,0000,18d8,6141,00,20090214093254,11F0$"));
        
        verifyAttributes(decoder, buffer(
                "+RESP:GTSOS,020102,135790246811220,,0,0,1,1,4.3,92,70.0,121.354335,31.222073,20090214013254,0460,0000,18d8,6141,00,,20090214093254,11F0$"));
        
        verifyAttributes(decoder, buffer(
                "+RESP:GTVER,1A0800,860599000773978,GL300,GL300,0A03,0103,20161007041531,10F8$"));

        verifyNull(decoder, buffer(
                "+ACK:GTHBD,1A0401,135790246811220,,20100214093254,11F0"));

        verifyAttributes(decoder, buffer(
                "+ACK:GTRTO,1A0800,860599000773978,GL300,VER,FFFF,20161006053520,0C19"));

        verifyAttributes(decoder, buffer(
                "+ACK:GTJDC,0A0102,135790246811220,,0016,20090214093254,11F0"));

        verifyAttributes(decoder, buffer(
                "+ACK:GTGEO,1A0102,135790246811220,,0,0008,20100310172830,11F0"));

    }

}
