package Game;

import java.util.ArrayList;
import java.util.List;

import controller.*;
import etc.enumTerritorio;
import etc.enumTerritorio.nomePais;
import etc.Continente;

public class TerritorioDataBase {
	
	
	// Lista de territorios
		static private List<Territorio> lstTerritorios = new ArrayList<Territorio>();
		
		// deslocaX e deslocaY e utilizado para alinhar os poligonos criados em cima da imagem dos territorios.
		static private final int deslocaX = 0;
		static private final int deslocaY = 0;

		// Bloco de inicializacao dos territorios
		// Estou assumindo que a classe territorio tem um nome e um poligono definindo sua area de clique.
		static{
			// Adicionando os territorios na lista de territorios.
			lstTerritorios.add(new Territorio(nomePais.Alasca,Continente.AmericaDoNorte, new Ponto[] {
					new Ponto(86.1, 124.1),
					new Ponto(134.6, 124.1),
					new Ponto(111.4, 167.3),
					new Ponto(58.7, 167.3),
					new Ponto(72.3, 141.8),
					new Ponto(77.3, 141.8) 
			}, deslocaX, deslocaY));
			
			lstTerritorios.add(new Territorio(nomePais.Calgary,Continente.AmericaDoNorte, new Ponto[] {
					new Ponto(148.7, 124.1),
					new Ponto(134.6, 124.1),
					new Ponto(126.4, 139.5),
					new Ponto(146.9, 177.0),
					new Ponto(223.0, 177.0),
					new Ponto(231.3, 163.2),
					new Ponto(245.5, 163.2),
					new Ponto(258.5, 139.5),
					new Ponto(284.1, 139.5),
					new Ponto(271.6, 116.9),
					new Ponto(241.7, 116.9),
					new Ponto(230.4, 137.8),
					new Ponto(212.9, 137.8),
					new Ponto(208.7, 130.1),
					new Ponto(152.4, 130.1)
			}, deslocaX, deslocaY));
			
			lstTerritorios.add(new Territorio(nomePais.Groelandia,Continente.AmericaDoNorte, new Ponto[] {
					new Ponto(285.4, 94.6),
					new Ponto(271.6, 116.9),
					new Ponto(284.1, 139.5),
					new Ponto(328.7, 139.5),
					new Ponto(335.1, 149.5),
					new Ponto(350.8, 149.5),
					new Ponto(365.9, 122.1),
					new Ponto(371.4, 122.1),
					new Ponto(380.4, 108.5),
					new Ponto(371.0, 94.6)
			}, deslocaX,deslocaY));
			
			lstTerritorios.add(new Territorio(nomePais.Vancouver,Continente.AmericaDoNorte, new Ponto[] {
					new Ponto(111.4, 167.3),
					new Ponto(119.3, 182.3),
					new Ponto(102.1, 211.9),
					new Ponto(107.5, 220.0),
					new Ponto(214.0, 220.0),
					new Ponto(231.7, 191.2),
					new Ponto(223.0, 177.0),
					new Ponto(146.90, 177.0),
					new Ponto(126.4, 139.5)
			}, deslocaX,deslocaY));
			
			lstTerritorios.add(new Territorio(nomePais.Quebec,Continente.AmericaDoNorte, new Ponto[] {
					new Ponto(262.2, 190.8),
					new Ponto(231.7, 190.8),
					new Ponto(214.0, 220.0),
					new Ponto(296.9, 220.0),
					new Ponto(304.3, 207.1),
					new Ponto(316.1, 207.1),
					new Ponto(312.5, 215.3),
					new Ponto(325.1, 215.3),
					new Ponto(329.9, 204.5),
					new Ponto(322.8, 191.4),
					new Ponto(331.6, 177.8),
					new Ponto(337.1, 184.7),
					new Ponto(344.7, 172.2),
					new Ponto(340.5, 163.4),
					new Ponto(321.2, 163.4),
					new Ponto(318.8, 160.4),
					new Ponto(288.7, 160.4),
					new Ponto(281.9, 171.9),
					new Ponto(272.9, 171.9)
			}, deslocaX,deslocaY));
			
			lstTerritorios.add(new Territorio(nomePais.California,Continente.AmericaDoNorte, new Ponto[] {
					new Ponto(107.5, 220.0),
					new Ponto(84.7, 258.0),
					new Ponto(89.9, 268.9),
					new Ponto(78.2, 289.0),
					new Ponto(90.4, 310.2),
					new Ponto(126.4, 310.2),
					new Ponto(178.5, 220.0)
			}, deslocaX,deslocaY));
			
			lstTerritorios.add(new Territorio(nomePais.Texas,Continente.AmericaDoNorte, new Ponto[] {
					new Ponto(202.2, 248.2),
					new Ponto(231.7, 248.2),
					new Ponto(246.1, 220.0),
					new Ponto(178.5, 220.0),
					new Ponto(126.4, 310.2),
					new Ponto(145.9, 343.8)
			}, deslocaX,deslocaY));
			
			lstTerritorios.add(new Territorio(nomePais.NovaYork,Continente.AmericaDoNorte, new Ponto[] {
					new Ponto(181.8, 310.2),
					new Ponto(165.7, 310.2),
					new Ponto(202.2, 248.2),
					new Ponto(231.7, 248.2),
					new Ponto(246.1, 220.0),
					new Ponto(296.9, 220.0),
					new Ponto(290.7, 231.7),
					new Ponto(279.4, 231.7),
					new Ponto(261.5, 265.1),
					new Ponto(243.7, 265.1),
					new Ponto(237.8, 279.1),
					new Ponto(231.3, 279.1),
					new Ponto(215.3, 306.5),
					new Ponto(207.3, 306.5),
					new Ponto(200.6, 318.9),
					new Ponto(211.5, 337.8),
					new Ponto(204.3, 349.4)
			}, deslocaX,deslocaY));
			
			lstTerritorios.add(new Territorio(nomePais.Mexico,Continente.AmericaDoNorte, new Ponto[] {
					new Ponto(90.4, 310.2),
					new Ponto(83.1, 323.0),
					new Ponto(103.6, 359.2),
					new Ponto(110.6, 346.5),
					new Ponto(102.5, 330.6),
					new Ponto(105.7, 324.8),
					new Ponto(136.6, 377.6),
					new Ponto(145.7, 377.6),
					new Ponto(162.1, 408.2),
					new Ponto(172.2, 408.2),
					new Ponto(179.8, 421.9),
					new Ponto(188.8, 406.2),
					new Ponto(183.8, 398.0),
					new Ponto(178.5, 398.0),
					new Ponto(173.0, 389.4),
					new Ponto(173.0, 386.3),
					new Ponto(175.3, 384.3),
					new Ponto(167.1, 370.0),
					new Ponto(171.8, 360.7),
					new Ponto(164.3, 348.1),
					new Ponto(161.4, 355.3),
					new Ponto(152.3, 355.3),
					new Ponto(126.4, 310.2)
			}, deslocaX,deslocaY));
			
			lstTerritorios.add(new Territorio(nomePais.Venezuela,Continente.AmericaDoSul, new Ponto[] {
					new Ponto(193.5, 398.2),
					new Ponto(254.3, 398.2),
					new Ponto(196.8, 498.1),
					new Ponto(188.8, 482.2),
					new Ponto(176.2, 482.2),
					new Ponto(161.2, 455.8),
					new Ponto(179.8, 421.9),
					new Ponto(188.8, 406.2)
			}, deslocaX,deslocaY));
			
			lstTerritorios.add(new Territorio(nomePais.Peru,Continente.AmericaDoSul, new Ponto[] {
					new Ponto(196.8, 498.1),
					new Ponto(202.3, 507.9),
					new Ponto(216.1, 507.9),
					new Ponto(232.2, 538.5),
					new Ponto(226.8, 545.4),
					new Ponto(239.7, 564.8),
					new Ponto(274.9, 505.0),
					new Ponto(233.8, 433.8)
			}, deslocaX,deslocaY));
			
			lstTerritorios.add(new Territorio(nomePais.Brasil,Continente.AmericaDoSul, new Ponto[] {
					new Ponto(259.6, 407.2),
					new Ponto(285.3, 407.2),
					new Ponto(293.4, 423.9),
					new Ponto(305.7, 423.9),
					new Ponto(316.1, 445.2),
					new Ponto(335.4, 445.2),
					new Ponto(343.3, 461.0),
					new Ponto(343.3, 463.1),
					new Ponto(325.9, 491.3),
					new Ponto(333.8, 505.0),
					new Ponto(274.9, 505.0),
					new Ponto(233.8, 433.8),
					new Ponto(254.3, 398.2)
			}, deslocaX,deslocaY));
			
			lstTerritorios.add(new Territorio(nomePais.Argentina,Continente.AmericaDoSul, new Ponto[] {
					new Ponto(333.8, 505.0),
					new Ponto(302.4, 558.8),
					new Ponto(311.2, 573.0),
					new Ponto(281.6, 624.5),
					new Ponto(295.7, 650.2),
					new Ponto(278.1, 650.2),
					new Ponto(235.0, 572.4),
					new Ponto(239.7, 564.8),
					new Ponto(274.9, 505.0)
			}, deslocaX,deslocaY));
			
			lstTerritorios.add(new Territorio(nomePais.AfricaDoSul,Continente.Africa, new Ponto[] { new Ponto(528.4, 545.4),
					new Ponto(558.1, 600.2),
					new Ponto(597.1, 600.2),
					new Ponto(606.1, 584.7),
					new Ponto(613.1, 584.7),
					new Ponto(626.6, 559.1),
					new Ponto(617.6, 545.4)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.Angola,Continente.Africa, new Ponto[] {
					new Ponto(514.7, 493.2),
					new Ponto(519.9, 482.5),
					new Ponto(588.6, 482.5),
					new Ponto(599.4, 502.3),
					new Ponto(573.4, 545.4),
					new Ponto(528.4, 545.4),
					new Ponto(535.6, 531.4)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.Argelia,Continente.Africa, new Ponto[] {
					new Ponto(436.7, 337.5),
					new Ponto(473.2, 337.5),
					new Ponto(479.6, 350.3),
					new Ponto(492.5, 350.3),
					new Ponto(499.1, 364.1),
					new Ponto(539.8, 364.1),
					new Ponto(513.0, 410.1),
					new Ponto(425.3, 410.1),
					new Ponto(409.3, 384.5)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.Egito,Continente.Africa, new Ponto[] {
					new Ponto(588.6, 360.3),
					new Ponto(542.0, 360.3),
					new Ponto(539.8, 364.1),
					new Ponto(513.0, 410.1),
					new Ponto(547.6, 410.1),
					new Ponto(562.4, 436.6),
					new Ponto(623.6, 436.6),
					new Ponto(594.0, 385.3),
					new Ponto(597.8, 378.5)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.Nigeria,Continente.Africa, new Ponto[] {
					new Ponto(425.3, 410.1),
					new Ponto(448.1, 452.2),
					new Ponto(503.3, 452.2),
					new Ponto(519.9, 482.5),
					new Ponto(588.6, 482.5),
					new Ponto(562.4, 436.6),
					new Ponto(547.6, 410.1)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.Somalia,Continente.Africa, new Ponto[] {
					new Ponto(643.1, 502.0),
					new Ponto(653.0, 502.0),
					new Ponto(672.7, 464.6),
					new Ponto(639.3, 464.6),
					new Ponto(623.6, 436.6),
					new Ponto(562.4, 436.6),
					new Ponto(599.4, 502.3),
					new Ponto(573.4, 545.4),
					new Ponto(617.6, 545.4)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.Espanha,Continente.Europa, new Ponto[] {
					new Ponto(442.3, 266.0),
					new Ponto(461.0, 266.0),
					new Ponto(476.9, 292.5),
					new Ponto(475.0, 296.6),
					new Ponto(480.0, 296.6),
					new Ponto(470.7, 312.3),
					new Ponto(452.3, 312.3),
					new Ponto(456.4, 304.0),
					new Ponto(443.2, 304.0),
					new Ponto(440.2, 309.2),
					new Ponto(415.9, 309.2)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.Franca,Continente.Europa, new Ponto[] {
					new Ponto(526.8, 186.6),
					new Ponto(538.7, 210.4),
					new Ponto(508.1, 263.1),
					new Ponto(502.1, 263.1),
					new Ponto(494.4, 279.1),
					new Ponto(483.7, 279.1),
					new Ponto(476.9, 292.5),
					new Ponto(461.0, 266.0),
					new Ponto(466.7, 255.2),
					new Ponto(459.9, 244.7),
					new Ponto(452.3, 244.7),
					new Ponto(448.2, 235.7),
					new Ponto(488.6, 235.7),
					new Ponto(499.3, 219.1),
					new Ponto(516.2, 219.1),
					new Ponto(521.8, 207.7),
					new Ponto(517.8, 200.4)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.Italia,Continente.Europa, new Ponto[] {
					new Ponto(552.4, 210.4),
					new Ponto(538.7, 210.4),
					new Ponto(508.1, 263.1),
					new Ponto(516.6, 263.1),
					new Ponto(526.7, 281.8),
					new Ponto(533.7, 281.8),
					new Ponto(542.5, 298.2),
					new Ponto(542.5, 300.2),
					new Ponto(537.1, 308.2),
					new Ponto(549.2, 308.2),
					new Ponto(554.8, 297.3),
					new Ponto(556.1, 297.3),
					new Ponto(557.4, 299.5),
					new Ponto(563.9, 299.5),
					new Ponto(563.9, 297.7),
					new Ponto(552.8, 277.8),
					new Ponto(547.0, 277.8),
					new Ponto(539.1, 261.1),
					new Ponto(543.5, 253.4),
					new Ponto(552.8, 253.4),
					new Ponto(555.8, 259.4),
					new Ponto(567.5, 237.9)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.Polonia,Continente.Europa, new Ponto[] {
					new Ponto(575.6, 176.1),
					new Ponto(583.6, 176.0),
					new Ponto(600.8, 205.9),
					new Ponto(581.8, 237.9),
					new Ponto(567.5, 237.9),
					new Ponto(552.4, 210.4),
					new Ponto(564.1, 189.0),
					new Ponto(569.8, 189.0)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.ReinoUnido,Continente.Europa, new Ponto[] {
					new Ponto(462.0, 146.2),
					new Ponto(481.6, 146.2),
					new Ponto(473.7, 156.6),
					new Ponto(480.8, 156.6),
					new Ponto(470.3, 174.2),
					new Ponto(482.7, 198.4),
					new Ponto(490.8, 198.4),
					new Ponto(484.0, 210.4),
					new Ponto(445.5, 210.4),
					new Ponto(451.3, 196.1),
					new Ponto(458.1, 196.1),
					new Ponto(463.2, 188.5),
					new Ponto(454.0, 174.2),
					new Ponto(459.4, 165.3),
					new Ponto(459.4, 163.2),
					new Ponto(450.8, 163.2)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.Romenia,Continente.Europa, new Ponto[] {
					new Ponto(567.5, 237.9),
					new Ponto(555.8, 259.4),
					new Ponto(555.8, 262.4),
					new Ponto(557.6, 264.2),
					new Ponto(566.1, 264.2),
					new Ponto(579.8, 288.6),
					new Ponto(574.4, 297.5),
					new Ponto(581.4, 308.2),
					new Ponto(593.2, 308.2),
					new Ponto(601.4, 297.4),
					new Ponto(595.1, 289.5),
					new Ponto(598.3, 283.7),
					new Ponto(607.9, 283.7),
					new Ponto(581.8, 237.9)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.Suecia,Continente.Europa, new Ponto[] {
					new Ponto(551.0, 96.6),
					new Ponto(582.5, 96.6),
					new Ponto(610.2, 144.5),
					new Ponto(602.0, 158.0),
					new Ponto(571.5, 158.0),
					new Ponto(578.7, 145.7),
					new Ponto(569.6, 145.7),
					new Ponto(579.6, 127.8),
					new Ponto(562.9, 127.8),
					new Ponto(552.1, 145.8),
					new Ponto(558.1, 156.3),
					new Ponto(552.0, 167.3),
					new Ponto(555.4, 172.1),
					new Ponto(548.3, 183.7),
					new Ponto(535.8, 183.7),
					new Ponto(530.4, 171.1),
					new Ponto(521.7, 171.1),
					new Ponto(514.0, 183.7),
					new Ponto(501.4, 183.7),
					new Ponto(492.1, 166.6),
					new Ponto(507.0, 140.6),
					new Ponto(522.0, 140.6),
					new Ponto(537.1, 111.5),
					new Ponto(543.0, 111.5)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.Ucrania,Continente.Europa, new Ponto[] {
					new Ponto(611.6, 254.4),
					new Ponto(620.1, 239.5),
					new Ponto(600.8, 205.9),
					new Ponto(581.8, 237.9),
					new Ponto(607.9, 283.7),
					new Ponto(619.0, 264.9)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.ArabiaSaudita,Continente.Asia, new Ponto[] {
					new Ponto(646.2, 423.6),
					new Ponto(639.1, 434.7),
					new Ponto(649.1, 450.3),
					new Ponto(699.0, 450.3),
					new Ponto(726.6, 403.0),
					new Ponto(716.8, 387.3),
					new Ponto(680.5, 387.3),
					new Ponto(654.0, 342.4),
					new Ponto(627.4, 388.2)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.Bangladesh,Continente.Asia, new Ponto[] {
					new Ponto(885.3, 350.0),
					new Ponto(847.8, 350.0),
					new Ponto(828.7, 383.5),
					new Ponto(842.1, 410.9),
					new Ponto(848.1, 410.9),
					new Ponto(859.7, 432.6),
					new Ponto(854.7, 441.3),
					new Ponto(870.5, 470.8),
					new Ponto(879.3, 458.8),
					new Ponto(879.3, 456.0),
					new Ponto(872.2, 444.6),
					new Ponto(879.9, 432.5),
					new Ponto(859.2, 396.3)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.Cazaquistao,Continente.Asia, new Ponto[] {
					new Ponto(907.9, 201.9),
					new Ponto(920.4, 222.6),
					new Ponto(906.1, 246.4),
					new Ponto(784.1, 246.4),
					new Ponto(772.1, 224.1),
					new Ponto(724.7, 224.1),
					new Ponto(739.0, 201.9)}, deslocaX,deslocaY));
				
			lstTerritorios.add(new Territorio(nomePais.Mongolia,Continente.Asia, new Ponto[] {
					new Ponto(906.1, 246.4),
					new Ponto(804.9, 246.4),
					new Ponto(822.0, 278.5),
					new Ponto(873.9, 278.5),
					new Ponto(894.6, 278.5),
					new Ponto(906.1, 300.4),
					new Ponto(916.3, 287.4),
					new Ponto(902.8, 264.5),
					new Ponto(910.3, 254.7)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.China,Continente.Asia, new Ponto[] {
					new Ponto(873.9, 278.5),
					new Ponto(822.0, 278.5),
					new Ponto(804.9, 246.5),
					new Ponto(784.1, 246.5),
					new Ponto(773.5, 264.0),
					new Ponto(764.7, 278.9),
					new Ponto(754.8, 297.2),
					new Ponto(785.5, 348.8),
					new Ponto(785.5, 350.5),
					new Ponto(811.9, 350.5),
					new Ponto(838.9, 302.5),
					new Ponto(887.9, 302.5)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.CoreiaDoNorte,Continente.Asia, new Ponto[] { 
					new Ponto(839.0, 302.2),
					new Ponto(825.3, 326.1),
					new Ponto(914.9, 326.1),
					new Ponto(908.2, 314.2),
					new Ponto(894.1, 314.2),
					new Ponto(888.0, 302.2)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.CoreiaDoSul,Continente.Asia, new Ponto[] {
					new Ponto(914.9, 326.1),
					new Ponto(922.1, 337.2),
					new Ponto(915.5, 350.0),
					new Ponto(811.9, 350.0),
					new Ponto(825.3, 326.1)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.Estonia,Continente.Asia, new Ponto[] {
					new Ponto(735.3, 123.8),
					new Ponto(659.5, 123.8),
					new Ponto(650.1, 144.1),
					new Ponto(630.0, 144.1),
					new Ponto(614.8, 117.0),
					new Ponto(628.2, 117.0),
					new Ponto(632.0, 124.2),
					new Ponto(644.4, 124.2),
					new Ponto(632.6, 101.5),
					new Ponto(607.8, 101.5),
					new Ponto(604.9, 96.6),
					new Ponto(582.5, 96.6),
					new Ponto(626.8, 173.1),
					new Ponto(706.8, 173.1)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.India,Continente.Asia, new Ponto[] {
					new Ponto(798.0, 450.3),
					new Ponto(763.8, 387.8),
					new Ponto(785.5, 351.2),
					new Ponto(785.5, 350.0),
					new Ponto(847.8, 350.0),
					new Ponto(808.0, 420.0),
					new Ponto(812.3, 427.5)}, deslocaX,deslocaY));

			lstTerritorios.add( new Territorio(nomePais.Ira,Continente.Asia, new Ponto[] {
					new Ponto(716.8, 310.2),
					new Ponto(701.1, 310.2),
					new Ponto(691.0, 329.0),
					new Ponto(703.0, 351.2),
					new Ponto(716.5, 375.9),
					new Ponto(733.6, 375.9),
					new Ponto(739.9, 387.8),
					new Ponto(751.3, 370.1)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.Iraque,Continente.Asia, new Ponto[] {
					new Ponto(703.0, 351.2),
					new Ponto(694.0, 362.7),
					new Ponto(694.0, 364.8),
					new Ponto(706.5, 387.3),
					new Ponto(680.5, 387.3),
					new Ponto(654.0, 342.4),
					new Ponto(671.9, 310.2),
					new Ponto(701.1, 310.2),
					new Ponto(691.0, 329.0)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.Japao,Continente.Asia, new Ponto[] {
					new Ponto(937.3, 222.4),
					new Ponto(956.3, 254.3),
					new Ponto(953.7, 257.5),
					new Ponto(965.5, 276.8),
					new Ponto(955.4, 293.3),
					new Ponto(947.6, 293.3),
					new Ponto(940.0, 307.4),
					new Ponto(921.9, 307.4),
					new Ponto(930.2, 293.0),
					new Ponto(927.9, 288.6),
					new Ponto(933.8, 279.7),
					new Ponto(939.4, 279.7),
					new Ponto(943.7, 269.9),
					new Ponto(927.1, 239.4)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.Jordania,Continente.Asia, new Ponto[] {
					new Ponto(621.9, 378.5),
					new Ponto(612.8, 378.5),
					new Ponto(602.1, 357.1),
					new Ponto(615.7, 337.6),
					new Ponto(633.6, 337.6),
					new Ponto(649.1, 310.2),
					new Ponto(671.9, 310.2),
					new Ponto(654.0, 342.4),
					new Ponto(627.4, 388.2)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.Letonia,Continente.Asia, new Ponto[] {
					new Ponto(610.2, 144.5),
					new Ponto(591.0, 176.0),
					new Ponto(583.6, 176.0),
					new Ponto(611.2, 224.1),
					new Ponto(724.7, 224.1),
					new Ponto(739.0, 201.9),
					new Ponto(724.7, 173.1),
					new Ponto(626.8, 173.1)}, deslocaX,deslocaY));

				

			lstTerritorios.add(new Territorio(nomePais.Paquistao,Continente.Asia, new Ponto[] {
					new Ponto(763.8, 387.8),
					new Ponto(739.9, 387.8),
					new Ponto(751.3, 370.1),
					new Ponto(708.9, 296.4),
					new Ponto(718.3, 278.9),
					new Ponto(764.7, 278.9),
					new Ponto(754.8, 297.2),
					new Ponto(785.5, 348.8),
					new Ponto(785.5, 351.2)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.Russia,Continente.Asia, new Ponto[] {
					new Ponto(744.4, 125.0),
					new Ponto(742.5, 129.9),
					new Ponto(748.2, 129.9),
					new Ponto(744.1, 136.7),
					new Ponto(728.4, 136.7),
					new Ponto(706.7, 173.1),
					new Ponto(724.7, 173.1),
					new Ponto(739.0, 201.9),
					new Ponto(825.0, 201.9),
					new Ponto(869.9, 125.0)}, deslocaX,deslocaY));

			lstTerritorios.add(new Territorio(nomePais.Siberia,Continente.Asia, new Ponto[] {
					new Ponto(949.4, 204.5),
					new Ponto(956.8, 191.1),
					new Ponto(940.9, 162.5),
					new Ponto(947.1, 155.2),
					new Ponto(940.9, 144.4),
					new Ponto(954.0, 144.4),
					new Ponto(937.8, 117.0),
					new Ponto(875.3, 117.0),
					new Ponto(870.6, 124.9),
					new Ponto(825.0, 201.9),
					new Ponto(888.4, 201.9),
					new Ponto(877.3, 187.8),
					new Ponto(885.4, 176.1),
					new Ponto(907.5, 176.1),
					new Ponto(916.3, 159.9),
					new Ponto(930.5, 183.1),
					new Ponto(938.0, 183.1)}, deslocaX,deslocaY));

			lstTerritorios.add( new Territorio(nomePais.Siria,Continente.Asia, new Ponto[] {
					new Ponto(660.8, 272.8),
					new Ponto(664.6, 278.9),
					new Ponto(718.3, 278.9),
					new Ponto(708.9, 296.4),
					new Ponto(716.8, 310.2),
					new Ponto(637.0, 310.2),
					new Ponto(637.0, 306.2),
					new Ponto(628.7, 306.6),
					new Ponto(619.6, 291.5),
					new Ponto(628.7, 275.8),
					new Ponto(646.1, 275.8),
					new Ponto(647.3, 272.8)}, deslocaX,deslocaY));

			lstTerritorios.add( new Territorio(nomePais.Tailandia,Continente.Asia, new Ponto[] {
					new Ponto(915.5, 350.0),
					new Ponto(885.3, 350.0),
					new Ponto(859.2, 396.3),
					new Ponto(879.9, 432.5),
					new Ponto(887.3, 446.2),
					new Ponto(895.1, 446.2),
					new Ponto(901.8, 432.5),
					new Ponto(897.5, 426.0),
					new Ponto(901.8, 420.7),
					new Ponto(887.0, 398.1),
					new Ponto(892.9, 389.8),
					new Ponto(895.9, 395.1),
					new Ponto(908.7, 395.1),
					new Ponto(911.4, 387.6),
					new Ponto(919.1, 387.6),
					new Ponto(927.4, 370.3)}, deslocaX,deslocaY));

			lstTerritorios.add( new Territorio(nomePais.Turquia,Continente.Asia, new Ponto[] {
					new Ponto(683.6, 278.9),
					new Ponto(691.0, 268.9),
					new Ponto(678.5, 247.4),
					new Ponto(668.1, 247.4),
					new Ponto(664.5, 240.9),
					new Ponto(651.9, 240.9),
					new Ponto(646.3, 251.2),
					new Ponto(639.4, 239.5),
					new Ponto(620.1, 239.5),
					new Ponto(611.2, 224.1),
					new Ponto(772.1, 224.1),
					new Ponto(784.1, 246.4),
					new Ponto(764.7, 278.9)}, deslocaX,deslocaY));

			lstTerritorios.add( new Territorio(nomePais.Australia,Continente.Oceania, new Ponto[] {
					new Ponto(875.1, 539.4),
					new Ponto(885.9, 539.4),
					new Ponto(919.7, 598.0),
					new Ponto(911.5, 611.8),
					new Ponto(917.6, 623.4),
					new Ponto(901.8, 650.0),
					new Ponto(891.1, 650.0),
					new Ponto(877.6, 673.5),
					new Ponto(846.1, 673.5),
					new Ponto(837.9, 655.8),
					new Ponto(823.4, 655.8),
					new Ponto(816.7, 641.9)}, deslocaX,deslocaY));

			lstTerritorios.add( new Territorio(nomePais.Indonesia,Continente.Oceania, new Ponto[] {
					new Ponto(850.9, 480.7),
					new Ponto(861.3, 500.4),
					new Ponto(880.7, 500.4),
					new Ponto(887.7, 486.3),
					new Ponto(902.5, 486.3),
					new Ponto(907.6, 498.3),
					new Ponto(925.2, 498.3),
					new Ponto(935.6, 517.9),
					new Ponto(943.8, 517.9),
					new Ponto(954.3, 536.6),
					new Ponto(928.3, 536.6),
					new Ponto(920.3, 522.0),
					new Ponto(907.2, 522.0),
					new Ponto(904.7, 528.9),
					new Ponto(890.3, 528.9),
					new Ponto(885.3, 517.5),
					new Ponto(849.0, 517.5),
					new Ponto(835.2, 490.0),
					new Ponto(841.0, 480.7)}, deslocaX,deslocaY));

			lstTerritorios.add( new Territorio(nomePais.NovaZelandia,Continente.Oceania, new Ponto[] {
					new Ponto(928.8, 601.5),
					new Ponto(936.9, 601.5),
					new Ponto(943.0, 613.7),
					new Ponto(939.8, 616.5),
					new Ponto(944.2, 616.5),
					new Ponto(950.3, 628.6),
					new Ponto(931.9, 661.5),
					new Ponto(926.6, 661.5),
					new Ponto(917.6, 678.5),
					new Ponto(900.1, 678.5),
					new Ponto(917.6, 644.5),
					new Ponto(922.9, 644.5),
					new Ponto(932.3, 627.8),
					new Ponto(928.0, 619.1),
					new Ponto(934.1, 610.0)}, deslocaX,deslocaY));

			lstTerritorios.add( new Territorio(nomePais.Perth,Continente.Oceania, new Ponto[] {
					new Ponto(856.7, 535.5),
					new Ponto(839.2, 535.5),
					new Ponto(822.3, 565.8),
					new Ponto(799.1, 565.8),
					new Ponto(789.6, 584.3),
					new Ponto(781.3, 584.3),
					new Ponto(775.3, 595.7),
					new Ponto(775.3, 598.3),
					new Ponto(782.3, 608.6),
					new Ponto(782.3, 610.7),
					new Ponto(770.9, 630.1),
					new Ponto(763.5, 630.1),
					new Ponto(756.7, 639.9),
					new Ponto(766.4, 655.8),
					new Ponto(780.3, 655.8),
					new Ponto(787.3, 641.9),
					new Ponto(816.7, 641.9),
					new Ponto(861.6, 562.1),
					new Ponto(855.6, 550.2),
					new Ponto(862.4, 542.3)}, deslocaX,deslocaY));

			
			//Alaska
			lstTerritorios.get(0).lstFronteirasAdd(buscaTerritorio(nomePais.Siberia));
			lstTerritorios.get(0).lstFronteirasAdd(buscaTerritorio(nomePais.Calgary));
			lstTerritorios.get(0).lstFronteirasAdd(buscaTerritorio(nomePais.Vancouver));
			//Calgary
			lstTerritorios.get(1).lstFronteirasAdd(buscaTerritorio(nomePais.Alasca));
			lstTerritorios.get(1).lstFronteirasAdd(buscaTerritorio(nomePais.Groelandia));
			lstTerritorios.get(1).lstFronteirasAdd(buscaTerritorio(nomePais.Vancouver));
			//Groelandia
			lstTerritorios.get(2).lstFronteirasAdd(buscaTerritorio(nomePais.Calgary));
			lstTerritorios.get(2).lstFronteirasAdd(buscaTerritorio(nomePais.Quebec));
			lstTerritorios.get(2).lstFronteirasAdd(buscaTerritorio(nomePais.ReinoUnido));
			//Vancouver
			lstTerritorios.get(3).lstFronteirasAdd(buscaTerritorio(nomePais.Alasca));
			lstTerritorios.get(3).lstFronteirasAdd(buscaTerritorio(nomePais.Calgary));
			lstTerritorios.get(3).lstFronteirasAdd(buscaTerritorio(nomePais.Quebec));
			lstTerritorios.get(3).lstFronteirasAdd(buscaTerritorio(nomePais.Texas));
			lstTerritorios.get(3).lstFronteirasAdd(buscaTerritorio(nomePais.NovaYork));
			//Quebec
			lstTerritorios.get(4).lstFronteirasAdd(buscaTerritorio(nomePais.Vancouver));
			lstTerritorios.get(4).lstFronteirasAdd(buscaTerritorio(nomePais.Texas));
			lstTerritorios.get(4).lstFronteirasAdd(buscaTerritorio(nomePais.NovaYork));		
			//California
			lstTerritorios.get(5).lstFronteirasAdd(buscaTerritorio(nomePais.Vancouver));
			lstTerritorios.get(5).lstFronteirasAdd(buscaTerritorio(nomePais.Texas));
			lstTerritorios.get(5).lstFronteirasAdd(buscaTerritorio(nomePais.Mexico));
			//Texas
			lstTerritorios.get(6).lstFronteirasAdd(buscaTerritorio(nomePais.Vancouver));
			lstTerritorios.get(6).lstFronteirasAdd(buscaTerritorio(nomePais.Quebec));
			lstTerritorios.get(6).lstFronteirasAdd(buscaTerritorio(nomePais.California));
			lstTerritorios.get(6).lstFronteirasAdd(buscaTerritorio(nomePais.NovaYork));
			lstTerritorios.get(6).lstFronteirasAdd(buscaTerritorio(nomePais.Mexico));
			//NovaYork
			lstTerritorios.get(7).lstFronteirasAdd(buscaTerritorio(nomePais.Quebec));
			lstTerritorios.get(7).lstFronteirasAdd(buscaTerritorio(nomePais.Texas));
			//Mexico
			lstTerritorios.get(8).lstFronteirasAdd(buscaTerritorio(nomePais.California));
			lstTerritorios.get(8).lstFronteirasAdd(buscaTerritorio(nomePais.Texas));
			//Venezuela
			lstTerritorios.get(9).lstFronteirasAdd(buscaTerritorio(nomePais.Mexico));
			lstTerritorios.get(9).lstFronteirasAdd(buscaTerritorio(nomePais.Brasil));
			lstTerritorios.get(9).lstFronteirasAdd(buscaTerritorio(nomePais.Peru));
			//Peru
			lstTerritorios.get(10).lstFronteirasAdd(buscaTerritorio(nomePais.Venezuela));
			lstTerritorios.get(10).lstFronteirasAdd(buscaTerritorio(nomePais.Brasil));
			lstTerritorios.get(10).lstFronteirasAdd(buscaTerritorio(nomePais.Argentina));
			//Brasil
			lstTerritorios.get(11).lstFronteirasAdd(buscaTerritorio(nomePais.Venezuela));
			lstTerritorios.get(11).lstFronteirasAdd(buscaTerritorio(nomePais.Peru));
			lstTerritorios.get(11).lstFronteirasAdd(buscaTerritorio(nomePais.Argentina));
			lstTerritorios.get(11).lstFronteirasAdd(buscaTerritorio(nomePais.Argelia));		
			//Argentina
			lstTerritorios.get(12).lstFronteirasAdd(buscaTerritorio(nomePais.Peru));
			lstTerritorios.get(12).lstFronteirasAdd(buscaTerritorio(nomePais.Brasil));
			//Africa do Sul
			lstTerritorios.get(13).lstFronteirasAdd(buscaTerritorio(nomePais.Angola));
			lstTerritorios.get(13).lstFronteirasAdd(buscaTerritorio(nomePais.Somalia));
			//Angola
			lstTerritorios.get(14).lstFronteirasAdd(buscaTerritorio(nomePais.Nigeria));
			lstTerritorios.get(14).lstFronteirasAdd(buscaTerritorio(nomePais.Somalia));
			lstTerritorios.get(14).lstFronteirasAdd(buscaTerritorio(nomePais.AfricaDoSul));
			//Argelia
			lstTerritorios.get(15).lstFronteirasAdd(buscaTerritorio(nomePais.Espanha));
			lstTerritorios.get(15).lstFronteirasAdd(buscaTerritorio(nomePais.Italia));
			lstTerritorios.get(15).lstFronteirasAdd(buscaTerritorio(nomePais.Egito));
			lstTerritorios.get(15).lstFronteirasAdd(buscaTerritorio(nomePais.Nigeria));
			//Egito
			lstTerritorios.get(16).lstFronteirasAdd(buscaTerritorio(nomePais.Romenia));
			lstTerritorios.get(16).lstFronteirasAdd(buscaTerritorio(nomePais.Argelia));
			lstTerritorios.get(16).lstFronteirasAdd(buscaTerritorio(nomePais.Nigeria));
			lstTerritorios.get(16).lstFronteirasAdd(buscaTerritorio(nomePais.Somalia));
			lstTerritorios.get(16).lstFronteirasAdd(buscaTerritorio(nomePais.Jordania));
			//Nigeria
			lstTerritorios.get(17).lstFronteirasAdd(buscaTerritorio(nomePais.Brasil));
			lstTerritorios.get(17).lstFronteirasAdd(buscaTerritorio(nomePais.Argelia));
			lstTerritorios.get(17).lstFronteirasAdd(buscaTerritorio(nomePais.Egito));
			lstTerritorios.get(17).lstFronteirasAdd(buscaTerritorio(nomePais.Somalia));
			lstTerritorios.get(17).lstFronteirasAdd(buscaTerritorio(nomePais.Angola));
			//Somalia
			lstTerritorios.get(18).lstFronteirasAdd(buscaTerritorio(nomePais.Egito));
			lstTerritorios.get(18).lstFronteirasAdd(buscaTerritorio(nomePais.Nigeria));
			lstTerritorios.get(18).lstFronteirasAdd(buscaTerritorio(nomePais.Angola));
			lstTerritorios.get(18).lstFronteirasAdd(buscaTerritorio(nomePais.AfricaDoSul));
			lstTerritorios.get(18).lstFronteirasAdd(buscaTerritorio(nomePais.ArabiaSaudita));
			//Espanha
			lstTerritorios.get(19).lstFronteirasAdd(buscaTerritorio(nomePais.Argelia));
			lstTerritorios.get(19).lstFronteirasAdd(buscaTerritorio(nomePais.Franca));
			//Franca
			lstTerritorios.get(20).lstFronteirasAdd(buscaTerritorio(nomePais.Espanha));
			lstTerritorios.get(20).lstFronteirasAdd(buscaTerritorio(nomePais.ReinoUnido));
			lstTerritorios.get(20).lstFronteirasAdd(buscaTerritorio(nomePais.Italia));
			lstTerritorios.get(20).lstFronteirasAdd(buscaTerritorio(nomePais.Suecia));
			//Italia
			lstTerritorios.get(21).lstFronteirasAdd(buscaTerritorio(nomePais.Franca));
			lstTerritorios.get(21).lstFronteirasAdd(buscaTerritorio(nomePais.Suecia));
			lstTerritorios.get(21).lstFronteirasAdd(buscaTerritorio(nomePais.Polonia));
			lstTerritorios.get(21).lstFronteirasAdd(buscaTerritorio(nomePais.Romenia));
			//Pol�nia
			lstTerritorios.get(22).lstFronteirasAdd(buscaTerritorio(nomePais.Letonia));
			lstTerritorios.get(22).lstFronteirasAdd(buscaTerritorio(nomePais.Italia));
			lstTerritorios.get(22).lstFronteirasAdd(buscaTerritorio(nomePais.Romenia));
			lstTerritorios.get(22).lstFronteirasAdd(buscaTerritorio(nomePais.Ucrania));
			//Reino Unido
			lstTerritorios.get(23).lstFronteirasAdd(buscaTerritorio(nomePais.Groelandia));
			lstTerritorios.get(23).lstFronteirasAdd(buscaTerritorio(nomePais.Franca));
			//Romania
			lstTerritorios.get(24).lstFronteirasAdd(buscaTerritorio(nomePais.Italia));
			lstTerritorios.get(24).lstFronteirasAdd(buscaTerritorio(nomePais.Polonia));
			lstTerritorios.get(24).lstFronteirasAdd(buscaTerritorio(nomePais.Ucrania));
			lstTerritorios.get(24).lstFronteirasAdd(buscaTerritorio(nomePais.Egito));
			//Suecia
			lstTerritorios.get(25).lstFronteirasAdd(buscaTerritorio(nomePais.Franca));
			lstTerritorios.get(25).lstFronteirasAdd(buscaTerritorio(nomePais.Polonia));
			lstTerritorios.get(25).lstFronteirasAdd(buscaTerritorio(nomePais.Estonia));
			lstTerritorios.get(25).lstFronteirasAdd(buscaTerritorio(nomePais.Letonia));
			//Ucrania
			lstTerritorios.get(26).lstFronteirasAdd(buscaTerritorio(nomePais.Polonia));
			lstTerritorios.get(26).lstFronteirasAdd(buscaTerritorio(nomePais.Letonia));
			lstTerritorios.get(26).lstFronteirasAdd(buscaTerritorio(nomePais.Turquia));
			lstTerritorios.get(26).lstFronteirasAdd(buscaTerritorio(nomePais.Romenia));
			//Arabia Saudita
			lstTerritorios.get(27).lstFronteirasAdd(buscaTerritorio(nomePais.Somalia));
			lstTerritorios.get(27).lstFronteirasAdd(buscaTerritorio(nomePais.Jordania));
			lstTerritorios.get(27).lstFronteirasAdd(buscaTerritorio(nomePais.Iraque));
			//Bangladesh
			lstTerritorios.get(28).lstFronteirasAdd(buscaTerritorio(nomePais.India));
			lstTerritorios.get(28).lstFronteirasAdd(buscaTerritorio(nomePais.CoreiaDoSul));
			lstTerritorios.get(28).lstFronteirasAdd(buscaTerritorio(nomePais.Tailandia));
			lstTerritorios.get(28).lstFronteirasAdd(buscaTerritorio(nomePais.Indonesia));
			//Cazaquistao
			lstTerritorios.get(29).lstFronteirasAdd(buscaTerritorio(nomePais.Letonia));
			lstTerritorios.get(29).lstFronteirasAdd(buscaTerritorio(nomePais.Russia));
			lstTerritorios.get(29).lstFronteirasAdd(buscaTerritorio(nomePais.Siberia));
			lstTerritorios.get(29).lstFronteirasAdd(buscaTerritorio(nomePais.Japao));
			lstTerritorios.get(29).lstFronteirasAdd(buscaTerritorio(nomePais.Mongolia));
			lstTerritorios.get(29).lstFronteirasAdd(buscaTerritorio(nomePais.China));
			lstTerritorios.get(29).lstFronteirasAdd(buscaTerritorio(nomePais.Turquia));
			//Mongolia
			lstTerritorios.get(30).lstFronteirasAdd(buscaTerritorio(nomePais.Cazaquistao));
			lstTerritorios.get(30).lstFronteirasAdd(buscaTerritorio(nomePais.Japao));
			lstTerritorios.get(30).lstFronteirasAdd(buscaTerritorio(nomePais.China));
			//China
			lstTerritorios.get(31).lstFronteirasAdd(buscaTerritorio(nomePais.Turquia));
			lstTerritorios.get(31).lstFronteirasAdd(buscaTerritorio(nomePais.Cazaquistao));
			lstTerritorios.get(31).lstFronteirasAdd(buscaTerritorio(nomePais.Mongolia));
			lstTerritorios.get(31).lstFronteirasAdd(buscaTerritorio(nomePais.CoreiaDoNorte));
			lstTerritorios.get(31).lstFronteirasAdd(buscaTerritorio(nomePais.CoreiaDoSul));
			lstTerritorios.get(31).lstFronteirasAdd(buscaTerritorio(nomePais.India));
			lstTerritorios.get(31).lstFronteirasAdd(buscaTerritorio(nomePais.Paquistao));

			//Coreia do Norte
			lstTerritorios.get(32).lstFronteirasAdd(buscaTerritorio(nomePais.China));
			lstTerritorios.get(32).lstFronteirasAdd(buscaTerritorio(nomePais.Japao));
			lstTerritorios.get(32).lstFronteirasAdd(buscaTerritorio(nomePais.CoreiaDoSul));
			//Coreia do Sul
			lstTerritorios.get(33).lstFronteirasAdd(buscaTerritorio(nomePais.China));
			lstTerritorios.get(33).lstFronteirasAdd(buscaTerritorio(nomePais.CoreiaDoNorte));
			lstTerritorios.get(33).lstFronteirasAdd(buscaTerritorio(nomePais.Tailandia));
			lstTerritorios.get(33).lstFronteirasAdd(buscaTerritorio(nomePais.Bangladesh));
			lstTerritorios.get(33).lstFronteirasAdd(buscaTerritorio(nomePais.India));
			//Estonia
			lstTerritorios.get(34).lstFronteirasAdd(buscaTerritorio(nomePais.Suecia));
			lstTerritorios.get(34).lstFronteirasAdd(buscaTerritorio(nomePais.Russia));
			lstTerritorios.get(34).lstFronteirasAdd(buscaTerritorio(nomePais.Letonia));
			//India
			lstTerritorios.get(35).lstFronteirasAdd(buscaTerritorio(nomePais.Paquistao));
			lstTerritorios.get(35).lstFronteirasAdd(buscaTerritorio(nomePais.China));
			lstTerritorios.get(35).lstFronteirasAdd(buscaTerritorio(nomePais.CoreiaDoSul));
			lstTerritorios.get(35).lstFronteirasAdd(buscaTerritorio(nomePais.Bangladesh));
			lstTerritorios.get(35).lstFronteirasAdd(buscaTerritorio(nomePais.Indonesia));
			//Ira
			lstTerritorios.get(36).lstFronteirasAdd(buscaTerritorio(nomePais.Siria));
			lstTerritorios.get(36).lstFronteirasAdd(buscaTerritorio(nomePais.Paquistao));
			lstTerritorios.get(36).lstFronteirasAdd(buscaTerritorio(nomePais.Iraque));
			//Iraque
			lstTerritorios.get(37).lstFronteirasAdd(buscaTerritorio(nomePais.Jordania));
			lstTerritorios.get(37).lstFronteirasAdd(buscaTerritorio(nomePais.Siria));
			lstTerritorios.get(37).lstFronteirasAdd(buscaTerritorio(nomePais.Ira));
			lstTerritorios.get(37).lstFronteirasAdd(buscaTerritorio(nomePais.ArabiaSaudita));
			//Japao
			lstTerritorios.get(38).lstFronteirasAdd(buscaTerritorio(nomePais.Cazaquistao));
			lstTerritorios.get(38).lstFronteirasAdd(buscaTerritorio(nomePais.Mongolia));
			lstTerritorios.get(38).lstFronteirasAdd(buscaTerritorio(nomePais.CoreiaDoNorte));
			//Jordania
			lstTerritorios.get(39).lstFronteirasAdd(buscaTerritorio(nomePais.Siria));
			lstTerritorios.get(39).lstFronteirasAdd(buscaTerritorio(nomePais.Iraque));
			lstTerritorios.get(39).lstFronteirasAdd(buscaTerritorio(nomePais.ArabiaSaudita));
			lstTerritorios.get(39).lstFronteirasAdd(buscaTerritorio(nomePais.Egito));
			//Letonia
			lstTerritorios.get(40).lstFronteirasAdd(buscaTerritorio(nomePais.Polonia));
			lstTerritorios.get(40).lstFronteirasAdd(buscaTerritorio(nomePais.Suecia));
			lstTerritorios.get(40).lstFronteirasAdd(buscaTerritorio(nomePais.Estonia));
			lstTerritorios.get(40).lstFronteirasAdd(buscaTerritorio(nomePais.Russia));
			lstTerritorios.get(40).lstFronteirasAdd(buscaTerritorio(nomePais.Cazaquistao));
			lstTerritorios.get(40).lstFronteirasAdd(buscaTerritorio(nomePais.Turquia));
			lstTerritorios.get(40).lstFronteirasAdd(buscaTerritorio(nomePais.Ucrania));
			//Paquistao
			lstTerritorios.get(41).lstFronteirasAdd(buscaTerritorio(nomePais.Siria));
			lstTerritorios.get(41).lstFronteirasAdd(buscaTerritorio(nomePais.Turquia));
			lstTerritorios.get(41).lstFronteirasAdd(buscaTerritorio(nomePais.China));
			lstTerritorios.get(41).lstFronteirasAdd(buscaTerritorio(nomePais.India));
			lstTerritorios.get(41).lstFronteirasAdd(buscaTerritorio(nomePais.Ira));
			//Russia
			lstTerritorios.get(42).lstFronteirasAdd(buscaTerritorio(nomePais.Estonia));
			lstTerritorios.get(42).lstFronteirasAdd(buscaTerritorio(nomePais.Siberia));
			lstTerritorios.get(42).lstFronteirasAdd(buscaTerritorio(nomePais.Cazaquistao));
			lstTerritorios.get(42).lstFronteirasAdd(buscaTerritorio(nomePais.Letonia));
			//Siberia
			lstTerritorios.get(43).lstFronteirasAdd(buscaTerritorio(nomePais.Russia));
			lstTerritorios.get(43).lstFronteirasAdd(buscaTerritorio(nomePais.Alasca));
			lstTerritorios.get(43).lstFronteirasAdd(buscaTerritorio(nomePais.Cazaquistao));
			//Siria
			lstTerritorios.get(44).lstFronteirasAdd(buscaTerritorio(nomePais.Turquia));
			lstTerritorios.get(44).lstFronteirasAdd(buscaTerritorio(nomePais.Paquistao));
			lstTerritorios.get(44).lstFronteirasAdd(buscaTerritorio(nomePais.Ira));
			lstTerritorios.get(44).lstFronteirasAdd(buscaTerritorio(nomePais.Iraque));
			lstTerritorios.get(44).lstFronteirasAdd(buscaTerritorio(nomePais.Jordania));
			//Tailandia
			lstTerritorios.get(45).lstFronteirasAdd(buscaTerritorio(nomePais.CoreiaDoSul));
			lstTerritorios.get(45).lstFronteirasAdd(buscaTerritorio(nomePais.Bangladesh));
			//Turquia
			lstTerritorios.get(46).lstFronteirasAdd(buscaTerritorio(nomePais.Letonia));
			lstTerritorios.get(46).lstFronteirasAdd(buscaTerritorio(nomePais.Cazaquistao));
			lstTerritorios.get(46).lstFronteirasAdd(buscaTerritorio(nomePais.China));
			lstTerritorios.get(46).lstFronteirasAdd(buscaTerritorio(nomePais.Paquistao));
			lstTerritorios.get(46).lstFronteirasAdd(buscaTerritorio(nomePais.Siria));
			//Australia
			lstTerritorios.get(47).lstFronteirasAdd(buscaTerritorio(nomePais.Perth));
			lstTerritorios.get(47).lstFronteirasAdd(buscaTerritorio(nomePais.Indonesia));
			lstTerritorios.get(47).lstFronteirasAdd(buscaTerritorio(nomePais.NovaZelandia));
			//Indonesia
			lstTerritorios.get(48).lstFronteirasAdd(buscaTerritorio(nomePais.India));
			lstTerritorios.get(48).lstFronteirasAdd(buscaTerritorio(nomePais.Bangladesh));
			lstTerritorios.get(48).lstFronteirasAdd(buscaTerritorio(nomePais.Australia));
			lstTerritorios.get(48).lstFronteirasAdd(buscaTerritorio(nomePais.NovaZelandia));
			//Nova Zelandia
			lstTerritorios.get(49).lstFronteirasAdd(buscaTerritorio(nomePais.Australia));
			lstTerritorios.get(49).lstFronteirasAdd(buscaTerritorio(nomePais.Indonesia));
			//Perth
			lstTerritorios.get(50).lstFronteirasAdd(buscaTerritorio(nomePais.Australia));			
		}
		
		static public Territorio buscaTerritorio (nomePais nomeTerritorio){
			
			for(Territorio t:lstTerritorios){			
				if(t.getNome()==nomeTerritorio)			
					return t;
			}
			return null;
		}
		static public ArrayList<Territorio> copyLstTerritorios (){
			ArrayList<Territorio> newList = new ArrayList<Territorio>(lstTerritorios);
			return newList;
		}
		static public List<Territorio> getLstTerritorios(){
			return lstTerritorios;
		}
}
