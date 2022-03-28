package models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Receipt")
public class Receipt {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long receiptId;
        @Column(name="Date")
        private LocalDateTime date;
        @Column(name="TotalPrice")
        private double totalPrice;

    public long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(long receiptId) {
        this.receiptId = receiptId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
