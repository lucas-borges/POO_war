package etc;

import java.awt.Color;

import etc.enumTerritorio.nomePais;

public class enumColor {
	public enum NamedColor {
		  BLUE(Color.BLUE, "azul","AZUIS."),
		  RED(Color.RED,"vermelho", "VERMELHOS."),
		  GREEN(Color.GREEN,"verde","VERDES."),
		  YELLOW(Color.YELLOW,"amarelo","AMARELOS."),
		  WHITE(Color.WHITE,"branco","BRANCOS."),
		  BLACK(Color.BLACK,"preto","PRETOS.")
		  ;

		  private final Color awtColor;
		  private final String colorName;
		  private final String plural;

		  private NamedColor(Color awtColor, String name, String plural) {
		    this.awtColor = awtColor;
		    this.colorName = name;
		    this.plural = plural;
		  }

		  public Color getAwtColor() {
		    return awtColor;
		  }

		  public String getColorName() {
		    return colorName;
		  }
		  public String getColorPlural() {
			    return plural;
			  }
		  
		  public static NamedColor getMatch(Color c){
			  for(NamedColor color : NamedColor.values()){
					if(c.equals(color.getAwtColor())){
						return color;
					}
				}
			  return null;
		  }
		  
		  public static Color getColor(String s){
			  for(NamedColor color : NamedColor.values()){
					if(s.equals(color.getColorName())){
						return color.getAwtColor();
					}
				}
			  return null;
		  }
		}
}
