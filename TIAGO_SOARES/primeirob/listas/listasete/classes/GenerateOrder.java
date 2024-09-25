package primeirob.listas.listasete.classes;

import java.util.Date;

public class GenerateOrder extends Order{
    
    public boolean process(Order orderToGenerate){
        if(!verifyBooking(orderToGenerate.getExpiredBooking()) && !confirmPayment(orderToGenerate.getDatePayment())){
            return true;
        }else{
            return false;
        }
    }

    boolean confirmPayment(Date datePayment){
        Date today = new Date();

        return today.after(datePayment);
    }

    private boolean verifyBooking(Date dateExpired){
        Date today = new Date();

        return today.after(dateExpired);
    }
}
