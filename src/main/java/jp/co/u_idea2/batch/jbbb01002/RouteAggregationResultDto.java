package jp.co.u_idea2.batch.jbbb01002;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 区間搭乗者情報集計結果オブジェクト。
 * 
 */
public class RouteAggregationResultDto {

    /**
     * 搭乗日。
     */
    @NotNull
    private Date departureDate;

    /**
     * 区間番号。
     */
    @NotNull
    private Integer routeNo;

    /**
     * 出発空港。
     */
    @NotNull
    @Size(max = 15, min = 1)
    private String depAirport;

    /**
     * 到着空港。
     */
    @NotNull
    @Size(max = 15, min = 1)
    private String arrAirport;

    /**
     * 席数（一般席）。
     */
    @NotNull
    private Integer normalSeatNum;

    /**
     * 席数（特別席）。
     */
    @NotNull
    private Integer specialSeatNum;

    /**
     * 搭乗者数。
     */
    private Integer passengerNum;

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
    public Integer getPassengerNum() {
        return passengerNum;
    }

    /**
     * 搭乗者数を設定する。
     * 
     * @param passengerNum 搭乗者数
     */
    public void setPassengerNum(Integer passengerNum) {
        this.passengerNum = passengerNum;
    }

    /**
     * 席数（一般席）を取得する。
     * 
     * @return 席数（一般席）
     */
    public Integer getNormalSeatNum() {
        return normalSeatNum;
    }

    /**
     * 席数（一般席）を設定する。
     * 
     * @param normalSeatNum 席数（一般席）
     */
    public void setNormalSeatNum(Integer normalSeatNum) {
        this.normalSeatNum = normalSeatNum;
    }

    /**
     * 席数（特別席）を取得する。
     * 
     * @return 搭乗日
     */
    public Integer getSpecialSeatNum() {
        return specialSeatNum;
    }

    /**
     * 席数（特別席）を設定する。
     * 
     * @param specialSeatNum 席数（特別席）
     */
    public void setSpecialSeatNum(Integer specialSeatNum) {
        this.specialSeatNum = specialSeatNum;
    }

    /**
     * 区間番号を取得する。
     * 
     * @return 区間番号
     */
    public Integer getRouteNo() {
        return routeNo;
    }

    /**
     * 区間番号を設定する。
     * 
     * @param routeNo 区間番号
     */
    public void setRouteNo(Integer routeNo) {
        this.routeNo = routeNo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
