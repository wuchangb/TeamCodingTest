package Baekjoon.boj4836;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String dance;

        while((dance = br.readLine()) != null) {
            String[] steps = dance.split(" ");
            Set<Integer> errorSteps = new LinkedHashSet<>();
            boolean twirled = false;
            boolean hopAfterTwirl = false;
            boolean firstJiggle = true;

            for (int i = 0; i < steps.length; i++) {
                if (steps[i].equals("jiggle")) {
                    if (firstJiggle || (i > 0 && !steps[i-1].equals("dip"))) {
                        errorSteps.add(1);
                        firstJiggle = false;
                    }
                } else if (steps[i].equals("twirl")) {
                    twirled = true;
                } else if (steps[i].equals("hop")) {
                    if(twirled){
                        hopAfterTwirl = true;
                    }
                }
            }

            if(steps[0].equals("jiggle")) {
                errorSteps.add(4);
            }
            if(!dance.contains("dip")) {
                errorSteps.add(5);
            }
            if(steps.length < 3 || !(steps[steps.length-3].equals("clap") && steps[steps.length-2].equals("stomp") && steps[steps.length-1].equals("clap"))) {
                errorSteps.add(2);
            }
            if(twirled && !hopAfterTwirl) {
                errorSteps.add(3);
            }

            List<Integer> errors = new ArrayList<>(errorSteps);
            if (errors.isEmpty()) {
                System.out.println("form ok: " + dance);
            } else if (errors.size() == 1) {
                System.out.println("form error " + errors.get(0) + ": " + dance);
            } else {
                System.out.print("form errors ");
                for (int i = 0; i < errors.size() - 1; i++) {
                    System.out.print(errors.get(i) + ", ");
                }
                System.out.println(" and " + errors.get(errors.size() - 1) + ": " + dance);
            }
        }
    }
}