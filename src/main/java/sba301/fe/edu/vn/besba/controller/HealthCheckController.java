package sba301.fe.edu.vn.besba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sba301.fe.edu.vn.besba.base.BaseController;
import sba301.fe.edu.vn.besba.base.BaseResponse;

@RestController
public class HealthCheckController extends BaseController {

    @GetMapping("/api/public/health")
    public BaseResponse<String> healthCheck() {
        return wrapSuccess("NextGen-Cinema Server is Alive!");
    }
}
