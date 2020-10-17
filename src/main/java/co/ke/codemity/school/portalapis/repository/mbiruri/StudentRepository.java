package co.ke.codemity.school.portalapis.repository.mbiruri;

import co.ke.codemity.school.portalapis.entities.mbiruri.MbiruriStudents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<MbiruriStudents, Long> {

}
