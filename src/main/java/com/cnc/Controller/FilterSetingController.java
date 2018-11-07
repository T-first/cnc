package com.cnc.Controller;

import com.alibaba.fastjson.JSON;
import com.cnc.Dao.FilterSetingRespository;
import com.cnc.entity.FilterSetingParams;
import com.cnc.util.HttpUtilsMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "products")
public class FilterSetingController {
    @Autowired
    private FilterSetingRespository filterSetingRespository;

    @RequestMapping(path = "settingfilter", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, List<FilterSetingParams>> setFiter(@ModelAttribute FilterSetingParams filterSetingParams) {
        System.out.println(filterSetingParams.getId());
        List<FilterSetingParams> list = filterSetingRespository.findAll();
        FilterSetingParams f = new FilterSetingParams();
        //     f.setId("");
//        f.setAlarmNum(BigDecimal.valueOf(5L));
//        f.setAttentionNum(BigDecimal.valueOf(5L));
//        filterSetingRespository.save(f);
        Map<String, List<FilterSetingParams>> result = new HashMap<String, List<FilterSetingParams>>();
        result.put("data", list);
        return result;
    }

    @RequestMapping(value = "getList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, FilterSetingParams> getList(
            @RequestParam(required = false) String token,
            @RequestParam(required = false) String hierarchyCode,
            @RequestParam(required = false) String url,
            @RequestParam(required = false) String serviceValue) {
        JSON json = HttpUtilsMethod.doGet(url, token, serviceValue);
        boolean isservie = JSON.parseObject(json.toString()).getBoolean("data");
        Map<String, FilterSetingParams> result = new HashMap<String, FilterSetingParams>();
        if (isservie) {
            FilterSetingParams fsp = new FilterSetingParams();
            fsp.setHierarchyCode(hierarchyCode);
            ExampleMatcher exampleMatcher = ExampleMatcher.matching();
            Example<FilterSetingParams> ex = Example.of(fsp, exampleMatcher);
            List<FilterSetingParams> list = filterSetingRespository.findAll(ex);
            if (list.isEmpty()) {
            } else {
                FilterSetingParams fs = list.get(0);
                result.put("data", fs);
            }
        }

        return result;
    }


}
