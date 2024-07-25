package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.TradeData;
import com.ruoyi.system.service.ITradeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 交易数据Controller
 * 
 * @author chenzhen
 * @date 2024-07-25
 */
@RestController
@RequestMapping("/system/data")
public class TradeDataController extends BaseController
{
    @Autowired
    private ITradeDataService tradeDataService;

    /**
     * 查询交易数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:data:list')")
    @GetMapping("/list")
    public TableDataInfo list(TradeData tradeData)
    {
        startPage();
        List<TradeData> list = tradeDataService.selectTradeDataList(tradeData);
        return getDataTable(list);
    }

    /**
     * 导出交易数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:data:export')")
    @Log(title = "交易数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TradeData tradeData)
    {
        List<TradeData> list = tradeDataService.selectTradeDataList(tradeData);
        ExcelUtil<TradeData> util = new ExcelUtil<TradeData>(TradeData.class);
        util.exportExcel(response, list, "交易数据数据");
    }

    /**
     * 获取交易数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:data:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tradeDataService.selectTradeDataById(id));
    }

    /**
     * 新增交易数据
     */
    @PreAuthorize("@ss.hasPermi('system:data:add')")
    @Log(title = "交易数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TradeData tradeData)
    {
        return toAjax(tradeDataService.insertTradeData(tradeData));
    }

    /**
     * 修改交易数据
     */
    @PreAuthorize("@ss.hasPermi('system:data:edit')")
    @Log(title = "交易数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TradeData tradeData)
    {
        return toAjax(tradeDataService.updateTradeData(tradeData));
    }

    /**
     * 删除交易数据
     */
    @PreAuthorize("@ss.hasPermi('system:data:remove')")
    @Log(title = "交易数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tradeDataService.deleteTradeDataByIds(ids));
    }
}
