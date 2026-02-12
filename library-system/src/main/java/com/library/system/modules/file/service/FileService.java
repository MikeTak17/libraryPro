package com.library.system.modules.file.service;

import com.library.system.modules.file.entity.File;
import com.library.system.modules.file.vo.FileVO;
import com.library.system.modules.file.bo.FilePage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @Author makejava
 * @Desc 使用者資料表(File)表服务接口
 * @Date 2026-02-12 20:01:39
 */
public interface FileService extends IService<File> {

    /**
     * 分页查询
     */
    IPage<FileVO> queryByPage(FilePage page);

    /**
     * 根据ID查详情
     */
    FileVO queryById(Integer id);

    /**
     * 新增数据
     */
    boolean insert(FileInsert fileInsert);

    /**
     * 修改数据
     */
    boolean update(FileUpdate fileUpdate);

    /**
     * 通过主键删除数据
     */
    boolean deleteById(Integer id);

}
