package limac.timbal.perpustakaanwebapputs.entitiy;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Buku {

    @Id @Getter @Setter
    private String id;

    @Getter @Setter
    private String judul_buku;

    @Getter @Setter
    private String penulis;

}
