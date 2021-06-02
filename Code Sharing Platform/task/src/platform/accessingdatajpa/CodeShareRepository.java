package platform.accessingdatajpa;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CodeShareRepository extends CrudRepository<CodeShare, Long> {
    CodeShare findById(long id);
    CodeShare findByUuid(String uuid);
    List<CodeShare> findTop10ByDueDateRestrictionFalseAndViewsRestrictionFalseOrderByDateDesc();
}