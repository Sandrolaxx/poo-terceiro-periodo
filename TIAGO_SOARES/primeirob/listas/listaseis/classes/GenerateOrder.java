package primeirob.listas.listaseis.classes;

import java.util.Date;

public class GenerateOrder extends Order{
    
    public boolean process(Order orderToGenerate){
        if(!verifyBooking(orderToGenerate.expiredBooking) && !confirmPayment(orderToGenerate.datePayment)){
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
