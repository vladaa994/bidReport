package bidReport.service;

import bidReport.model.Report;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * Created by pc-mg on 7/27/2018.
 */
public interface ReportService extends BaseService<Report>{
    JasperPrint generateReport(Report report);
}
