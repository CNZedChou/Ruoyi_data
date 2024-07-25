package com.ruoyi.system.service;

import com.ruoyi.system.domain.TradeData;

import java.util.List;

/**
 * 交易数据Service接口
 * 
 * @author chenzhen
 * @date 2024-07-25
 */
public interface ITradeDataService 
{
    /**
     * 查询交易数据
     * 
     * @param id 交易数据主键
     * @return 交易数据
     */
    public TradeData selectTradeDataById(Long id);

    /**
     * 查询交易数据列表
     * 
     * @param tradeData 交易数据
     * @return 交易数据集合
     */
    public List<TradeData> selectTradeDataList(TradeData tradeData);

    /**
     * 新增交易数据
     * 
     * @param tradeData 交易数据
     * @return 结果
     */
    public int insertTradeData(TradeData tradeData);

    /**
     * 修改交易数据
     * 
     * @param tradeData 交易数据
     * @return 结果
     */
    public int updateTradeData(TradeData tradeData);

    /**
     * 批量删除交易数据
     * 
     * @param ids 需要删除的交易数据主键集合
     * @return 结果
     */
    public int deleteTradeDataByIds(Long[] ids);

    /**
     * 删除交易数据信息
     * 
     * @param id 交易数据主键
     * @return 结果
     */
    public int deleteTradeDataById(Long id);
}
