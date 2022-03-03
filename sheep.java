import java.util.Random;

public class sheep {
    public sheep(){
        boolean switchDoor = true;
        boolean[] doors = {false, false, false};
        int iterations = 1000;

        Random winningDoorRNG = new Random();
        int winningDoor;

        Random chooseDoorRNG = new Random();
        int chooseDoor;

        Random revealedDoorRNG = new Random();
        int revealedDoor = -1;

        int finalChoice = -1;

        Random chooseTwo = new Random();

        int wins = 0;
        int losses = 0;

        for (int i = 0; i < iterations; i++) {
            winningDoor = winningDoorRNG.nextInt(0,3);
            chooseDoor = chooseDoorRNG.nextInt(0,3);

            doors[winningDoor] = true;

            // set the value of the revealed door
            if (winningDoor == 0 && chooseDoor == 0) {
                revealedDoor = revealedDoorRNG.nextInt(0, 1);
                if (revealedDoor == 0){
                    revealedDoor = 1;
                }
                else {
                    revealedDoor = 2;
                }
            }
            else if (winningDoor == 1 && chooseDoor == 1) {
                revealedDoor = revealedDoorRNG.nextInt(0,1);
                if (revealedDoor == 0){
                    revealedDoor = 0;
                }
                else {
                    revealedDoor = 2;
                }
            }

            else if (winningDoor == 2 && chooseDoor == 2) {
                revealedDoor = revealedDoorRNG.nextInt(0,1);
                if (revealedDoor == 0){
                    revealedDoor = 0;
                }
                else {
                    revealedDoor = 1;
                }
            } else if (winningDoor == 0 && chooseDoor == 1 || winningDoor == 1 && chooseDoor == 0) {
                revealedDoor = 2;
            }
            else if (winningDoor == 0 && chooseDoor == 2 || winningDoor == 2 && chooseDoor == 0) {
                revealedDoor = 1;
            }

            else if (winningDoor == 1 && chooseDoor == 2 || winningDoor == 2 && chooseDoor == 1) {
                revealedDoor = 0;
            }
            else {
                System.out.println("error");
            }



            if (revealedDoor == 0 && chooseDoor == 1 || revealedDoor == 1 && chooseDoor == 0){
                finalChoice = 2;

            }

            else if (revealedDoor == 1 && chooseDoor == 2 || revealedDoor == 2 && chooseDoor == 1){
                finalChoice = 0;
            }

            else if (revealedDoor == 0 && chooseDoor == 2 || revealedDoor == 2 && chooseDoor == 0){
                finalChoice = 1;
            }


            if (finalChoice == winningDoor){
                wins++;
            }
            else{
                losses++;
            }



        }

        System.out.println("Iterations: " + iterations);
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);


    }
    public static void main (String[] args){
        new sheep();
    }



}
