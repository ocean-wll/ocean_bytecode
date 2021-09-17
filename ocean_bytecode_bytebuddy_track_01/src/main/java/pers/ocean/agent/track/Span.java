package pers.ocean.agent.track;

import java.util.Date;

import lombok.Data;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/17 3:40 下午
 */
@Data
public class Span {

    /**
     * 链路id
     */
    private String linkId;

    /**
     * 方法进入时间
     */
    private Date enterTime;

    public Span(String linkId) {
        this.linkId = linkId;
        this.enterTime = new Date();
    }
}
