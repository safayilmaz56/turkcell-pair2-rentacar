package com.turkcell.rentacar.business.dtos.requests.creates;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCreditCardRequest {

    @NotNull
    private String cardHolderName;

    @NotNull
    @Pattern(regexp = "\\d{16}", message = "Credit card number must be 16 digits")
    private String cardNumber;

    @Pattern(regexp = "\\d{3}", message = "CVV must be 3 digits")
    @NotNull
    private String cvv;

    @Pattern(regexp = "(0[1-9]|1[0-2])/[0-9]{2}", message = "Expiration date must be in the format MM/YY")
    @NotNull
    private String expirationDate;
}
