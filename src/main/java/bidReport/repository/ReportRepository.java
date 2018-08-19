package bidReport.repository;

import bidReport.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by pc-mg on 7/27/2018.
 */
@Repository
public interface ReportRepository extends JpaRepository<Report, Integer>{
    Report findTopByOrderById();

    @Query("select max(r.reportNumber) from Report r ")
    int findLast();
}
