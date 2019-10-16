package jp.co.u_idea2.batch.jbbb01002;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 区間搭乗者情報集計オブジェクト。
 * 
 */
public class RouteAggregationDto {

    /**
     * 搭乗日。
     */
    private Date departureDate;

    /**
     * 出発空港。
     */
    private String depAirport;

    /**
     * 到着空港。
     */
    private String arrAirport;

    /**
     * 搭乗者数。
     */
    private int passengerNum;

    /**
     * 搭乗率。
     */
    private BigDecimal loadFactor;

    /**
     * 搭乗日を取得する。
     * 
     * @return 搭乗日
     */
    public Date getDepartureDate() {
        return departureDate;
    }

    /**
     * 搭乗日を設定する。
     * 
     * @param departureDate 搭乗日
     */
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * 出発空港を取得する。
     * 
     * @return 出発空港
     */
    public String getDepAirport() {
        return depAirport;
    }

    /**
     * 出発空港を設定する。
     * 
     * @param depAirport 出発空港
     */
    public void setDepAirport(String depAirport) {
        this.depAirport = depAirport;
    }

    /**
     * 到着空港を取得する。
     * 
     * @return 到着空港
     */
    public String getArrAirport() {
        return arrAirport;
    }

    /**
     * 到着空港を設定する。
     * 
     * @param arrAirport 到着空港
     */
    public void setArrAirport(String arrAirport) {
        this.arrAirport = arrAirport;
    }

    /**
     * 搭乗者数を取得する。
     * 
     * @return 搭乗者数
     */
    public int getPassengerNum() {
        return passengerNum;
    }

    /**
     * 搭乗者数を設定する。
     * 
     * @param passengerNum 搭乗者数
     */
    public void setPassengerNum(int passengerNum) {
        this.passengerNum = passengerNum;
    }

    /**
     * 搭乗率を取得する。
     * 
     * @return 搭乗率
     */
    public BigDecimal getLoadFactor() {
        return loadFactor;
    }

    /**
     * 搭乗率を設定する。
     * 
     * @param loadFactor 搭乗率
     */
    public void setLoadFactor(BigDecimal loadFactor) {
        this.loadFactor = loadFactor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
