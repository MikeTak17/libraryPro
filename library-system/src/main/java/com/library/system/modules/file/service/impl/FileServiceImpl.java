package com.library.system.modules.file.service.impl;

import com.library.system.modules.file.entity.File;
import com.library.system.modules.file.vo.FileVO;
import com.library.system.modules.file.bo.FilePage;
import com.library.system.modules.file.mapper.FileMapper;
import com.library.system.modules.file.struct.FileStructMapper;
import com.library.system.modules.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import com.library.common.util.PageCovertUtil;


/**
 * @Author makejava
 * @Desc 使用者資料表(File)表服务实现类
 * @Date 2026-02-12 20:01:39
 */

@Service("fileService")
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {

    @Resource
    private FileStructMapper fileStructMapper;
    @Resource
    private FileMapper fileMapper;


    @Override
    public IPage<FileVO> queryByPage(FilePage page) {
        // 查询条件
        LambdaQueryWrapper<File> queryWrapper = new LambdaQueryWrapper<>();
        // 查询分页数据
        Page<File> filePage = new Page<File>(page.getCurrent(), page.getSize());
        IPage<File> pageData = baseMapper.selectPage(filePage, queryWrapper);

        //转换成vo
        IPage<FileVO> records = PageCovertUtil.pageVoCovert(pageData, FileVO.class);
        return records;
    }


    @Override
    public FileVO queryById(Integer id) {
        File file = baseMapper.selectById(id);
        return fileStructMapper.fileToFileVO(file);
    }

    @Override
    public boolean insert(FileInsert fileInsert) {
        File file = fileStructMapper.insertToFile(fileInsert);
        save(file);
        return true;
    }


    @Override
    public boolean update(FileUpdate fileUpdate) {
        File file = fileStructMapper.updateToFile(fileUpdate);
        updateById(file);
        return true;
    }

    @Override
    public boolean deleteById(Integer id) {
        return removeById(id);
    }

}
