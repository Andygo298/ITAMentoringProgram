package weekFirst.task2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieHouseTest {
    @Test
    public void paymentsTest() {
        MovieHouse movieHouse = new MovieHouse();
        List<Buyer> buyers = movieHouse.createBuyers();
        System.out.println(movieHouse.payments(buyers));
    }
}