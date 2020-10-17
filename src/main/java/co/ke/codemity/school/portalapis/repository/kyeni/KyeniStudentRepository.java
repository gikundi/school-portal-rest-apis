package co.ke.codemity.school.portalapis.repository.kyeni;

import co.ke.codemity.school.portalapis.entities.kyeni.KyeniStudents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KyeniStudentRepository extends JpaRepository<KyeniStudents, Long> {


}
