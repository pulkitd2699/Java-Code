package OOPs.KCatering;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class KCatering {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws ParseException{
        Event event = getEventInfo();
        event.printEvent();
    }

    public static Event getEventInfo() throws ParseException{
        String eventType = getEventType();
        int guests = getNumGuests();
        String eventDate = getDate();
        Event event = new Event(eventType, eventDate, guests);
        return event;
    }

    public static int getNumGuests(){
        System.out.println("How many guests do you expect: ");
        while(!in.hasNextInt()){
            System.out.println("Enter a whole number");
            in.nextLine();
        }
        int guests = in.nextInt();
        in.nextLine();
        return guests;
    }

    public static String getEventType(){
        int selection = 0;
        boolean firstTime = true;
        do{
            if(firstTime == true) firstTime = false;
            else System.out.println("Invalid Selection");

            System.out.println("What type of event are you hosting: \n1. Wedding \n2. Birthday \n3. Shower \n4. Other, please Specify:");
            selection = in.nextInt();
            in.nextLine();
        } while(selection != 1 && selection != 2 && selection != 3 && selection != 4);

        switch(selection){
            case 1: 
                return "Wedding";
            case 2: 
                return "Birthday";
            case 3: 
                return "Shower";
            case 4:
                System.out.println("Please enter the type of event");
                String eventName = in.nextLine();
                return eventName;
        }
        return "no type selected";
    }

    public static String getDate() throws ParseException{
        System.out.println("When is the date of your event? (mm/dd/yyyy)");
        String inDate = in.nextLine();
        DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
        Date eventD = null;
        try{
            eventD = df.parse(inDate);
        }
        catch(ParseException e){
            System.out.println("Error in date format");
        }

        String finalDate = df.format(eventD);
        return finalDate;
    }
}
