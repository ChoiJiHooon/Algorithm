package week5;

import java.io.*;
import java.util.*;

public class p00_31844_창고던지기_cjh {
	static int robot, box, ans, target;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        robot = -1; box = -1; target = -1;
        ans = 0; 
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '@') robot = i;
            else if (line.charAt(i) == '#') box = i;
            else if (line.charAt(i) == '!') target = i;
        }
       storage();
       System.out.println(ans);
        
        
        
    }


	static void storage() {
		if (robot > target) {
        	if (robot < box || box < target) {
        		ans =  -1 ; 
        	}else {
        		ans =  robot - target -1 ; 
        	}
        }
        else if (target > robot) {	
        	if (target < box || box < robot) {
        		ans =  -1 ; 
        	} else {
        		ans =  target- robot - 1; 
        	}
        }
		return; 
	}

    
}

