package supports;

import java.util.ArrayList;

public class Helper {
    public static ArrayList<String> transferToString(ArrayList<Share> shares){

        ArrayList<String> transferred = new ArrayList<>();

        for (int i=0; i<shares.size(); i++){
            String res = "";
            res+= shares.get(i).simpleString();
            transferred.add(res);
        }

        return transferred;
    }
}
