package com.cnc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "filter_seting_params")
public class FilterSetingParams {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    private String id;
    private BigDecimal attentionNum;
    private BigDecimal alarmNum;
    private  Boolean   iseffect;
    private  String  hierarchyCode;
//    private  String   r1;
//    private String r2;
//    private String r3;

  public String getHierarchyCode() {
        return hierarchyCode;
    }

    public void setHierarchyCode(String hierarchyCode) {
        this.hierarchyCode = hierarchyCode;
    }

    public Boolean getIseffect() {
        return iseffect;
    }

    public void setIseffect(Boolean iseffect) {
        this.iseffect = iseffect;
    }



    public BigDecimal getAttentionNum() {
        return attentionNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAttentionNum(BigDecimal attentionNum) {
        this.attentionNum = attentionNum;
    }

    public BigDecimal getAlarmNum() {
        return alarmNum;
    }

    public void setAlarmNum(BigDecimal alarmNum) {
        this.alarmNum = alarmNum;
    }


    @Override
    public String toString() {
        return "FilterSetingParams{" +
                "id=" + id +
                ", attentionNum=" + attentionNum +
                ", alarmNum=" + alarmNum +
                ", iseffect=" + iseffect +
                '}';
    }
}
