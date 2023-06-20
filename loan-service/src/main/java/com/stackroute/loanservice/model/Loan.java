

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    private Double loanAmount; 
    private Double interestRate;
    private Integer tenure;

}
