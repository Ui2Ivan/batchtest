package jp.co.u_idea2.batch.jbba00;

import jp.co.u_idea2.batch.common.validate.FixedLength;
import jp.co.u_idea2.batch.common.validate.HalfWidthAlpha;
import jp.co.u_idea2.batch.common.validate.HalfWidthAlphaNumber;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * フライト情報テーブルオブジェクト。
 * 
 */
public class FlightDto {

    /**
     * 搭乗日。
     */
    @NotNull
    private Date departureDate;

    /**
     * 便名。
     */
    @NotNull
    @HalfWidthAlphaNumber
    @FixedLength(6)
    private String flightName;

    /**
     * 搭乗クラスコード。
     */
    @NotNull
    @HalfWidthAlpha
    @FixedLength(1)
    private String boardingClassCd;

    /**
     * 運賃種別コード。
     */
    @NotNull
    @HalfWidthAlphaNumber
    @Size(min = 1, max = 4)
    private String fareTypeCd;

    /**
     * 空席数。
     */
    @NotNull
    private Integer vacantNum;

    /**
     * 搭乗日 を取得する。
     * 
     * @return 搭乗日
     */
    public Date getDepartureDate() {
        return departureDate;
    }

    /**
     * 搭乗日 を設定する。
     * 
     * @param departureDate 搭乗日
     */
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * 便名 を取得する。
     * 
     * @return 便名
     */
    public String getFlightName() {
        return flightName;
    }

    /**
     * 便名 を設定する。
     * 
     * @param flightName 便名
     */
    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    /**
     * 搭乗クラスコード を取得する。
     * 
     * @return 搭乗クラスコード
     */
    public String getBoardingClassCd() {
        return boardingClassCd;
    }

    /**
     * 搭乗クラスコード を設定する。
     * 
     * @param boardingClassCd 搭乗クラスコード
     */
    public void setBoardingClassCd(String boardingClassCd) {
        this.boardingClassCd = boardingClassCd;
    }

    /**
     * 運賃種別コード を取得する。
     * 
     * @return 運賃種別コード
     */
    public String getFareTypeCd() {
        return fareTypeCd;
    }

    /**
     * 運賃種別コード を設定する。
     * 
     * @param fareTypeCd 運賃種別コード
     */
    public void setFareTypeCd(String fareTypeCd) {
        this.fareTypeCd = fareTypeCd;
    }

    /**
     * 空席数 を取得する。
     * 
     * @return 空席数
     */
    public Integer getVacantNum() {
        return vacantNum;
    }

    /**
     * 空席数 を設定する。
     * 
     * @param vacantNum 空席数
     */
    public void setVacantNum(Integer vacantNum) {
        this.vacantNum = vacantNum;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}