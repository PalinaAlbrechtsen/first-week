package clerk.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Clerk {

    public List<Integer> cashbox;

    public List<Integer> getCashbox() {
        if (cashbox != null) {
            return cashbox;
        } else {
            return new ArrayList<>();
        }
    }
}
