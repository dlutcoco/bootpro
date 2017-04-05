package com.netposa.bootpro.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.netposa.bootpro.conf.AppProperties;
import com.netposa.bootpro.mapper.ContentMapper;
import com.netposa.bootpro.pojo.Content;
import com.netposa.bootpro.pojo.ContentExample;
import com.netposa.bootpro.utils.ConstUtil;

@Service
public class DataService {

    private static final Logger LOG = LoggerFactory.getLogger(DataService.class);

    @Autowired
    private AppProperties appConfig;

    @Autowired
    private ContentMapper contentMapper;

    public void build() {
        long start = System.currentTimeMillis();

        int nowSize = contentMapper.countByExample(null);
        LOG.info("共计要构造数据:" + appConfig.getDatasize() + "条");
        LOG.info("现有表中的数据:" + nowSize + "条");

        LOG.info("开始构造测试数据...");
        if (appConfig.getDatasize() >= nowSize) {
            Integer current = contentMapper.getMax();
            int max = current == null ? 0 : current;
            LOG.info("共计要新增数据:" + (appConfig.getDatasize() - nowSize) + "条");
            for (int i = max + 1; i <= appConfig.getDatasize(); i++) {
                Content content = new Content();
                content.setId(i);
                content.setContent(ConstUtil.randomKbStr());
                contentMapper.insert(content);
            }
        } else {
            LOG.info("共计要删除数据:" + (nowSize - appConfig.getDatasize()) + "条");

            ContentExample example = new ContentExample();
            example.createCriteria().andIdGreaterThan(appConfig.getDatasize());
            contentMapper.deleteByExample(example);
        }

        LOG.info("测试数据构造完成...");
        LOG.info("初始化数据用时:" + (System.currentTimeMillis() - start) + "ms");
    }

    public String queryRandom() {
        int key = (int) (Math.random() * appConfig.getDatasize());
        Content content = contentMapper.selectByPrimaryKey(key);
        return content == null ? null : content.getContent();
    }

    @Cacheable(value = "guavademo")
	public String query(int id) {
		Content content = contentMapper.selectByPrimaryKey(id);
		return content == null ? null : content.getContent();
	}
}
