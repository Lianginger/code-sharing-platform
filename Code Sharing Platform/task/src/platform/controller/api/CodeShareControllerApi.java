package platform.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import platform.accessingdatajpa.CodeShare;
import platform.accessingdatajpa.CodeShareRepository;
import platform.service.CodeShareService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class CodeShareControllerApi {
    private static final String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss";

    @Autowired
    private CodeShareRepository codeShareRepository;
    @Autowired
    CodeShareService codeShareService;

    @PostMapping("/code/new")
    public Map<String, String> createCodeShareApi(@RequestBody NewCodeSharePayload newCodeSharePayload) {
        CodeShare newCodeShare = codeShareRepository.save(
                new CodeShare(
                        newCodeSharePayload.getCode(),
                        newCodeSharePayload.getTime(),
                        newCodeSharePayload.getViews()
                )
        );

        return Map.of("id", newCodeShare.getUuid());
    }

    @GetMapping("/code/{uuid}")
    public Map<String, Object> getCodeShareByUuid(@PathVariable String uuid) {
        CodeShare codeShare = codeShareService.getCodeShareByUuid(uuid);
        return codeShare.toMap();
    }

    @GetMapping("/code/latest")
    public List<Map<String, Object>> getLatestCodeShareApi() {
        List<CodeShare> latestCodeShare = codeShareRepository.findTop10ByDueDateRestrictionFalseAndViewsRestrictionFalseOrderByDateDesc();
        return latestCodeShare.stream()
                .map(CodeShare::toMap)
                .collect(Collectors.toList());
    }
}

class NewCodeSharePayload {
    String code;
    long time;
    long views;

    public String getCode() {
        return code;
    }

    public long getTime() {
        return time;
    }

    public long getViews() {
        return views;
    }
}