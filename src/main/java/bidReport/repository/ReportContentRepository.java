package bidReport.repository;

import bidReport.model.ReportContent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pc-mg on 8/8/2018.
 */
public interface ReportContentRepository extends JpaRepository<ReportContent, Integer> {
}
