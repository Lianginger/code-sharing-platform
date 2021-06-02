package platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import platform.accessingdatajpa.CodeShare;
import platform.accessingdatajpa.CodeShareRepository;

@Service
public class CodeShareService {
    @Autowired
    private CodeShareRepository codeShareRepository;

    public CodeShare getCodeShareByUuid(String uuid) {
        CodeShare codeShare = codeShareRepository.findByUuid(uuid);

        if (codeShare.getDueDateRestriction() &&
                codeShare.calculateLeftDueTime() < 0
        ) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        if (codeShare.getViewsRestriction()) {
            if (codeShare.getViews() <= 0) {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "entity not found"
                );
            } else {
                codeShare.setViews(codeShare.getViews() - 1);
            }
            codeShare = codeShareRepository.save(codeShare);
        }
        return codeShare;
    }
}
