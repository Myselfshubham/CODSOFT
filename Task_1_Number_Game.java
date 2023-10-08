import java.util.*;
class PlayerData{
    private String Name;
    int noOfTimesPlayed;
    int noOfTimesPlayedLimited;
    int noOfTimesWon;
    int noTotalAttempts;
    public PlayerData(){
        this.noOfTimesWon = 0;
        this.noOfTimesPlayed = 0;
        this.noOfTimesPlayedLimited = 0;
        this.noTotalAttempts = 0;
    }
    public void setName(String name) {
        Name = name;
    }

    public void fetchScore(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("------------[YOUR SCORE]-----------");
        System.out.println("|=> Your Name : " + this.Name);
        System.out.println("|=> No. of Times You Played : " + this.noOfTimesPlayed);
        System.out.println("|=> No. of Times You Played With Limited Guess : " + this.noOfTimesPlayedLimited);
        System.out.println("|=> Average Attempts per round : " + this.noTotalAttempts/((this.noOfTimesPlayed-this.noOfTimesPlayedLimited)+this.noOfTimesWon));
        System.out.println("|=> No. of Times You Played With Unlimited Guess : " + (this.noOfTimesPlayed-this.noOfTimesPlayedLimited));
        System.out.println("|=> No. of Times You Won (Limited Guess) : " + this.noOfTimesWon);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

}
public class Task_1_Number_Game {
    public static void main(String[] args) {
        System.out.println("***********************************");
        System.out.println("-----------[NUMBER GAME]-----------");
        System.out.println("***********************************");
        PlayerData player = new PlayerData();
        System.out.print("Enter Your Name : ");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        player.setName(name);
        while (true)
        {
            Random random = new Random();
            int orgNum = random.nextInt(101);
            System.out.println("***********************************");
            System.out.print("You have to Guess Number Between [1-100]\nSelect what to do : \n1. Guess in limited number of Attempts. \n2. Guess in unlimited number of Attempts. \n3. Know Your Score. \n0. EXIT.\n=> ");
            char choice = scan.next().charAt(0);
            if(choice == '1')
            {
                player.noOfTimesPlayed += 1;
                player.noOfTimesPlayedLimited += 1;
                System.out.print("Enter no. of Attempts you want[n <= 10] : ");
                int noOfTimesYouWant = scan.nextInt();
                int count = 0;
                if(noOfTimesYouWant <= 10)
                {
                    while(noOfTimesYouWant-- > 0)
                    {
                        System.out.print("Enter Your guessed number : ");
                        int guessNum = scan.nextInt();
                        count++;
                        if(guessNum == orgNum)
                        {
                            player.noTotalAttempts += count;
                            player.noOfTimesWon += 1;
                            System.out.println("Hurrah, You Won The Game in Limited Attempts!!!");
                            break;
                        }
                        else if (guessNum > orgNum) {
                            System.out.println("Guess Lower Number!!!");
                        }
                        else {
                            System.out.println("Guess Higher Number!!!");
                        }
                    }
                }
                else
                {
                    System.out.println("Please Enter the Attempts <= 15 !!!");
                }
                if(noOfTimesYouWant <= 0)
                {
                    System.out.println("Huh, You Failed to Guess :(");
                    System.out.println("Try Again!!!");
                }

            }
            else if(choice == '2')
            {
                player.noOfTimesPlayed += 1;
                int count = 0;
                while(true)
                {
                    System.out.print("Enter Your guessed number : ");
                    int guessNum = scan.nextInt();
                    count++;
                    if(guessNum == orgNum)
                    {
                        player.noTotalAttempts += count;
                        System.out.println("Hurrah!!! You took : " + count + " steps and won the game :)");
                        break;
                    }
                    else if (guessNum > orgNum)
                        System.out.println("Guess Lower Number!!!");
                    else
                        System.out.println("Guess Higher Number!!!");
                }
            }
            else if(choice == '3')
            {
                player.fetchScore();
            }
            else if (choice == '0') {
                player.fetchScore();
                return;
            } else {
                System.out.println("ENTER VALID CHOICE!!!!!");
            }
            System.out.print("Do you want to continue[y/n] : ");
            char yesNo = scan.next().charAt(0);
            yesNo = Character.toLowerCase(yesNo);
            if(yesNo == 'n')
            {
                player.fetchScore();
                return;
            }
        }
    }
}

