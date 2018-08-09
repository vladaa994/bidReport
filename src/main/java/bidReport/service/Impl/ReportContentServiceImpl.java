package bidReport.service.Impl;

import bidReport.model.Report;
import bidReport.model.ReportContent;
import bidReport.repository.ReportContentRepository;
import bidReport.service.ReportContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by pc-mg on 8/8/2018.
 */
@Service
public class ReportContentServiceImpl implements ReportContentService{

    private ReportContentRepository reportContentRepository;

    @Autowired
    public ReportContentServiceImpl(ReportContentRepository reportContentRepository) {
        this.reportContentRepository = reportContentRepository;
    }

    @Override
    public List<ReportContent> findAll() {
        return null;
    }

    @Override
    public Optional<ReportContent> findById(int id) {
        return null;
    }

    @Override
    public ReportContent save(ReportContent user) {
        return reportContentRepository.save(user);
    }

    @Override
    public void delete(int id) {

    }
}
