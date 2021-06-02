package platform.accessingdatajpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Entity
public class CodeShare {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String uuid;
    private String code;
    private String date;
    private String dueDate;
    private Boolean dueDateRestriction;
    private Long views;
    private Boolean viewsRestriction;


    protected CodeShare() {
    }

    public CodeShare(String code, long time, long views) {
        UUID uuid = UUID.randomUUID();
        this.uuid = uuid.toString();
        this.code = code;
        this.date = LocalDateTime.now().toString();
        this.dueDate = LocalDateTime.now().plusSeconds(time).toString();
        this.dueDateRestriction = time == 0 ? false : true;
        this.views = views;
        this.viewsRestriction = views == 0 ? false : true;

    }

    @Override
    public String toString() {
        return String.format(
                "CodeShare[id=%d, code='%s', date='%s']",
                id, code, date);
    }

    public Map<String, Object> toMap() {
        Map map = new HashMap<>();
        map.put("code", code);
        map.put("date", date);
        map.put("time", calculateLeftDueTime());
        map.put("views", views);
        return map;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getDueDateRestriction() {
        return dueDateRestriction;
    }

    public void setDueDateRestriction(Boolean dueDateRestriction) {
        this.dueDateRestriction = dueDateRestriction;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public Boolean getViewsRestriction() {
        return viewsRestriction;
    }

    public void setViewsRestriction(Boolean viewsRestriction) {
        this.viewsRestriction = viewsRestriction;
    }

    public long getTime() {
        return calculateLeftDueTime();
    }

    public long calculateLeftDueTime() {
        ZoneId zoneId = ZoneId.systemDefault();
        long currentTime = LocalDateTime.now().atZone(zoneId).toEpochSecond();
        long dueTime = LocalDateTime.parse(dueDate).atZone(zoneId).toEpochSecond();
        if (dueDateRestriction) {
            return dueTime > currentTime ? dueTime - currentTime : -1;
        } else {
            return 0;
        }
    }

    //    private String getDateTimeNow() {
//        LocalDateTime localDateTime = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
//        return localDateTime.format(formatter);
//        return LocalDateTime.now().toString();
//    }
}
