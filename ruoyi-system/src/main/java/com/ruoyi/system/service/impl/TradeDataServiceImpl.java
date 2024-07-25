package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.TradeData;
import com.ruoyi.system.mapper.TradeDataMapper;
import com.ruoyi.system.service.ITradeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 交易数据Service业务层处理
 * 
 * @author chenzhen
 * @date 2024-07-25
 */
@Service
public class TradeDataServiceImpl implements ITradeDataService 
{
    @Autowired
    private TradeDataMapper tradeDataMapper;

    /**
     * 查询交易数据
     * 
     * @param id 交易数据主键
     * @return 交易数据
     */
    @Override
    public TradeData selectTradeDataById(Long id)
    {
        return tradeDataMapper.selectTradeDataById(id);
    }

    /**
     * 查询交易数据列表
     * 
     * @param tradeData 交易数据
     * @return 交易数据
     */
    @Override
    public List<TradeData> selectTradeDataList(TradeData tradeData)
    {
        return tradeDataMapper.selectTradeDataList(tradeData);
    }

    /**
     * 新增交易数据
     * 
     * @param tradeData 交易数据
     * @return 结果
     */
    @Override
    public int insertTradeData(TradeData tradeData)
    {
        return tradeDataMapper.insertTradeData(tradeData);
    }

    /**
     * 修改交易数据
     * 
     * @param tradeData 交易数据
     * @return 结果
     */
    @Override
    public int updateTradeData(TradeData tradeData)
    {
        return tradeDataMapper.updateTradeData(tradeData);
    }

    /**
     * 批量删除交易数据
     * 
     * @param ids 需要删除的交易数据主键
     * @return 结果
     */
    @Override
    public int deleteTradeDataByIds(Long[] ids)
    {
        return tradeDataMapper.deleteTradeDataByIds(ids);
    }

    /**
     * 删除交易数据信息
     * 
     * @param id 交易数据主键
     * @return 结果
     */
    @Override
    public int deleteTradeDataById(Long id)
    {
        return tradeDataMapper.deleteTradeDataById(id);
    }
}
