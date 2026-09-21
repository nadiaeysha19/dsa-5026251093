package lw01.unguided;

public class ProjectorRental extends Rental {

    public ProjectorRental(String id, int days) {
        super(id, days);
    }

    @Override
    public int calculateCharge() {
        int dayy = getDays();
        int rentalCost;
        

        if (dayy <= 3) {
            rentalCost = dayy * 60000;
        } else {
            rentalCost = 3 * 60000 + (dayy - 3) * 45000;
        }
        return rentalCost + 20000;
    }

    @Override 
    public String label() {
        return "Projector";
    }
    
    
}
