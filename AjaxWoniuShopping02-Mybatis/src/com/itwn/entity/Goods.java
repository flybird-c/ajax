package com.itwn.entity;

import java.io.Serializable;

public class Goods implements Serializable {
    private Integer id;
    private String goodsName;
    private String goodsImg;
    private Double goodsPrice;
    private Integer goodsCount;
    private String goodsIntroduce;
    private Integer goodsSellCount;
    private Integer secondTypeId;
    private Integer firstTypeId;

    public Goods() {
    }

    public Goods(Integer id, String goodsName, String goodsImg, Double goodsPrice, Integer goodsCount, String goodsIntroduce, Integer goodsSellCount, Integer secondTypeId, Integer firstTypeId) {
        this.id = id;
        this.goodsName = goodsName;
        this.goodsImg = goodsImg;
        this.goodsPrice = goodsPrice;
        this.goodsCount = goodsCount;
        this.goodsIntroduce = goodsIntroduce;
        this.goodsSellCount = goodsSellCount;
        this.secondTypeId = secondTypeId;
        this.firstTypeId = firstTypeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }

    public Integer getGoodsSellCount() {
        return goodsSellCount;
    }

    public void setGoodsSellCount(Integer goodsSellCount) {
        this.goodsSellCount = goodsSellCount;
    }

    public Integer getSecondTypeId() {
        return secondTypeId;
    }

    public void setSecondTypeId(Integer secondTypeId) {
        this.secondTypeId = secondTypeId;
    }

    public Integer getFirstTypeId() {
        return firstTypeId;
    }

    public void setFirstTypeId(Integer firstTypeId) {
        this.firstTypeId = firstTypeId;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", goodsImg='" + goodsImg + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsCount=" + goodsCount +
                ", goodsIntroduce='" + goodsIntroduce + '\'' +
                ", goodsSellCount=" + goodsSellCount +
                ", secondTypeId=" + secondTypeId +
                ", firstTypeId=" + firstTypeId +
                '}';
    }
}
