package bidReport.controller;

import bidReport.enums.OwnerEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pc-mg on 7/26/2018.
 */
@Controller
@RequestMapping(value = "/report")
public class ReportController {

    @GetMapping(value = "/create")
    public String getReport() {
        String ownerName = OwnerEnum.ownerName.getContent();
        System.out.print(ownerName);
        return "report/create";
    }
}
