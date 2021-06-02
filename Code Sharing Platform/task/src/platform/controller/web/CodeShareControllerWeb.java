package platform.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import platform.accessingdatajpa.CodeShare;
import platform.accessingdatajpa.CodeShareRepository;
import platform.service.CodeShareService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CodeShareControllerWeb {
    @Autowired
    private CodeShareRepository codeShareRepository;
    @Autowired
    CodeShareService codeShareService;

    @GetMapping(value = "/")
    public ModelAndView getHomepage() {
        var params = new HashMap<String, String>();
        params.put("name", "Ginger");

        return new ModelAndView("index");
    }

    @GetMapping("/code/new")
    public ModelAndView createCodeShare() {
        return new ModelAndView("create");
    }

    @GetMapping("/code/{uuid}")
    public ModelAndView getCodeShareByUuid(@PathVariable String uuid) {
        CodeShare codeShare = codeShareService.getCodeShareByUuid(uuid);
        Map map = new HashMap();
        map.put("codeShare", codeShare);
        return new ModelAndView("specifyCodeShare", map);
    }

    @GetMapping("/code/latest")
    public ModelAndView getLatestCodeShare() {
        List<CodeShare> latestCodeShare = codeShareRepository.findTop10ByDueDateRestrictionFalseAndViewsRestrictionFalseOrderByDateDesc();
        Map map = new HashMap();
        map.put("latestCodeShare", latestCodeShare);
        return new ModelAndView("latestCodeShare", map);
    }

    private class NoSuchRequestHandlingMethodException extends Exception {
    }
}
