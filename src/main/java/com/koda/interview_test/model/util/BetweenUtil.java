package com.koda.interview_test.model.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.koda.interview_test.util.Util;

public class BetweenUtil {

    private String paramName;
    
    private String paramType;
    
    private String startDatatime;
    
    private String endDatatime;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }
    
    public void setParamType(String paramType) {
        if("LocalDateTime".equals(paramType)) {
            this.paramType = paramType;
        }else if("LocalDate".equals(paramType)) {
            this.paramType = paramType;
        }else {
            this.paramType = "LocalDateTime";
        }
    }
    
    public String getParamType() {
        return paramType;
    }
    
    public String getStartDatatime() {
        return startDatatime;
    }

    public void setStartDatatime(String startDatatime) {
        this.startDatatime = startDatatime;
    }

    public String getEndDatatime() {
        return endDatatime;
    }

    public void setEndDatatime(String endDatatime) {
        this.endDatatime = endDatatime;
    }
    
    public LocalDateTime getStartLocalDateTime() {
        return Util.stringToLocalDateTime(this.startDatatime);
    }
    
    public LocalDateTime getEndLocalDateTime() {
        return Util.stringToLocalDateTime(this.endDatatime);
    }
    
    public LocalDate getStartLocalDate() {
        return Util.stringToLocalDateTime(this.startDatatime).toLocalDate();
    }
    
    public LocalDate getEndLocalDate() {
        return Util.stringToLocalDateTime(this.endDatatime).toLocalDate();
    }

    @Override
    public String toString() {
        return "BetweenUtil [paramName=" + paramName + ", paramType=" + paramType + ", startDatatime=" + startDatatime
                + ", endDatatime=" + endDatatime + "]";
    }
}
