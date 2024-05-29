package payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookingDate {
    //1. private variables
    private String checkin;
    private String checkout;

    //2. No arg constructor
    /*public BookingDate() {}

    //3. All arg constructor
    public BookingDate(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    //4. Getters
    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    //5. Setters
    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }*/
}
