import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.



        FileReader b = new FileReader();
        String[] text2 = (b.leerTxt2("C:\\Users\\danil\\OneDrive\\Documentos\\text\\prueba.txt"));
        //System.out.println(b);

        String[] solonombre = new String[text2.length];




        Map<String, Player> players = new HashMap<>();
        for (String lineas: text2 ){
            if (lineas != null){
                 String[] parts = lineas.split("\\s+");
                 String playerN = parts[0];
                 int pinsDown;
                    if (parts[1].equalsIgnoreCase("F")){
                        pinsDown=0;
                     }else {
                        pinsDown = Integer.parseInt(parts[1]);
                        }
                Player player = players.computeIfAbsent(playerN, Player::new);

                // Agregar la tirada al jugador correcto
                player.addRoll(pinsDown);

            }
        }
        for (Player player : players.values()) {
            player.printScore();
          }


    }
    }
