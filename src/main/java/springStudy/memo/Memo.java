package springStudy.memo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contents;

    public Memo (String contents){
        this.contents=contents;
    }

    public void update(String contents){
        this.contents=contents;
    }

}
