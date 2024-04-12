import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Frame> frames = new ArrayList<>();
    private int totalScore;

    public Player(String name) {
        this.name = name;
        // Inicializa el primer frame
        frames.add(new Frame(frames.size() == 9));
    }

    public void addRoll(int pins) {
        Frame currentFrame = getCurrentFrame();
        currentFrame.addRoll(pins);
        if (currentFrame.isComplete() && frames.size() < 10) {
            frames.add(new Frame(frames.size() == 9)); // Añadir un nuevo frame si es necesario
        }
    }

    private Frame getCurrentFrame() {
        return frames.get(frames.size() - 1); // Siempre trabaja en el último frame
    }


    public int calculateTotalScore() {
        int score = 0;
        for (int i = 0; i < frames.size(); i++) {
            Frame frame = frames.get(i);
            score += frame.getScore();
            if (frame.isStrike() && i < frames.size() - 1) {
                score += frames.get(i + 1).getRoll(0);
                if (frames.get(i + 1).isStrike() && i < frames.size() - 2) {
                    score += frames.get(i + 2).getRoll(0);
                } else {
                    score += frames.get(i + 1).getRoll(1);
                }
            } else if (frame.isSpare() && i < frames.size() - 1) {
                score += frames.get(i + 1).getRoll(0);
            }
        }
        return score;
    }




    public String getName(){
        return name;
    }

    public void printScore() {
        System.out.println("Puntuación de " + name + ":");
        for (int i = 0; i < frames.size(); i++) {
            System.out.println("Frame " + (i + 1) + ": " + frames.get(i).getScore()); // Imprimir por frame
        }
        System.out.println("Puntuación total: " + calculateTotalScore()); // Iprimir puntuacin total
    }


}
