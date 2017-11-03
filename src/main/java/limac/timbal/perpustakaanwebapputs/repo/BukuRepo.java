package limac.timbal.perpustakaanwebapputs.repo;

import limac.timbal.perpustakaanwebapputs.entitiy.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BukuRepo extends JpaRepository<Buku,String> {

    Buku findById(String id);
}
