package gh2;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    public static final double CONCERT_A=440.0;
    public static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    public static double[] fre=new double[37];
    public static GuitarString[] stringKey=new GuitarString[37];
    public static void creatFre(){
        for (int i = 0; i < keyboard.length(); i++) {
            fre[i]=(CONCERT_A*Math.pow(2,1.0*(i-24)/12));
        }
        for (int i = 0; i < keyboard.length(); i++) {
            stringKey[i]=new GuitarString(fre[i]);
        }
    }

    public static int findItem(char ch){
        for (int i = 0; i < keyboard.length(); i++) {
            if(ch==keyboard.charAt(i)){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        creatFre();

        while(true){
            char key;
            int find = -1;

            if(StdDraw.hasNextKeyTyped()){
                 key=StdDraw.nextKeyTyped();
                find=keyboard.indexOf(key);
                if(find==-1) continue;
                stringKey[find].pluck();
               
            }
            double sample=0.0;
            for (GuitarString string : stringKey) {
                sample+=string.sample();
            }
//            sample/=stringKey.length;
            StdAudio.play(sample);

            for (GuitarString string : stringKey) {
                string.tic();
            }
        }
    }
}
